package com.google.crypto.tink.mac;

import com.google.crypto.tink.Mac;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.internal.MonitoringUtil;
import com.google.crypto.tink.internal.MutableMonitoringRegistry;
import com.google.crypto.tink.monitoring.MonitoringClient;
import com.google.crypto.tink.monitoring.MonitoringKeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

class MacWrapper implements PrimitiveWrapper<Mac, Mac> {
    /* access modifiers changed from: private */
    public static final byte[] FORMAT_VERSION = {0};
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(MacWrapper.class.getName());

    private static class WrappedMac implements Mac {
        private final MonitoringClient.Logger computeLogger;
        private final PrimitiveSet<Mac> primitives;
        private final MonitoringClient.Logger verifyLogger;

        private WrappedMac(PrimitiveSet<Mac> primitiveSet) {
            this.primitives = primitiveSet;
            if (primitiveSet.hasAnnotations()) {
                MonitoringClient monitoringClient = MutableMonitoringRegistry.globalInstance().getMonitoringClient();
                MonitoringKeysetInfo monitoringKeysetInfo = MonitoringUtil.getMonitoringKeysetInfo(primitiveSet);
                this.computeLogger = monitoringClient.createLogger(monitoringKeysetInfo, "mac", "compute");
                this.verifyLogger = monitoringClient.createLogger(monitoringKeysetInfo, "mac", "verify");
                return;
            }
            this.computeLogger = MonitoringUtil.DO_NOTHING_LOGGER;
            this.verifyLogger = MonitoringUtil.DO_NOTHING_LOGGER;
        }

        public byte[] computeMac(byte[] bArr) throws GeneralSecurityException {
            if (this.primitives.getPrimary().getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                bArr = Bytes.concat(bArr, MacWrapper.FORMAT_VERSION);
            }
            try {
                byte[] concat = Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().computeMac(bArr));
                this.computeLogger.log(this.primitives.getPrimary().getKeyId(), (long) bArr.length);
                return concat;
            } catch (GeneralSecurityException e) {
                this.computeLogger.logFailure();
                throw e;
            }
        }

        public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            byte[] bArr3;
            if (bArr.length > 5) {
                byte[] copyOf = Arrays.copyOf(bArr, 5);
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                for (PrimitiveSet.Entry next : this.primitives.getPrimitive(copyOf)) {
                    if (next.getOutputPrefixType().equals(OutputPrefixType.LEGACY)) {
                        bArr3 = Bytes.concat(bArr2, MacWrapper.FORMAT_VERSION);
                    } else {
                        bArr3 = bArr2;
                    }
                    try {
                        ((Mac) next.getPrimitive()).verifyMac(copyOfRange, bArr3);
                        this.verifyLogger.log(next.getKeyId(), (long) bArr3.length);
                        return;
                    } catch (GeneralSecurityException e) {
                        Logger access$100 = MacWrapper.logger;
                        access$100.info("tag prefix matches a key, but cannot verify: " + e);
                    }
                }
                for (PrimitiveSet.Entry next2 : this.primitives.getRawPrimitives()) {
                    try {
                        ((Mac) next2.getPrimitive()).verifyMac(bArr, bArr2);
                        this.verifyLogger.log(next2.getKeyId(), (long) bArr2.length);
                        return;
                    } catch (GeneralSecurityException unused) {
                    }
                }
                this.verifyLogger.logFailure();
                throw new GeneralSecurityException("invalid MAC");
            }
            this.verifyLogger.logFailure();
            throw new GeneralSecurityException("tag too short");
        }
    }

    private void validateMacKeyPrefixes(PrimitiveSet<Mac> primitiveSet) throws GeneralSecurityException {
        for (List<PrimitiveSet.Entry<Mac>> it : primitiveSet.getAll()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    PrimitiveSet.Entry entry = (PrimitiveSet.Entry) it2.next();
                    if (entry.getKey() instanceof MacKey) {
                        MacKey macKey = (MacKey) entry.getKey();
                        com.google.crypto.tink.util.Bytes copyFrom = com.google.crypto.tink.util.Bytes.copyFrom(entry.getIdentifier());
                        if (!copyFrom.equals(macKey.getOutputPrefix())) {
                            throw new GeneralSecurityException("Mac Key with parameters " + macKey.getParameters() + " has wrong output prefix (" + macKey.getOutputPrefix() + ") instead of (" + copyFrom + ")");
                        }
                    }
                }
            }
        }
    }

    MacWrapper() {
    }

    public Mac wrap(PrimitiveSet<Mac> primitiveSet) throws GeneralSecurityException {
        validateMacKeyPrefixes(primitiveSet);
        return new WrappedMac(primitiveSet);
    }

    public Class<Mac> getPrimitiveClass() {
        return Mac.class;
    }

    public Class<Mac> getInputPrimitiveClass() {
        return Mac.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new MacWrapper());
    }
}
