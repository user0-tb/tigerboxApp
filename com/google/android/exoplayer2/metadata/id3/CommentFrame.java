package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.C1229Util;

public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() {
        public CommentFrame createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }

        public CommentFrame[] newArray(int i) {
            return new CommentFrame[i];
        }
    };

    /* renamed from: ID */
    public static final String f159ID = "COMM";
    public final String description;
    public final String language;
    public final String text;

    public CommentFrame(String str, String str2, String str3) {
        super(f159ID);
        this.language = str;
        this.description = str2;
        this.text = str3;
    }

    CommentFrame(Parcel parcel) {
        super(f159ID);
        this.language = (String) C1229Util.castNonNull(parcel.readString());
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
        CommentFrame commentFrame = (CommentFrame) obj;
        if (!C1229Util.areEqual(this.description, commentFrame.description) || !C1229Util.areEqual(this.language, commentFrame.language) || !C1229Util.areEqual(this.text, commentFrame.text)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.language;
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
        return this.f161id + ": language=" + this.language + ", description=" + this.description;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f161id);
        parcel.writeString(this.language);
        parcel.writeString(this.text);
    }
}
