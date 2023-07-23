package p009j$.util.stream;

import java.util.EnumMap;
import java.util.Map;
import p009j$.util.Map;
import p009j$.util.Spliterator;

/* renamed from: j$.util.stream.StreamOpFlag */
enum StreamOpFlag {
    DISTINCT(0, r2),
    SORTED(1, r5),
    ORDERED(2, r7),
    SIZED(3, r11),
    SHORT_CIRCUIT(12, r13);
    
    private static final int FLAG_MASK = 0;
    private static final int FLAG_MASK_IS = 0;
    private static final int FLAG_MASK_NOT = 0;
    static final int INITIAL_OPS_VALUE = 0;
    static final int IS_DISTINCT = 0;
    static final int IS_ORDERED = 0;
    static final int IS_SHORT_CIRCUIT = 0;
    static final int IS_SIZED = 0;
    static final int IS_SORTED = 0;
    static final int NOT_DISTINCT = 0;
    static final int NOT_ORDERED = 0;
    static final int NOT_SIZED = 0;
    static final int NOT_SORTED = 0;
    static final int OP_MASK = 0;
    static final int SPLITERATOR_CHARACTERISTICS_MASK = 0;
    static final int STREAM_MASK = 0;
    private final int bitPosition;
    private final int clear;
    private final Map maskTable;
    private final int preserve;
    private final int set;

    /* renamed from: j$.util.stream.StreamOpFlag$MaskBuilder */
    class MaskBuilder {
        final Map map;

        MaskBuilder(Map map2) {
            this.map = map2;
        }

        /* access modifiers changed from: package-private */
        public MaskBuilder clear(Type type) {
            this.map.put(type, 2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public MaskBuilder set(Type type) {
            this.map.put(type, 1);
            return this;
        }

        /* access modifiers changed from: package-private */
        public MaskBuilder setAndClear(Type type) {
            this.map.put(type, 3);
            return this;
        }
    }

    /* renamed from: j$.util.stream.StreamOpFlag$Type */
    enum Type {
        SPLITERATOR,
        STREAM,
        OP,
        TERMINAL_OP,
        UPSTREAM_TERMINAL_OP
    }

    static {
        StreamOpFlag streamOpFlag;
        Type type;
        Type type2;
        Type type3;
        int i;
        StreamOpFlag streamOpFlag2;
        StreamOpFlag streamOpFlag3;
        Type type4;
        Type type5;
        StreamOpFlag streamOpFlag4;
        StreamOpFlag streamOpFlag5;
        SPLITERATOR_CHARACTERISTICS_MASK = createMask(type);
        int createMask = createMask(type2);
        STREAM_MASK = createMask;
        OP_MASK = createMask(type3);
        createMask(type4);
        createMask(type5);
        int i2 = 0;
        for (StreamOpFlag streamOpFlag6 : values()) {
            i2 |= streamOpFlag6.preserve;
        }
        FLAG_MASK = i2;
        FLAG_MASK_IS = createMask;
        int i3 = createMask << 1;
        FLAG_MASK_NOT = i3;
        INITIAL_OPS_VALUE = createMask | i3;
        IS_DISTINCT = streamOpFlag.set;
        NOT_DISTINCT = streamOpFlag.clear;
        IS_SORTED = streamOpFlag2.set;
        NOT_SORTED = streamOpFlag2.clear;
        IS_ORDERED = streamOpFlag3.set;
        NOT_ORDERED = streamOpFlag3.clear;
        IS_SIZED = streamOpFlag4.set;
        NOT_SIZED = streamOpFlag4.clear;
        IS_SHORT_CIRCUIT = streamOpFlag5.set;
    }

    private StreamOpFlag(int i, MaskBuilder maskBuilder) {
        for (Type type : Type.values()) {
            Map map = maskBuilder.map;
            if (map instanceof p009j$.util.Map) {
                ((p009j$.util.Map) map).putIfAbsent(type, 0);
            } else {
                Map.CC.$default$putIfAbsent(map, type, 0);
            }
        }
        this.maskTable = maskBuilder.map;
        int i2 = i * 2;
        this.bitPosition = i2;
        this.set = 1 << i2;
        this.clear = 2 << i2;
        this.preserve = 3 << i2;
    }

    static int combineOpFlags(int i, int i2) {
        return i | (i2 & (i == 0 ? FLAG_MASK : ~(((FLAG_MASK_IS & i) << 1) | i | ((FLAG_MASK_NOT & i) >> 1))));
    }

    private static int createMask(Type type) {
        int i = 0;
        for (StreamOpFlag streamOpFlag : values()) {
            i |= ((Integer) streamOpFlag.maskTable.get(type)).intValue() << streamOpFlag.bitPosition;
        }
        return i;
    }

    static int fromCharacteristics(Spliterator spliterator) {
        int characteristics = spliterator.characteristics();
        return ((characteristics & 4) == 0 || spliterator.getComparator() == null) ? SPLITERATOR_CHARACTERISTICS_MASK & characteristics : SPLITERATOR_CHARACTERISTICS_MASK & characteristics & -5;
    }

    private static MaskBuilder set(Type type) {
        EnumMap enumMap = new EnumMap(Type.class);
        MaskBuilder maskBuilder = new MaskBuilder(enumMap);
        enumMap.put(type, 1);
        return maskBuilder;
    }

    static int toStreamFlags(int i) {
        return i & ((~i) >> 1) & FLAG_MASK_IS;
    }

    /* access modifiers changed from: package-private */
    public boolean isKnown(int i) {
        return (i & this.preserve) == this.set;
    }

    /* access modifiers changed from: package-private */
    public boolean isPreserved(int i) {
        int i2 = this.preserve;
        return (i & i2) == i2;
    }
}
