package media.tiger.tigerbox.p016ui.main.maincontent;

import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.data.repository.ProfileChangeListener;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$profilesListener$1", "Lmedia/tiger/tigerbox/data/repository/ProfileChangeListener;", "didChangeProfile", "", "id", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$profilesListener$1 */
/* compiled from: ProductContentViewModel.kt */
public final class ProductContentViewModel$profilesListener$1 implements ProfileChangeListener {
    final /* synthetic */ ProductContentViewModel this$0;

    ProductContentViewModel$profilesListener$1(ProductContentViewModel productContentViewModel) {
        this.this$0 = productContentViewModel;
    }

    public void didUpdateProfilesInfo() {
        ProfileChangeListener.DefaultImpls.didUpdateProfilesInfo(this);
    }

    public void didChangeProfile(int i) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("ProductContentViewModel didChangeProfile " + i, new Object[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new ProductContentViewModel$profilesListener$1$didChangeProfile$1(this.this$0, (Continuation<? super ProductContentViewModel$profilesListener$1$didChangeProfile$1>) null), 3, (Object) null);
    }
}
