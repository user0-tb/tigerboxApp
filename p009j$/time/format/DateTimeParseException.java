package p009j$.time.format;

import p009j$.time.DateTimeException;

/* renamed from: j$.time.format.DateTimeParseException */
public class DateTimeParseException extends DateTimeException {
    public DateTimeParseException(String str, CharSequence charSequence, int i) {
        super(str);
        charSequence.toString();
    }

    public DateTimeParseException(String str, CharSequence charSequence, int i, Throwable th) {
        super(str, th);
        charSequence.toString();
    }
}
