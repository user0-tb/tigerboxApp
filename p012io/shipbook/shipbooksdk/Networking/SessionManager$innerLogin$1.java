package p012io.shipbook.shipbooksdk.Networking;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p013io.FilesKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import p012io.shipbook.shipbooksdk.BroadcastNames;
import p012io.shipbook.shipbooksdk.InnerLog;
import p012io.shipbook.shipbooksdk.LogManager;
import p012io.shipbook.shipbooksdk.Models.Login;
import p012io.shipbook.shipbooksdk.Models.LoginResponse;

@Metadata(mo33736d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, mo33737d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@DebugMetadata(mo34423c = "io.shipbook.shipbooksdk.Networking.SessionManager$innerLogin$1", mo34424f = "SessionManager.kt", mo34425i = {}, mo34426l = {96}, mo34427m = "invokeSuspend", mo34428n = {}, mo34429s = {})
/* renamed from: io.shipbook.shipbooksdk.Networking.SessionManager$innerLogin$1 */
/* compiled from: SessionManager.kt */
final class SessionManager$innerLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    SessionManager$innerLogin$1(Continuation<? super SessionManager$innerLogin$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SessionManager$innerLogin$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SessionManager$innerLogin$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InnerLog.d$default(InnerLog.INSTANCE, SessionManager.TAG, Intrinsics.stringPlus("current thread: ", Thread.currentThread().getName()), (Throwable) null, 4, (Object) null);
            ConnectionClient connectionClient = ConnectionClient.INSTANCE;
            Login login = SessionManager.INSTANCE.getLogin();
            JSONObject json = login == null ? null : login.toJson();
            this.label = 1;
            obj = connectionClient.request("auth/loginSdk", String.valueOf(json), HttpMethod.POST, (Continuation<? super ResponseData>) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResponseData responseData = (ResponseData) obj;
        SessionManager.INSTANCE.setInLoginRequest(false);
        if (responseData.getOk()) {
            try {
                if (responseData.getData() != null) {
                    LoginResponse create = LoginResponse.Companion.create(responseData.getData());
                    SessionManager.INSTANCE.setToken(create.getToken());
                    create.getSessionUrl();
                    Function1<String, Unit> sessionCompletion = SessionManager.INSTANCE.getSessionCompletion();
                    if (sessionCompletion != null) {
                        sessionCompletion.invoke(create.getSessionUrl());
                    }
                    LogManager.INSTANCE.config(create.getConfig());
                    File configFile = SessionManager.INSTANCE.getConfigFile();
                    Intrinsics.checkNotNull(configFile);
                    String jSONObject = create.getConfig().toJson().toString();
                    Intrinsics.checkNotNullExpressionValue(jSONObject, "loginResponse.config.toJson().toString()");
                    FilesKt.writeText$default(configFile, jSONObject, (Charset) null, 2, (Object) null);
                    Context appContext = SessionManager.INSTANCE.getAppContext();
                    Intrinsics.checkNotNull(appContext);
                    LocalBroadcastManager.getInstance(appContext).sendBroadcast(new Intent(BroadcastNames.INSTANCE.getCONNECTED()));
                } else {
                    throw new Exception("No Data error");
                }
            } catch (Throwable th) {
                InnerLog.INSTANCE.mo33259e(SessionManager.TAG, "There was a problem with the data", th);
            }
        } else {
            InnerLog.e$default(InnerLog.INSTANCE, SessionManager.TAG, "The response not ok", (Throwable) null, 4, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
