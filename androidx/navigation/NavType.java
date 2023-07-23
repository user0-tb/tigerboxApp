package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import okhttp3.HttpUrl;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006\u0019\u001a\u001b\u001c\u001d\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH¦\u0002¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\bH&¢\u0006\u0002\u0010\u0014J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, mo33737d2 = {"Landroidx/navigation/NavType;", "T", "", "isNullableAllowed", "", "(Z)V", "()Z", "name", "", "getName", "()Ljava/lang/String;", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "parseAndPut", "value", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Object;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "toString", "Companion", "EnumType", "ParcelableArrayType", "ParcelableType", "SerializableArrayType", "SerializableType", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: NavType.kt */
public abstract class NavType<T> {
    public static final NavType<boolean[]> BoolArrayType = new NavType$Companion$BoolArrayType$1();
    public static final NavType<Boolean> BoolType = new NavType$Companion$BoolType$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final NavType<float[]> FloatArrayType = new NavType$Companion$FloatArrayType$1();
    public static final NavType<Float> FloatType = new NavType$Companion$FloatType$1();
    public static final NavType<int[]> IntArrayType = new NavType$Companion$IntArrayType$1();
    public static final NavType<Integer> IntType = new NavType$Companion$IntType$1();
    public static final NavType<long[]> LongArrayType = new NavType$Companion$LongArrayType$1();
    public static final NavType<Long> LongType = new NavType$Companion$LongType$1();
    public static final NavType<Integer> ReferenceType = new NavType$Companion$ReferenceType$1();
    public static final NavType<String[]> StringArrayType = new NavType$Companion$StringArrayType$1();
    public static final NavType<String> StringType = new NavType$Companion$StringType$1();
    private final boolean isNullableAllowed;
    private final String name = "nav_type";

    @JvmStatic
    public static NavType<?> fromArgType(String str, String str2) {
        return Companion.fromArgType(str, str2);
    }

    @JvmStatic
    public static final NavType<Object> inferFromValue(String str) {
        return Companion.inferFromValue(str);
    }

    @JvmStatic
    public static final NavType<Object> inferFromValueType(Object obj) {
        return Companion.inferFromValueType(obj);
    }

    public abstract T get(Bundle bundle, String str);

    public abstract T parseValue(String str);

    public abstract void put(Bundle bundle, String str, T t);

    public NavType(boolean z) {
        this.isNullableAllowed = z;
    }

    public boolean isNullableAllowed() {
        return this.isNullableAllowed;
    }

    public final T parseAndPut(Bundle bundle, String str, String str2) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        T parseValue = parseValue(str2);
        put(bundle, str, parseValue);
        return parseValue;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return getName();
    }

    @Metadata(mo33736d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u0017H\u0017J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\u0006\u0010\u001d\u001a\u00020\u0017H\u0007J\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0007R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00160\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo33737d2 = {"Landroidx/navigation/NavType$Companion;", "", "()V", "BoolArrayType", "Landroidx/navigation/NavType;", "", "BoolType", "", "FloatArrayType", "", "FloatType", "", "IntArrayType", "", "IntType", "", "LongArrayType", "", "LongType", "", "ReferenceType", "StringArrayType", "", "", "StringType", "fromArgType", "type", "packageName", "inferFromValue", "value", "inferFromValueType", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavType.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public NavType<?> fromArgType(String str, String str2) {
            if (Intrinsics.areEqual((Object) NavType.IntType.getName(), (Object) str)) {
                return NavType.IntType;
            }
            if (Intrinsics.areEqual((Object) NavType.IntArrayType.getName(), (Object) str)) {
                return NavType.IntArrayType;
            }
            if (Intrinsics.areEqual((Object) NavType.LongType.getName(), (Object) str)) {
                return NavType.LongType;
            }
            if (Intrinsics.areEqual((Object) NavType.LongArrayType.getName(), (Object) str)) {
                return NavType.LongArrayType;
            }
            if (Intrinsics.areEqual((Object) NavType.BoolType.getName(), (Object) str)) {
                return NavType.BoolType;
            }
            if (Intrinsics.areEqual((Object) NavType.BoolArrayType.getName(), (Object) str)) {
                return NavType.BoolArrayType;
            }
            if (Intrinsics.areEqual((Object) NavType.StringType.getName(), (Object) str)) {
                return NavType.StringType;
            }
            if (Intrinsics.areEqual((Object) NavType.StringArrayType.getName(), (Object) str)) {
                return NavType.StringArrayType;
            }
            if (Intrinsics.areEqual((Object) NavType.FloatType.getName(), (Object) str)) {
                return NavType.FloatType;
            }
            if (Intrinsics.areEqual((Object) NavType.FloatArrayType.getName(), (Object) str)) {
                return NavType.FloatArrayType;
            }
            if (Intrinsics.areEqual((Object) NavType.ReferenceType.getName(), (Object) str)) {
                return NavType.ReferenceType;
            }
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                return NavType.StringType;
            }
            try {
                String stringPlus = (!StringsKt.startsWith$default(str, DownloadsManager.EXTENSION_SEPARATOR, false, 2, (Object) null) || str2 == null) ? str : Intrinsics.stringPlus(str2, str);
                if (StringsKt.endsWith$default(str, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, false, 2, (Object) null)) {
                    stringPlus = stringPlus.substring(0, stringPlus.length() - 2);
                    Intrinsics.checkNotNullExpressionValue(stringPlus, "this as java.lang.String…ing(startIndex, endIndex)");
                    Class<?> cls = Class.forName(stringPlus);
                    if (Parcelable.class.isAssignableFrom(cls)) {
                        if (cls != null) {
                            return new ParcelableArrayType<>(cls);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                    } else if (Serializable.class.isAssignableFrom(cls)) {
                        if (cls != null) {
                            return new SerializableArrayType<>(cls);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                    }
                } else {
                    Class<?> cls2 = Class.forName(stringPlus);
                    if (Parcelable.class.isAssignableFrom(cls2)) {
                        if (cls2 != null) {
                            return new ParcelableType<>(cls2);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Any?>");
                    } else if (Enum.class.isAssignableFrom(cls2)) {
                        if (cls2 != null) {
                            return new EnumType<>(cls2);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Enum<*>>");
                    } else if (Serializable.class.isAssignableFrom(cls2)) {
                        if (cls2 != null) {
                            return new SerializableType<>(cls2);
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                    }
                }
                throw new IllegalArgumentException(Intrinsics.stringPlus(stringPlus, " is not Serializable or Parcelable."));
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        /* JADX WARNING: type inference failed for: r2v6, types: [androidx.navigation.NavType<java.lang.Object>, androidx.navigation.NavType<java.lang.Float>] */
        /* JADX WARNING: type inference failed for: r2v7, types: [androidx.navigation.NavType<java.lang.Long>, androidx.navigation.NavType<java.lang.Object>] */
        /* JADX WARNING: type inference failed for: r2v8, types: [androidx.navigation.NavType<java.lang.Object>, androidx.navigation.NavType<java.lang.Integer>] */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|12) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
        /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            androidx.navigation.NavType.BoolType.parseValue(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
            return androidx.navigation.NavType.BoolType;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            return androidx.navigation.NavType.StringType;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            r2 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
            androidx.navigation.NavType.LongType.parseValue(r2);
            r2 = androidx.navigation.NavType.LongType;
            r2 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
            return r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
            r2 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
            androidx.navigation.NavType.FloatType.parseValue(r2);
            r2 = androidx.navigation.NavType.FloatType;
            r2 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
            return r2;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 3 */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.navigation.NavType<java.lang.Object> inferFromValue(java.lang.String r2) {
            /*
                r1 = this;
                java.lang.String r0 = "value"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                androidx.navigation.NavType<java.lang.Integer> r0 = androidx.navigation.NavType.IntType     // Catch:{ IllegalArgumentException -> 0x000e }
                r0.parseValue(r2)     // Catch:{ IllegalArgumentException -> 0x000e }
                androidx.navigation.NavType<java.lang.Integer> r2 = androidx.navigation.NavType.IntType     // Catch:{ IllegalArgumentException -> 0x000e }
                return r2
            L_0x000e:
                androidx.navigation.NavType<java.lang.Long> r0 = androidx.navigation.NavType.LongType     // Catch:{ IllegalArgumentException -> 0x0016 }
                r0.parseValue(r2)     // Catch:{ IllegalArgumentException -> 0x0016 }
                androidx.navigation.NavType<java.lang.Long> r2 = androidx.navigation.NavType.LongType     // Catch:{ IllegalArgumentException -> 0x0016 }
                return r2
            L_0x0016:
                androidx.navigation.NavType<java.lang.Float> r0 = androidx.navigation.NavType.FloatType     // Catch:{ IllegalArgumentException -> 0x001e }
                r0.parseValue(r2)     // Catch:{ IllegalArgumentException -> 0x001e }
                androidx.navigation.NavType<java.lang.Float> r2 = androidx.navigation.NavType.FloatType     // Catch:{ IllegalArgumentException -> 0x001e }
                return r2
            L_0x001e:
                androidx.navigation.NavType<java.lang.Boolean> r0 = androidx.navigation.NavType.BoolType     // Catch:{ IllegalArgumentException -> 0x0026 }
                r0.parseValue(r2)     // Catch:{ IllegalArgumentException -> 0x0026 }
                androidx.navigation.NavType<java.lang.Boolean> r2 = androidx.navigation.NavType.BoolType     // Catch:{ IllegalArgumentException -> 0x0026 }
                return r2
            L_0x0026:
                androidx.navigation.NavType<java.lang.String> r2 = androidx.navigation.NavType.StringType
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavType.Companion.inferFromValue(java.lang.String):androidx.navigation.NavType");
        }

        @JvmStatic
        public final NavType<Object> inferFromValueType(Object obj) {
            if (obj instanceof Integer) {
                return NavType.IntType;
            }
            if (obj instanceof int[]) {
                return NavType.IntArrayType;
            }
            if (obj instanceof Long) {
                return NavType.LongType;
            }
            if (obj instanceof long[]) {
                return NavType.LongArrayType;
            }
            if (obj instanceof Float) {
                return NavType.FloatType;
            }
            if (obj instanceof float[]) {
                return NavType.FloatArrayType;
            }
            if (obj instanceof Boolean) {
                return NavType.BoolType;
            }
            if (obj instanceof boolean[]) {
                return NavType.BoolArrayType;
            }
            if ((obj instanceof String) || obj == null) {
                return NavType.StringType;
            }
            if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
                return NavType.StringArrayType;
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    Class<?> componentType2 = obj.getClass().getComponentType();
                    Objects.requireNonNull(componentType2, "null cannot be cast to non-null type java.lang.Class<android.os.Parcelable>");
                    return new ParcelableArrayType<>(componentType2);
                }
            }
            if (obj.getClass().isArray()) {
                Class<?> componentType3 = obj.getClass().getComponentType();
                Intrinsics.checkNotNull(componentType3);
                if (Serializable.class.isAssignableFrom(componentType3)) {
                    Class<?> componentType4 = obj.getClass().getComponentType();
                    Objects.requireNonNull(componentType4, "null cannot be cast to non-null type java.lang.Class<java.io.Serializable>");
                    return new SerializableArrayType<>(componentType4);
                }
            }
            if (obj instanceof Parcelable) {
                return new ParcelableType<>(obj.getClass());
            }
            if (obj instanceof Enum) {
                return new EnumType<>(obj.getClass());
            }
            if (obj instanceof Serializable) {
                return new SerializableType<>(obj.getClass());
            }
            throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
        }
    }

    @Metadata(mo33736d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J \u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0015\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0016\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0017J%\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo33737d2 = {"Landroidx/navigation/NavType$ParcelableType;", "D", "Landroidx/navigation/NavType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Object;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Object;)V", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavType.kt */
    public static final class ParcelableType<D> extends NavType<D> {
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParcelableType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, SessionDescription.ATTR_TYPE);
            boolean z = true;
            if (!Parcelable.class.isAssignableFrom(cls) && !Serializable.class.isAssignableFrom(cls)) {
                z = false;
            }
            if (z) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Parcelable or Serializable.").toString());
        }

        public String getName() {
            String name = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        public void put(Bundle bundle, String str, D d) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            this.type.cast(d);
            if (d == null || (d instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d);
            } else if (d instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d);
            }
        }

        public D get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return bundle.get(str);
        }

        public D parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.type, (Object) ((ParcelableType) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }
    }

    @Metadata(mo33736d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, mo33737d2 = {"Landroidx/navigation/NavType$ParcelableArrayType;", "D", "Landroid/os/Parcelable;", "Landroidx/navigation/NavType;", "", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "arrayType", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)[Landroid/os/Parcelable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Landroid/os/Parcelable;)V", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavType.kt */
    public static final class ParcelableArrayType<D extends Parcelable> extends NavType<D[]> {
        private final Class<D[]> arrayType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ParcelableArrayType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, SessionDescription.ATTR_TYPE);
            if (Parcelable.class.isAssignableFrom(cls)) {
                try {
                    Class<?> cls2 = Class.forName("[L" + cls.getName() + ';');
                    if (cls2 != null) {
                        this.arrayType = cls2;
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.ParcelableArrayType>>");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Parcelable.").toString());
            }
        }

        public String getName() {
            String name = this.arrayType.getName();
            Intrinsics.checkNotNullExpressionValue(name, "arrayType.name");
            return name;
        }

        public void put(Bundle bundle, String str, D[] dArr) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            this.arrayType.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }

        public D[] get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return (Parcelable[]) bundle.get(str);
        }

        public D[] parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.arrayType, (Object) ((ParcelableArrayType) obj).arrayType);
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }
    }

    @Metadata(mo33736d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001d\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J \u0010\u0011\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0015\u0010\u0018\u001a\u00028\u00012\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u001aJ%\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo33737d2 = {"Landroidx/navigation/NavType$SerializableType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "nullableAllowed", "", "(ZLjava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "equals", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/io/Serializable;)V", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavType.kt */
    public static class SerializableType<D extends Serializable> extends NavType<D> {
        private final Class<D> type;

        public String getName() {
            String name = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, SessionDescription.ATTR_TYPE);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            } else if (true ^ cls.isEnum()) {
                this.type = cls;
            } else {
                throw new IllegalArgumentException((cls + " is an Enum. You should use EnumType instead.").toString());
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableType(boolean z, Class<D> cls) {
            super(z);
            Intrinsics.checkNotNullParameter(cls, SessionDescription.ATTR_TYPE);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
        }

        public void put(Bundle bundle, String str, D d) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(d, "value");
            this.type.cast(d);
            bundle.putSerializable(str, d);
        }

        public D get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return (Serializable) bundle.get(str);
        }

        public D parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SerializableType)) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.type, (Object) ((SerializableType) obj).type);
        }

        public int hashCode() {
            return this.type.hashCode();
        }
    }

    @Metadata(mo33736d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000*\f\b\u0001\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo33737d2 = {"Landroidx/navigation/NavType$EnumType;", "D", "", "Landroidx/navigation/NavType$SerializableType;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "name", "", "getName", "()Ljava/lang/String;", "parseValue", "value", "(Ljava/lang/String;)Ljava/lang/Enum;", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavType.kt */
    public static final class EnumType<D extends Enum<?>> extends SerializableType<D> {
        private final Class<D> type;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EnumType(Class<D> cls) {
            super(false, cls);
            Intrinsics.checkNotNullParameter(cls, SessionDescription.ATTR_TYPE);
            if (cls.isEnum()) {
                this.type = cls;
                return;
            }
            throw new IllegalArgumentException((cls + " is not an Enum type.").toString());
        }

        public String getName() {
            String name = this.type.getName();
            Intrinsics.checkNotNullExpressionValue(name, "type.name");
            return name;
        }

        public D parseValue(String str) {
            D d;
            Intrinsics.checkNotNullParameter(str, "value");
            D[] enumConstants = this.type.getEnumConstants();
            Intrinsics.checkNotNullExpressionValue(enumConstants, "type.enumConstants");
            int length = enumConstants.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    d = null;
                    break;
                }
                d = enumConstants[i];
                i++;
                if (StringsKt.equals(((Enum) d).name(), str, true)) {
                    break;
                }
            }
            D d2 = (Enum) d;
            if (d2 != null) {
                return d2;
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.type.getName() + '.');
        }
    }

    @Metadata(mo33736d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00040\u0003B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J&\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0019\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u001aJ-\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\n2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u001dR\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, mo33737d2 = {"Landroidx/navigation/NavType$SerializableArrayType;", "D", "Ljava/io/Serializable;", "Landroidx/navigation/NavType;", "", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "arrayType", "name", "", "getName", "()Ljava/lang/String;", "equals", "", "other", "", "get", "bundle", "Landroid/os/Bundle;", "key", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/io/Serializable;", "hashCode", "", "parseValue", "value", "(Ljava/lang/String;)[Ljava/io/Serializable;", "put", "", "(Landroid/os/Bundle;Ljava/lang/String;[Ljava/io/Serializable;)V", "navigation-common_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: NavType.kt */
    public static final class SerializableArrayType<D extends Serializable> extends NavType<D[]> {
        private final Class<D[]> arrayType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SerializableArrayType(Class<D> cls) {
            super(true);
            Intrinsics.checkNotNullParameter(cls, SessionDescription.ATTR_TYPE);
            if (Serializable.class.isAssignableFrom(cls)) {
                try {
                    Class<?> cls2 = Class.forName("[L" + cls.getName() + ';');
                    if (cls2 != null) {
                        this.arrayType = cls2;
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<kotlin.Array<D of androidx.navigation.NavType.SerializableArrayType>>");
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                throw new IllegalArgumentException((cls + " does not implement Serializable.").toString());
            }
        }

        public String getName() {
            String name = this.arrayType.getName();
            Intrinsics.checkNotNullExpressionValue(name, "arrayType.name");
            return name;
        }

        public void put(Bundle bundle, String str, D[] dArr) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            this.arrayType.cast(dArr);
            bundle.putSerializable(str, (Serializable) dArr);
        }

        public D[] get(Bundle bundle, String str) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(str, "key");
            return (Serializable[]) bundle.get(str);
        }

        public D[] parseValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
                return false;
            }
            return Intrinsics.areEqual((Object) this.arrayType, (Object) ((SerializableArrayType) obj).arrayType);
        }

        public int hashCode() {
            return this.arrayType.hashCode();
        }
    }
}
