package org.spongycastle.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SignerInformationStore {
    private List all = new ArrayList();
    private Map table = new HashMap();

    public SignerInformationStore(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            SignerInformation signerInformation = (SignerInformation) it.next();
            SignerId sid = signerInformation.getSID();
            ArrayList arrayList = (ArrayList) this.table.get(sid);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.table.put(sid, arrayList);
            }
            arrayList.add(signerInformation);
        }
        this.all = new ArrayList(collection);
    }

    public SignerInformation get(SignerId signerId) {
        Collection signers = getSigners(signerId);
        if (signers.size() == 0) {
            return null;
        }
        return (SignerInformation) signers.iterator().next();
    }

    public int size() {
        return this.all.size();
    }

    public Collection getSigners() {
        return new ArrayList(this.all);
    }

    public Collection getSigners(SignerId signerId) {
        if (signerId.getIssuer() == null || signerId.getSubjectKeyIdentifier() == null) {
            ArrayList arrayList = (ArrayList) this.table.get(signerId);
            return arrayList == null ? new ArrayList() : new ArrayList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Collection signers = getSigners(new SignerId(signerId.getIssuer(), signerId.getSerialNumber()));
        if (signers != null) {
            arrayList2.addAll(signers);
        }
        Collection signers2 = getSigners(new SignerId(signerId.getSubjectKeyIdentifier()));
        if (signers2 != null) {
            arrayList2.addAll(signers2);
        }
        return arrayList2;
    }
}
