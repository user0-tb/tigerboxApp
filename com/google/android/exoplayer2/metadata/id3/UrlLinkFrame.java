package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.C1229Util;

public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() {
        public UrlLinkFrame createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }

        public UrlLinkFrame[] newArray(int i) {
            return new UrlLinkFrame[i];
        }
    };
    public final String description;
    public final String url;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.description = str2;
        this.url = str3;
    }

    UrlLinkFrame(Parcel parcel) {
        super((String) C1229Util.castNonNull(parcel.readString()));
        this.description = parcel.readString();
        this.url = (String) C1229Util.castNonNull(parcel.readString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
        if (!this.f161id.equals(urlLinkFrame.f161id) || !C1229Util.areEqual(this.description, urlLinkFrame.description) || !C1229Util.areEqual(this.url, urlLinkFrame.url)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (527 + this.f161id.hashCode()) * 31;
        String str = this.description;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return this.f161id + ": url=" + this.url;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f161id);
        parcel.writeString(this.description);
        parcel.writeString(this.url);
    }
}
