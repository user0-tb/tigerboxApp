package p009j$.time.format;

/* renamed from: j$.time.format.TextStyle */
public enum TextStyle {
    FULL(2, 0),
    FULL_STANDALONE(32770, 0),
    SHORT(1, 1),
    SHORT_STANDALONE(32769, 1),
    NARROW(4, 1),
    NARROW_STANDALONE(32772, 1);
    
    private final int zoneNameStyleIndex;

    private TextStyle(int i, int i2) {
        this.zoneNameStyleIndex = i2;
    }

    /* access modifiers changed from: package-private */
    public int zoneNameStyleIndex() {
        return this.zoneNameStyleIndex;
    }
}
