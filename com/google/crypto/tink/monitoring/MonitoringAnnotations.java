package com.google.crypto.tink.monitoring;

import com.google.errorprone.annotations.Immutable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Immutable
public final class MonitoringAnnotations {
    public static final MonitoringAnnotations EMPTY = newBuilder().build();
    private final Map<String, String> entries;

    public static final class Builder {
        private HashMap<String, String> builderEntries = new HashMap<>();

        public Builder addAll(Map<String, String> map) {
            HashMap<String, String> hashMap = this.builderEntries;
            if (hashMap != null) {
                hashMap.putAll(map);
                return this;
            }
            throw new IllegalStateException("addAll cannot be called after build()");
        }

        public Builder add(String str, String str2) {
            HashMap<String, String> hashMap = this.builderEntries;
            if (hashMap != null) {
                hashMap.put(str, str2);
                return this;
            }
            throw new IllegalStateException("add cannot be called after build()");
        }

        public MonitoringAnnotations build() {
            if (this.builderEntries != null) {
                MonitoringAnnotations monitoringAnnotations = new MonitoringAnnotations(Collections.unmodifiableMap(this.builderEntries));
                this.builderEntries = null;
                return monitoringAnnotations;
            }
            throw new IllegalStateException("cannot call build() twice");
        }
    }

    private MonitoringAnnotations(Map<String, String> map) {
        this.entries = map;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Map<String, String> toMap() {
        return this.entries;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MonitoringAnnotations)) {
            return false;
        }
        return this.entries.equals(((MonitoringAnnotations) obj).entries);
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return this.entries.toString();
    }
}
