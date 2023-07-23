package media.tiger.tigerbox.services.implementations;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import media.tiger.tigerbox.model.domain.TigerCard;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import media.tiger.tigerbox.services.implementations.timersController.TimersControllerKt;
import media.tiger.tigerbox.services.interfaces.NfcListener;
import media.tiger.tigerbox.services.interfaces.NfcService;
import media.tiger.tigerbox.services.interfaces.timersController.LockedModeService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0014\u0010\"\u001a\u00020\n2\n\u0010#\u001a\u00060$j\u0002`%H\u0002J\b\u0010&\u001a\u00020\nH\u0002J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0014\u0010,\u001a\u00020\n2\n\u0010#\u001a\u00060$j\u0002`%H\u0002J\u0010\u0010-\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\nH\u0002J\f\u0010/\u001a\u00020\u000f*\u00020\u000fH\u0002J\f\u00100\u001a\u00020\u000f*\u00020)H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HardwareNfcService;", "Lmedia/tiger/tigerbox/services/interfaces/NfcService;", "lockedModeService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;", "(Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;)V", "mPendingIntent", "Landroid/app/PendingIntent;", "nfcAdapter", "Landroid/nfc/NfcAdapter;", "disableForegroundDispatch", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "enableForegroundDispatch", "getSecureCodeFromUrl", "", "url", "getValidUidHexString", "hexString", "handleAction", "action", "intent", "Landroid/content/Intent;", "handleNewNfcInsertedEvent", "handleOldNfcInsertedEvent", "hex2Dec", "", "hexChar", "", "loadCard", "tigerCard", "Lmedia/tiger/tigerbox/model/domain/TigerCard;", "onCardInserted", "card", "onCardReadError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onCardRemoved", "parseByteData", "byteArray", "", "parseIntent", "parseUrl", "postOnCardException", "postOnCardInserted", "postOnCardRemoved", "fromHexString", "toHex", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HardwareNfcService.kt */
public final class HardwareNfcService extends NfcService {
    private static final int BITS_PER_CHAR = 2;
    private static final int BIT_PREFIX = 12;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int DATA_LENGTH = 106;
    private static final int RADIX = 16;
    private static final int UID_HEX_LENGTH = 20;
    private static final int URL_INDEX_START = 14;
    private static final int URL_LEN_END = 9;
    private static final int URL_LEN_START = 8;
    private static final String URL_PREFIX = "https://";
    private static final String fileReference = "/dev/mf175x";
    private static final List<Integer> invalidIndexValues = CollectionsKt.listOf(0, 1, 8, 9, 18, 19);
    private PendingIntent mPendingIntent;
    private NfcAdapter nfcAdapter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HardwareNfcService(LockedModeService lockedModeService) {
        super(lockedModeService);
        Intrinsics.checkNotNullParameter(lockedModeService, "lockedModeService");
    }

    public void enableForegroundDispatch(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Timber.Tree tag = Timber.Forest.tag("Nfc");
        tag.mo50221i("enableForegroundDispatch " + appCompatActivity, new Object[0]);
        try {
            if (this.nfcAdapter == null) {
                this.nfcAdapter = NfcAdapter.getDefaultAdapter(appCompatActivity.getApplication());
            }
            Intent addFlags = new Intent(appCompatActivity, appCompatActivity.getClass()).addFlags(536870912);
            Intrinsics.checkNotNullExpressionValue(addFlags, "Intent(activity, activit…FLAG_ACTIVITY_SINGLE_TOP)");
            PendingIntent activity = PendingIntent.getActivity(appCompatActivity, 0, addFlags, 0);
            this.mPendingIntent = activity;
            NfcAdapter nfcAdapter2 = this.nfcAdapter;
            if (nfcAdapter2 != null && activity != null && nfcAdapter2 != null) {
                nfcAdapter2.enableForegroundDispatch(appCompatActivity, activity, (IntentFilter[]) null, (String[][]) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Timber.Tree tag2 = Timber.Forest.tag("Nfc");
            tag2.mo50217e("exception " + e.getMessage(), new Object[0]);
        }
    }

    public void disableForegroundDispatch(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        NfcAdapter nfcAdapter2 = this.nfcAdapter;
        if (nfcAdapter2 != null) {
            nfcAdapter2.disableForegroundDispatch(appCompatActivity);
        }
    }

    public void parseIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Timber.Tree tag = Timber.Forest.tag("Nfc");
        tag.mo50221i("parseIntent: " + intent + " action: " + intent.getAction(), new Object[0]);
        handleAction(String.valueOf(intent.getAction()), intent);
    }

    private final void postOnCardInserted(TigerCard tigerCard) {
        Iterator<NfcListener> it = getListeners().iterator();
        while (it.hasNext()) {
            it.next().onCardInserted(tigerCard);
        }
    }

    private final void postOnCardRemoved() {
        Iterator<NfcListener> it = getListeners().iterator();
        while (it.hasNext()) {
            it.next().onCardRemoved();
        }
    }

    private final void postOnCardException(Exception exc) {
        Iterator<NfcListener> it = getListeners().iterator();
        while (it.hasNext()) {
            it.next().onCardException(exc);
        }
    }

    private final void onCardRemoved() {
        postOnCardRemoved();
    }

    private final void onCardInserted(TigerCard tigerCard) {
        postOnCardInserted(tigerCard);
    }

    private final void onCardReadError(Exception exc) {
        postOnCardException(exc);
    }

    public void handleAction(String str, Intent intent) {
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Timber.Tree tag = Timber.Forest.tag("Nfc");
        tag.mo50221i("handleAction: " + str + " intent: " + intent, new Object[0]);
        if (TimersControllerKt.isInLockedMode(getLockedModeService().checkLockedMode())) {
            Timber.Forest.tag("Nfc").mo50217e("Exit because of locked mode.", new Object[0]);
        } else if (Intrinsics.areEqual((Object) str, (Object) NfcService.NFC_OUT) || Intrinsics.areEqual((Object) str, (Object) NfcService.OLD_NFC_OUT)) {
            set_insertedCard((TigerCard) null);
            onCardRemoved();
        } else if (Intrinsics.areEqual((Object) "android.nfc.action.TAG_DISCOVERED", (Object) str) || Intrinsics.areEqual((Object) "android.nfc.action.TECH_DISCOVERED", (Object) str) || Intrinsics.areEqual((Object) "android.nfc.action.NDEF_DISCOVERED", (Object) str)) {
            Timber.Forest.tag("Nfc").mo50221i("detected old nfc event", new Object[0]);
            handleOldNfcInsertedEvent(intent);
        } else if (Intrinsics.areEqual((Object) str, (Object) NfcService.NFC_IN)) {
            Timber.Forest.tag("Nfc").mo50221i("detected new nfc event", new Object[0]);
            handleNewNfcInsertedEvent();
        }
    }

    private final void handleOldNfcInsertedEvent(Intent intent) {
        String str;
        byte[] id;
        set_insertedCard((TigerCard) null);
        Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if (tag == null || (id = tag.getId()) == null || (str = toHex(id)) == null) {
            str = "";
        }
        Timber.Tree tag2 = Timber.Forest.tag("Nfc");
        tag2.mo50221i("handleOldNfcInsertedEvent: " + intent + " tag: " + tag + " uid: " + str + " raw: " + parcelableArrayExtra, new Object[0]);
        if (parcelableArrayExtra != null) {
            Iterator it = ArrayIteratorKt.iterator(parcelableArrayExtra);
            while (it.hasNext()) {
                Parcelable parcelable = (Parcelable) it.next();
                NdefMessage ndefMessage = parcelable instanceof NdefMessage ? (NdefMessage) parcelable : null;
                NdefRecord[] records = ndefMessage != null ? ndefMessage.getRecords() : null;
                if (records != null) {
                    if (!(records.length == 0)) {
                        try {
                            Uri uri = records[0].toUri();
                            String uri2 = uri.toString();
                            Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
                            String secureCodeFromUrl = getSecureCodeFromUrl(uri2);
                            String uri3 = uri.toString();
                            Intrinsics.checkNotNullExpressionValue(uri3, "uri.toString()");
                            set_insertedCard(new TigerCard(str, secureCodeFromUrl, uri3));
                            TigerCard tigerCard = get_insertedCard();
                            if (tigerCard != null) {
                                onCardInserted(tigerCard);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            Timber.Forest forest = Timber.Forest;
                            forest.mo50217e("Exception: Could not parse uri " + e, new Object[0]);
                            onCardReadError(e);
                            return;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059 A[ExcHandler: ParseException (e java.text.ParseException), Splitter:B:5:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A[ExcHandler: IOException (e java.io.IOException), Splitter:B:5:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e A[ExcHandler: FileNotFoundException (e java.io.FileNotFoundException), Splitter:B:5:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096 A[SYNTHETIC, Splitter:B:41:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c4 A[SYNTHETIC, Splitter:B:50:0x00c4] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00f2 A[SYNTHETIC, Splitter:B:59:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0121 A[SYNTHETIC, Splitter:B:68:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012c A[SYNTHETIC, Splitter:B:74:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0131 A[Catch:{ Exception -> 0x0134 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:47:0x00a0=Splitter:B:47:0x00a0, B:38:0x007c=Splitter:B:38:0x007c, B:65:0x00fd=Splitter:B:65:0x00fd, B:56:0x00ce=Splitter:B:56:0x00ce} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleNewNfcInsertedEvent() {
        /*
            r7 = this;
            r0 = 0
            r7.set_insertedCard(r0)
            r1 = 106(0x6a, float:1.49E-43)
            byte[] r2 = new byte[r1]
            r3 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00ca, ParseException -> 0x009c, Exception -> 0x0078, all -> 0x0072 }
            java.lang.String r5 = "/dev/mf175x"
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00f9, IOException -> 0x00ca, ParseException -> 0x009c, Exception -> 0x0078, all -> 0x0072 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x006e, IOException -> 0x006a, ParseException -> 0x0067, Exception -> 0x0064, all -> 0x0061 }
            r6 = r4
            java.io.InputStream r6 = (java.io.InputStream) r6     // Catch:{ FileNotFoundException -> 0x006e, IOException -> 0x006a, ParseException -> 0x0067, Exception -> 0x0064, all -> 0x0061 }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x006e, IOException -> 0x006a, ParseException -> 0x0067, Exception -> 0x0064, all -> 0x0061 }
            r5.read(r2, r3, r1)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            media.tiger.tigerbox.model.domain.TigerCard r1 = r7.parseByteData(r2)     // Catch:{ Exception -> 0x0023, FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059 }
            r7.set_insertedCard(r1)     // Catch:{ Exception -> 0x0023, FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059 }
            goto L_0x003f
        L_0x0023:
            r1 = move-exception
            r7.set_insertedCard(r0)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            java.lang.String r6 = "Nfc: Could not parse nfc bytes "
            r2.append(r6)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            r2.append(r1)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            java.lang.String r1 = r2.toString()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            r0.mo50217e(r1, r2)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
        L_0x003f:
            media.tiger.tigerbox.model.domain.TigerCard r0 = r7.get_insertedCard()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            if (r0 == 0) goto L_0x004f
            media.tiger.tigerbox.model.domain.TigerCard r0 = r7.get_insertedCard()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
            r7.onCardInserted(r0)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParseException -> 0x0059, Exception -> 0x0057 }
        L_0x004f:
            r5.close()     // Catch:{ Exception -> 0x0128 }
        L_0x0052:
            r4.close()     // Catch:{ Exception -> 0x0128 }
            goto L_0x0128
        L_0x0057:
            r0 = move-exception
            goto L_0x007c
        L_0x0059:
            r0 = move-exception
            goto L_0x00a0
        L_0x005b:
            r0 = move-exception
            goto L_0x00ce
        L_0x005e:
            r0 = move-exception
            goto L_0x00fd
        L_0x0061:
            r1 = move-exception
            r5 = r0
            goto L_0x0075
        L_0x0064:
            r1 = move-exception
            r5 = r0
            goto L_0x007b
        L_0x0067:
            r1 = move-exception
            r5 = r0
            goto L_0x009f
        L_0x006a:
            r1 = move-exception
            r5 = r0
            goto L_0x00cd
        L_0x006e:
            r1 = move-exception
            r5 = r0
            goto L_0x00fc
        L_0x0072:
            r1 = move-exception
            r4 = r0
            r5 = r4
        L_0x0075:
            r0 = r1
            goto L_0x012a
        L_0x0078:
            r1 = move-exception
            r4 = r0
            r5 = r4
        L_0x007b:
            r0 = r1
        L_0x007c:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest     // Catch:{ all -> 0x0129 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            r2.<init>()     // Catch:{ all -> 0x0129 }
            java.lang.String r6 = "NfcService handleNewNfcInsertedEvent - unknown exception: "
            r2.append(r6)     // Catch:{ all -> 0x0129 }
            r2.append(r0)     // Catch:{ all -> 0x0129 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0129 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x0129 }
            r1.mo50217e(r0, r2)     // Catch:{ all -> 0x0129 }
            if (r5 == 0) goto L_0x0099
            r5.close()     // Catch:{ Exception -> 0x0128 }
        L_0x0099:
            if (r4 == 0) goto L_0x0128
            goto L_0x0052
        L_0x009c:
            r1 = move-exception
            r4 = r0
            r5 = r4
        L_0x009f:
            r0 = r1
        L_0x00a0:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest     // Catch:{ all -> 0x0129 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            r2.<init>()     // Catch:{ all -> 0x0129 }
            java.lang.String r6 = "NfcService handleNewNfcInsertedEvent - Data Parse Error: "
            r2.append(r6)     // Catch:{ all -> 0x0129 }
            r2.append(r0)     // Catch:{ all -> 0x0129 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0129 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0129 }
            r1.mo50217e(r2, r3)     // Catch:{ all -> 0x0129 }
            media.tiger.tigerbox.services.interfaces.NfcService$NfcReadError r1 = media.tiger.tigerbox.services.interfaces.NfcService.NfcReadError.DATA_ERROR     // Catch:{ all -> 0x0129 }
            r7.publishError(r1)     // Catch:{ all -> 0x0129 }
            java.lang.Exception r0 = (java.lang.Exception) r0     // Catch:{ all -> 0x0129 }
            r7.onCardReadError(r0)     // Catch:{ all -> 0x0129 }
            if (r5 == 0) goto L_0x00c7
            r5.close()     // Catch:{ Exception -> 0x0128 }
        L_0x00c7:
            if (r4 == 0) goto L_0x0128
            goto L_0x0052
        L_0x00ca:
            r1 = move-exception
            r4 = r0
            r5 = r4
        L_0x00cd:
            r0 = r1
        L_0x00ce:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest     // Catch:{ all -> 0x0129 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            r2.<init>()     // Catch:{ all -> 0x0129 }
            java.lang.String r6 = "NfcService handleNewNfcInsertedEvent - IO Error: "
            r2.append(r6)     // Catch:{ all -> 0x0129 }
            r2.append(r0)     // Catch:{ all -> 0x0129 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0129 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0129 }
            r1.mo50217e(r2, r3)     // Catch:{ all -> 0x0129 }
            media.tiger.tigerbox.services.interfaces.NfcService$NfcReadError r1 = media.tiger.tigerbox.services.interfaces.NfcService.NfcReadError.IO     // Catch:{ all -> 0x0129 }
            r7.publishError(r1)     // Catch:{ all -> 0x0129 }
            java.lang.Exception r0 = (java.lang.Exception) r0     // Catch:{ all -> 0x0129 }
            r7.onCardReadError(r0)     // Catch:{ all -> 0x0129 }
            if (r5 == 0) goto L_0x00f5
            r5.close()     // Catch:{ Exception -> 0x0128 }
        L_0x00f5:
            if (r4 == 0) goto L_0x0128
            goto L_0x0052
        L_0x00f9:
            r1 = move-exception
            r4 = r0
            r5 = r4
        L_0x00fc:
            r0 = r1
        L_0x00fd:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest     // Catch:{ all -> 0x0129 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            r2.<init>()     // Catch:{ all -> 0x0129 }
            java.lang.String r6 = "NfcService handleNewNfcInsertedEvent - FILE NOT FOUND: "
            r2.append(r6)     // Catch:{ all -> 0x0129 }
            r2.append(r0)     // Catch:{ all -> 0x0129 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0129 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0129 }
            r1.mo50217e(r2, r3)     // Catch:{ all -> 0x0129 }
            media.tiger.tigerbox.services.interfaces.NfcService$NfcReadError r1 = media.tiger.tigerbox.services.interfaces.NfcService.NfcReadError.FILE_NOT_FOUND     // Catch:{ all -> 0x0129 }
            r7.publishError(r1)     // Catch:{ all -> 0x0129 }
            java.lang.Exception r0 = (java.lang.Exception) r0     // Catch:{ all -> 0x0129 }
            r7.onCardReadError(r0)     // Catch:{ all -> 0x0129 }
            if (r5 == 0) goto L_0x0124
            r5.close()     // Catch:{ Exception -> 0x0128 }
        L_0x0124:
            if (r4 == 0) goto L_0x0128
            goto L_0x0052
        L_0x0128:
            return
        L_0x0129:
            r0 = move-exception
        L_0x012a:
            if (r5 == 0) goto L_0x012f
            r5.close()     // Catch:{ Exception -> 0x0134 }
        L_0x012f:
            if (r4 == 0) goto L_0x0134
            r4.close()     // Catch:{ Exception -> 0x0134 }
        L_0x0134:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.services.implementations.HardwareNfcService.handleNewNfcInsertedEvent():void");
    }

    public void loadCard(TigerCard tigerCard) {
        Intrinsics.checkNotNullParameter(tigerCard, "tigerCard");
        onCardInserted(tigerCard);
    }

    private final TigerCard parseByteData(byte[] bArr) {
        String hex = toHex(bArr);
        String parseUrl = parseUrl(hex);
        String substring = hex.substring(hex.length() - 20);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return new TigerCard(getValidUidHexString(substring), getSecureCodeFromUrl(parseUrl), parseUrl);
    }

    private final String getSecureCodeFromUrl(String str) {
        return StringsKt.substringAfterLast$default(str, DownloadsManager.FOLDERS_SEPARATOR, (String) null, 2, (Object) null);
    }

    private final String getValidUidHexString(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!invalidIndexValues.contains(Integer.valueOf(i))) {
                sb.append(str.charAt(i));
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "uid.toString()");
        return sb2;
    }

    private final String parseUrl(String str) {
        String substring = str.substring(14, (Integer.parseInt(new String(new char[]{str.charAt(8), str.charAt(9)}), CharsKt.checkRadix(16)) * 2) + 12);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return URL_PREFIX + fromHexString(substring);
    }

    private final String fromHexString(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            str = '0' + str;
            length++;
        }
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        byte[] bArr = new byte[(length >> 1)];
        IntProgression step = RangesKt.step((IntProgression) RangesKt.until(0, length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                bArr[first >> 1] = (byte) ((hex2Dec(charArray[first]) << 4) | hex2Dec(charArray[first + 1]));
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        return new String(bArr, Charsets.UTF_8);
    }

    private final int hex2Dec(char c) {
        boolean z = true;
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('A' > c || c >= 'G') {
            z = false;
        }
        if (z) {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException();
    }

    private final String toHex(byte[] bArr) {
        String upperCase = ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) HardwareNfcService$toHex$1.INSTANCE, 30, (Object) null).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    @Metadata(mo33736d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/HardwareNfcService$Companion;", "", "()V", "BITS_PER_CHAR", "", "BIT_PREFIX", "DATA_LENGTH", "RADIX", "UID_HEX_LENGTH", "URL_INDEX_START", "URL_LEN_END", "URL_LEN_START", "URL_PREFIX", "", "fileReference", "invalidIndexValues", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: HardwareNfcService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
