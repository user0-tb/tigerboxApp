package p012io.shipbook.shipbooksdk.Models;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

@Metadata(mo33736d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/Severity;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Off", "Error", "Warning", "Info", "Debug", "Verbose", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.Severity */
/* compiled from: Severity.kt */
public enum Severity {
    Off(0),
    Error(6),
    Warning(5),
    Info(4),
    Debug(3),
    Verbose(2);
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<Integer, Severity> map = null;
    private final int value;

    private Severity(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        int i;
        Companion = new Companion((DefaultConstructorMarker) null);
        Severity[] values = values();
        Map<Integer, Severity> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        int length = values.length;
        while (i < length) {
            Severity severity = values[i];
            i++;
            linkedHashMap.put(Integer.valueOf(severity.getValue()), severity);
        }
        map = linkedHashMap;
    }

    @Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/Severity$Companion;", "", "()V", "map", "", "", "Lio/shipbook/shipbooksdk/Models/Severity;", "fromInt", "type", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.Severity$Companion */
    /* compiled from: Severity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Severity fromInt(int i) {
            Severity severity = (Severity) Severity.map.get(Integer.valueOf(i));
            return severity == null ? Severity.Verbose : severity;
        }
    }
}
