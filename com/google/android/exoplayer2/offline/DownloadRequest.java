package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.C1229Util;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class DownloadRequest implements Parcelable {
    public static final Parcelable.Creator<DownloadRequest> CREATOR = new Parcelable.Creator<DownloadRequest>() {
        public DownloadRequest createFromParcel(Parcel parcel) {
            return new DownloadRequest(parcel);
        }

        public DownloadRequest[] newArray(int i) {
            return new DownloadRequest[i];
        }
    };
    public final String customCacheKey;
    public final byte[] data;

    /* renamed from: id */
    public final String f165id;
    public final byte[] keySetId;
    public final String mimeType;
    public final List<StreamKey> streamKeys;
    public final Uri uri;

    public static class UnsupportedRequestException extends IOException {
    }

    public int describeContents() {
        return 0;
    }

    public static class Builder {
        private String customCacheKey;
        private byte[] data;

        /* renamed from: id */
        private final String f166id;
        private byte[] keySetId;
        private String mimeType;
        private List<StreamKey> streamKeys;
        private final Uri uri;

        public Builder(String str, Uri uri2) {
            this.f166id = str;
            this.uri = uri2;
        }

        public Builder setMimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public Builder setStreamKeys(List<StreamKey> list) {
            this.streamKeys = list;
            return this;
        }

        public Builder setKeySetId(byte[] bArr) {
            this.keySetId = bArr;
            return this;
        }

        public Builder setCustomCacheKey(String str) {
            this.customCacheKey = str;
            return this;
        }

        public Builder setData(byte[] bArr) {
            this.data = bArr;
            return this;
        }

        public DownloadRequest build() {
            String str = this.f166id;
            Uri uri2 = this.uri;
            String str2 = this.mimeType;
            List list = this.streamKeys;
            if (list == null) {
                list = ImmutableList.m261of();
            }
            return new DownloadRequest(str, uri2, str2, list, this.keySetId, this.customCacheKey, this.data);
        }
    }

    private DownloadRequest(String str, Uri uri2, String str2, List<StreamKey> list, byte[] bArr, String str3, byte[] bArr2) {
        int inferContentTypeForUriAndMimeType = C1229Util.inferContentTypeForUriAndMimeType(uri2, str2);
        boolean z = true;
        if (inferContentTypeForUriAndMimeType == 0 || inferContentTypeForUriAndMimeType == 2 || inferContentTypeForUriAndMimeType == 1) {
            z = str3 != null ? false : z;
            Assertions.checkArgument(z, "customCacheKey must be null for type: " + inferContentTypeForUriAndMimeType);
        }
        this.f165id = str;
        this.uri = uri2;
        this.mimeType = str2;
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        this.customCacheKey = str3;
        this.data = bArr2 != null ? Arrays.copyOf(bArr2, bArr2.length) : C1229Util.EMPTY_BYTE_ARRAY;
    }

    DownloadRequest(Parcel parcel) {
        this.f165id = (String) C1229Util.castNonNull(parcel.readString());
        this.uri = Uri.parse((String) C1229Util.castNonNull(parcel.readString()));
        this.mimeType = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((StreamKey) parcel.readParcelable(StreamKey.class.getClassLoader()));
        }
        this.streamKeys = Collections.unmodifiableList(arrayList);
        this.keySetId = parcel.createByteArray();
        this.customCacheKey = parcel.readString();
        this.data = (byte[]) C1229Util.castNonNull(parcel.createByteArray());
    }

    public DownloadRequest copyWithId(String str) {
        return new DownloadRequest(str, this.uri, this.mimeType, this.streamKeys, this.keySetId, this.customCacheKey, this.data);
    }

    public DownloadRequest copyWithKeySetId(byte[] bArr) {
        return new DownloadRequest(this.f165id, this.uri, this.mimeType, this.streamKeys, bArr, this.customCacheKey, this.data);
    }

    public DownloadRequest copyWithMergedRequest(DownloadRequest downloadRequest) {
        List list;
        Assertions.checkArgument(this.f165id.equals(downloadRequest.f165id));
        if (this.streamKeys.isEmpty() || downloadRequest.streamKeys.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = new ArrayList(this.streamKeys);
            for (int i = 0; i < downloadRequest.streamKeys.size(); i++) {
                StreamKey streamKey = downloadRequest.streamKeys.get(i);
                if (!list.contains(streamKey)) {
                    list.add(streamKey);
                }
            }
        }
        return new DownloadRequest(this.f165id, downloadRequest.uri, downloadRequest.mimeType, list, downloadRequest.keySetId, downloadRequest.customCacheKey, downloadRequest.data);
    }

    public MediaItem toMediaItem() {
        return new MediaItem.Builder().setMediaId(this.f165id).setUri(this.uri).setCustomCacheKey(this.customCacheKey).setMimeType(this.mimeType).setStreamKeys(this.streamKeys).build();
    }

    public String toString() {
        return this.mimeType + ":" + this.f165id;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DownloadRequest)) {
            return false;
        }
        DownloadRequest downloadRequest = (DownloadRequest) obj;
        if (!this.f165id.equals(downloadRequest.f165id) || !this.uri.equals(downloadRequest.uri) || !C1229Util.areEqual(this.mimeType, downloadRequest.mimeType) || !this.streamKeys.equals(downloadRequest.streamKeys) || !Arrays.equals(this.keySetId, downloadRequest.keySetId) || !C1229Util.areEqual(this.customCacheKey, downloadRequest.customCacheKey) || !Arrays.equals(this.data, downloadRequest.data)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = ((this.f165id.hashCode() * 31 * 31) + this.uri.hashCode()) * 31;
        String str = this.mimeType;
        int i = 0;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.streamKeys.hashCode()) * 31) + Arrays.hashCode(this.keySetId)) * 31;
        String str2 = this.customCacheKey;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode2 + i) * 31) + Arrays.hashCode(this.data);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f165id);
        parcel.writeString(this.uri.toString());
        parcel.writeString(this.mimeType);
        parcel.writeInt(this.streamKeys.size());
        for (int i2 = 0; i2 < this.streamKeys.size(); i2++) {
            parcel.writeParcelable(this.streamKeys.get(i2), 0);
        }
        parcel.writeByteArray(this.keySetId);
        parcel.writeString(this.customCacheKey);
        parcel.writeByteArray(this.data);
    }
}
