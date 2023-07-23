package androidx.room;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo33737d2 = {"Landroidx/room/FtsOptions;", "", "()V", "TOKENIZER_ICU", "", "TOKENIZER_PORTER", "TOKENIZER_SIMPLE", "TOKENIZER_UNICODE61", "MatchInfo", "Order", "room-common"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* compiled from: FtsOptions.kt */
public final class FtsOptions {
    public static final FtsOptions INSTANCE = new FtsOptions();
    public static final String TOKENIZER_ICU = "icu";
    public static final String TOKENIZER_PORTER = "porter";
    public static final String TOKENIZER_SIMPLE = "simple";
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo33737d2 = {"Landroidx/room/FtsOptions$MatchInfo;", "", "(Ljava/lang/String;I)V", "FTS3", "FTS4", "room-common"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
    /* compiled from: FtsOptions.kt */
    public enum MatchInfo {
        FTS3,
        FTS4
    }

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, mo33737d2 = {"Landroidx/room/FtsOptions$Order;", "", "(Ljava/lang/String;I)V", "ASC", "DESC", "room-common"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
    /* compiled from: FtsOptions.kt */
    public enum Order {
        ASC,
        DESC
    }

    private FtsOptions() {
    }
}
