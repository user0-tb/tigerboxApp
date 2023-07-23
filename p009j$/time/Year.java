package p009j$.time;

import java.io.Serializable;
import p009j$.time.format.DateTimeFormatterBuilder;
import p009j$.time.format.SignStyle;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.Temporal;
import p009j$.time.temporal.TemporalAdjuster;

/* renamed from: j$.time.Year */
public abstract class Year implements Temporal, TemporalAdjuster, Comparable, Serializable {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).toFormatter();
    }
}
