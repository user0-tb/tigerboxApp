package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.util.C1229Util;

public final class Descriptor {

    /* renamed from: id */
    public final String f175id;
    public final String schemeIdUri;
    public final String value;

    public Descriptor(String str, String str2, String str3) {
        this.schemeIdUri = str;
        this.value = str2;
        this.f175id = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Descriptor descriptor = (Descriptor) obj;
        if (!C1229Util.areEqual(this.schemeIdUri, descriptor.schemeIdUri) || !C1229Util.areEqual(this.value, descriptor.value) || !C1229Util.areEqual(this.f175id, descriptor.f175id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.schemeIdUri.hashCode() * 31;
        String str = this.value;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f175id;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }
}
