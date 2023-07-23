package media.tiger.tigerbox.webserver.exception;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, mo33737d2 = {"Lmedia/tiger/tigerbox/webserver/exception/ProductNotFoundException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "productId", "", "(I)V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: ProductNotFoundException.kt */
public final class ProductNotFoundException extends Exception {
    public ProductNotFoundException(int i) {
        super("Product [" + i + "] not found");
    }
}
