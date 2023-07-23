package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.C0963C;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class HlsMediaPlaylist extends HlsPlaylist {
    public static final int PLAYLIST_TYPE_EVENT = 2;
    public static final int PLAYLIST_TYPE_UNKNOWN = 0;
    public static final int PLAYLIST_TYPE_VOD = 1;
    public final int discontinuitySequence;
    public final long durationUs;
    public final boolean hasDiscontinuitySequence;
    public final boolean hasEndTag;
    public final boolean hasPositiveStartOffset;
    public final boolean hasProgramDateTime;
    public final long mediaSequence;
    public final long partTargetDurationUs;
    public final int playlistType;
    public final boolean preciseStart;
    public final DrmInitData protectionSchemes;
    public final Map<Uri, RenditionReport> renditionReports;
    public final List<Segment> segments;
    public final ServerControl serverControl;
    public final long startOffsetUs;
    public final long startTimeUs;
    public final long targetDurationUs;
    public final List<Part> trailingParts;
    public final int version;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaylistType {
    }

    public HlsMediaPlaylist copy(List<StreamKey> list) {
        return this;
    }

    public static final class ServerControl {
        public final boolean canBlockReload;
        public final boolean canSkipDateRanges;
        public final long holdBackUs;
        public final long partHoldBackUs;
        public final long skipUntilUs;

        public ServerControl(long j, boolean z, long j2, long j3, boolean z2) {
            this.skipUntilUs = j;
            this.canSkipDateRanges = z;
            this.holdBackUs = j2;
            this.partHoldBackUs = j3;
            this.canBlockReload = z2;
        }
    }

    public static final class Segment extends SegmentBase {
        public final List<Part> parts;
        public final String title;

        public Segment(String str, long j, long j2, String str2, String str3) {
            this(str, (Segment) null, "", 0, -1, C0963C.TIME_UNSET, (DrmInitData) null, str2, str3, j, j2, false, ImmutableList.m261of());
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Segment(String str, Segment segment, String str2, long j, int i, long j2, DrmInitData drmInitData, String str3, String str4, long j3, long j4, boolean z, List<Part> list) {
            super(str, segment, j, i, j2, drmInitData, str3, str4, j3, j4, z);
            this.title = str2;
            this.parts = ImmutableList.copyOf(list);
        }

        public Segment copyWith(long j, int i) {
            ArrayList arrayList = new ArrayList();
            long j2 = j;
            for (int i2 = 0; i2 < this.parts.size(); i2++) {
                Part part = this.parts.get(i2);
                arrayList.add(part.copyWith(j2, i));
                j2 += part.durationUs;
            }
            int i3 = i;
            return new Segment(this.url, this.initializationSegment, this.title, this.durationUs, i, j, this.drmInitData, this.fullSegmentEncryptionKeyUri, this.encryptionIV, this.byteRangeOffset, this.byteRangeLength, this.hasGapTag, arrayList);
        }
    }

    public static final class Part extends SegmentBase {
        public final boolean isIndependent;
        public final boolean isPreload;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Part(String str, Segment segment, long j, int i, long j2, DrmInitData drmInitData, String str2, String str3, long j3, long j4, boolean z, boolean z2, boolean z3) {
            super(str, segment, j, i, j2, drmInitData, str2, str3, j3, j4, z);
            this.isIndependent = z2;
            this.isPreload = z3;
        }

        public Part copyWith(long j, int i) {
            int i2 = i;
            return new Part(this.url, this.initializationSegment, this.durationUs, i2, j, this.drmInitData, this.fullSegmentEncryptionKeyUri, this.encryptionIV, this.byteRangeOffset, this.byteRangeLength, this.hasGapTag, this.isIndependent, this.isPreload);
        }
    }

    public static class SegmentBase implements Comparable<Long> {
        public final long byteRangeLength;
        public final long byteRangeOffset;
        public final DrmInitData drmInitData;
        public final long durationUs;
        public final String encryptionIV;
        public final String fullSegmentEncryptionKeyUri;
        public final boolean hasGapTag;
        public final Segment initializationSegment;
        public final int relativeDiscontinuitySequence;
        public final long relativeStartTimeUs;
        public final String url;

        private SegmentBase(String str, Segment segment, long j, int i, long j2, DrmInitData drmInitData2, String str2, String str3, long j3, long j4, boolean z) {
            this.url = str;
            this.initializationSegment = segment;
            this.durationUs = j;
            this.relativeDiscontinuitySequence = i;
            this.relativeStartTimeUs = j2;
            this.drmInitData = drmInitData2;
            this.fullSegmentEncryptionKeyUri = str2;
            this.encryptionIV = str3;
            this.byteRangeOffset = j3;
            this.byteRangeLength = j4;
            this.hasGapTag = z;
        }

        public int compareTo(Long l) {
            if (this.relativeStartTimeUs > l.longValue()) {
                return 1;
            }
            return this.relativeStartTimeUs < l.longValue() ? -1 : 0;
        }
    }

    public static final class RenditionReport {
        public final long lastMediaSequence;
        public final int lastPartIndex;
        public final Uri playlistUri;

        public RenditionReport(Uri uri, long j, int i) {
            this.playlistUri = uri;
            this.lastMediaSequence = j;
            this.lastPartIndex = i;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HlsMediaPlaylist(int i, String str, List<String> list, long j, boolean z, long j2, boolean z2, int i2, long j3, int i3, long j4, long j5, boolean z3, boolean z4, boolean z5, DrmInitData drmInitData, List<Segment> list2, List<Part> list3, ServerControl serverControl2, Map<Uri, RenditionReport> map) {
        super(str, list, z3);
        long j6 = j;
        String str2 = str;
        List<String> list4 = list;
        this.playlistType = i;
        this.startTimeUs = j2;
        this.preciseStart = z;
        this.hasDiscontinuitySequence = z2;
        this.discontinuitySequence = i2;
        this.mediaSequence = j3;
        this.version = i3;
        this.targetDurationUs = j4;
        this.partTargetDurationUs = j5;
        this.hasEndTag = z4;
        this.hasProgramDateTime = z5;
        this.protectionSchemes = drmInitData;
        this.segments = ImmutableList.copyOf(list2);
        this.trailingParts = ImmutableList.copyOf(list3);
        this.renditionReports = ImmutableMap.copyOf(map);
        if (!list3.isEmpty()) {
            Part part = (Part) Iterables.getLast(list3);
            this.durationUs = part.relativeStartTimeUs + part.durationUs;
        } else if (!list2.isEmpty()) {
            Segment segment = (Segment) Iterables.getLast(list2);
            this.durationUs = segment.relativeStartTimeUs + segment.durationUs;
        } else {
            this.durationUs = 0;
        }
        long j7 = C0963C.TIME_UNSET;
        if (j6 != C0963C.TIME_UNSET) {
            if (j6 >= 0) {
                j7 = Math.min(this.durationUs, j);
            } else {
                j7 = Math.max(0, this.durationUs + j6);
            }
        }
        this.startOffsetUs = j7;
        this.hasPositiveStartOffset = j6 >= 0;
        this.serverControl = serverControl2;
    }

    public boolean isNewerThan(HlsMediaPlaylist hlsMediaPlaylist) {
        if (hlsMediaPlaylist == null) {
            return true;
        }
        long j = this.mediaSequence;
        long j2 = hlsMediaPlaylist.mediaSequence;
        if (j > j2) {
            return true;
        }
        if (j < j2) {
            return false;
        }
        int size = this.segments.size() - hlsMediaPlaylist.segments.size();
        if (size == 0) {
            int size2 = this.trailingParts.size();
            int size3 = hlsMediaPlaylist.trailingParts.size();
            if (size2 > size3) {
                return true;
            }
            if (size2 != size3 || !this.hasEndTag || hlsMediaPlaylist.hasEndTag) {
                return false;
            }
            return true;
        } else if (size > 0) {
            return true;
        } else {
            return false;
        }
    }

    public long getEndTimeUs() {
        return this.startTimeUs + this.durationUs;
    }

    public HlsMediaPlaylist copyWith(long j, int i) {
        int i2 = this.playlistType;
        return new HlsMediaPlaylist(i2, this.baseUri, this.tags, this.startOffsetUs, this.preciseStart, j, true, i, this.mediaSequence, this.version, this.targetDurationUs, this.partTargetDurationUs, this.hasIndependentSegments, this.hasEndTag, this.hasProgramDateTime, this.protectionSchemes, this.segments, this.trailingParts, this.serverControl, this.renditionReports);
    }

    public HlsMediaPlaylist copyWithEndTag() {
        if (this.hasEndTag) {
            return this;
        }
        HlsMediaPlaylist hlsMediaPlaylist = r2;
        HlsMediaPlaylist hlsMediaPlaylist2 = new HlsMediaPlaylist(this.playlistType, this.baseUri, this.tags, this.startOffsetUs, this.preciseStart, this.startTimeUs, this.hasDiscontinuitySequence, this.discontinuitySequence, this.mediaSequence, this.version, this.targetDurationUs, this.partTargetDurationUs, this.hasIndependentSegments, true, this.hasProgramDateTime, this.protectionSchemes, this.segments, this.trailingParts, this.serverControl, this.renditionReports);
        return hlsMediaPlaylist;
    }
}
