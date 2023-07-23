package p009j$.time.zone;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import p009j$.util.concurrent.ConcurrentHashMap;

/* renamed from: j$.time.zone.ZoneRulesProvider */
public abstract class ZoneRulesProvider {
    private static final CopyOnWriteArrayList PROVIDERS;
    private static final ConcurrentMap ZONES = new ConcurrentHashMap(512, 0.75f, 2);

    /* renamed from: j$.time.zone.ZoneRulesProvider$TimeZoneRulesProvider */
    final class TimeZoneRulesProvider extends ZoneRulesProvider {
        private final Set zoneIds;

        TimeZoneRulesProvider() {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (String add : TimeZone.getAvailableIDs()) {
                linkedHashSet.add(add);
            }
            this.zoneIds = Collections.unmodifiableSet(linkedHashSet);
        }

        /* access modifiers changed from: protected */
        public ZoneRules provideRules(String str, boolean z) {
            if (this.zoneIds.contains(str)) {
                return new ZoneRules(TimeZone.getTimeZone(str));
            }
            throw new ZoneRulesException("Not a built-in time zone: " + str);
        }

        /* access modifiers changed from: protected */
        public Set provideZoneIds() {
            return this.zoneIds;
        }
    }

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        PROVIDERS = copyOnWriteArrayList;
        final ArrayList arrayList = new ArrayList();
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                Class<ZoneRulesProvider> cls = ZoneRulesProvider.class;
                String property = System.getProperty("java.time.zone.DefaultZoneRulesProvider");
                if (property != null) {
                    try {
                        ZoneRulesProvider cast = cls.cast(Class.forName(property, true, cls.getClassLoader()).newInstance());
                        ZoneRulesProvider.registerProvider(cast);
                        arrayList.add(cast);
                        return null;
                    } catch (Exception e) {
                        throw new Error(e);
                    }
                } else {
                    ZoneRulesProvider.registerProvider(new TimeZoneRulesProvider());
                    return null;
                }
            }
        });
        copyOnWriteArrayList.addAll(arrayList);
    }

    protected ZoneRulesProvider() {
    }

    public static Set getAvailableZoneIds() {
        return new HashSet(((ConcurrentHashMap) ZONES).keySet());
    }

    public static ZoneRules getRules(String str, boolean z) {
        Objects.requireNonNull(str, "zoneId");
        ConcurrentMap concurrentMap = ZONES;
        ZoneRulesProvider zoneRulesProvider = (ZoneRulesProvider) concurrentMap.get(str);
        if (zoneRulesProvider != null) {
            return zoneRulesProvider.provideRules(str, z);
        }
        if (concurrentMap.isEmpty()) {
            throw new ZoneRulesException("No time-zone data files registered");
        }
        throw new ZoneRulesException("Unknown time-zone ID: " + str);
    }

    public static void registerProvider(ZoneRulesProvider zoneRulesProvider) {
        Objects.requireNonNull(zoneRulesProvider, "provider");
        for (String str : zoneRulesProvider.provideZoneIds()) {
            Objects.requireNonNull(str, "zoneId");
            if (((ZoneRulesProvider) ZONES.putIfAbsent(str, zoneRulesProvider)) != null) {
                throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + str + ", currently loading from provider: " + zoneRulesProvider);
            }
        }
        PROVIDERS.add(zoneRulesProvider);
    }

    /* access modifiers changed from: protected */
    public abstract ZoneRules provideRules(String str, boolean z);

    /* access modifiers changed from: protected */
    public abstract Set provideZoneIds();
}
