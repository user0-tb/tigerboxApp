package p009j$.time;

import java.io.Serializable;

/* renamed from: j$.time.Clock */
public abstract class Clock {

    /* renamed from: j$.time.Clock$SystemClock */
    static final class SystemClock extends Clock implements Serializable {
        private final ZoneId zone;

        SystemClock(ZoneId zoneId) {
            this.zone = zoneId;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SystemClock) {
                return this.zone.equals(((SystemClock) obj).zone);
            }
            return false;
        }

        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        public Instant instant() {
            return Instant.ofEpochMilli(System.currentTimeMillis());
        }

        public long millis() {
            return System.currentTimeMillis();
        }

        public String toString() {
            StringBuilder m = Clock$SystemClock$$ExternalSyntheticOutline0.m183m("SystemClock[");
            m.append(this.zone);
            m.append("]");
            return m.toString();
        }
    }

    protected Clock() {
    }

    public static Clock systemUTC() {
        return new SystemClock(ZoneOffset.UTC);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public abstract Instant instant();

    public long millis() {
        return instant().toEpochMilli();
    }
}
