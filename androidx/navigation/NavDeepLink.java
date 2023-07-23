package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;

@Metadata(mo33736d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 E2\u00020\u0001:\u0004DEFGB\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\b\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ$\u0010(\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010)\u001a\u00060*j\u0002`+2\u0006\u0010,\u001a\u00020\u001bH\u0002J\u0013\u0010-\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u0002J(\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u0002022\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010403H\u0007J\u0010\u00105\u001a\u0002062\u0006\u0010\u0007\u001a\u00020\u0003H\u0007J\b\u00107\u001a\u000206H\u0016J\u0012\u00108\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u00109\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010:\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u000102H\u0002J\u0015\u0010;\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u000202H\u0000¢\u0006\u0002\b<J\u0015\u0010;\u001a\u00020\u00122\u0006\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\b<J*\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u000104H\u0002R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128G@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\nR\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u0004\u0018\u00010\u001b8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b$\u0010\u001dR\u0010\u0010&\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\n¨\u0006H"}, mo33737d2 = {"Landroidx/navigation/NavDeepLink;", "", "uri", "", "(Ljava/lang/String;)V", "uriPattern", "action", "mimeType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "arguments", "", "argumentsNames", "", "getArgumentsNames$navigation_common_release", "()Ljava/util/List;", "<set-?>", "", "isExactDeepLink", "()Z", "setExactDeepLink$navigation_common_release", "(Z)V", "isParameterizedQuery", "getMimeType", "mimeTypeFinalRegex", "mimeTypePattern", "Ljava/util/regex/Pattern;", "getMimeTypePattern", "()Ljava/util/regex/Pattern;", "mimeTypePattern$delegate", "Lkotlin/Lazy;", "paramArgMap", "", "Landroidx/navigation/NavDeepLink$ParamQuery;", "pattern", "getPattern", "pattern$delegate", "patternFinalRegex", "getUriPattern", "buildPathRegex", "uriRegex", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "fillInPattern", "equals", "other", "getMatchingArguments", "Landroid/os/Bundle;", "deepLink", "Landroid/net/Uri;", "", "Landroidx/navigation/NavArgument;", "getMimeTypeMatchRating", "", "hashCode", "matchAction", "matchMimeType", "matchUri", "matches", "matches$navigation_common_release", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "parseArgument", "bundle", "name", "value", "argument", "Builder", "Companion", "MimeType", "ParamQuery", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NavDeepLink.kt */
public final class NavDeepLink {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private final String action;
    private final List<String> arguments;
    private boolean isExactDeepLink;
    private boolean isParameterizedQuery;
    private final String mimeType;
    /* access modifiers changed from: private */
    public String mimeTypeFinalRegex;
    private final Lazy mimeTypePattern$delegate;
    private final Map<String, ParamQuery> paramArgMap;
    private final Lazy pattern$delegate;
    /* access modifiers changed from: private */
    public String patternFinalRegex;
    private final String uriPattern;

    public NavDeepLink(String str, String str2, String str3) {
        String str4 = str;
        this.uriPattern = str4;
        this.action = str2;
        this.mimeType = str3;
        this.arguments = new ArrayList();
        this.paramArgMap = new LinkedHashMap();
        this.pattern$delegate = LazyKt.lazy(new NavDeepLink$pattern$2(this));
        this.mimeTypePattern$delegate = LazyKt.lazy(new NavDeepLink$mimeTypePattern$2(this));
        if (str4 != null) {
            Uri parse = Uri.parse(str);
            this.isParameterizedQuery = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            if (!SCHEME_PATTERN.matcher(str4).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.isParameterizedQuery) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str4);
                if (matcher.find()) {
                    String substring = str4.substring(0, matcher.start());
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Intrinsics.checkNotNullExpressionValue(compile, "fillInPattern");
                    this.isExactDeepLink = buildPathRegex(substring, sb, compile);
                }
                for (String next : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(next);
                    Objects.requireNonNull(queryParameter, "null cannot be cast to non-null type kotlin.String");
                    Matcher matcher2 = compile.matcher(queryParameter);
                    ParamQuery paramQuery = new ParamQuery();
                    int i = 0;
                    while (matcher2.find()) {
                        String group = matcher2.group(1);
                        Objects.requireNonNull(group, "null cannot be cast to non-null type kotlin.String");
                        paramQuery.addArgumentName(group);
                        String substring2 = queryParameter.substring(i, matcher2.start());
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb2.append(Pattern.quote(substring2));
                        sb2.append("(.+?)?");
                        i = matcher2.end();
                    }
                    if (i < queryParameter.length()) {
                        String substring3 = queryParameter.substring(i);
                        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                        sb2.append(Pattern.quote(substring3));
                    }
                    String sb3 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(sb3, "argRegex.toString()");
                    paramQuery.setParamRegex(StringsKt.replace$default(sb3, ".*", "\\E.*\\Q", false, 4, (Object) null));
                    Map<String, ParamQuery> map = this.paramArgMap;
                    Intrinsics.checkNotNullExpressionValue(next, "paramName");
                    map.put(next, paramQuery);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(compile, "fillInPattern");
                this.isExactDeepLink = buildPathRegex(str4, sb, compile);
            }
            String sb4 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "uriRegex.toString()");
            this.patternFinalRegex = StringsKt.replace$default(sb4, ".*", "\\E.*\\Q", false, 4, (Object) null);
        }
        if (this.mimeType == null) {
            return;
        }
        if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches()) {
            MimeType mimeType2 = new MimeType(this.mimeType);
            this.mimeTypeFinalRegex = StringsKt.replace$default("^(" + mimeType2.getType() + "|[*]+)/(" + mimeType2.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, (Object) null);
            return;
        }
        throw new IllegalArgumentException(("The given mimeType " + getMimeType() + " does not match to required \"type/subtype\" format").toString());
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    private final Pattern getPattern() {
        return (Pattern) this.pattern$delegate.getValue();
    }

    private final Pattern getMimeTypePattern() {
        return (Pattern) this.mimeTypePattern$delegate.getValue();
    }

    public final List<String> getArgumentsNames$navigation_common_release() {
        Collection collection = this.arguments;
        Collection arrayList = new ArrayList();
        for (ParamQuery arguments2 : this.paramArgMap.values()) {
            CollectionsKt.addAll(arrayList, arguments2.getArguments());
        }
        return CollectionsKt.plus(collection, (List) arrayList);
    }

    public final boolean isExactDeepLink() {
        return this.isExactDeepLink;
    }

    public final void setExactDeepLink$navigation_common_release(boolean z) {
        this.isExactDeepLink = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NavDeepLink(String str) {
        this(str, (String) null, (String) null);
        Intrinsics.checkNotNullParameter(str, "uri");
    }

    private final boolean buildPathRegex(String str, StringBuilder sb, Pattern pattern) {
        CharSequence charSequence = str;
        Matcher matcher = pattern.matcher(charSequence);
        boolean z = !StringsKt.contains$default(charSequence, (CharSequence) ".*", false, 2, (Object) null);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            Objects.requireNonNull(group, "null cannot be cast to non-null type kotlin.String");
            this.arguments.add(group);
            String substring = str.substring(i, matcher.start());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(Pattern.quote(substring));
            sb.append("([^/]+?)");
            i = matcher.end();
            z = false;
        }
        if (i < str.length()) {
            String substring2 = str.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(Pattern.quote(substring2));
        }
        sb.append("($|(\\?(.)*)|(\\#(.)*))");
        return z;
    }

    public final boolean matches$navigation_common_release(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return matches$navigation_common_release(new NavDeepLinkRequest(uri, (String) null, (String) null));
    }

    public final boolean matches$navigation_common_release(NavDeepLinkRequest navDeepLinkRequest) {
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "deepLinkRequest");
        if (matchUri(navDeepLinkRequest.getUri()) && matchAction(navDeepLinkRequest.getAction())) {
            return matchMimeType(navDeepLinkRequest.getMimeType());
        }
        return false;
    }

    private final boolean matchUri(Uri uri) {
        if ((uri == null) != (getPattern() != null)) {
            if (uri == null) {
                return true;
            }
            Pattern pattern = getPattern();
            Intrinsics.checkNotNull(pattern);
            if (pattern.matcher(uri.toString()).matches()) {
                return true;
            }
        }
        return false;
    }

    private final boolean matchAction(String str) {
        boolean z = str == null;
        String str2 = this.action;
        return z != (str2 != null) && (str == null || Intrinsics.areEqual((Object) str2, (Object) str));
    }

    private final boolean matchMimeType(String str) {
        if ((str == null) != (this.mimeType != null)) {
            if (str == null) {
                return true;
            }
            Pattern mimeTypePattern = getMimeTypePattern();
            Intrinsics.checkNotNull(mimeTypePattern);
            if (mimeTypePattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public final int getMimeTypeMatchRating(String str) {
        Intrinsics.checkNotNullParameter(str, "mimeType");
        if (this.mimeType != null) {
            Pattern mimeTypePattern = getMimeTypePattern();
            Intrinsics.checkNotNull(mimeTypePattern);
            if (mimeTypePattern.matcher(str).matches()) {
                return new MimeType(this.mimeType).compareTo(new MimeType(str));
            }
        }
        return -1;
    }

    public final Bundle getMatchingArguments(Uri uri, Map<String, NavArgument> map) {
        Matcher matcher;
        String str;
        Uri uri2 = uri;
        Map<String, NavArgument> map2 = map;
        Intrinsics.checkNotNullParameter(uri2, "deepLink");
        Intrinsics.checkNotNullParameter(map2, "arguments");
        Pattern pattern = getPattern();
        Matcher matcher2 = pattern == null ? null : pattern.matcher(uri.toString());
        if (matcher2 == null || !matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.arguments.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            String str2 = this.arguments.get(i);
            String decode = Uri.decode(matcher2.group(i2));
            NavArgument navArgument = map2.get(str2);
            try {
                Intrinsics.checkNotNullExpressionValue(decode, "value");
                if (parseArgument(bundle, str2, decode, navArgument)) {
                    return null;
                }
                i = i2;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (this.isParameterizedQuery) {
            for (String next : this.paramArgMap.keySet()) {
                ParamQuery paramQuery = this.paramArgMap.get(next);
                String queryParameter = uri2.getQueryParameter(next);
                if (queryParameter != null) {
                    Intrinsics.checkNotNull(paramQuery);
                    matcher = Pattern.compile(paramQuery.getParamRegex(), 32).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                Bundle bundle2 = new Bundle();
                try {
                    Intrinsics.checkNotNull(paramQuery);
                    int size2 = paramQuery.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        int i4 = i3 + 1;
                        if (matcher != null) {
                            str = matcher.group(i4);
                            if (str == null) {
                                str = "";
                            }
                        } else {
                            str = null;
                        }
                        String argumentName = paramQuery.getArgumentName(i3);
                        NavArgument navArgument2 = map2.get(argumentName);
                        if (str != null) {
                            if (!Intrinsics.areEqual((Object) str, (Object) '{' + argumentName + '}') && parseArgument(bundle2, argumentName, str, navArgument2)) {
                                return null;
                            }
                        }
                        i3 = i4;
                    }
                    bundle.putAll(bundle2);
                } catch (IllegalArgumentException unused2) {
                }
            }
        }
        for (Map.Entry next2 : map.entrySet()) {
            String str3 = (String) next2.getKey();
            NavArgument navArgument3 = (NavArgument) next2.getValue();
            if ((navArgument3 != null && !navArgument3.isNullable() && !navArgument3.isDefaultValuePresent()) && !bundle.containsKey(str3)) {
                return null;
            }
        }
        return bundle;
    }

    private final boolean parseArgument(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            navArgument.getType().parseAndPut(bundle, str, str2);
            return false;
        }
        bundle.putString(str, str2);
        return false;
    }

    @Metadata(mo33736d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, mo33737d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", "", "()V", "arguments", "", "", "getArguments", "()Ljava/util/List;", "paramRegex", "getParamRegex", "()Ljava/lang/String;", "setParamRegex", "(Ljava/lang/String;)V", "addArgumentName", "", "name", "getArgumentName", "index", "", "size", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavDeepLink.kt */
    private static final class ParamQuery {
        private final List<String> arguments = new ArrayList();
        private String paramRegex;

        public final String getParamRegex() {
            return this.paramRegex;
        }

        public final void setParamRegex(String str) {
            this.paramRegex = str;
        }

        public final List<String> getArguments() {
            return this.arguments;
        }

        public final void addArgumentName(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.arguments.add(str);
        }

        public final String getArgumentName(int i) {
            return this.arguments.get(i);
        }

        public final int size() {
            return this.arguments.size();
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0002R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004¨\u0006\u000f"}, mo33737d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", "", "mimeType", "", "(Ljava/lang/String;)V", "subType", "getSubType", "()Ljava/lang/String;", "setSubType", "type", "getType", "setType", "compareTo", "", "other", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavDeepLink.kt */
    private static final class MimeType implements Comparable<MimeType> {
        private String subType;
        private String type;

        public MimeType(String str) {
            List list;
            boolean z;
            Intrinsics.checkNotNullParameter(str, "mimeType");
            List<String> split = new Regex(DownloadsManager.FOLDERS_SEPARATOR).split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        break;
                    }
                    if (listIterator.previous().length() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        list = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
                this.type = (String) list.get(0);
                this.subType = (String) list.get(1);
            }
            list = CollectionsKt.emptyList();
            this.type = (String) list.get(0);
            this.subType = (String) list.get(1);
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public final String getSubType() {
            return this.subType;
        }

        public final void setSubType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.subType = str;
        }

        public int compareTo(MimeType mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "other");
            int i = Intrinsics.areEqual((Object) this.type, (Object) mimeType.type) ? 2 : 0;
            return Intrinsics.areEqual((Object) this.subType, (Object) mimeType.subType) ? i + 1 : i;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) obj;
        if (!Intrinsics.areEqual((Object) this.uriPattern, (Object) navDeepLink.uriPattern) || !Intrinsics.areEqual((Object) this.action, (Object) navDeepLink.action) || !Intrinsics.areEqual((Object) this.mimeType, (Object) navDeepLink.mimeType)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.uriPattern;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 0) * 31;
        String str2 = this.action;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mimeType;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    @Metadata(mo33736d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0017¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo33737d2 = {"Landroidx/navigation/NavDeepLink$Builder;", "", "()V", "action", "", "mimeType", "uriPattern", "build", "Landroidx/navigation/NavDeepLink;", "setAction", "setMimeType", "setUriPattern", "Companion", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavDeepLink.kt */
    public static final class Builder {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String action;
        private String mimeType;
        private String uriPattern;

        @JvmStatic
        public static final Builder fromAction(String str) {
            return Companion.fromAction(str);
        }

        @JvmStatic
        public static final Builder fromMimeType(String str) {
            return Companion.fromMimeType(str);
        }

        @JvmStatic
        public static final Builder fromUriPattern(String str) {
            return Companion.fromUriPattern(str);
        }

        public final Builder setUriPattern(String str) {
            Intrinsics.checkNotNullParameter(str, "uriPattern");
            this.uriPattern = str;
            return this;
        }

        public final Builder setAction(String str) {
            Intrinsics.checkNotNullParameter(str, "action");
            if (str.length() > 0) {
                this.action = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
        }

        public final Builder setMimeType(String str) {
            Intrinsics.checkNotNullParameter(str, "mimeType");
            this.mimeType = str;
            return this;
        }

        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }

        @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, mo33737d2 = {"Landroidx/navigation/NavDeepLink$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLink$Builder;", "action", "", "fromMimeType", "mimeType", "fromUriPattern", "uriPattern", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: NavDeepLink.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Builder fromUriPattern(String str) {
                Intrinsics.checkNotNullParameter(str, "uriPattern");
                Builder builder = new Builder();
                builder.setUriPattern(str);
                return builder;
            }

            @JvmStatic
            public final Builder fromAction(String str) {
                Intrinsics.checkNotNullParameter(str, "action");
                if (str.length() > 0) {
                    Builder builder = new Builder();
                    builder.setAction(str);
                    return builder;
                }
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.".toString());
            }

            @JvmStatic
            public final Builder fromMimeType(String str) {
                Intrinsics.checkNotNullParameter(str, "mimeType");
                Builder builder = new Builder();
                builder.setMimeType(str);
                return builder;
            }
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo33737d2 = {"Landroidx/navigation/NavDeepLink$Companion;", "", "()V", "SCHEME_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavDeepLink.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
