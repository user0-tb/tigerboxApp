package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import kotlin.Metadata;
import media.tiger.tigerbox.infrastructure.functional.ObservableUpdate;

@Metadata(mo33736d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH¦\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH¦\u0002¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DigestValidator;", "Lmedia/tiger/tigerbox/infrastructure/functional/ObservableUpdate;", "", "invoke", "", "fileToValidate", "", "publicKeyString", "", "signatureFile", "base64Converter", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/Base64Converter;", "signatureAsString", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DigestValidator */
/* compiled from: DigestValidator.kt */
public interface DigestValidator extends ObservableUpdate<Double> {
    boolean invoke(String str, String str2, String str3, Base64Converter base64Converter);

    boolean invoke(byte[] bArr, String str, byte[] bArr2, Base64Converter base64Converter);
}
