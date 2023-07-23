package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.C0963C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.DummyExtractorOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.UnmodifiableIterator;
import java.io.IOException;
import java.util.ArrayList;

public final class AviExtractor implements Extractor {
    private static final int AVIIF_KEYFRAME = 16;
    public static final int FOURCC_AVI_ = 541677121;
    public static final int FOURCC_JUNK = 1263424842;
    public static final int FOURCC_LIST = 1414744396;
    public static final int FOURCC_RIFF = 1179011410;
    public static final int FOURCC_auds = 1935963489;
    public static final int FOURCC_avih = 1751742049;
    public static final int FOURCC_hdrl = 1819436136;
    public static final int FOURCC_idx1 = 829973609;
    public static final int FOURCC_movi = 1769369453;
    public static final int FOURCC_strf = 1718776947;
    public static final int FOURCC_strh = 1752331379;
    public static final int FOURCC_strl = 1819440243;
    public static final int FOURCC_strn = 1852994675;
    public static final int FOURCC_txts = 1937012852;
    public static final int FOURCC_vids = 1935960438;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    private static final int STATE_FINDING_IDX1_HEADER = 4;
    private static final int STATE_FINDING_MOVI_HEADER = 3;
    private static final int STATE_READING_HDRL_BODY = 2;
    private static final int STATE_READING_HDRL_HEADER = 1;
    private static final int STATE_READING_IDX1_BODY = 5;
    private static final int STATE_READING_SAMPLES = 6;
    private static final int STATE_SKIPPING_TO_HDRL = 0;
    private static final String TAG = "AviExtractor";
    private AviMainHeaderChunk aviHeader;
    private final ChunkHeaderHolder chunkHeaderHolder = new ChunkHeaderHolder();
    /* access modifiers changed from: private */
    public ChunkReader[] chunkReaders = new ChunkReader[0];
    private ChunkReader currentChunkReader;
    private long durationUs = C0963C.TIME_UNSET;
    private ExtractorOutput extractorOutput = new DummyExtractorOutput();
    private int hdrlSize = -1;
    private int idx1BodySize;
    private long moviEnd = -1;
    private long moviStart = -1;
    private long pendingReposition;
    private final ParsableByteArray scratch = new ParsableByteArray(12);
    private boolean seekMapHasBeenOutput;
    private int state;

    public void release() {
    }

    public void init(ExtractorOutput extractorOutput2) {
        this.state = 0;
        this.extractorOutput = extractorOutput2;
        this.pendingReposition = -1;
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        extractorInput.peekFully(this.scratch.getData(), 0, 12);
        this.scratch.setPosition(0);
        if (this.scratch.readLittleEndianInt() != 1179011410) {
            return false;
        }
        this.scratch.skipBytes(4);
        if (this.scratch.readLittleEndianInt() == 541677121) {
            return true;
        }
        return false;
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        if (resolvePendingReposition(extractorInput, positionHolder)) {
            return 1;
        }
        switch (this.state) {
            case 0:
                if (sniff(extractorInput)) {
                    extractorInput.skipFully(12);
                    this.state = 1;
                    return 0;
                }
                throw ParserException.createForMalformedContainer("AVI Header List not found", (Throwable) null);
            case 1:
                extractorInput.readFully(this.scratch.getData(), 0, 12);
                this.scratch.setPosition(0);
                this.chunkHeaderHolder.populateWithListHeaderFrom(this.scratch);
                if (this.chunkHeaderHolder.listType == 1819436136) {
                    this.hdrlSize = this.chunkHeaderHolder.size;
                    this.state = 2;
                    return 0;
                }
                throw ParserException.createForMalformedContainer("hdrl expected, found: " + this.chunkHeaderHolder.listType, (Throwable) null);
            case 2:
                int i = this.hdrlSize - 4;
                ParsableByteArray parsableByteArray = new ParsableByteArray(i);
                extractorInput.readFully(parsableByteArray.getData(), 0, i);
                parseHdrlBody(parsableByteArray);
                this.state = 3;
                return 0;
            case 3:
                if (this.moviStart != -1) {
                    long position = extractorInput.getPosition();
                    long j = this.moviStart;
                    if (position != j) {
                        this.pendingReposition = j;
                        return 0;
                    }
                }
                extractorInput.peekFully(this.scratch.getData(), 0, 12);
                extractorInput.resetPeekPosition();
                this.scratch.setPosition(0);
                this.chunkHeaderHolder.populateFrom(this.scratch);
                int readLittleEndianInt = this.scratch.readLittleEndianInt();
                if (this.chunkHeaderHolder.chunkType == 1179011410) {
                    extractorInput.skipFully(12);
                    return 0;
                } else if (this.chunkHeaderHolder.chunkType == 1414744396 && readLittleEndianInt == 1769369453) {
                    long position2 = extractorInput.getPosition();
                    this.moviStart = position2;
                    this.moviEnd = position2 + ((long) this.chunkHeaderHolder.size) + 8;
                    if (!this.seekMapHasBeenOutput) {
                        if (((AviMainHeaderChunk) Assertions.checkNotNull(this.aviHeader)).hasIndex()) {
                            this.state = 4;
                            this.pendingReposition = this.moviEnd;
                            return 0;
                        }
                        this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                        this.seekMapHasBeenOutput = true;
                    }
                    this.pendingReposition = extractorInput.getPosition() + 12;
                    this.state = 6;
                    return 0;
                } else {
                    this.pendingReposition = extractorInput.getPosition() + ((long) this.chunkHeaderHolder.size) + 8;
                    return 0;
                }
            case 4:
                extractorInput.readFully(this.scratch.getData(), 0, 8);
                this.scratch.setPosition(0);
                int readLittleEndianInt2 = this.scratch.readLittleEndianInt();
                int readLittleEndianInt3 = this.scratch.readLittleEndianInt();
                if (readLittleEndianInt2 == 829973609) {
                    this.state = 5;
                    this.idx1BodySize = readLittleEndianInt3;
                } else {
                    this.pendingReposition = extractorInput.getPosition() + ((long) readLittleEndianInt3);
                }
                return 0;
            case 5:
                ParsableByteArray parsableByteArray2 = new ParsableByteArray(this.idx1BodySize);
                extractorInput.readFully(parsableByteArray2.getData(), 0, this.idx1BodySize);
                parseIdx1Body(parsableByteArray2);
                this.state = 6;
                this.pendingReposition = this.moviStart;
                return 0;
            case 6:
                return readMoviChunks(extractorInput);
            default:
                throw new AssertionError();
        }
    }

    public void seek(long j, long j2) {
        this.pendingReposition = -1;
        this.currentChunkReader = null;
        for (ChunkReader seekToPosition : this.chunkReaders) {
            seekToPosition.seekToPosition(j);
        }
        if (j != 0) {
            this.state = 6;
        } else if (this.chunkReaders.length == 0) {
            this.state = 0;
        } else {
            this.state = 3;
        }
    }

    private boolean resolvePendingReposition(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z;
        if (this.pendingReposition != -1) {
            long position = extractorInput.getPosition();
            long j = this.pendingReposition;
            if (j < position || j > 262144 + position) {
                positionHolder.position = j;
                z = true;
                this.pendingReposition = -1;
                return z;
            }
            extractorInput.skipFully((int) (j - position));
        }
        z = false;
        this.pendingReposition = -1;
        return z;
    }

    private void parseHdrlBody(ParsableByteArray parsableByteArray) throws IOException {
        ListChunk parseFrom = ListChunk.parseFrom(FOURCC_hdrl, parsableByteArray);
        if (parseFrom.getType() == 1819436136) {
            AviMainHeaderChunk aviMainHeaderChunk = (AviMainHeaderChunk) parseFrom.getChild(AviMainHeaderChunk.class);
            if (aviMainHeaderChunk != null) {
                this.aviHeader = aviMainHeaderChunk;
                this.durationUs = ((long) aviMainHeaderChunk.totalFrames) * ((long) aviMainHeaderChunk.frameDurationUs);
                ArrayList arrayList = new ArrayList();
                UnmodifiableIterator<AviChunk> it = parseFrom.children.iterator();
                int i = 0;
                while (it.hasNext()) {
                    AviChunk next = it.next();
                    if (next.getType() == 1819440243) {
                        int i2 = i + 1;
                        ChunkReader processStreamList = processStreamList((ListChunk) next, i);
                        if (processStreamList != null) {
                            arrayList.add(processStreamList);
                        }
                        i = i2;
                    }
                }
                this.chunkReaders = (ChunkReader[]) arrayList.toArray(new ChunkReader[0]);
                this.extractorOutput.endTracks();
                return;
            }
            throw ParserException.createForMalformedContainer("AviHeader not found", (Throwable) null);
        }
        throw ParserException.createForMalformedContainer("Unexpected header list type " + parseFrom.getType(), (Throwable) null);
    }

    private void parseIdx1Body(ParsableByteArray parsableByteArray) {
        long peekSeekOffset = peekSeekOffset(parsableByteArray);
        while (parsableByteArray.bytesLeft() >= 16) {
            int readLittleEndianInt = parsableByteArray.readLittleEndianInt();
            int readLittleEndianInt2 = parsableByteArray.readLittleEndianInt();
            long readLittleEndianInt3 = ((long) parsableByteArray.readLittleEndianInt()) + peekSeekOffset;
            parsableByteArray.readLittleEndianInt();
            ChunkReader chunkReader = getChunkReader(readLittleEndianInt);
            if (chunkReader != null) {
                if ((readLittleEndianInt2 & 16) == 16) {
                    chunkReader.appendKeyFrameToIndex(readLittleEndianInt3);
                }
                chunkReader.incrementIndexChunkCount();
            }
        }
        for (ChunkReader compactIndex : this.chunkReaders) {
            compactIndex.compactIndex();
        }
        this.seekMapHasBeenOutput = true;
        this.extractorOutput.seekMap(new AviSeekMap(this.durationUs));
    }

    private long peekSeekOffset(ParsableByteArray parsableByteArray) {
        long j = 0;
        if (parsableByteArray.bytesLeft() < 16) {
            return 0;
        }
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(8);
        long j2 = this.moviStart;
        if (((long) parsableByteArray.readLittleEndianInt()) <= j2) {
            j = 8 + j2;
        }
        parsableByteArray.setPosition(position);
        return j;
    }

    private ChunkReader getChunkReader(int i) {
        for (ChunkReader chunkReader : this.chunkReaders) {
            if (chunkReader.handlesChunkId(i)) {
                return chunkReader;
            }
        }
        return null;
    }

    private int readMoviChunks(ExtractorInput extractorInput) throws IOException {
        if (extractorInput.getPosition() >= this.moviEnd) {
            return -1;
        }
        ChunkReader chunkReader = this.currentChunkReader;
        if (chunkReader == null) {
            alignInputToEvenPosition(extractorInput);
            int i = 12;
            extractorInput.peekFully(this.scratch.getData(), 0, 12);
            this.scratch.setPosition(0);
            int readLittleEndianInt = this.scratch.readLittleEndianInt();
            if (readLittleEndianInt == 1414744396) {
                this.scratch.setPosition(8);
                if (this.scratch.readLittleEndianInt() != 1769369453) {
                    i = 8;
                }
                extractorInput.skipFully(i);
                extractorInput.resetPeekPosition();
                return 0;
            }
            int readLittleEndianInt2 = this.scratch.readLittleEndianInt();
            if (readLittleEndianInt == 1263424842) {
                this.pendingReposition = extractorInput.getPosition() + ((long) readLittleEndianInt2) + 8;
                return 0;
            }
            extractorInput.skipFully(8);
            extractorInput.resetPeekPosition();
            ChunkReader chunkReader2 = getChunkReader(readLittleEndianInt);
            if (chunkReader2 == null) {
                this.pendingReposition = extractorInput.getPosition() + ((long) readLittleEndianInt2);
                return 0;
            }
            chunkReader2.onChunkStart(readLittleEndianInt2);
            this.currentChunkReader = chunkReader2;
        } else if (chunkReader.onChunkData(extractorInput)) {
            this.currentChunkReader = null;
        }
        return 0;
    }

    private ChunkReader processStreamList(ListChunk listChunk, int i) {
        AviStreamHeaderChunk aviStreamHeaderChunk = (AviStreamHeaderChunk) listChunk.getChild(AviStreamHeaderChunk.class);
        StreamFormatChunk streamFormatChunk = (StreamFormatChunk) listChunk.getChild(StreamFormatChunk.class);
        if (aviStreamHeaderChunk == null) {
            Log.m157w(TAG, "Missing Stream Header");
            return null;
        } else if (streamFormatChunk == null) {
            Log.m157w(TAG, "Missing Stream Format");
            return null;
        } else {
            long durationUs2 = aviStreamHeaderChunk.getDurationUs();
            Format format = streamFormatChunk.format;
            Format.Builder buildUpon = format.buildUpon();
            buildUpon.setId(i);
            int i2 = aviStreamHeaderChunk.suggestedBufferSize;
            if (i2 != 0) {
                buildUpon.setMaxInputSize(i2);
            }
            StreamNameChunk streamNameChunk = (StreamNameChunk) listChunk.getChild(StreamNameChunk.class);
            if (streamNameChunk != null) {
                buildUpon.setLabel(streamNameChunk.name);
            }
            int trackType = MimeTypes.getTrackType(format.sampleMimeType);
            if (trackType != 1 && trackType != 2) {
                return null;
            }
            TrackOutput track = this.extractorOutput.track(i, trackType);
            track.format(buildUpon.build());
            ChunkReader chunkReader = new ChunkReader(i, trackType, durationUs2, aviStreamHeaderChunk.length, track);
            this.durationUs = durationUs2;
            return chunkReader;
        }
    }

    private static void alignInputToEvenPosition(ExtractorInput extractorInput) throws IOException {
        if ((extractorInput.getPosition() & 1) == 1) {
            extractorInput.skipFully(1);
        }
    }

    private class AviSeekMap implements SeekMap {
        private final long durationUs;

        public boolean isSeekable() {
            return true;
        }

        public AviSeekMap(long j) {
            this.durationUs = j;
        }

        public long getDurationUs() {
            return this.durationUs;
        }

        public SeekMap.SeekPoints getSeekPoints(long j) {
            SeekMap.SeekPoints seekPoints = AviExtractor.this.chunkReaders[0].getSeekPoints(j);
            for (int i = 1; i < AviExtractor.this.chunkReaders.length; i++) {
                SeekMap.SeekPoints seekPoints2 = AviExtractor.this.chunkReaders[i].getSeekPoints(j);
                if (seekPoints2.first.position < seekPoints.first.position) {
                    seekPoints = seekPoints2;
                }
            }
            return seekPoints;
        }
    }

    private static class ChunkHeaderHolder {
        public int chunkType;
        public int listType;
        public int size;

        private ChunkHeaderHolder() {
        }

        public void populateWithListHeaderFrom(ParsableByteArray parsableByteArray) throws ParserException {
            populateFrom(parsableByteArray);
            if (this.chunkType == 1414744396) {
                this.listType = parsableByteArray.readLittleEndianInt();
                return;
            }
            throw ParserException.createForMalformedContainer("LIST expected, found: " + this.chunkType, (Throwable) null);
        }

        public void populateFrom(ParsableByteArray parsableByteArray) {
            this.chunkType = parsableByteArray.readLittleEndianInt();
            this.size = parsableByteArray.readLittleEndianInt();
            this.listType = 0;
        }
    }
}
