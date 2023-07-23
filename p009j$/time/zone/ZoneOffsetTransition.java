package p009j$.time.zone;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p009j$.time.Clock$SystemClock$$ExternalSyntheticOutline0;
import p009j$.time.Duration;
import p009j$.time.Instant;
import p009j$.time.LocalDateTime;
import p009j$.time.ZoneOffset;

/* renamed from: j$.time.zone.ZoneOffsetTransition */
public final class ZoneOffsetTransition implements Comparable, Serializable {
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final LocalDateTime transition;

    ZoneOffsetTransition(long j, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.transition = LocalDateTime.ofEpochSecond(j, 0, zoneOffset);
        this.offsetBefore = zoneOffset;
        this.offsetAfter = zoneOffset2;
    }

    ZoneOffsetTransition(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.transition = localDateTime;
        this.offsetBefore = zoneOffset;
        this.offsetAfter = zoneOffset2;
    }

    public int compareTo(Object obj) {
        return getInstant().compareTo(((ZoneOffsetTransition) obj).getInstant());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransition)) {
            return false;
        }
        ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
        return this.transition.equals(zoneOffsetTransition.transition) && this.offsetBefore.equals(zoneOffsetTransition.offsetBefore) && this.offsetAfter.equals(zoneOffsetTransition.offsetAfter);
    }

    public LocalDateTime getDateTimeAfter() {
        return this.transition.plusSeconds((long) (this.offsetAfter.getTotalSeconds() - this.offsetBefore.getTotalSeconds()));
    }

    public LocalDateTime getDateTimeBefore() {
        return this.transition;
    }

    public Duration getDuration() {
        return Duration.ofSeconds((long) (this.offsetAfter.getTotalSeconds() - this.offsetBefore.getTotalSeconds()));
    }

    public Instant getInstant() {
        LocalDateTime localDateTime = this.transition;
        return Instant.ofEpochSecond(localDateTime.toEpochSecond(this.offsetBefore), (long) localDateTime.toLocalTime().getNano());
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    /* access modifiers changed from: package-private */
    public List getValidOffsets() {
        if (isGap()) {
            return Collections.emptyList();
        }
        return Arrays.asList(new ZoneOffset[]{this.offsetBefore, this.offsetAfter});
    }

    public int hashCode() {
        return (this.transition.hashCode() ^ this.offsetBefore.hashCode()) ^ Integer.rotateLeft(this.offsetAfter.hashCode(), 16);
    }

    public boolean isGap() {
        return this.offsetAfter.getTotalSeconds() > this.offsetBefore.getTotalSeconds();
    }

    public long toEpochSecond() {
        return this.transition.toEpochSecond(this.offsetBefore);
    }

    public String toString() {
        StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("Transition[");
        m.append(isGap() ? "Gap" : "Overlap");
        m.append(" at ");
        m.append(this.transition);
        m.append(this.offsetBefore);
        m.append(" to ");
        m.append(this.offsetAfter);
        m.append(']');
        return m.toString();
    }
}
