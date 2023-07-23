package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;
import kotlin.UShort;

@ElementTypesAreNonnullByDefault
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final byte ABSENT = -1;
    private static final int BYTE_MASK = 255;
    private static final int BYTE_MAX_SIZE = 128;
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap((Object) null, new Object[0], 0);
    private static final int SHORT_MASK = 65535;
    private static final int SHORT_MAX_SIZE = 32768;
    private static final long serialVersionUID = 0;
    final transient Object[] alternatingKeysAndValues;
    @CheckForNull
    private final transient Object hashTable;
    private final transient int size;

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }

    static <K, V> RegularImmutableMap<K, V> create(int i, Object[] objArr) {
        if (i == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            CollectPreconditions.checkEntryNotNull(obj, obj2);
            return new RegularImmutableMap<>((Object) null, objArr, 1);
        }
        Preconditions.checkPositionIndex(i, objArr.length >> 1);
        return new RegularImmutableMap<>(createHashTable(objArr, i, ImmutableSet.chooseTableSize(i), 0), objArr, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        r11[r5] = (byte) r1;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008b, code lost:
        r11[r5] = (short) r1;
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c8, code lost:
        r11[r6] = r1;
        r2 = r2 + 1;
     */
    @javax.annotation.CheckForNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.Object createHashTable(java.lang.Object[] r9, int r10, int r11, int r12) {
        /*
            r0 = 1
            if (r10 != r0) goto L_0x0014
            r10 = r9[r12]
            java.util.Objects.requireNonNull(r10)
            r11 = r12 ^ 1
            r9 = r9[r11]
            java.util.Objects.requireNonNull(r9)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r10, r9)
            r9 = 0
            return r9
        L_0x0014:
            int r0 = r11 + -1
            r1 = 128(0x80, float:1.794E-43)
            r2 = 0
            r3 = -1
            if (r11 > r1) goto L_0x005c
            byte[] r11 = new byte[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x0021:
            if (r2 >= r10) goto L_0x005b
            int r1 = r2 * 2
            int r1 = r1 + r12
            r3 = r9[r1]
            java.util.Objects.requireNonNull(r3)
            r4 = r1 ^ 1
            r4 = r9[r4]
            java.util.Objects.requireNonNull(r4)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r3, r4)
            int r5 = r3.hashCode()
            int r5 = com.google.common.collect.Hashing.smear(r5)
        L_0x003d:
            r5 = r5 & r0
            byte r6 = r11[r5]
            r7 = 255(0xff, float:3.57E-43)
            r6 = r6 & r7
            if (r6 != r7) goto L_0x004b
            byte r1 = (byte) r1
            r11[r5] = r1
            int r2 = r2 + 1
            goto L_0x0021
        L_0x004b:
            r7 = r9[r6]
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L_0x0056
            int r5 = r5 + 1
            goto L_0x003d
        L_0x0056:
            java.lang.IllegalArgumentException r9 = duplicateKeyException(r3, r4, r9, r6)
            throw r9
        L_0x005b:
            return r11
        L_0x005c:
            r1 = 32768(0x8000, float:4.5918E-41)
            if (r11 > r1) goto L_0x00a2
            short[] r11 = new short[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x0066:
            if (r2 >= r10) goto L_0x00a1
            int r1 = r2 * 2
            int r1 = r1 + r12
            r3 = r9[r1]
            java.util.Objects.requireNonNull(r3)
            r4 = r1 ^ 1
            r4 = r9[r4]
            java.util.Objects.requireNonNull(r4)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r3, r4)
            int r5 = r3.hashCode()
            int r5 = com.google.common.collect.Hashing.smear(r5)
        L_0x0082:
            r5 = r5 & r0
            short r6 = r11[r5]
            r7 = 65535(0xffff, float:9.1834E-41)
            r6 = r6 & r7
            if (r6 != r7) goto L_0x0091
            short r1 = (short) r1
            r11[r5] = r1
            int r2 = r2 + 1
            goto L_0x0066
        L_0x0091:
            r7 = r9[r6]
            boolean r7 = r3.equals(r7)
            if (r7 != 0) goto L_0x009c
            int r5 = r5 + 1
            goto L_0x0082
        L_0x009c:
            java.lang.IllegalArgumentException r9 = duplicateKeyException(r3, r4, r9, r6)
            throw r9
        L_0x00a1:
            return r11
        L_0x00a2:
            int[] r11 = new int[r11]
            java.util.Arrays.fill(r11, r3)
        L_0x00a7:
            if (r2 >= r10) goto L_0x00dd
            int r1 = r2 * 2
            int r1 = r1 + r12
            r4 = r9[r1]
            java.util.Objects.requireNonNull(r4)
            r5 = r1 ^ 1
            r5 = r9[r5]
            java.util.Objects.requireNonNull(r5)
            com.google.common.collect.CollectPreconditions.checkEntryNotNull(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.common.collect.Hashing.smear(r6)
        L_0x00c3:
            r6 = r6 & r0
            r7 = r11[r6]
            if (r7 != r3) goto L_0x00cd
            r11[r6] = r1
            int r2 = r2 + 1
            goto L_0x00a7
        L_0x00cd:
            r8 = r9[r7]
            boolean r8 = r4.equals(r8)
            if (r8 != 0) goto L_0x00d8
            int r6 = r6 + 1
            goto L_0x00c3
        L_0x00d8:
            java.lang.IllegalArgumentException r9 = duplicateKeyException(r4, r5, r9, r7)
            throw r9
        L_0x00dd:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularImmutableMap.createHashTable(java.lang.Object[], int, int, int):java.lang.Object");
    }

    private static IllegalArgumentException duplicateKeyException(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private RegularImmutableMap(@CheckForNull Object obj, Object[] objArr, int i) {
        this.hashTable = obj;
        this.alternatingKeysAndValues = objArr;
        this.size = i;
    }

    public int size() {
        return this.size;
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        V v = get(this.hashTable, this.alternatingKeysAndValues, this.size, 0, obj);
        if (v == null) {
            return null;
        }
        return v;
    }

    @CheckForNull
    static Object get(@CheckForNull Object obj, Object[] objArr, int i, int i2, @CheckForNull Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            Object obj3 = objArr[i2];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i2 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int smear = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i3 = smear & length;
                    byte b = bArr[i3] & 255;
                    if (b == 255) {
                        return null;
                    }
                    if (obj2.equals(objArr[b])) {
                        return objArr[b ^ 1];
                    }
                    smear = i3 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int smear2 = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i4 = smear2 & length2;
                    short s = sArr[i4] & UShort.MAX_VALUE;
                    if (s == 65535) {
                        return null;
                    }
                    if (obj2.equals(objArr[s])) {
                        return objArr[s ^ 1];
                    }
                    smear2 = i4 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int smear3 = Hashing.smear(obj2.hashCode());
                while (true) {
                    int i5 = smear3 & length3;
                    int i6 = iArr[i5];
                    if (i6 == -1) {
                        return null;
                    }
                    if (obj2.equals(objArr[i6])) {
                        return objArr[i6 ^ 1];
                    }
                    smear3 = i5 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.size);
    }

    static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        /* access modifiers changed from: private */
        public final transient Object[] alternatingKeysAndValues;
        /* access modifiers changed from: private */
        public final transient int keyOffset;
        private final transient ImmutableMap<K, V> map;
        /* access modifiers changed from: private */
        public final transient int size;

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i, int i2) {
            this.map = immutableMap;
            this.alternatingKeysAndValues = objArr;
            this.keyOffset = i;
            this.size = i2;
        }

        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }

        /* access modifiers changed from: package-private */
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        /* access modifiers changed from: package-private */
        public ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() {
                public boolean isPartialView() {
                    return true;
                }

                public Map.Entry<K, V> get(int i) {
                    Preconditions.checkElementIndex(i, EntrySet.this.size);
                    int i2 = i * 2;
                    Object obj = EntrySet.this.alternatingKeysAndValues[EntrySet.this.keyOffset + i2];
                    Objects.requireNonNull(obj);
                    Object obj2 = EntrySet.this.alternatingKeysAndValues[i2 + (EntrySet.this.keyOffset ^ 1)];
                    Objects.requireNonNull(obj2);
                    return new AbstractMap.SimpleImmutableEntry(obj, obj2);
                }

                public int size() {
                    return EntrySet.this.size;
                }
            };
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.map.get(key))) {
                return false;
            }
            return true;
        }

        public int size() {
            return this.size;
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.size));
    }

    static final class KeysOrValuesAsList extends ImmutableList<Object> {
        private final transient Object[] alternatingKeysAndValues;
        private final transient int offset;
        private final transient int size;

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        KeysOrValuesAsList(Object[] objArr, int i, int i2) {
            this.alternatingKeysAndValues = objArr;
            this.offset = i;
            this.size = i2;
        }

        public Object get(int i) {
            Preconditions.checkElementIndex(i, this.size);
            Object obj = this.alternatingKeysAndValues[(i * 2) + this.offset];
            Objects.requireNonNull(obj);
            return obj;
        }

        public int size() {
            return this.size;
        }
    }

    static final class KeySet<K> extends ImmutableSet<K> {
        private final transient ImmutableList<K> list;
        private final transient ImmutableMap<K, ?> map;

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.map = immutableMap;
            this.list = immutableList;
        }

        public UnmodifiableIterator<K> iterator() {
            return asList().iterator();
        }

        /* access modifiers changed from: package-private */
        public int copyIntoArray(Object[] objArr, int i) {
            return asList().copyIntoArray(objArr, i);
        }

        public ImmutableList<K> asList() {
            return this.list;
        }

        public boolean contains(@CheckForNull Object obj) {
            return this.map.get(obj) != null;
        }

        public int size() {
            return this.map.size();
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.size);
    }
}
