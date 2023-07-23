package media.tiger.tigerbox.model.dto;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0003J.\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0006\u0018\u00010\u0005\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/AlwaysListTypeAdapterFactory;", "E", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", "T", "gson", "Lcom/google/gson/Gson;", "typeToken", "Lcom/google/gson/reflect/TypeToken;", "AlwaysListTypeAdapter", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AlwaysListTypeAdapterFactory.kt */
public final class AlwaysListTypeAdapterFactory<E> implements TypeAdapterFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    private AlwaysListTypeAdapterFactory() {
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(typeToken, "typeToken");
        if (!List.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Companion companion = Companion;
        Type type = typeToken.getType();
        Intrinsics.checkNotNullExpressionValue(type, "typeToken.type");
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(companion.resolveTypeArgument(type)));
        Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.google.gson.TypeAdapter<E of media.tiger.tigerbox.model.dto.AlwaysListTypeAdapterFactory?>");
        TypeAdapter<T> nullSafe = new AlwaysListTypeAdapter(adapter).nullSafe();
        Objects.requireNonNull(nullSafe, "null cannot be cast to non-null type com.google.gson.TypeAdapter<T of media.tiger.tigerbox.model.dto.AlwaysListTypeAdapterFactory.create?>");
        return nullSafe;
    }

    @Metadata(mo33736d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/AlwaysListTypeAdapterFactory$AlwaysListTypeAdapter;", "E", "Lcom/google/gson/TypeAdapter;", "", "elementTypeAdapter", "(Lcom/google/gson/TypeAdapter;)V", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "list", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AlwaysListTypeAdapterFactory.kt */
    private static final class AlwaysListTypeAdapter<E> extends TypeAdapter<List<? extends E>> {
        private final TypeAdapter<E> elementTypeAdapter;

        @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: AlwaysListTypeAdapterFactory.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[JsonToken.values().length];
                iArr[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
                iArr[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
                iArr[JsonToken.STRING.ordinal()] = 3;
                iArr[JsonToken.NUMBER.ordinal()] = 4;
                iArr[JsonToken.BOOLEAN.ordinal()] = 5;
                iArr[JsonToken.NULL.ordinal()] = 6;
                iArr[JsonToken.NAME.ordinal()] = 7;
                iArr[JsonToken.END_ARRAY.ordinal()] = 8;
                iArr[JsonToken.END_OBJECT.ordinal()] = 9;
                iArr[JsonToken.END_DOCUMENT.ordinal()] = 10;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public AlwaysListTypeAdapter(TypeAdapter<E> typeAdapter) {
            Intrinsics.checkNotNullParameter(typeAdapter, "elementTypeAdapter");
            this.elementTypeAdapter = typeAdapter;
        }

        public void write(JsonWriter jsonWriter, List<? extends E> list) {
            throw new UnsupportedOperationException();
        }

        public List<E> read(JsonReader jsonReader) throws IOException {
            Intrinsics.checkNotNullParameter(jsonReader, "reader");
            List<E> arrayList = new ArrayList<>();
            JsonToken peek = jsonReader.peek();
            Intrinsics.checkNotNullExpressionValue(peek, "reader.peek()");
            switch (WhenMappings.$EnumSwitchMapping$0[peek.ordinal()]) {
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(this.elementTypeAdapter.read(jsonReader));
                    }
                    jsonReader.endArray();
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    arrayList.add(this.elementTypeAdapter.read(jsonReader));
                    break;
                case 6:
                    throw new AssertionError("Must never happen: check if the type adapter configured with .nullSafe()");
                case 7:
                case 8:
                case 9:
                case 10:
                    throw new MalformedJsonException("Unexpected token: " + peek);
                default:
                    throw new AssertionError("Must never happen: " + peek);
            }
            return arrayList;
        }
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/model/dto/AlwaysListTypeAdapterFactory$Companion;", "", "()V", "resolveTypeArgument", "Ljava/lang/reflect/Type;", "type", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AlwaysListTypeAdapterFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final Type resolveTypeArgument(Type type) {
            if (!(type instanceof ParameterizedType)) {
                return Object.class;
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            Intrinsics.checkNotNullExpressionValue(type2, "parameterizedType.actualTypeArguments[0]");
            return type2;
        }
    }
}
