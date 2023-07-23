package p009j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import p009j$.time.chrono.ChronoLocalDate;
import p009j$.time.chrono.ChronoLocalDateTime;
import p009j$.time.chrono.ChronoZonedDateTime;
import p009j$.time.chrono.Chronology;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.ChronoUnit;
import p009j$.time.temporal.Temporal;
import p009j$.time.temporal.TemporalAdjuster;
import p009j$.time.temporal.TemporalField;
import p009j$.time.temporal.TemporalQueries;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda0;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda1;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda2;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda3;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda4;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda5;
import p009j$.time.temporal.TemporalQueries$$ExternalSyntheticLambda6;
import p009j$.time.temporal.TemporalQuery;
import p009j$.time.temporal.TemporalUnit;
import p009j$.time.temporal.UnsupportedTemporalTypeException;
import p009j$.time.temporal.ValueRange;
import p009j$.time.zone.ZoneOffsetTransition;
import p009j$.time.zone.ZoneRules;

/* renamed from: j$.time.ZonedDateTime */
public final class ZonedDateTime implements Temporal, ChronoZonedDateTime, Serializable {
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    /* renamed from: j$.time.ZonedDateTime$1 */
    abstract /* synthetic */ class C14141 {
        static final /* synthetic */ int[] $SwitchMap$java$time$temporal$ChronoField;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                j$.time.temporal.ChronoField[] r0 = p009j$.time.temporal.ChronoField.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$time$temporal$ChronoField = r0
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$java$time$temporal$ChronoField     // Catch:{ NoSuchFieldError -> 0x001d }
                j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009j$.time.ZonedDateTime.C14141.<clinit>():void");
        }
    }

    private ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.dateTime = localDateTime;
        this.offset = zoneOffset;
        this.zone = zoneId;
    }

    private static ZonedDateTime create(long j, int i, ZoneId zoneId) {
        ZoneOffset offset2 = zoneId.getRules().getOffset(Instant.ofEpochSecond(j, (long) i));
        return new ZonedDateTime(LocalDateTime.ofEpochSecond(j, i, offset2), offset2, zoneId);
    }

    public static ZonedDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return create(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    public static ZonedDateTime ofLocal(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules rules = zoneId.getRules();
        List validOffsets = rules.getValidOffsets(localDateTime);
        if (validOffsets.size() == 1) {
            zoneOffset = (ZoneOffset) validOffsets.get(0);
        } else if (validOffsets.size() == 0) {
            ZoneOffsetTransition transition = rules.getTransition(localDateTime);
            localDateTime = localDateTime.plusSeconds(transition.getDuration().getSeconds());
            zoneOffset = transition.getOffsetAfter();
        } else if (zoneOffset == null || !validOffsets.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) validOffsets.get(0);
            Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        }
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    private ZonedDateTime resolveLocal(LocalDateTime localDateTime) {
        return ofLocal(localDateTime, this.zone, this.offset);
    }

    private ZonedDateTime resolveOffset(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.offset) || !this.zone.getRules().getValidOffsets(this.dateTime).contains(zoneOffset)) ? this : new ZonedDateTime(this.dateTime, zoneOffset, this.zone);
    }

    public int compareTo(Object obj) {
        ZonedDateTime zonedDateTime = (ZonedDateTime) ((ChronoZonedDateTime) obj);
        int compare = Long.compare(toEpochSecond(), zonedDateTime.toEpochSecond());
        if (compare != 0) {
            return compare;
        }
        int nano = toLocalTime().getNano() - zonedDateTime.toLocalTime().getNano();
        if (nano != 0) {
            return nano;
        }
        int compareTo = ((LocalDateTime) toLocalDateTime()).compareTo(zonedDateTime.toLocalDateTime());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = getZone().getId().compareTo(zonedDateTime.getZone().getId());
        if (compareTo2 != 0) {
            return compareTo2;
        }
        getChronology();
        IsoChronology isoChronology = IsoChronology.INSTANCE;
        zonedDateTime.getChronology();
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        return this.dateTime.equals(zonedDateTime.dateTime) && this.offset.equals(zonedDateTime.offset) && this.zone.equals(zonedDateTime.zone);
    }

    public int get(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return Chronology.CC.$default$get(this, temporalField);
        }
        int i = C14141.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i == 1) {
            throw new UnsupportedTemporalTypeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i != 2) {
            return this.dateTime.get(temporalField);
        } else {
            return this.offset.getTotalSeconds();
        }
    }

    public Chronology getChronology() {
        Objects.requireNonNull((LocalDate) toLocalDate());
        return IsoChronology.INSTANCE;
    }

    public long getLong(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        int i = C14141.$SwitchMap$java$time$temporal$ChronoField[((ChronoField) temporalField).ordinal()];
        if (i == 1) {
            return toEpochSecond();
        }
        if (i != 2) {
            return this.dateTime.getLong(temporalField);
        }
        return (long) this.offset.getTotalSeconds();
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public ZoneId getZone() {
        return this.zone;
    }

    public int hashCode() {
        return (this.dateTime.hashCode() ^ this.offset.hashCode()) ^ Integer.rotateLeft(this.zone.hashCode(), 3);
    }

    public boolean isSupported(TemporalField temporalField) {
        return (temporalField instanceof ChronoField) || (temporalField != null && temporalField.isSupportedBy(this));
    }

    public ZonedDateTime plus(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (ZonedDateTime) temporalUnit.addTo(this, j);
        }
        if (temporalUnit.isDateBased()) {
            return resolveLocal(this.dateTime.plus(j, temporalUnit));
        }
        LocalDateTime plus = this.dateTime.plus(j, temporalUnit);
        ZoneOffset zoneOffset = this.offset;
        ZoneId zoneId = this.zone;
        Objects.requireNonNull(plus, "localDateTime");
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        Objects.requireNonNull(zoneId, "zone");
        return zoneId.getRules().getValidOffsets(plus).contains(zoneOffset) ? new ZonedDateTime(plus, zoneOffset, zoneId) : create(plus.toEpochSecond(zoneOffset), plus.getNano(), zoneId);
    }

    public Object query(TemporalQuery temporalQuery) {
        int i = TemporalQueries.$r8$clinit;
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda5.INSTANCE) {
            return this.dateTime.toLocalDate();
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda4.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda0.INSTANCE) {
            return this.zone;
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda3.INSTANCE) {
            return this.offset;
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda6.INSTANCE) {
            return toLocalTime();
        }
        if (temporalQuery != TemporalQueries$$ExternalSyntheticLambda1.INSTANCE) {
            return temporalQuery == TemporalQueries$$ExternalSyntheticLambda2.INSTANCE ? ChronoUnit.NANOS : temporalQuery.queryFrom(this);
        }
        getChronology();
        return IsoChronology.INSTANCE;
    }

    public ValueRange range(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? (temporalField == ChronoField.INSTANT_SECONDS || temporalField == ChronoField.OFFSET_SECONDS) ? temporalField.range() : this.dateTime.range(temporalField) : temporalField.rangeRefinedBy(this);
    }

    public long toEpochSecond() {
        return ((((LocalDate) toLocalDate()).toEpochDay() * 86400) + ((long) toLocalTime().toSecondOfDay())) - ((long) getOffset().getTotalSeconds());
    }

    public ChronoLocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    public ChronoLocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public String toString() {
        String str = this.dateTime.toString() + this.offset.toString();
        if (this.offset == this.zone) {
            return str;
        }
        return str + '[' + this.zone.toString() + ']';
    }

    public Temporal with(TemporalAdjuster temporalAdjuster) {
        return ofLocal(LocalDateTime.m188of((LocalDate) temporalAdjuster, this.dateTime.toLocalTime()), this.zone, this.offset);
    }

    public Temporal with(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (ZonedDateTime) temporalField.adjustInto(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        int i = C14141.$SwitchMap$java$time$temporal$ChronoField[chronoField.ordinal()];
        if (i != 1) {
            return i != 2 ? resolveLocal(this.dateTime.with(temporalField, j)) : resolveOffset(ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j)));
        }
        return create(j, this.dateTime.getNano(), this.zone);
    }
}
