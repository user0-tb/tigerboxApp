package androidx.room;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Build;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo33736d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0013\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eJ\u001b\u0010\f\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u0011J\u0014\u0010\f\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u00020\u00172\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u0018J\u0014\u0010\u0016\u001a\u00020\u00172\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019J#\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00102\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u001bJ!\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0010¢\u0006\u0002\u0010\u001fJ\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo33737d2 = {"Landroidx/room/EntityUpsertionAdapter;", "T", "", "insertionAdapter", "Landroidx/room/EntityInsertionAdapter;", "updateAdapter", "Landroidx/room/EntityDeletionOrUpdateAdapter;", "(Landroidx/room/EntityInsertionAdapter;Landroidx/room/EntityDeletionOrUpdateAdapter;)V", "checkUniquenessException", "", "ex", "Landroid/database/sqlite/SQLiteConstraintException;", "upsert", "entity", "(Ljava/lang/Object;)V", "entities", "", "([Ljava/lang/Object;)V", "", "upsertAndReturnId", "", "(Ljava/lang/Object;)J", "upsertAndReturnIdsArray", "", "([Ljava/lang/Object;)[J", "", "upsertAndReturnIdsArrayBox", "([Ljava/lang/Object;)[Ljava/lang/Long;", "(Ljava/util/Collection;)[Ljava/lang/Long;", "upsertAndReturnIdsList", "", "([Ljava/lang/Object;)Ljava/util/List;", "room-runtime_release"}, mo33738k = 1, mo33739mv = {1, 7, 1}, mo33741xi = 48)
/* compiled from: EntityUpsertionAdapter.kt */
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> entityInsertionAdapter, EntityDeletionOrUpdateAdapter<T> entityDeletionOrUpdateAdapter) {
        Intrinsics.checkNotNullParameter(entityInsertionAdapter, "insertionAdapter");
        Intrinsics.checkNotNullParameter(entityDeletionOrUpdateAdapter, "updateAdapter");
        this.insertionAdapter = entityInsertionAdapter;
        this.updateAdapter = entityDeletionOrUpdateAdapter;
    }

    public final void upsert(T t) {
        try {
            this.insertionAdapter.insert(t);
        } catch (SQLiteConstraintException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(t);
        }
    }

    public final long upsertAndReturnId(T t) {
        try {
            return this.insertionAdapter.insertAndReturnId(t);
        } catch (SQLiteConstraintException e) {
            checkUniquenessException(e);
            this.updateAdapter.handle(t);
            return -1;
        }
    }

    public final long[] upsertAndReturnIdsArray(T[] tArr) {
        long j;
        Intrinsics.checkNotNullParameter(tArr, "entities");
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            try {
                j = this.insertionAdapter.insertAndReturnId(tArr[i]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(tArr[i]);
                j = -1;
            }
            jArr[i] = j;
        }
        return jArr;
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> collection) {
        long j;
        Intrinsics.checkNotNullParameter(collection, "entities");
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            Object next = it.next();
            try {
                j = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                j = -1;
            }
            jArr[i] = j;
        }
        return jArr;
    }

    public final List<Long> upsertAndReturnIdsList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "entities");
        List createListBuilder = CollectionsKt.createListBuilder();
        for (T t : tArr) {
            try {
                createListBuilder.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
                createListBuilder.add(-1L);
            }
        }
        return CollectionsKt.build(createListBuilder);
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "entities");
        List createListBuilder = CollectionsKt.createListBuilder();
        for (Object next : collection) {
            try {
                createListBuilder.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(next)));
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                createListBuilder.add(-1L);
            }
        }
        return CollectionsKt.build(createListBuilder);
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] tArr) {
        long j;
        Intrinsics.checkNotNullParameter(tArr, "entities");
        int length = tArr.length;
        Long[] lArr = new Long[length];
        for (int i = 0; i < length; i++) {
            try {
                j = this.insertionAdapter.insertAndReturnId(tArr[i]);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(tArr[i]);
                j = -1;
            }
            lArr[i] = Long.valueOf(j);
        }
        return lArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        long j;
        Intrinsics.checkNotNullParameter(collection, "entities");
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        Long[] lArr = new Long[size];
        for (int i = 0; i < size; i++) {
            Object next = it.next();
            try {
                j = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
                j = -1;
            }
            lArr[i] = Long.valueOf(j);
        }
        return lArr;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message == null) {
            throw sQLiteConstraintException;
        } else if (Build.VERSION.SDK_INT <= 19) {
            if (!StringsKt.contains((CharSequence) message, (CharSequence) "unique", true)) {
                throw sQLiteConstraintException;
            }
        } else if (!StringsKt.contains((CharSequence) message, (CharSequence) "1555", true)) {
            throw sQLiteConstraintException;
        }
    }

    public final void upsert(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "entities");
        for (T t : tArr) {
            try {
                this.insertionAdapter.insert(t);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(t);
            }
        }
    }

    public final void upsert(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "entities");
        for (Object next : iterable) {
            try {
                this.insertionAdapter.insert(next);
            } catch (SQLiteConstraintException e) {
                checkUniquenessException(e);
                this.updateAdapter.handle(next);
            }
        }
    }
}
