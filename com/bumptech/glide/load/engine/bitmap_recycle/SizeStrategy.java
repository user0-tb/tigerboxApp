package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.C0957Util;
import java.util.NavigableMap;

final class SizeStrategy implements LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();
    private final KeyPool keyPool = new KeyPool();
    private final NavigableMap<Integer, Integer> sortedSizes = new PrettyPrintTreeMap();

    SizeStrategy() {
    }

    public void put(Bitmap bitmap) {
        Key key = this.keyPool.get(C0957Util.getBitmapByteSize(bitmap));
        this.groupedMap.put(key, bitmap);
        Integer num = (Integer) this.sortedSizes.get(Integer.valueOf(key.size));
        NavigableMap<Integer, Integer> navigableMap = this.sortedSizes;
        Integer valueOf = Integer.valueOf(key.size);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        navigableMap.put(valueOf, Integer.valueOf(i));
    }

    public Bitmap get(int i, int i2, Bitmap.Config config) {
        int bitmapByteSize = C0957Util.getBitmapByteSize(i, i2, config);
        Key key = this.keyPool.get(bitmapByteSize);
        Integer ceilingKey = this.sortedSizes.ceilingKey(Integer.valueOf(bitmapByteSize));
        if (!(ceilingKey == null || ceilingKey.intValue() == bitmapByteSize || ceilingKey.intValue() > bitmapByteSize * 8)) {
            this.keyPool.offer(key);
            key = this.keyPool.get(ceilingKey.intValue());
        }
        Bitmap bitmap = this.groupedMap.get(key);
        if (bitmap != null) {
            bitmap.reconfigure(i, i2, config);
            decrementBitmapOfSize(ceilingKey);
        }
        return bitmap;
    }

    public Bitmap removeLast() {
        Bitmap removeLast = this.groupedMap.removeLast();
        if (removeLast != null) {
            decrementBitmapOfSize(Integer.valueOf(C0957Util.getBitmapByteSize(removeLast)));
        }
        return removeLast;
    }

    private void decrementBitmapOfSize(Integer num) {
        Integer num2 = (Integer) this.sortedSizes.get(num);
        if (num2.intValue() == 1) {
            this.sortedSizes.remove(num);
        } else {
            this.sortedSizes.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    public String logBitmap(int i, int i2, Bitmap.Config config) {
        return getBitmapString(C0957Util.getBitmapByteSize(i, i2, config));
    }

    public int getSize(Bitmap bitmap) {
        return C0957Util.getBitmapByteSize(bitmap);
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.groupedMap + "\n  SortedSizes" + this.sortedSizes;
    }

    private static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(C0957Util.getBitmapByteSize(bitmap));
    }

    static String getBitmapString(int i) {
        return "[" + i + "]";
    }

    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        public Key get(int i) {
            Key key = (Key) super.get();
            key.init(i);
            return key;
        }

        /* access modifiers changed from: protected */
        public Key create() {
            return new Key(this);
        }
    }

    static final class Key implements Poolable {
        private final KeyPool pool;
        int size;

        Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public void init(int i) {
            this.size = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key) || this.size != ((Key) obj).size) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.size;
        }

        public String toString() {
            return SizeStrategy.getBitmapString(this.size);
        }

        public void offer() {
            this.pool.offer(this);
        }
    }
}
