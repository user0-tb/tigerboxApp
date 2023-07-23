package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.dto.TigerCardValidState;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "states", "Lmedia/tiger/tigerbox/model/dto/TigerCardValidState;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GetValidTigerCardUseCase.kt */
final class GetValidTigerCardUseCase$run$2 extends Lambda implements Function1<TigerCardValidState, TigerCardDomain> {
    public static final GetValidTigerCardUseCase$run$2 INSTANCE = new GetValidTigerCardUseCase$run$2();

    GetValidTigerCardUseCase$run$2() {
        super(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
        r3 = r3.getHref();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final media.tiger.tigerbox.services.interfaces.TigerCardDomain invoke(media.tiger.tigerbox.model.dto.TigerCardValidState r29) {
        /*
            r28 = this;
            java.lang.String r0 = "states"
            r1 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            media.tiger.tigerbox.model.dto.TigerCardValidState$Embedded r0 = r29.get_embedded()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Embedded$AccountGeneratedContents r0 = r0.getAccountGeneratedContents()
            r2 = 0
            if (r0 == 0) goto L_0x007a
            media.tiger.tigerbox.model.dto.TigerCardValidState$Links r3 = r0.get_links()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link r3 = r3.getPlaylist()
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0027
            java.lang.String r3 = r3.getHref()
            if (r3 != 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r5 = r3
            goto L_0x0028
        L_0x0027:
            r5 = r4
        L_0x0028:
            java.lang.String r7 = r29.getUid()
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "{uid}"
            java.lang.String r11 = kotlin.text.StringsKt.replace$default((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (boolean) r8, (int) r9, (java.lang.Object) r10)
            java.lang.String r13 = r29.getCode()
            r14 = 0
            r15 = 4
            r16 = 0
            java.lang.String r12 = "{code}"
            java.lang.String r24 = kotlin.text.StringsKt.replace$default((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (boolean) r14, (int) r15, (java.lang.Object) r16)
            media.tiger.tigerbox.services.interfaces.TigerCardDomain$AccountGeneratedContentsDomain r3 = new media.tiger.tigerbox.services.interfaces.TigerCardDomain$AccountGeneratedContentsDomain
            java.lang.String r18 = r0.getName()
            int r19 = r0.getAccountId()
            int r20 = r0.getTotalDuration()
            java.lang.String r21 = r0.getContentType()
            java.lang.String r22 = r0.getTranscodingStatus()
            java.lang.String r23 = r0.getLastModifiedDate()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Links r0 = r0.get_links()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link r0 = r0.getCover()
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = r0.getHref()
            if (r0 != 0) goto L_0x006e
            goto L_0x0071
        L_0x006e:
            r25 = r0
            goto L_0x0073
        L_0x0071:
            r25 = r4
        L_0x0073:
            r17 = r3
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25)
            r10 = r3
            goto L_0x007b
        L_0x007a:
            r10 = r2
        L_0x007b:
            media.tiger.tigerbox.model.dto.TigerCardValidState$Embedded r0 = r29.get_embedded()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Embedded$Coupon r0 = r0.getCoupon()
            if (r0 == 0) goto L_0x00d7
            media.tiger.tigerbox.services.interfaces.TigerTicketDomain r3 = new media.tiger.tigerbox.services.interfaces.TigerTicketDomain
            java.lang.String r0 = r0.getCouponCode()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Links r4 = r29.get_links()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link r4 = r4.getValidate()
            if (r4 == 0) goto L_0x009a
            java.lang.String r4 = r4.getHref()
            goto L_0x009b
        L_0x009a:
            r4 = r2
        L_0x009b:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "UTF-8"
            java.lang.String r4 = java.net.URLDecoder.decode(r4, r5)
            java.lang.String r5 = "decode(states._links.val…href.toString(), \"UTF-8\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            media.tiger.tigerbox.model.dto.TigerCardValidState$Links r5 = r29.get_links()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link r5 = r5.getGetProduct()
            if (r5 == 0) goto L_0x00b9
            java.lang.String r5 = r5.getHref()
            goto L_0x00ba
        L_0x00b9:
            r5 = r2
        L_0x00ba:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            media.tiger.tigerbox.model.dto.TigerCardValidState$Links r6 = r29.get_links()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Links$Link r6 = r6.getOrder()
            if (r6 == 0) goto L_0x00cd
            java.lang.String r6 = r6.getHref()
            goto L_0x00ce
        L_0x00cd:
            r6 = r2
        L_0x00ce:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r3.<init>(r0, r4, r5, r6)
            r11 = r3
            goto L_0x00d8
        L_0x00d7:
            r11 = r2
        L_0x00d8:
            media.tiger.tigerbox.model.dto.TigerCardValidState$MultiTigercardVariant r0 = r29.getMultiTigercardVariant()
            if (r0 == 0) goto L_0x0147
            java.lang.String r13 = r0.getName()
            java.lang.String r14 = r0.getDescription()
            java.lang.String r15 = r0.getCreatedBy()
            java.lang.String r16 = r0.getCreatedDate()
            java.lang.String r17 = r0.getLastModifiedBy()
            java.lang.String r18 = r0.getLastModifiedDate()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Embedded r0 = r29.get_embedded()
            java.util.List r19 = r0.getProducts()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Embedded r0 = r29.get_embedded()
            media.tiger.tigerbox.model.dto.TigerCardValidState$Embedded$RecentlyUsedProduct r0 = r0.getRecentlyUsedProduct()
            if (r0 == 0) goto L_0x012c
            media.tiger.tigerbox.services.interfaces.TigerCardDomain$MultiTigercardVariantDomain$RecentlyUsedProductDomain r3 = new media.tiger.tigerbox.services.interfaces.TigerCardDomain$MultiTigercardVariantDomain$RecentlyUsedProductDomain
            int r21 = r0.getMultiTigercardVariantId()
            int r22 = r0.getProfileId()
            int r23 = r0.getProductId()
            java.lang.String r24 = r0.getCreatedBy()
            java.lang.String r25 = r0.getCreatedDate()
            java.lang.String r26 = r0.getLastModifiedBy()
            java.lang.String r27 = r0.getLastModifiedDate()
            r20 = r3
            r20.<init>(r21, r22, r23, r24, r25, r26, r27)
            goto L_0x012e
        L_0x012c:
            r20 = r2
        L_0x012e:
            media.tiger.tigerbox.model.dto.TigerCardValidState$Templates r0 = r29.get_templates()
            if (r0 == 0) goto L_0x013e
            media.tiger.tigerbox.model.dto.TigerCardValidState$Templates$Template r0 = r0.getSaveRecentlyUsedMultiTigercardProduct()
            if (r0 == 0) goto L_0x013e
            java.lang.String r2 = r0.getTarget()
        L_0x013e:
            r21 = r2
            media.tiger.tigerbox.services.interfaces.TigerCardDomain$MultiTigercardVariantDomain r2 = new media.tiger.tigerbox.services.interfaces.TigerCardDomain$MultiTigercardVariantDomain
            r12 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21)
            goto L_0x0148
        L_0x0147:
            r12 = r2
        L_0x0148:
            media.tiger.tigerbox.services.interfaces.TigerCardDomain r0 = new media.tiger.tigerbox.services.interfaces.TigerCardDomain
            java.lang.String r5 = r29.getCode()
            java.lang.String r6 = r29.getUid()
            java.lang.String r7 = r29.getCardType()
            java.lang.Integer r8 = r29.getProductId()
            int r9 = r29.getAccountGeneratedContentId()
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.usecase.GetValidTigerCardUseCase$run$2.invoke(media.tiger.tigerbox.model.dto.TigerCardValidState):media.tiger.tigerbox.services.interfaces.TigerCardDomain");
    }
}
