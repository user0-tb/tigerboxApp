package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavOptions;
import androidx.navigation.common.C0614R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(mo33736d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0007\u001a\u00020\u00112\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0019\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u001c\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u001d\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo33737d2 = {"Landroidx/navigation/NavInflater;", "", "context", "Landroid/content/Context;", "navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "(Landroid/content/Context;Landroidx/navigation/NavigatorProvider;)V", "inflate", "Landroidx/navigation/NavDestination;", "res", "Landroid/content/res/Resources;", "parser", "Landroid/content/res/XmlResourceParser;", "attrs", "Landroid/util/AttributeSet;", "graphResId", "", "Landroidx/navigation/NavGraph;", "inflateAction", "", "dest", "inflateArgument", "Landroidx/navigation/NavArgument;", "a", "Landroid/content/res/TypedArray;", "inflateArgumentForBundle", "bundle", "Landroid/os/Bundle;", "inflateArgumentForDestination", "inflateDeepLink", "Companion", "navigation-runtime_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NavInflater.kt */
public final class NavInflater {
    public static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG_ACTION = "action";
    private static final String TAG_ARGUMENT = "argument";
    private static final String TAG_DEEP_LINK = "deepLink";
    private static final String TAG_INCLUDE = "include";
    private static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal<>();
    private final Context context;
    private final NavigatorProvider navigatorProvider;

    public NavInflater(Context context2, NavigatorProvider navigatorProvider2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(navigatorProvider2, "navigatorProvider");
        this.context = context2;
        this.navigatorProvider = navigatorProvider2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005f A[Catch:{ Exception -> 0x0069, all -> 0x0067 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023 A[Catch:{ Exception -> 0x0069, all -> 0x0067 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.navigation.NavGraph inflate(int r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.context
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.XmlResourceParser r1 = r0.getXml(r7)
            java.lang.String r2 = "res.getXml(graphResId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r2 = r1
            org.xmlpull.v1.XmlPullParser r2 = (org.xmlpull.v1.XmlPullParser) r2
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r2)
        L_0x0016:
            int r3 = r1.next()     // Catch:{ Exception -> 0x0069 }
            r4 = 2
            if (r3 == r4) goto L_0x0021
            r5 = 1
            if (r3 == r5) goto L_0x0021
            goto L_0x0016
        L_0x0021:
            if (r3 != r4) goto L_0x005f
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "res"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "attrs"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ Exception -> 0x0069 }
            androidx.navigation.NavDestination r2 = r6.inflate(r0, r1, r2, r7)     // Catch:{ Exception -> 0x0069 }
            boolean r4 = r2 instanceof androidx.navigation.NavGraph     // Catch:{ Exception -> 0x0069 }
            if (r4 == 0) goto L_0x003f
            androidx.navigation.NavGraph r2 = (androidx.navigation.NavGraph) r2     // Catch:{ Exception -> 0x0069 }
            r1.close()
            return r2
        L_0x003f:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0069 }
            r2.<init>()     // Catch:{ Exception -> 0x0069 }
            java.lang.String r4 = "Root element <"
            r2.append(r4)     // Catch:{ Exception -> 0x0069 }
            r2.append(r3)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "> did not inflate into a NavGraph"
            r2.append(r3)     // Catch:{ Exception -> 0x0069 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0069 }
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0069 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0069 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0069 }
            throw r3     // Catch:{ Exception -> 0x0069 }
        L_0x005f:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x0069 }
            java.lang.String r3 = "No start tag found"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0069 }
            throw r2     // Catch:{ Exception -> 0x0069 }
        L_0x0067:
            r7 = move-exception
            goto L_0x0093
        L_0x0069:
            r2 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x0067 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r4.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r5 = "Exception inflating "
            r4.append(r5)     // Catch:{ all -> 0x0067 }
            java.lang.String r7 = r0.getResourceName(r7)     // Catch:{ all -> 0x0067 }
            r4.append(r7)     // Catch:{ all -> 0x0067 }
            java.lang.String r7 = " line "
            r4.append(r7)     // Catch:{ all -> 0x0067 }
            int r7 = r1.getLineNumber()     // Catch:{ all -> 0x0067 }
            r4.append(r7)     // Catch:{ all -> 0x0067 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0067 }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x0067 }
            r3.<init>(r7, r2)     // Catch:{ all -> 0x0067 }
            throw r3     // Catch:{ all -> 0x0067 }
        L_0x0093:
            r1.close()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.inflate(int):androidx.navigation.NavGraph");
    }

    private final NavDestination inflate(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        int depth;
        NavigatorProvider navigatorProvider2 = this.navigatorProvider;
        String name = xmlResourceParser.getName();
        Intrinsics.checkNotNullExpressionValue(name, "parser.name");
        NavDestination createDestination = navigatorProvider2.getNavigator(name).createDestination();
        createDestination.onInflate(this.context, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                return createDestination;
            }
            if (next == 2 && depth <= depth2) {
                String name2 = xmlResourceParser.getName();
                if (Intrinsics.areEqual((Object) TAG_ARGUMENT, (Object) name2)) {
                    inflateArgumentForDestination(resources, createDestination, attributeSet, i);
                } else if (Intrinsics.areEqual((Object) TAG_DEEP_LINK, (Object) name2)) {
                    inflateDeepLink(resources, createDestination, attributeSet);
                } else if (Intrinsics.areEqual((Object) TAG_ACTION, (Object) name2)) {
                    inflateAction(resources, createDestination, attributeSet, xmlResourceParser, i);
                } else if (Intrinsics.areEqual((Object) TAG_INCLUDE, (Object) name2) && (createDestination instanceof NavGraph)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C0612R.styleable.NavInclude);
                    Intrinsics.checkNotNullExpressionValue(obtainAttributes, "res.obtainAttributes(att…n.R.styleable.NavInclude)");
                    ((NavGraph) createDestination).addDestination(inflate(obtainAttributes.getResourceId(C0612R.styleable.NavInclude_graph, 0)));
                    Unit unit = Unit.INSTANCE;
                    obtainAttributes.recycle();
                } else if (createDestination instanceof NavGraph) {
                    ((NavGraph) createDestination).addDestination(inflate(resources, xmlResourceParser, attributeSet, i));
                }
            }
        }
        return createDestination;
    }

    private final void inflateArgumentForDestination(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C0614R.styleable.NavArgument);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = obtainAttributes.getString(C0614R.styleable.NavArgument_android_name);
        if (string != null) {
            navDestination.addArgument(string, inflateArgument(obtainAttributes, resources, i));
            Unit unit = Unit.INSTANCE;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private final void inflateArgumentForBundle(Resources resources, Bundle bundle, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C0614R.styleable.NavArgument);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = obtainAttributes.getString(C0614R.styleable.NavArgument_android_name);
        if (string != null) {
            NavArgument inflateArgument = inflateArgument(obtainAttributes, resources, i);
            if (inflateArgument.isDefaultValuePresent()) {
                inflateArgument.putDefaultValue(string, bundle);
            }
            Unit unit = Unit.INSTANCE;
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.navigation.NavArgument inflateArgument(android.content.res.TypedArray r11, android.content.res.Resources r12, int r13) throws org.xmlpull.v1.XmlPullParserException {
        /*
            r10 = this;
            androidx.navigation.NavArgument$Builder r0 = new androidx.navigation.NavArgument$Builder
            r0.<init>()
            int r1 = androidx.navigation.common.C0614R.styleable.NavArgument_nullable
            r2 = 0
            boolean r1 = r11.getBoolean(r1, r2)
            r0.setIsNullable(r1)
            java.lang.ThreadLocal<android.util.TypedValue> r1 = sTmpValue
            java.lang.Object r3 = r1.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L_0x0021
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r1.set(r3)
        L_0x0021:
            int r1 = androidx.navigation.common.C0614R.styleable.NavArgument_argType
            java.lang.String r8 = r11.getString(r1)
            r1 = 0
            if (r8 == 0) goto L_0x0036
            androidx.navigation.NavType$Companion r4 = androidx.navigation.NavType.Companion
            java.lang.String r13 = r12.getResourcePackageName(r13)
            androidx.navigation.NavType r13 = r4.fromArgType(r8, r13)
            r6 = r13
            goto L_0x0037
        L_0x0036:
            r6 = r1
        L_0x0037:
            int r13 = androidx.navigation.common.C0614R.styleable.NavArgument_android_defaultValue
            boolean r13 = r11.getValue(r13, r3)
            if (r13 == 0) goto L_0x017f
            androidx.navigation.NavType<java.lang.Integer> r13 = androidx.navigation.NavType.ReferenceType
            java.lang.String r1 = "' for "
            java.lang.String r4 = "unsupported value '"
            r5 = 16
            if (r6 != r13) goto L_0x0085
            int r11 = r3.resourceId
            if (r11 == 0) goto L_0x0051
            int r2 = r3.resourceId
            goto L_0x0059
        L_0x0051:
            int r11 = r3.type
            if (r11 != r5) goto L_0x005f
            int r11 = r3.data
            if (r11 != 0) goto L_0x005f
        L_0x0059:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            goto L_0x017f
        L_0x005f:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r4)
            java.lang.CharSequence r13 = r3.string
            r12.append(r13)
            r12.append(r1)
            java.lang.String r13 = r6.getName()
            r12.append(r13)
            java.lang.String r13 = ". Must be a reference to a resource."
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0085:
            int r13 = r3.resourceId
            if (r13 == 0) goto L_0x00c9
            if (r6 != 0) goto L_0x0095
            androidx.navigation.NavType<java.lang.Integer> r6 = androidx.navigation.NavType.ReferenceType
            int r11 = r3.resourceId
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x017f
        L_0x0095:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r4)
            java.lang.CharSequence r13 = r3.string
            r12.append(r13)
            r12.append(r1)
            java.lang.String r13 = r6.getName()
            r12.append(r13)
            java.lang.String r13 = ". You must use a \""
            r12.append(r13)
            androidx.navigation.NavType<java.lang.Integer> r13 = androidx.navigation.NavType.ReferenceType
            java.lang.String r13 = r13.getName()
            r12.append(r13)
            java.lang.String r13 = "\" type to reference other resources."
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x00c9:
            androidx.navigation.NavType<java.lang.String> r13 = androidx.navigation.NavType.StringType
            if (r6 != r13) goto L_0x00d5
            int r12 = androidx.navigation.common.C0614R.styleable.NavArgument_android_defaultValue
            java.lang.String r1 = r11.getString(r12)
            goto L_0x017f
        L_0x00d5:
            int r11 = r3.type
            r13 = 3
            if (r11 == r13) goto L_0x016d
            r13 = 4
            if (r11 == r13) goto L_0x0159
            r13 = 5
            if (r11 == r13) goto L_0x0140
            r12 = 18
            if (r11 == r12) goto L_0x012b
            int r11 = r3.type
            if (r11 < r5) goto L_0x0118
            int r11 = r3.type
            r12 = 31
            if (r11 > r12) goto L_0x0118
            androidx.navigation.NavType<java.lang.Float> r11 = androidx.navigation.NavType.FloatType
            if (r6 != r11) goto L_0x0106
            androidx.navigation.NavInflater$Companion r4 = Companion
            androidx.navigation.NavType<java.lang.Float> r7 = androidx.navigation.NavType.FloatType
            java.lang.String r9 = "float"
            r5 = r3
            androidx.navigation.NavType r6 = r4.checkNavType$navigation_runtime_release(r5, r6, r7, r8, r9)
            int r11 = r3.data
            float r11 = (float) r11
            java.lang.Float r1 = java.lang.Float.valueOf(r11)
            goto L_0x017f
        L_0x0106:
            androidx.navigation.NavInflater$Companion r4 = Companion
            androidx.navigation.NavType<java.lang.Integer> r7 = androidx.navigation.NavType.IntType
            java.lang.String r9 = "integer"
            r5 = r3
            androidx.navigation.NavType r6 = r4.checkNavType$navigation_runtime_release(r5, r6, r7, r8, r9)
            int r11 = r3.data
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x017f
        L_0x0118:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException
            int r12 = r3.type
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "unsupported argument type "
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r13, r12)
            r11.<init>(r12)
            throw r11
        L_0x012b:
            androidx.navigation.NavInflater$Companion r4 = Companion
            androidx.navigation.NavType<java.lang.Boolean> r7 = androidx.navigation.NavType.BoolType
            java.lang.String r9 = "boolean"
            r5 = r3
            androidx.navigation.NavType r6 = r4.checkNavType$navigation_runtime_release(r5, r6, r7, r8, r9)
            int r11 = r3.data
            if (r11 == 0) goto L_0x013b
            r2 = 1
        L_0x013b:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r2)
            goto L_0x017f
        L_0x0140:
            androidx.navigation.NavInflater$Companion r4 = Companion
            androidx.navigation.NavType<java.lang.Integer> r7 = androidx.navigation.NavType.IntType
            java.lang.String r9 = "dimension"
            r5 = r3
            androidx.navigation.NavType r6 = r4.checkNavType$navigation_runtime_release(r5, r6, r7, r8, r9)
            android.util.DisplayMetrics r11 = r12.getDisplayMetrics()
            float r11 = r3.getDimension(r11)
            int r11 = (int) r11
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x017f
        L_0x0159:
            androidx.navigation.NavInflater$Companion r4 = Companion
            androidx.navigation.NavType<java.lang.Float> r7 = androidx.navigation.NavType.FloatType
            java.lang.String r9 = "float"
            r5 = r3
            androidx.navigation.NavType r6 = r4.checkNavType$navigation_runtime_release(r5, r6, r7, r8, r9)
            float r11 = r3.getFloat()
            java.lang.Float r1 = java.lang.Float.valueOf(r11)
            goto L_0x017f
        L_0x016d:
            java.lang.CharSequence r11 = r3.string
            java.lang.String r11 = r11.toString()
            if (r6 != 0) goto L_0x017b
            androidx.navigation.NavType$Companion r12 = androidx.navigation.NavType.Companion
            androidx.navigation.NavType r6 = r12.inferFromValue(r11)
        L_0x017b:
            java.lang.Object r1 = r6.parseValue(r11)
        L_0x017f:
            if (r1 == 0) goto L_0x0184
            r0.setDefaultValue(r1)
        L_0x0184:
            if (r6 == 0) goto L_0x0189
            r0.setType(r6)
        L_0x0189:
            androidx.navigation.NavArgument r11 = r0.build()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.inflateArgument(android.content.res.TypedArray, android.content.res.Resources, int):androidx.navigation.NavArgument");
    }

    private final void inflateDeepLink(Resources resources, NavDestination navDestination, AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, C0614R.styleable.NavDeepLink);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "res.obtainAttributes(att… R.styleable.NavDeepLink)");
        String string = obtainAttributes.getString(C0614R.styleable.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(C0614R.styleable.NavDeepLink_action);
        String string3 = obtainAttributes.getString(C0614R.styleable.NavDeepLink_mimeType);
        CharSequence charSequence = string;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            CharSequence charSequence2 = string2;
            if (charSequence2 == null || charSequence2.length() == 0) {
                CharSequence charSequence3 = string3;
                if (charSequence3 == null || charSequence3.length() == 0) {
                    throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
                }
            }
        }
        NavDeepLink.Builder builder = new NavDeepLink.Builder();
        if (string != null) {
            String packageName = this.context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "context.packageName");
            builder.setUriPattern(StringsKt.replace$default(string, APPLICATION_ID_PLACEHOLDER, packageName, false, 4, (Object) null));
        }
        CharSequence charSequence4 = string2;
        if (charSequence4 == null || charSequence4.length() == 0) {
            z = true;
        }
        if (!z) {
            String packageName2 = this.context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName2, "context.packageName");
            builder.setAction(StringsKt.replace$default(string2, APPLICATION_ID_PLACEHOLDER, packageName2, false, 4, (Object) null));
        }
        if (string3 != null) {
            String packageName3 = this.context.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName3, "context.packageName");
            builder.setMimeType(StringsKt.replace$default(string3, APPLICATION_ID_PLACEHOLDER, packageName3, false, 4, (Object) null));
        }
        navDestination.addDeepLink(builder.build());
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    private final void inflateAction(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i) throws IOException, XmlPullParserException {
        int depth;
        Context context2 = this.context;
        int[] iArr = C0614R.styleable.NavAction;
        Intrinsics.checkNotNullExpressionValue(iArr, "NavAction");
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        int resourceId = obtainStyledAttributes.getResourceId(C0614R.styleable.NavAction_android_id, 0);
        NavAction navAction = new NavAction(obtainStyledAttributes.getResourceId(C0614R.styleable.NavAction_destination, 0), (NavOptions) null, (Bundle) null, 6, (DefaultConstructorMarker) null);
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.setLaunchSingleTop(obtainStyledAttributes.getBoolean(C0614R.styleable.NavAction_launchSingleTop, false));
        builder.setRestoreState(obtainStyledAttributes.getBoolean(C0614R.styleable.NavAction_restoreState, false));
        builder.setPopUpTo(obtainStyledAttributes.getResourceId(C0614R.styleable.NavAction_popUpTo, -1), obtainStyledAttributes.getBoolean(C0614R.styleable.NavAction_popUpToInclusive, false), obtainStyledAttributes.getBoolean(C0614R.styleable.NavAction_popUpToSaveState, false));
        builder.setEnterAnim(obtainStyledAttributes.getResourceId(C0614R.styleable.NavAction_enterAnim, -1));
        builder.setExitAnim(obtainStyledAttributes.getResourceId(C0614R.styleable.NavAction_exitAnim, -1));
        builder.setPopEnterAnim(obtainStyledAttributes.getResourceId(C0614R.styleable.NavAction_popEnterAnim, -1));
        builder.setPopExitAnim(obtainStyledAttributes.getResourceId(C0614R.styleable.NavAction_popExitAnim, -1));
        navAction.setNavOptions(builder.build());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1 && ((depth = xmlResourceParser.getDepth()) >= depth2 || next != 3)) {
                if (next == 2 && depth <= depth2 && Intrinsics.areEqual((Object) TAG_ARGUMENT, (Object) xmlResourceParser.getName())) {
                    inflateArgumentForBundle(resources, bundle, attributeSet, i);
                }
            }
        }
        if (!bundle.isEmpty()) {
            navAction.setDefaultArguments(bundle);
        }
        navDestination.putAction(resourceId, navAction);
        obtainStyledAttributes.recycle();
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JE\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\r2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo33737d2 = {"Landroidx/navigation/NavInflater$Companion;", "", "()V", "APPLICATION_ID_PLACEHOLDER", "", "TAG_ACTION", "TAG_ARGUMENT", "TAG_DEEP_LINK", "TAG_INCLUDE", "sTmpValue", "Ljava/lang/ThreadLocal;", "Landroid/util/TypedValue;", "checkNavType", "Landroidx/navigation/NavType;", "value", "navType", "expectedNavType", "argType", "foundType", "checkNavType$navigation_runtime_release", "navigation-runtime_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavInflater.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NavType<?> checkNavType$navigation_runtime_release(TypedValue typedValue, NavType<?> navType, NavType<?> navType2, String str, String str2) throws XmlPullParserException {
            Intrinsics.checkNotNullParameter(typedValue, "value");
            Intrinsics.checkNotNullParameter(navType2, "expectedNavType");
            Intrinsics.checkNotNullParameter(str2, "foundType");
            if (navType == null || navType == navType2) {
                return navType == null ? navType2 : navType;
            }
            throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
        }
    }
}
