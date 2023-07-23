package p009j$.time.format;

import p009j$.time.chrono.Chronology;
import p009j$.time.format.DateTimeFormatterBuilder;
import p009j$.util.function.Consumer;

/* renamed from: j$.time.format.DateTimeFormatterBuilder$ReducedPrinterParser$$ExternalSyntheticLambda0 */
public final /* synthetic */ class C1419xdc213142 implements Consumer {
    public final /* synthetic */ DateTimeFormatterBuilder.ReducedPrinterParser f$0;
    public final /* synthetic */ DateTimeParseContext f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ int f$4;

    public /* synthetic */ C1419xdc213142(DateTimeFormatterBuilder.ReducedPrinterParser reducedPrinterParser, DateTimeParseContext dateTimeParseContext, long j, int i, int i2) {
        this.f$0 = reducedPrinterParser;
        this.f$1 = dateTimeParseContext;
        this.f$2 = j;
        this.f$3 = i;
        this.f$4 = i2;
    }

    public final void accept(Object obj) {
        Chronology chronology = (Chronology) obj;
        this.f$0.setValue(this.f$1, this.f$2, this.f$3, this.f$4);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
