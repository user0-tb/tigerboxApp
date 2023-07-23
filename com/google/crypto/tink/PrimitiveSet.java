package com.google.crypto.tink;

import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.monitoring.MonitoringAnnotations;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Hex;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;
import p009j$.util.concurrent.ConcurrentHashMap;

public final class PrimitiveSet<P> {
    private final MonitoringAnnotations annotations;
    private final boolean isMutable;
    private Entry<P> primary;
    private final Class<P> primitiveClass;
    private final ConcurrentMap<Prefix, List<Entry<P>>> primitives;

    public static final class Entry<P> {
        private final byte[] identifier;
        private final Key key;
        private final int keyId;
        private final OutputPrefixType outputPrefixType;
        private final P primitive;
        private final KeyStatusType status;

        Entry(P p, byte[] bArr, KeyStatusType keyStatusType, OutputPrefixType outputPrefixType2, int i, Key key2) {
            this.primitive = p;
            this.identifier = Arrays.copyOf(bArr, bArr.length);
            this.status = keyStatusType;
            this.outputPrefixType = outputPrefixType2;
            this.keyId = i;
            this.key = key2;
        }

        public P getPrimitive() {
            return this.primitive;
        }

        public KeyStatusType getStatus() {
            return this.status;
        }

        public OutputPrefixType getOutputPrefixType() {
            return this.outputPrefixType;
        }

        public final byte[] getIdentifier() {
            byte[] bArr = this.identifier;
            if (bArr == null) {
                return null;
            }
            return Arrays.copyOf(bArr, bArr.length);
        }

        public int getKeyId() {
            return this.keyId;
        }

        public Key getKey() {
            return this.key;
        }

        public Parameters getParameters() {
            return this.key.getParameters();
        }
    }

    /* access modifiers changed from: private */
    public static <P> Entry<P> addEntryToMap(P p, Keyset.Key key, ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap) throws GeneralSecurityException {
        Integer valueOf = Integer.valueOf(key.getKeyId());
        if (key.getOutputPrefixType() == OutputPrefixType.RAW) {
            valueOf = null;
        }
        Entry entry = new Entry(p, CryptoFormat.getOutputPrefix(key), key.getStatus(), key.getOutputPrefixType(), key.getKeyId(), MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(ProtoKeySerialization.create(key.getKeyData().getTypeUrl(), key.getKeyData().getValue(), key.getKeyData().getKeyMaterialType(), key.getOutputPrefixType(), valueOf), InsecureSecretKeyAccess.get()));
        ArrayList arrayList = new ArrayList();
        arrayList.add(entry);
        Prefix prefix = new Prefix(entry.getIdentifier());
        List list = (List) concurrentMap.put(prefix, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(entry);
            concurrentMap.put(prefix, Collections.unmodifiableList(arrayList2));
        }
        return entry;
    }

    @Nullable
    public Entry<P> getPrimary() {
        return this.primary;
    }

    public boolean hasAnnotations() {
        return !this.annotations.toMap().isEmpty();
    }

    public MonitoringAnnotations getAnnotations() {
        return this.annotations;
    }

    public List<Entry<P>> getRawPrimitives() {
        return getPrimitive(CryptoFormat.RAW_PREFIX);
    }

    public List<Entry<P>> getPrimitive(byte[] bArr) {
        List<Entry<P>> list = (List) this.primitives.get(new Prefix(bArr));
        return list != null ? list : Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public List<Entry<P>> getPrimitive(Keyset.Key key) throws GeneralSecurityException {
        return getPrimitive(CryptoFormat.getOutputPrefix(key));
    }

    public Collection<List<Entry<P>>> getAll() {
        return this.primitives.values();
    }

    @Deprecated
    private PrimitiveSet(Class<P> cls) {
        this.primitives = new ConcurrentHashMap();
        this.primitiveClass = cls;
        this.annotations = MonitoringAnnotations.EMPTY;
        this.isMutable = true;
    }

    private PrimitiveSet(ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap, Entry<P> entry, MonitoringAnnotations monitoringAnnotations, Class<P> cls) {
        this.primitives = concurrentMap;
        this.primary = entry;
        this.primitiveClass = cls;
        this.annotations = monitoringAnnotations;
        this.isMutable = false;
    }

    @Deprecated
    public static <P> PrimitiveSet<P> newPrimitiveSet(Class<P> cls) {
        return new PrimitiveSet<>(cls);
    }

    @Deprecated
    public void setPrimary(Entry<P> entry) {
        if (!this.isMutable) {
            throw new IllegalStateException("setPrimary cannot be called on an immutable primitive set");
        } else if (entry == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (entry.getStatus() != KeyStatusType.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        } else if (!getPrimitive(entry.getIdentifier()).isEmpty()) {
            this.primary = entry;
        } else {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
    }

    @Deprecated
    public Entry<P> addPrimitive(P p, Keyset.Key key) throws GeneralSecurityException {
        if (!this.isMutable) {
            throw new IllegalStateException("addPrimitive cannot be called on an immutable primitive set");
        } else if (key.getStatus() == KeyStatusType.ENABLED) {
            return addEntryToMap(p, key, this.primitives);
        } else {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
    }

    public Class<P> getPrimitiveClass() {
        return this.primitiveClass;
    }

    private static class Prefix implements Comparable<Prefix> {
        private final byte[] prefix;

        private Prefix(byte[] bArr) {
            this.prefix = Arrays.copyOf(bArr, bArr.length);
        }

        public int hashCode() {
            return Arrays.hashCode(this.prefix);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Prefix)) {
                return false;
            }
            return Arrays.equals(this.prefix, ((Prefix) obj).prefix);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compareTo(com.google.crypto.tink.PrimitiveSet.Prefix r7) {
            /*
                r6 = this;
                byte[] r0 = r6.prefix
                int r1 = r0.length
                byte[] r2 = r7.prefix
                int r3 = r2.length
                if (r1 == r3) goto L_0x000c
                int r7 = r0.length
                int r0 = r2.length
            L_0x000a:
                int r7 = r7 - r0
                return r7
            L_0x000c:
                r0 = 0
                r1 = 0
            L_0x000e:
                byte[] r2 = r6.prefix
                int r3 = r2.length
                if (r1 >= r3) goto L_0x0023
                byte r3 = r2[r1]
                byte[] r4 = r7.prefix
                byte r5 = r4[r1]
                if (r3 == r5) goto L_0x0020
                byte r7 = r2[r1]
                byte r0 = r4[r1]
                goto L_0x000a
            L_0x0020:
                int r1 = r1 + 1
                goto L_0x000e
            L_0x0023:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.PrimitiveSet.Prefix.compareTo(com.google.crypto.tink.PrimitiveSet$Prefix):int");
        }

        public String toString() {
            return Hex.encode(this.prefix);
        }
    }

    public static class Builder<P> {
        private MonitoringAnnotations annotations;
        private Entry<P> primary;
        private final Class<P> primitiveClass;
        private ConcurrentMap<Prefix, List<Entry<P>>> primitives;

        private Builder<P> addPrimitive(P p, Keyset.Key key, boolean z) throws GeneralSecurityException {
            if (this.primitives == null) {
                throw new IllegalStateException("addPrimitive cannot be called after build");
            } else if (key.getStatus() == KeyStatusType.ENABLED) {
                Entry<P> access$100 = PrimitiveSet.addEntryToMap(p, key, this.primitives);
                if (z) {
                    if (this.primary == null) {
                        this.primary = access$100;
                    } else {
                        throw new IllegalStateException("you cannot set two primary primitives");
                    }
                }
                return this;
            } else {
                throw new GeneralSecurityException("only ENABLED key is allowed");
            }
        }

        public Builder<P> addPrimitive(P p, Keyset.Key key) throws GeneralSecurityException {
            return addPrimitive(p, key, false);
        }

        public Builder<P> addPrimaryPrimitive(P p, Keyset.Key key) throws GeneralSecurityException {
            return addPrimitive(p, key, true);
        }

        public Builder<P> setAnnotations(MonitoringAnnotations monitoringAnnotations) {
            if (this.primitives != null) {
                this.annotations = monitoringAnnotations;
                return this;
            }
            throw new IllegalStateException("setAnnotations cannot be called after build");
        }

        public PrimitiveSet<P> build() throws GeneralSecurityException {
            ConcurrentMap<Prefix, List<Entry<P>>> concurrentMap = this.primitives;
            if (concurrentMap != null) {
                PrimitiveSet primitiveSet = new PrimitiveSet(concurrentMap, this.primary, this.annotations, this.primitiveClass);
                this.primitives = null;
                return primitiveSet;
            }
            throw new IllegalStateException("build cannot be called twice");
        }

        private Builder(Class<P> cls) {
            this.primitives = new ConcurrentHashMap();
            this.primitiveClass = cls;
            this.annotations = MonitoringAnnotations.EMPTY;
        }
    }

    public static <P> Builder<P> newBuilder(Class<P> cls) {
        return new Builder<>(cls);
    }
}
