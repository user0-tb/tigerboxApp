package androidx.navigation;

import androidx.navigation.NavDeepLink;
import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\t¨\u0006\u0015"}, mo33737d2 = {"Landroidx/navigation/NavDeepLinkDslBuilder;", "", "()V", "p", "", "action", "getAction", "()Ljava/lang/String;", "setAction", "(Ljava/lang/String;)V", "builder", "Landroidx/navigation/NavDeepLink$Builder;", "mimeType", "getMimeType", "setMimeType", "uriPattern", "getUriPattern", "setUriPattern", "build", "Landroidx/navigation/NavDeepLink;", "build$navigation_common_release", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@NavDeepLinkDsl
/* compiled from: NavDeepLinkDslBuilder.kt */
public final class NavDeepLinkDslBuilder {
    private String action;
    private final NavDeepLink.Builder builder = new NavDeepLink.Builder();
    private String mimeType;
    private String uriPattern;

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final void setUriPattern(String str) {
        this.uriPattern = str;
    }

    public final String getAction() {
        return this.action;
    }

    public final void setAction(String str) {
        if (str != null) {
            if (str.length() == 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
        }
        this.action = str;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final void setMimeType(String str) {
        this.mimeType = str;
    }

    public final NavDeepLink build$navigation_common_release() {
        NavDeepLink.Builder builder2 = this.builder;
        if ((getUriPattern() == null && getAction() == null && getMimeType() == null) ? false : true) {
            String uriPattern2 = getUriPattern();
            if (uriPattern2 != null) {
                builder2.setUriPattern(uriPattern2);
            }
            String action2 = getAction();
            if (action2 != null) {
                builder2.setAction(action2);
            }
            String mimeType2 = getMimeType();
            if (mimeType2 != null) {
                builder2.setMimeType(mimeType2);
            }
            return builder2.build();
        }
        throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.".toString());
    }
}
