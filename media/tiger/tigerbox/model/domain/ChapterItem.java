package media.tiger.tigerbox.model.domain;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.spongycastle.i18n.MessageBundle;

@Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003JQ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006!"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/domain/ChapterItem;", "", "id", "", "title", "", "position", "duration", "isSelected", "", "isProduct", "coverUrl", "(ILjava/lang/String;ILjava/lang/String;ZZLjava/lang/String;)V", "getCoverUrl", "()Ljava/lang/String;", "getDuration", "getId", "()I", "()Z", "getPosition", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ChapterItem.kt */
public final class ChapterItem {
    private final String coverUrl;
    private final String duration;

    /* renamed from: id */
    private final int f623id;
    private final boolean isProduct;
    private final boolean isSelected;
    private final int position;
    private final String title;

    public static /* synthetic */ ChapterItem copy$default(ChapterItem chapterItem, int i, String str, int i2, String str2, boolean z, boolean z2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = chapterItem.f623id;
        }
        if ((i3 & 2) != 0) {
            str = chapterItem.title;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            i2 = chapterItem.position;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            str2 = chapterItem.duration;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            z = chapterItem.isSelected;
        }
        boolean z3 = z;
        if ((i3 & 32) != 0) {
            z2 = chapterItem.isProduct;
        }
        boolean z4 = z2;
        if ((i3 & 64) != 0) {
            str3 = chapterItem.coverUrl;
        }
        return chapterItem.copy(i, str4, i4, str5, z3, z4, str3);
    }

    public final int component1() {
        return this.f623id;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.position;
    }

    public final String component4() {
        return this.duration;
    }

    public final boolean component5() {
        return this.isSelected;
    }

    public final boolean component6() {
        return this.isProduct;
    }

    public final String component7() {
        return this.coverUrl;
    }

    public final ChapterItem copy(int i, String str, int i2, String str2, boolean z, boolean z2, String str3) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, TypedValues.TransitionType.S_DURATION);
        return new ChapterItem(i, str, i2, str2, z, z2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChapterItem)) {
            return false;
        }
        ChapterItem chapterItem = (ChapterItem) obj;
        return this.f623id == chapterItem.f623id && Intrinsics.areEqual((Object) this.title, (Object) chapterItem.title) && this.position == chapterItem.position && Intrinsics.areEqual((Object) this.duration, (Object) chapterItem.duration) && this.isSelected == chapterItem.isSelected && this.isProduct == chapterItem.isProduct && Intrinsics.areEqual((Object) this.coverUrl, (Object) chapterItem.coverUrl);
    }

    public int hashCode() {
        int hashCode = ((((((this.f623id * 31) + this.title.hashCode()) * 31) + this.position) * 31) + this.duration.hashCode()) * 31;
        boolean z = this.isSelected;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isProduct;
        if (!z3) {
            z2 = z3;
        }
        int i2 = (i + (z2 ? 1 : 0)) * 31;
        String str = this.coverUrl;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ChapterItem(id=" + this.f623id + ", title=" + this.title + ", position=" + this.position + ", duration=" + this.duration + ", isSelected=" + this.isSelected + ", isProduct=" + this.isProduct + ", coverUrl=" + this.coverUrl + ')';
    }

    public ChapterItem(int i, String str, int i2, String str2, boolean z, boolean z2, String str3) {
        Intrinsics.checkNotNullParameter(str, MessageBundle.TITLE_ENTRY);
        Intrinsics.checkNotNullParameter(str2, TypedValues.TransitionType.S_DURATION);
        this.f623id = i;
        this.title = str;
        this.position = i2;
        this.duration = str2;
        this.isSelected = z;
        this.isProduct = z2;
        this.coverUrl = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChapterItem(int i, String str, int i2, String str2, boolean z, boolean z2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, str2, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? null : str3);
    }

    public final int getId() {
        return this.f623id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isProduct() {
        return this.isProduct;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }
}
