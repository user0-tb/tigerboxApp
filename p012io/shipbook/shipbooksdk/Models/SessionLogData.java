package p012io.shipbook.shipbooksdk.Models;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import p012io.shipbook.shipbooksdk.Models.BaseLog;
import p012io.shipbook.shipbooksdk.Models.Login;
import p012io.shipbook.shipbooksdk.Models.User;

@Metadata(mo33736d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J=\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\b\u0010'\u001a\u00020(H\u0016J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006+"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/SessionLogData;", "Lio/shipbook/shipbooksdk/Models/BaseObj;", "token", "", "login", "Lio/shipbook/shipbooksdk/Models/Login;", "user", "Lio/shipbook/shipbooksdk/Models/User;", "logs", "", "Lio/shipbook/shipbooksdk/Models/BaseLog;", "(Ljava/lang/String;Lio/shipbook/shipbooksdk/Models/Login;Lio/shipbook/shipbooksdk/Models/User;Ljava/util/List;)V", "getLogin", "()Lio/shipbook/shipbooksdk/Models/Login;", "setLogin", "(Lio/shipbook/shipbooksdk/Models/Login;)V", "getLogs", "()Ljava/util/List;", "setLogs", "(Ljava/util/List;)V", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "getUser", "()Lio/shipbook/shipbooksdk/Models/User;", "setUser", "(Lio/shipbook/shipbooksdk/Models/User;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Models.SessionLogData */
/* compiled from: SessionLogData.kt */
public final class SessionLogData implements BaseObj {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Login login;
    private List<BaseLog> logs;
    private String token;
    private User user;

    public SessionLogData() {
        this((String) null, (Login) null, (User) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SessionLogData copy$default(SessionLogData sessionLogData, String str, Login login2, User user2, List<BaseLog> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sessionLogData.token;
        }
        if ((i & 2) != 0) {
            login2 = sessionLogData.login;
        }
        if ((i & 4) != 0) {
            user2 = sessionLogData.user;
        }
        if ((i & 8) != 0) {
            list = sessionLogData.logs;
        }
        return sessionLogData.copy(str, login2, user2, list);
    }

    public final String component1() {
        return this.token;
    }

    public final Login component2() {
        return this.login;
    }

    public final User component3() {
        return this.user;
    }

    public final List<BaseLog> component4() {
        return this.logs;
    }

    public final SessionLogData copy(String str, Login login2, User user2, List<BaseLog> list) {
        Intrinsics.checkNotNullParameter(list, "logs");
        return new SessionLogData(str, login2, user2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionLogData)) {
            return false;
        }
        SessionLogData sessionLogData = (SessionLogData) obj;
        return Intrinsics.areEqual((Object) this.token, (Object) sessionLogData.token) && Intrinsics.areEqual((Object) this.login, (Object) sessionLogData.login) && Intrinsics.areEqual((Object) this.user, (Object) sessionLogData.user) && Intrinsics.areEqual((Object) this.logs, (Object) sessionLogData.logs);
    }

    public int hashCode() {
        String str = this.token;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Login login2 = this.login;
        int hashCode2 = (hashCode + (login2 == null ? 0 : login2.hashCode())) * 31;
        User user2 = this.user;
        if (user2 != null) {
            i = user2.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.logs.hashCode();
    }

    public String toString() {
        return "SessionLogData(token=" + this.token + ", login=" + this.login + ", user=" + this.user + ", logs=" + this.logs + ')';
    }

    public SessionLogData(String str, Login login2, User user2, List<BaseLog> list) {
        Intrinsics.checkNotNullParameter(list, "logs");
        this.token = str;
        this.login = login2;
        this.user = user2;
        this.logs = list;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final Login getLogin() {
        return this.login;
    }

    public final void setLogin(Login login2) {
        this.login = login2;
    }

    public final User getUser() {
        return this.user;
    }

    public final void setUser(User user2) {
        this.user = user2;
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Models/SessionLogData$Companion;", "", "()V", "create", "Lio/shipbook/shipbooksdk/Models/SessionLogData;", "json", "Lorg/json/JSONObject;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: io.shipbook.shipbooksdk.Models.SessionLogData$Companion */
    /* compiled from: SessionLogData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SessionLogData create(JSONObject jSONObject) {
            Login login;
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            String optString = jSONObject.optString("token");
            User user = null;
            if (jSONObject.has("login")) {
                Login.Companion companion = Login.Companion;
                JSONObject jSONObject2 = jSONObject.getJSONObject("login");
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.getJSONObject(\"login\")");
                login = companion.create(jSONObject2);
            } else {
                login = null;
            }
            if (jSONObject.has("user")) {
                User.Companion companion2 = User.Companion;
                JSONObject jSONObject3 = jSONObject.getJSONObject("user");
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "json.getJSONObject(\"user\")");
                user = companion2.create(jSONObject3);
            }
            List arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray("logs");
            int i = 0;
            int length = jSONArray.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i2 = i + 1;
                    BaseLog.Companion companion3 = BaseLog.Companion;
                    JSONObject jSONObject4 = jSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "logsArray.getJSONObject(i)");
                    arrayList.add(companion3.create(jSONObject4));
                    if (i == length) {
                        break;
                    }
                    i = i2;
                }
            }
            return new SessionLogData(optString, login, user, arrayList);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SessionLogData(String str, Login login2, User user2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : login2, (i & 4) != 0 ? null : user2, (i & 8) != 0 ? new ArrayList() : list);
    }

    public final List<BaseLog> getLogs() {
        return this.logs;
    }

    public final void setLogs(List<BaseLog> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.logs = list;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.putOpt("token", this.token);
        Login login2 = this.login;
        if (login2 != null) {
            jSONObject.put("login", login2.toJson());
        }
        User user2 = this.user;
        if (user2 != null) {
            jSONObject.put("user", user2.toJson());
        }
        JSONArray jSONArray = new JSONArray();
        for (BaseLog json : this.logs) {
            jSONArray.put(json.toJson());
        }
        jSONObject.put("logs", jSONArray);
        return jSONObject;
    }
}
