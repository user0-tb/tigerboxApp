package media.tiger.tigerbox.usecase;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.ProductDetails;
import media.tiger.tigerbox.model.dto.ProductDetailsDto;

@Metadata(mo33736d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo33737d2 = {"<anonymous>", "Lmedia/tiger/tigerbox/model/domain/ProductDetails;", "dto", "Lmedia/tiger/tigerbox/model/dto/ProductDetailsDto;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: GetProductDetailsUseCase.kt */
final class GetProductDetailsUseCase$run$2 extends Lambda implements Function1<ProductDetailsDto, ProductDetails> {
    public static final GetProductDetailsUseCase$run$2 INSTANCE = new GetProductDetailsUseCase$run$2();

    GetProductDetailsUseCase$run$2() {
        super(1);
    }

    public final ProductDetails invoke(ProductDetailsDto productDetailsDto) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(productDetailsDto, "dto");
        int id = productDetailsDto.getId();
        String productType = productDetailsDto.getProductType();
        String str4 = productType == null ? "" : productType;
        String title = productDetailsDto.getTitle();
        if (title == null) {
            str = "";
        } else {
            str = title;
        }
        String description = productDetailsDto.getDescription();
        if (description == null) {
            str2 = "";
        } else {
            str2 = description;
        }
        String language = productDetailsDto.getLanguage();
        if (language == null) {
            str3 = "";
        } else {
            str3 = language;
        }
        String author = productDetailsDto.getAuthor();
        if (author == null) {
            author = "";
        }
        return new ProductDetails(id, str4, str, str2, str3, author);
    }
}
