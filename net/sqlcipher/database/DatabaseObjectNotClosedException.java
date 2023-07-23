package net.sqlcipher.database;

public class DatabaseObjectNotClosedException extends RuntimeException {

    /* renamed from: s */
    private static final String f659s = "Application did not close the cursor or database object that was opened here";

    public DatabaseObjectNotClosedException() {
        super(f659s);
    }
}
