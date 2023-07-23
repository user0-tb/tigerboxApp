package p009j$.time;

import p009j$.time.zone.ZoneRules;
import p009j$.time.zone.ZoneRulesException;
import p009j$.time.zone.ZoneRulesProvider;

/* renamed from: j$.time.ZoneRegion */
final class ZoneRegion extends ZoneId {

    /* renamed from: id */
    private final String f229id;
    private final transient ZoneRules rules;

    ZoneRegion(String str, ZoneRules zoneRules) {
        this.f229id = str;
        this.rules = zoneRules;
    }

    static ZoneRegion ofId(String str, boolean z) {
        int length = str.length();
        if (length >= 2) {
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && ((charAt != '/' || i == 0) && ((charAt < '0' || charAt > '9' || i == 0) && ((charAt != '~' || i == 0) && ((charAt != '.' || i == 0) && ((charAt != '_' || i == 0) && ((charAt != '+' || i == 0) && (charAt != '-' || i == 0))))))))) {
                    throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
                }
            }
            ZoneRules zoneRules = null;
            try {
                zoneRules = ZoneRulesProvider.getRules(str, true);
            } catch (ZoneRulesException e) {
                if (z) {
                    throw e;
                }
            }
            return new ZoneRegion(str, zoneRules);
        }
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
    }

    public String getId() {
        return this.f229id;
    }

    public ZoneRules getRules() {
        ZoneRules zoneRules = this.rules;
        return zoneRules != null ? zoneRules : ZoneRulesProvider.getRules(this.f229id, false);
    }
}
