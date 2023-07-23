package com.google.crypto.tink.jwt;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.Map;

final class JsonUtil {
    static boolean isValidString(String str) {
        int length = str.length();
        int i = 0;
        while (i != length) {
            char charAt = str.charAt(i);
            i++;
            if (Character.isSurrogate(charAt)) {
                if (Character.isLowSurrogate(charAt) || i == length || !Character.isLowSurrogate(str.charAt(i))) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    private static void validateAllStringsInJsonObject(JsonObject jsonObject) throws JwtInvalidException {
        for (Map.Entry next : jsonObject.entrySet()) {
            if (isValidString((String) next.getKey())) {
                validateAllStringsInJsonElement((JsonElement) next.getValue());
            } else {
                throw new JwtInvalidException("JSON string contains character");
            }
        }
    }

    private static void validateAllStringsInJsonElement(JsonElement jsonElement) throws JwtInvalidException {
        if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().isString()) {
            if (jsonElement.isJsonObject()) {
                validateAllStringsInJsonObject(jsonElement.getAsJsonObject());
            } else if (jsonElement.isJsonArray()) {
                validateAllStringsInJsonArray(jsonElement.getAsJsonArray());
            }
        } else if (!isValidString(jsonElement.getAsJsonPrimitive().getAsString())) {
            throw new JwtInvalidException("JSON string contains invalid character");
        }
    }

    private static void validateAllStringsInJsonArray(JsonArray jsonArray) throws JwtInvalidException {
        Iterator<JsonElement> it = jsonArray.iterator();
        while (it.hasNext()) {
            validateAllStringsInJsonElement(it.next());
        }
    }

    static JsonObject parseJson(String str) throws JwtInvalidException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.setLenient(false);
            JsonObject asJsonObject = Streams.parse(jsonReader).getAsJsonObject();
            validateAllStringsInJsonObject(asJsonObject);
            return asJsonObject;
        } catch (JsonParseException | IllegalStateException | StackOverflowError e) {
            throw new JwtInvalidException("invalid JSON: " + e);
        }
    }

    static JsonArray parseJsonArray(String str) throws JwtInvalidException {
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(str));
            jsonReader.setLenient(false);
            JsonArray asJsonArray = Streams.parse(jsonReader).getAsJsonArray();
            validateAllStringsInJsonArray(asJsonArray);
            return asJsonArray;
        } catch (JsonParseException | IllegalStateException | StackOverflowError e) {
            throw new JwtInvalidException("invalid JSON: " + e);
        }
    }

    private JsonUtil() {
    }
}
