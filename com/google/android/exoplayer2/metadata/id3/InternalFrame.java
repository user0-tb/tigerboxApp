package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.C1229Util;

public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new Parcelable.Creator<InternalFrame>() {
        public InternalFrame createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }

        public InternalFrame[] newArray(int i) {
            return new InternalFrame[i];
        }
    };

    /* renamed from: ID */
    public static final String f162ID = "----";
    public final String description;
    public final String domain;
    public final String text;

    public InternalFrame(String str, String str2, String str3) {
        super(f162ID);
        this.domain = str;
        this.description = str2;
        this.text = str3;
    }

    InternalFrame(Parcel parcel) {
        super(f162ID);
        this.domain = (String) C1229Util.castNonNull(parcel.readString());
        this.description = (String) C1229Util.castNonNull(parcel.readString());
        this.text = (String) C1229Util.castNonNull(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InternalFrame internalFrame = (InternalFrame) obj;
        if (!C1229Util.areEqual(this.description, internalFrame.description) || !C1229Util.areEqual(this.domain, internalFrame.domain) || !C1229Util.areEqual(this.text, internalFrame.text)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.domain;
        int i = 0;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return this.f161id + ": domain=" + this.domain + ", description=" + this.description;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f161id);
        parcel.writeString(this.domain);
        parcel.writeString(this.text);
    }
}
