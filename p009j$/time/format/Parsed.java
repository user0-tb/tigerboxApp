package p009j$.time.format;

import com.google.android.exoplayer2.C0963C;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import p009j$.lang.Iterable;
import p009j$.time.Clock$SystemClock$$ExternalSyntheticOutline0;
import p009j$.time.DateTimeException;
import p009j$.time.Instant;
import p009j$.time.LocalDate;
import p009j$.time.LocalTime;
import p009j$.time.Period;
import p009j$.time.ZoneId;
import p009j$.time.ZoneOffset;
import p009j$.time.ZonedDateTime;
import p009j$.time.chrono.AbstractChronology;
import p009j$.time.chrono.ChronoLocalDate;
import p009j$.time.chrono.Chronology;
import p009j$.time.chrono.IsoChronology;
import p009j$.time.temporal.ChronoField;
import p009j$.time.temporal.TemporalAccessor;
import p009j$.time.temporal.TemporalAdjusters;
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
import p009j$.time.temporal.UnsupportedTemporalTypeException;
import p009j$.time.temporal.ValueRange;

/* renamed from: j$.time.format.Parsed */
final class Parsed implements TemporalAccessor {
    Chronology chrono;
    private ChronoLocalDate date;
    Period excessDays = Period.ZERO;
    final Map fieldValues = new HashMap();
    boolean leapSecond;
    private ResolverStyle resolverStyle;
    private LocalTime time;
    ZoneId zone;

    Parsed() {
    }

    private void crossCheck(TemporalAccessor temporalAccessor) {
        Iterator it = this.fieldValues.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            TemporalField temporalField = (TemporalField) entry.getKey();
            if (temporalAccessor.isSupported(temporalField)) {
                try {
                    long j = temporalAccessor.getLong(temporalField);
                    long longValue = ((Long) entry.getValue()).longValue();
                    if (j == longValue) {
                        it.remove();
                    } else {
                        throw new DateTimeException("Conflict found: Field " + temporalField + " " + j + " differs from " + temporalField + " " + longValue + " derived from " + temporalAccessor);
                    }
                } catch (RuntimeException unused) {
                    continue;
                }
            }
        }
    }

    private void resolveInstantFields() {
        if (this.fieldValues.containsKey(ChronoField.INSTANT_SECONDS)) {
            ZoneId zoneId = this.zone;
            if (zoneId == null) {
                Long l = (Long) this.fieldValues.get(ChronoField.OFFSET_SECONDS);
                if (l != null) {
                    zoneId = ZoneOffset.ofTotalSeconds(l.intValue());
                } else {
                    return;
                }
            }
            resolveInstantFields0(zoneId);
        }
    }

    private void resolveInstantFields0(ZoneId zoneId) {
        Map map = this.fieldValues;
        ChronoField chronoField = ChronoField.INSTANT_SECONDS;
        Instant ofEpochSecond = Instant.ofEpochSecond(((Long) map.remove(chronoField)).longValue());
        Objects.requireNonNull((IsoChronology) this.chrono);
        ZonedDateTime ofInstant = ZonedDateTime.ofInstant(ofEpochSecond, zoneId);
        updateCheckConflict(ofInstant.toLocalDate());
        updateCheckConflict(chronoField, ChronoField.SECOND_OF_DAY, Long.valueOf((long) ofInstant.toLocalTime().toSecondOfDay()));
    }

    private void resolveTime(long j, long j2, long j3, long j4) {
        LocalTime of;
        Period period;
        if (this.resolverStyle == ResolverStyle.LENIENT) {
            long m = Iterable.CC.m182m(Iterable.CC.m182m(Iterable.CC.m182m(Iterable.CC.m$3(j, 3600000000000L), Iterable.CC.m$3(j2, 60000000000L)), Iterable.CC.m$3(j3, C0963C.NANOS_PER_SECOND)), j4);
            of = LocalTime.ofNanoOfDay(Iterable.CC.m$1(m, 86400000000000L));
            period = Period.ofDays((int) Iterable.CC.m$2(m, 86400000000000L));
        } else {
            int checkValidIntValue = ChronoField.MINUTE_OF_HOUR.checkValidIntValue(j2);
            int checkValidIntValue2 = ChronoField.NANO_OF_SECOND.checkValidIntValue(j4);
            if (this.resolverStyle == ResolverStyle.SMART && j == 24 && checkValidIntValue == 0 && j3 == 0 && checkValidIntValue2 == 0) {
                of = LocalTime.MIDNIGHT;
                period = Period.ofDays(1);
            } else {
                of = LocalTime.m190of(ChronoField.HOUR_OF_DAY.checkValidIntValue(j), checkValidIntValue, ChronoField.SECOND_OF_MINUTE.checkValidIntValue(j3), checkValidIntValue2);
                period = Period.ZERO;
            }
        }
        updateCheckConflict(of, period);
    }

    private void resolveTimeFields() {
        Long l;
        ChronoField chronoField;
        Map map = this.fieldValues;
        ChronoField chronoField2 = ChronoField.CLOCK_HOUR_OF_DAY;
        long j = 0;
        if (map.containsKey(chronoField2)) {
            long longValue = ((Long) this.fieldValues.remove(chronoField2)).longValue();
            ResolverStyle resolverStyle2 = this.resolverStyle;
            if (resolverStyle2 == ResolverStyle.STRICT || (resolverStyle2 == ResolverStyle.SMART && longValue != 0)) {
                chronoField2.checkValidValue(longValue);
            }
            ChronoField chronoField3 = ChronoField.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            updateCheckConflict(chronoField2, chronoField3, Long.valueOf(longValue));
        }
        Map map2 = this.fieldValues;
        ChronoField chronoField4 = ChronoField.CLOCK_HOUR_OF_AMPM;
        if (map2.containsKey(chronoField4)) {
            long longValue2 = ((Long) this.fieldValues.remove(chronoField4)).longValue();
            ResolverStyle resolverStyle3 = this.resolverStyle;
            if (resolverStyle3 == ResolverStyle.STRICT || (resolverStyle3 == ResolverStyle.SMART && longValue2 != 0)) {
                chronoField4.checkValidValue(longValue2);
            }
            ChronoField chronoField5 = ChronoField.HOUR_OF_AMPM;
            if (longValue2 != 12) {
                j = longValue2;
            }
            updateCheckConflict(chronoField4, chronoField5, Long.valueOf(j));
        }
        Map map3 = this.fieldValues;
        ChronoField chronoField6 = ChronoField.AMPM_OF_DAY;
        if (map3.containsKey(chronoField6)) {
            Map map4 = this.fieldValues;
            ChronoField chronoField7 = ChronoField.HOUR_OF_AMPM;
            if (map4.containsKey(chronoField7)) {
                long longValue3 = ((Long) this.fieldValues.remove(chronoField6)).longValue();
                long longValue4 = ((Long) this.fieldValues.remove(chronoField7)).longValue();
                if (this.resolverStyle == ResolverStyle.LENIENT) {
                    chronoField = ChronoField.HOUR_OF_DAY;
                    l = Long.valueOf(Iterable.CC.m182m(Iterable.CC.m$3(longValue3, 12), longValue4));
                } else {
                    chronoField6.checkValidValue(longValue3);
                    chronoField7.checkValidValue(longValue3);
                    chronoField = ChronoField.HOUR_OF_DAY;
                    l = Long.valueOf((longValue3 * 12) + longValue4);
                }
                updateCheckConflict(chronoField6, chronoField, l);
            }
        }
        Map map5 = this.fieldValues;
        ChronoField chronoField8 = ChronoField.NANO_OF_DAY;
        if (map5.containsKey(chronoField8)) {
            long longValue5 = ((Long) this.fieldValues.remove(chronoField8)).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                chronoField8.checkValidValue(longValue5);
            }
            updateCheckConflict(chronoField8, ChronoField.HOUR_OF_DAY, Long.valueOf(longValue5 / 3600000000000L));
            updateCheckConflict(chronoField8, ChronoField.MINUTE_OF_HOUR, Long.valueOf((longValue5 / 60000000000L) % 60));
            updateCheckConflict(chronoField8, ChronoField.SECOND_OF_MINUTE, Long.valueOf((longValue5 / C0963C.NANOS_PER_SECOND) % 60));
            updateCheckConflict(chronoField8, ChronoField.NANO_OF_SECOND, Long.valueOf(longValue5 % C0963C.NANOS_PER_SECOND));
        }
        Map map6 = this.fieldValues;
        ChronoField chronoField9 = ChronoField.MICRO_OF_DAY;
        if (map6.containsKey(chronoField9)) {
            long longValue6 = ((Long) this.fieldValues.remove(chronoField9)).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                chronoField9.checkValidValue(longValue6);
            }
            updateCheckConflict(chronoField9, ChronoField.SECOND_OF_DAY, Long.valueOf(longValue6 / 1000000));
            updateCheckConflict(chronoField9, ChronoField.MICRO_OF_SECOND, Long.valueOf(longValue6 % 1000000));
        }
        Map map7 = this.fieldValues;
        ChronoField chronoField10 = ChronoField.MILLI_OF_DAY;
        if (map7.containsKey(chronoField10)) {
            long longValue7 = ((Long) this.fieldValues.remove(chronoField10)).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                chronoField10.checkValidValue(longValue7);
            }
            updateCheckConflict(chronoField10, ChronoField.SECOND_OF_DAY, Long.valueOf(longValue7 / 1000));
            updateCheckConflict(chronoField10, ChronoField.MILLI_OF_SECOND, Long.valueOf(longValue7 % 1000));
        }
        Map map8 = this.fieldValues;
        ChronoField chronoField11 = ChronoField.SECOND_OF_DAY;
        if (map8.containsKey(chronoField11)) {
            long longValue8 = ((Long) this.fieldValues.remove(chronoField11)).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                chronoField11.checkValidValue(longValue8);
            }
            updateCheckConflict(chronoField11, ChronoField.HOUR_OF_DAY, Long.valueOf(longValue8 / 3600));
            updateCheckConflict(chronoField11, ChronoField.MINUTE_OF_HOUR, Long.valueOf((longValue8 / 60) % 60));
            updateCheckConflict(chronoField11, ChronoField.SECOND_OF_MINUTE, Long.valueOf(longValue8 % 60));
        }
        Map map9 = this.fieldValues;
        ChronoField chronoField12 = ChronoField.MINUTE_OF_DAY;
        if (map9.containsKey(chronoField12)) {
            long longValue9 = ((Long) this.fieldValues.remove(chronoField12)).longValue();
            if (this.resolverStyle != ResolverStyle.LENIENT) {
                chronoField12.checkValidValue(longValue9);
            }
            updateCheckConflict(chronoField12, ChronoField.HOUR_OF_DAY, Long.valueOf(longValue9 / 60));
            updateCheckConflict(chronoField12, ChronoField.MINUTE_OF_HOUR, Long.valueOf(longValue9 % 60));
        }
        Map map10 = this.fieldValues;
        ChronoField chronoField13 = ChronoField.NANO_OF_SECOND;
        if (map10.containsKey(chronoField13)) {
            long longValue10 = ((Long) this.fieldValues.get(chronoField13)).longValue();
            ResolverStyle resolverStyle4 = this.resolverStyle;
            ResolverStyle resolverStyle5 = ResolverStyle.LENIENT;
            if (resolverStyle4 != resolverStyle5) {
                chronoField13.checkValidValue(longValue10);
            }
            Map map11 = this.fieldValues;
            ChronoField chronoField14 = ChronoField.MICRO_OF_SECOND;
            if (map11.containsKey(chronoField14)) {
                long longValue11 = ((Long) this.fieldValues.remove(chronoField14)).longValue();
                if (this.resolverStyle != resolverStyle5) {
                    chronoField14.checkValidValue(longValue11);
                }
                longValue10 = (longValue10 % 1000) + (longValue11 * 1000);
                updateCheckConflict(chronoField14, chronoField13, Long.valueOf(longValue10));
            }
            Map map12 = this.fieldValues;
            ChronoField chronoField15 = ChronoField.MILLI_OF_SECOND;
            if (map12.containsKey(chronoField15)) {
                long longValue12 = ((Long) this.fieldValues.remove(chronoField15)).longValue();
                if (this.resolverStyle != resolverStyle5) {
                    chronoField15.checkValidValue(longValue12);
                }
                updateCheckConflict(chronoField15, chronoField13, Long.valueOf((longValue10 % 1000000) + (longValue12 * 1000000)));
            }
        }
        Map map13 = this.fieldValues;
        ChronoField chronoField16 = ChronoField.HOUR_OF_DAY;
        if (map13.containsKey(chronoField16)) {
            Map map14 = this.fieldValues;
            ChronoField chronoField17 = ChronoField.MINUTE_OF_HOUR;
            if (map14.containsKey(chronoField17)) {
                Map map15 = this.fieldValues;
                ChronoField chronoField18 = ChronoField.SECOND_OF_MINUTE;
                if (map15.containsKey(chronoField18) && this.fieldValues.containsKey(chronoField13)) {
                    resolveTime(((Long) this.fieldValues.remove(chronoField16)).longValue(), ((Long) this.fieldValues.remove(chronoField17)).longValue(), ((Long) this.fieldValues.remove(chronoField18)).longValue(), ((Long) this.fieldValues.remove(chronoField13)).longValue());
                }
            }
        }
    }

    private void updateCheckConflict(LocalTime localTime, Period period) {
        LocalTime localTime2 = this.time;
        if (localTime2 == null) {
            this.time = localTime;
        } else if (!localTime2.equals(localTime)) {
            StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Conflict found: Fields resolved to different times: ");
            m.append(this.time);
            m.append(" ");
            m.append(localTime);
            throw new DateTimeException(m.toString());
        } else if (!this.excessDays.isZero() && !period.isZero() && !this.excessDays.equals(period)) {
            StringBuilder m2 = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Conflict found: Fields resolved to different excess periods: ");
            m2.append(this.excessDays);
            m2.append(" ");
            m2.append(period);
            throw new DateTimeException(m2.toString());
        }
        this.excessDays = period;
    }

    private void updateCheckConflict(ChronoLocalDate chronoLocalDate) {
        ChronoLocalDate chronoLocalDate2 = this.date;
        if (chronoLocalDate2 != null) {
            if (chronoLocalDate != null && !chronoLocalDate2.equals(chronoLocalDate)) {
                StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Conflict found: Fields resolved to two different dates: ");
                m.append(this.date);
                m.append(" ");
                m.append(chronoLocalDate);
                throw new DateTimeException(m.toString());
            }
        } else if (chronoLocalDate != null) {
            if (((AbstractChronology) this.chrono).equals(chronoLocalDate.getChronology())) {
                this.date = chronoLocalDate;
                return;
            }
            StringBuilder m2 = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("ChronoLocalDate must use the effective parsed chronology: ");
            m2.append(this.chrono);
            throw new DateTimeException(m2.toString());
        }
    }

    private void updateCheckConflict(TemporalField temporalField, TemporalField temporalField2, Long l) {
        Long l2 = (Long) this.fieldValues.put(temporalField2, l);
        if (l2 != null && l2.longValue() != l.longValue()) {
            throw new DateTimeException("Conflict found: " + temporalField2 + " " + l2 + " differs from " + temporalField2 + " " + l + " while resolving  " + temporalField);
        }
    }

    public /* synthetic */ int get(TemporalField temporalField) {
        return TemporalAdjusters.$default$get(this, temporalField);
    }

    public long getLong(TemporalField temporalField) {
        Objects.requireNonNull(temporalField, "field");
        Long l = (Long) this.fieldValues.get(temporalField);
        if (l != null) {
            return l.longValue();
        }
        ChronoLocalDate chronoLocalDate = this.date;
        if (chronoLocalDate != null && chronoLocalDate.isSupported(temporalField)) {
            return this.date.getLong(temporalField);
        }
        LocalTime localTime = this.time;
        if (localTime != null && localTime.isSupported(temporalField)) {
            return this.time.getLong(temporalField);
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.getFrom(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + temporalField);
    }

    public boolean isSupported(TemporalField temporalField) {
        if (this.fieldValues.containsKey(temporalField)) {
            return true;
        }
        ChronoLocalDate chronoLocalDate = this.date;
        if (chronoLocalDate != null && chronoLocalDate.isSupported(temporalField)) {
            return true;
        }
        LocalTime localTime = this.time;
        if (localTime == null || !localTime.isSupported(temporalField)) {
            return temporalField != null && !(temporalField instanceof ChronoField) && temporalField.isSupportedBy(this);
        }
        return true;
    }

    public Object query(TemporalQuery temporalQuery) {
        int i = TemporalQueries.$r8$clinit;
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda0.INSTANCE) {
            return this.zone;
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda1.INSTANCE) {
            return this.chrono;
        }
        if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda5.INSTANCE) {
            ChronoLocalDate chronoLocalDate = this.date;
            if (chronoLocalDate != null) {
                return LocalDate.from(chronoLocalDate);
            }
            return null;
        } else if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda6.INSTANCE) {
            return this.time;
        } else {
            if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda4.INSTANCE || temporalQuery == TemporalQueries$$ExternalSyntheticLambda3.INSTANCE) {
                return temporalQuery.queryFrom(this);
            }
            if (temporalQuery == TemporalQueries$$ExternalSyntheticLambda2.INSTANCE) {
                return null;
            }
            return temporalQuery.queryFrom(this);
        }
    }

    public /* synthetic */ ValueRange range(TemporalField temporalField) {
        return TemporalAdjusters.$default$range(this, temporalField);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0301  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0239  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p009j$.time.temporal.TemporalAccessor resolve(p009j$.time.format.ResolverStyle r19, java.util.Set r20) {
        /*
            r18 = this;
            r9 = r18
            r0 = r20
            if (r0 == 0) goto L_0x000f
            java.util.Map r1 = r9.fieldValues
            java.util.Set r1 = r1.keySet()
            r1.retainAll(r0)
        L_0x000f:
            r0 = r19
            r9.resolverStyle = r0
            r18.resolveInstantFields()
            j$.time.chrono.Chronology r0 = r9.chrono
            java.util.Map r1 = r9.fieldValues
            j$.time.format.ResolverStyle r2 = r9.resolverStyle
            j$.time.chrono.IsoChronology r0 = (p009j$.time.chrono.IsoChronology) r0
            j$.time.chrono.ChronoLocalDate r0 = r0.resolveDate(r1, r2)
            r9.updateCheckConflict(r0)
            r18.resolveTimeFields()
            java.util.Map r0 = r9.fieldValues
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00fd
            r0 = 0
        L_0x0031:
            r1 = 50
            if (r0 >= r1) goto L_0x00db
            java.util.Map r2 = r9.fieldValues
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x003f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00db
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getKey()
            j$.time.temporal.TemporalField r3 = (p009j$.time.temporal.TemporalField) r3
            java.util.Map r4 = r9.fieldValues
            j$.time.format.ResolverStyle r5 = r9.resolverStyle
            j$.time.temporal.TemporalAccessor r4 = r3.resolve(r4, r9, r5)
            if (r4 == 0) goto L_0x00cf
            boolean r1 = r4 instanceof p009j$.time.chrono.ChronoZonedDateTime
            if (r1 == 0) goto L_0x0098
            j$.time.chrono.ChronoZonedDateTime r4 = (p009j$.time.chrono.ChronoZonedDateTime) r4
            j$.time.ZoneId r1 = r9.zone
            if (r1 != 0) goto L_0x006f
            r1 = r4
            j$.time.ZonedDateTime r1 = (p009j$.time.ZonedDateTime) r1
            j$.time.ZoneId r1 = r1.getZone()
            r9.zone = r1
            goto L_0x007c
        L_0x006f:
            r2 = r4
            j$.time.ZonedDateTime r2 = (p009j$.time.ZonedDateTime) r2
            j$.time.ZoneId r2 = r2.getZone()
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0083
        L_0x007c:
            j$.time.ZonedDateTime r4 = (p009j$.time.ZonedDateTime) r4
            j$.time.chrono.ChronoLocalDateTime r4 = r4.toLocalDateTime()
            goto L_0x0098
        L_0x0083:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            java.lang.String r1 = "ChronoZonedDateTime must use the effective parsed zone: "
            java.lang.StringBuilder r1 = p009j$.time.Clock$SystemClock$$ExternalSyntheticOutline0.m183m(r1)
            j$.time.ZoneId r2 = r9.zone
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0098:
            boolean r1 = r4 instanceof p009j$.time.chrono.ChronoLocalDateTime
            if (r1 == 0) goto L_0x00b1
            j$.time.chrono.ChronoLocalDateTime r4 = (p009j$.time.chrono.ChronoLocalDateTime) r4
            j$.time.LocalDateTime r4 = (p009j$.time.LocalDateTime) r4
            j$.time.LocalTime r1 = r4.toLocalTime()
            j$.time.Period r2 = p009j$.time.Period.ZERO
            r9.updateCheckConflict(r1, r2)
            j$.time.chrono.ChronoLocalDate r1 = r4.toLocalDate()
            r9.updateCheckConflict(r1)
            goto L_0x00d7
        L_0x00b1:
            boolean r1 = r4 instanceof p009j$.time.chrono.ChronoLocalDate
            if (r1 == 0) goto L_0x00bb
            j$.time.chrono.ChronoLocalDate r4 = (p009j$.time.chrono.ChronoLocalDate) r4
            r9.updateCheckConflict(r4)
            goto L_0x00d7
        L_0x00bb:
            boolean r1 = r4 instanceof p009j$.time.LocalTime
            if (r1 == 0) goto L_0x00c7
            j$.time.LocalTime r4 = (p009j$.time.LocalTime) r4
            j$.time.Period r1 = p009j$.time.Period.ZERO
            r9.updateCheckConflict(r4, r1)
            goto L_0x00d7
        L_0x00c7:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            java.lang.String r1 = "Method resolve() can only return ChronoZonedDateTime, ChronoLocalDateTime, ChronoLocalDate or LocalTime"
            r0.<init>(r1)
            throw r0
        L_0x00cf:
            java.util.Map r4 = r9.fieldValues
            boolean r3 = r4.containsKey(r3)
            if (r3 != 0) goto L_0x003f
        L_0x00d7:
            int r0 = r0 + 1
            goto L_0x0031
        L_0x00db:
            if (r0 == r1) goto L_0x00f5
            if (r0 <= 0) goto L_0x00fd
            r18.resolveInstantFields()
            j$.time.chrono.Chronology r0 = r9.chrono
            java.util.Map r1 = r9.fieldValues
            j$.time.format.ResolverStyle r2 = r9.resolverStyle
            j$.time.chrono.IsoChronology r0 = (p009j$.time.chrono.IsoChronology) r0
            j$.time.chrono.ChronoLocalDate r0 = r0.resolveDate(r1, r2)
            r9.updateCheckConflict(r0)
            r18.resolveTimeFields()
            goto L_0x00fd
        L_0x00f5:
            j$.time.DateTimeException r0 = new j$.time.DateTimeException
            java.lang.String r1 = "One of the parsed fields has an incorrectly implemented resolve method"
            r0.<init>(r1)
            throw r0
        L_0x00fd:
            j$.time.LocalTime r0 = r9.time
            r1 = 1000000(0xf4240, double:4.940656E-318)
            r10 = 1000(0x3e8, double:4.94E-321)
            if (r0 != 0) goto L_0x01ea
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r3 = p009j$.time.temporal.ChronoField.MILLI_OF_SECOND
            boolean r0 = r0.containsKey(r3)
            if (r0 == 0) goto L_0x0150
            java.util.Map r0 = r9.fieldValues
            java.lang.Object r0 = r0.remove(r3)
            java.lang.Long r0 = (java.lang.Long) r0
            long r4 = r0.longValue()
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r6 = p009j$.time.temporal.ChronoField.MICRO_OF_SECOND
            boolean r0 = r0.containsKey(r6)
            if (r0 == 0) goto L_0x0143
            long r4 = r4 * r10
            java.util.Map r0 = r9.fieldValues
            java.lang.Object r0 = r0.get(r6)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            long r0 = r0 % r10
            long r0 = r0 + r4
            java.lang.Long r2 = java.lang.Long.valueOf(r0)
            r9.updateCheckConflict(r3, r6, r2)
            java.util.Map r2 = r9.fieldValues
            r2.remove(r6)
            goto L_0x0166
        L_0x0143:
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r3 = p009j$.time.temporal.ChronoField.NANO_OF_SECOND
            long r4 = r4 * r1
            java.lang.Long r1 = java.lang.Long.valueOf(r4)
            r2 = r0
            r0 = r1
            goto L_0x0170
        L_0x0150:
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MICRO_OF_SECOND
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0173
            java.util.Map r0 = r9.fieldValues
            java.lang.Object r0 = r0.remove(r1)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
        L_0x0166:
            java.util.Map r2 = r9.fieldValues
            j$.time.temporal.ChronoField r3 = p009j$.time.temporal.ChronoField.NANO_OF_SECOND
            long r0 = r0 * r10
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
        L_0x0170:
            r2.put(r3, r0)
        L_0x0173:
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r12 = p009j$.time.temporal.ChronoField.HOUR_OF_DAY
            java.lang.Object r0 = r0.get(r12)
            java.lang.Long r0 = (java.lang.Long) r0
            if (r0 == 0) goto L_0x01ea
            java.util.Map r1 = r9.fieldValues
            j$.time.temporal.ChronoField r13 = p009j$.time.temporal.ChronoField.MINUTE_OF_HOUR
            java.lang.Object r1 = r1.get(r13)
            java.lang.Long r1 = (java.lang.Long) r1
            java.util.Map r2 = r9.fieldValues
            j$.time.temporal.ChronoField r14 = p009j$.time.temporal.ChronoField.SECOND_OF_MINUTE
            java.lang.Object r2 = r2.get(r14)
            java.lang.Long r2 = (java.lang.Long) r2
            java.util.Map r3 = r9.fieldValues
            j$.time.temporal.ChronoField r15 = p009j$.time.temporal.ChronoField.NANO_OF_SECOND
            java.lang.Object r3 = r3.get(r15)
            java.lang.Long r3 = (java.lang.Long) r3
            if (r1 != 0) goto L_0x01a3
            if (r2 != 0) goto L_0x022e
            if (r3 != 0) goto L_0x022e
        L_0x01a3:
            if (r1 == 0) goto L_0x01ab
            if (r2 != 0) goto L_0x01ab
            if (r3 == 0) goto L_0x01ab
            goto L_0x022e
        L_0x01ab:
            if (r1 == 0) goto L_0x01b2
            long r4 = r1.longValue()
            goto L_0x01b4
        L_0x01b2:
            r4 = 0
        L_0x01b4:
            if (r2 == 0) goto L_0x01bb
            long r1 = r2.longValue()
            goto L_0x01bd
        L_0x01bb:
            r1 = 0
        L_0x01bd:
            r6 = r1
            if (r3 == 0) goto L_0x01c5
            long r1 = r3.longValue()
            goto L_0x01c7
        L_0x01c5:
            r1 = 0
        L_0x01c7:
            r16 = r1
            long r1 = r0.longValue()
            r0 = r18
            r3 = r4
            r5 = r6
            r7 = r16
            r0.resolveTime(r1, r3, r5, r7)
            java.util.Map r0 = r9.fieldValues
            r0.remove(r12)
            java.util.Map r0 = r9.fieldValues
            r0.remove(r13)
            java.util.Map r0 = r9.fieldValues
            r0.remove(r14)
            java.util.Map r0 = r9.fieldValues
            r0.remove(r15)
        L_0x01ea:
            j$.time.format.ResolverStyle r0 = r9.resolverStyle
            j$.time.format.ResolverStyle r1 = p009j$.time.format.ResolverStyle.LENIENT
            if (r0 == r1) goto L_0x022e
            java.util.Map r0 = r9.fieldValues
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x022e
            java.util.Map r0 = r9.fieldValues
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0202:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x022e
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            j$.time.temporal.TemporalField r2 = (p009j$.time.temporal.TemporalField) r2
            boolean r3 = r2 instanceof p009j$.time.temporal.ChronoField
            if (r3 == 0) goto L_0x0202
            boolean r3 = r2.isTimeBased()
            if (r3 == 0) goto L_0x0202
            j$.time.temporal.ChronoField r2 = (p009j$.time.temporal.ChronoField) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.Long r1 = (java.lang.Long) r1
            long r3 = r1.longValue()
            r2.checkValidValue(r3)
            goto L_0x0202
        L_0x022e:
            j$.time.chrono.ChronoLocalDate r0 = r9.date
            if (r0 == 0) goto L_0x0235
            r9.crossCheck(r0)
        L_0x0235:
            j$.time.LocalTime r0 = r9.time
            if (r0 == 0) goto L_0x0253
            r9.crossCheck(r0)
            j$.time.chrono.ChronoLocalDate r0 = r9.date
            if (r0 == 0) goto L_0x0253
            java.util.Map r0 = r9.fieldValues
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0253
            j$.time.chrono.ChronoLocalDate r0 = r9.date
            j$.time.LocalTime r1 = r9.time
            j$.time.chrono.ChronoLocalDateTime r0 = r0.atTime(r1)
            r9.crossCheck(r0)
        L_0x0253:
            j$.time.chrono.ChronoLocalDate r0 = r9.date
            if (r0 == 0) goto L_0x0271
            j$.time.LocalTime r0 = r9.time
            if (r0 == 0) goto L_0x0271
            j$.time.Period r0 = r9.excessDays
            boolean r0 = r0.isZero()
            if (r0 != 0) goto L_0x0271
            j$.time.chrono.ChronoLocalDate r0 = r9.date
            j$.time.Period r1 = r9.excessDays
            j$.time.chrono.ChronoLocalDate r0 = r0.plus(r1)
            r9.date = r0
            j$.time.Period r0 = p009j$.time.Period.ZERO
            r9.excessDays = r0
        L_0x0271:
            j$.time.LocalTime r0 = r9.time
            if (r0 != 0) goto L_0x02e7
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.INSTANT_SECONDS
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0293
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.SECOND_OF_DAY
            boolean r0 = r0.containsKey(r1)
            if (r0 != 0) goto L_0x0293
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.SECOND_OF_MINUTE
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x02e7
        L_0x0293:
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.NANO_OF_SECOND
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x02c6
            java.util.Map r0 = r9.fieldValues
            java.lang.Object r0 = r0.get(r1)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            java.util.Map r2 = r9.fieldValues
            j$.time.temporal.ChronoField r3 = p009j$.time.temporal.ChronoField.MICRO_OF_SECOND
            long r4 = r0 / r10
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2.put(r3, r4)
            java.util.Map r2 = r9.fieldValues
            j$.time.temporal.ChronoField r3 = p009j$.time.temporal.ChronoField.MILLI_OF_SECOND
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r4
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r2.put(r3, r0)
            goto L_0x02e7
        L_0x02c6:
            java.util.Map r0 = r9.fieldValues
            r2 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r2)
            r0.put(r1, r4)
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MICRO_OF_SECOND
            java.lang.Long r4 = java.lang.Long.valueOf(r2)
            r0.put(r1, r4)
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.MILLI_OF_SECOND
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0.put(r1, r2)
        L_0x02e7:
            j$.time.chrono.ChronoLocalDate r0 = r9.date
            if (r0 == 0) goto L_0x0332
            j$.time.LocalTime r1 = r9.time
            if (r1 == 0) goto L_0x0332
            j$.time.ZoneId r2 = r9.zone
            r3 = 0
            if (r2 == 0) goto L_0x0301
            j$.time.chrono.ChronoLocalDateTime r0 = r0.atTime(r1)
            j$.time.ZoneId r1 = r9.zone
            j$.time.LocalDateTime r0 = (p009j$.time.LocalDateTime) r0
            j$.time.ZonedDateTime r0 = p009j$.time.ZonedDateTime.ofLocal(r0, r1, r3)
            goto L_0x0323
        L_0x0301:
            java.util.Map r0 = r9.fieldValues
            j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.OFFSET_SECONDS
            java.lang.Object r0 = r0.get(r1)
            java.lang.Long r0 = (java.lang.Long) r0
            if (r0 == 0) goto L_0x0332
            int r0 = r0.intValue()
            j$.time.ZoneOffset r0 = p009j$.time.ZoneOffset.ofTotalSeconds(r0)
            j$.time.chrono.ChronoLocalDate r1 = r9.date
            j$.time.LocalTime r2 = r9.time
            j$.time.chrono.ChronoLocalDateTime r1 = r1.atTime(r2)
            j$.time.LocalDateTime r1 = (p009j$.time.LocalDateTime) r1
            j$.time.ZonedDateTime r0 = p009j$.time.ZonedDateTime.ofLocal(r1, r0, r3)
        L_0x0323:
            j$.time.temporal.ChronoField r1 = p009j$.time.temporal.ChronoField.INSTANT_SECONDS
            long r2 = r0.getLong(r1)
            java.util.Map r0 = r9.fieldValues
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0.put(r1, r2)
        L_0x0332:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p009j$.time.format.Parsed.resolve(j$.time.format.ResolverStyle, java.util.Set):j$.time.temporal.TemporalAccessor");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.fieldValues);
        sb.append(',');
        sb.append(this.chrono);
        if (this.zone != null) {
            sb.append(',');
            sb.append(this.zone);
        }
        if (!(this.date == null && this.time == null)) {
            sb.append(" resolved to ");
            ChronoLocalDate chronoLocalDate = this.date;
            if (chronoLocalDate != null) {
                sb.append(chronoLocalDate);
                if (this.time != null) {
                    sb.append('T');
                }
            }
            sb.append(this.time);
        }
        return sb.toString();
    }
}
