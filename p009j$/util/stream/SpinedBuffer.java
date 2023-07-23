package p009j$.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import p009j$.lang.Iterable;
import p009j$.util.Objects;
import p009j$.util.Spliterator;
import p009j$.util.Spliterators;
import p009j$.util.function.Consumer;
import p009j$.util.function.DoubleConsumer;
import p009j$.util.function.IntConsumer;
import p009j$.util.function.LongConsumer;
import p009j$.wrappers.C$r8$wrapper$java$util$function$Consumer$VWRP;

/* renamed from: j$.util.stream.SpinedBuffer */
class SpinedBuffer extends AbstractSpinedBuffer implements Consumer, Iterable, Iterable {
    protected Object[] curChunk = new Object[16];
    protected Object[][] spine;

    /* renamed from: j$.util.stream.SpinedBuffer$1Splitr  reason: invalid class name */
    class AnonymousClass1Splitr implements Spliterator {
        final int lastSpineElementFence;
        final int lastSpineIndex;
        Object[] splChunk;
        int splElementIndex;
        int splSpineIndex;

        {
            this.splSpineIndex = r2;
            this.lastSpineIndex = r3;
            this.splElementIndex = r4;
            this.lastSpineElementFence = r5;
            Object[][] objArr = SpinedBuffer.this.spine;
            this.splChunk = objArr == null ? SpinedBuffer.this.curChunk : objArr[r2];
        }

        public int characteristics() {
            return 16464;
        }

        public long estimateSize() {
            int i = this.splSpineIndex;
            int i2 = this.lastSpineIndex;
            if (i == i2) {
                return ((long) this.lastSpineElementFence) - ((long) this.splElementIndex);
            }
            long[] jArr = SpinedBuffer.this.priorElementCount;
            return ((jArr[i2] + ((long) this.lastSpineElementFence)) - jArr[i]) - ((long) this.splElementIndex);
        }

        public void forEachRemaining(Consumer consumer) {
            int i;
            java.util.Objects.requireNonNull(consumer);
            int i2 = this.splSpineIndex;
            int i3 = this.lastSpineIndex;
            if (i2 < i3 || (i2 == i3 && this.splElementIndex < this.lastSpineElementFence)) {
                int i4 = this.splElementIndex;
                while (true) {
                    i = this.lastSpineIndex;
                    if (i2 >= i) {
                        break;
                    }
                    Object[] objArr = SpinedBuffer.this.spine[i2];
                    while (i4 < objArr.length) {
                        consumer.accept(objArr[i4]);
                        i4++;
                    }
                    i4 = 0;
                    i2++;
                }
                Object[] objArr2 = this.splSpineIndex == i ? this.splChunk : SpinedBuffer.this.spine[i];
                int i5 = this.lastSpineElementFence;
                while (i4 < i5) {
                    consumer.accept(objArr2[i4]);
                    i4++;
                }
                this.splSpineIndex = this.lastSpineIndex;
                this.splElementIndex = this.lastSpineElementFence;
            }
        }

        public Comparator getComparator() {
            throw new IllegalStateException();
        }

        public /* synthetic */ long getExactSizeIfKnown() {
            return Objects.$default$getExactSizeIfKnown(this);
        }

        public /* synthetic */ boolean hasCharacteristics(int i) {
            return Objects.$default$hasCharacteristics(this, i);
        }

        public boolean tryAdvance(Consumer consumer) {
            java.util.Objects.requireNonNull(consumer);
            int i = this.splSpineIndex;
            int i2 = this.lastSpineIndex;
            if (i >= i2 && (i != i2 || this.splElementIndex >= this.lastSpineElementFence)) {
                return false;
            }
            Object[] objArr = this.splChunk;
            int i3 = this.splElementIndex;
            this.splElementIndex = i3 + 1;
            consumer.accept(objArr[i3]);
            if (this.splElementIndex == this.splChunk.length) {
                this.splElementIndex = 0;
                int i4 = this.splSpineIndex + 1;
                this.splSpineIndex = i4;
                Object[][] objArr2 = SpinedBuffer.this.spine;
                if (objArr2 != null && i4 <= this.lastSpineIndex) {
                    this.splChunk = objArr2[i4];
                }
            }
            return true;
        }

        public Spliterator trySplit() {
            int i = this.splSpineIndex;
            int i2 = this.lastSpineIndex;
            if (i < i2) {
                SpinedBuffer spinedBuffer = SpinedBuffer.this;
                int i3 = i2 - 1;
                AnonymousClass1Splitr r0 = new AnonymousClass1Splitr(i, i3, this.splElementIndex, spinedBuffer.spine[i3].length);
                int i4 = this.lastSpineIndex;
                this.splSpineIndex = i4;
                this.splElementIndex = 0;
                this.splChunk = SpinedBuffer.this.spine[i4];
                return r0;
            } else if (i != i2) {
                return null;
            } else {
                int i5 = this.lastSpineElementFence;
                int i6 = this.splElementIndex;
                int i7 = (i5 - i6) / 2;
                if (i7 == 0) {
                    return null;
                }
                Spliterator spliterator = Spliterators.spliterator(this.splChunk, i6, i6 + i7, 1040);
                this.splElementIndex += i7;
                return spliterator;
            }
        }
    }

    /*  JADX ERROR: Inner class code generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:274)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: RETURN  
          (wrap: j$.util.stream.SpinedBuffer$OfDouble$1Splitr : 0x000a: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfDouble$1Splitr) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfDouble A[THIS])
          (0 int)
          (wrap: int : 0x0002: IGET  (r3v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfDouble A[THIS]) j$.util.stream.AbstractSpinedBuffer.spineIndex int)
          (0 int)
          (wrap: int : 0x0004: IGET  (r5v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfDouble A[THIS]) j$.util.stream.AbstractSpinedBuffer.elementIndex int)
         call: j$.util.stream.SpinedBuffer.OfDouble.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfDouble, int, int, int, int):void type: CONSTRUCTOR)
         in method: j$.util.stream.SpinedBuffer.OfDouble.spliterator():j$.util.Spliterator$OfDouble, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
        	... 35 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfDouble$1Splitr) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfDouble A[THIS])
          (0 int)
          (wrap: int : 0x0002: IGET  (r3v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfDouble A[THIS]) j$.util.stream.AbstractSpinedBuffer.spineIndex int)
          (0 int)
          (wrap: int : 0x0004: IGET  (r5v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfDouble A[THIS]) j$.util.stream.AbstractSpinedBuffer.elementIndex int)
         call: j$.util.stream.SpinedBuffer.OfDouble.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfDouble, int, int, int, int):void type: CONSTRUCTOR in method: j$.util.stream.SpinedBuffer.OfDouble.spliterator():j$.util.Spliterator$OfDouble, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:314)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	... 44 more
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:274)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
        	... 48 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: RETURN  
          (wrap: j$.util.stream.SpinedBuffer$OfDouble$1Splitr : 0x0009: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfDouble$1Splitr) = 
          (wrap: j$.util.stream.SpinedBuffer$OfDouble : 0x0002: IGET  (r1v0 j$.util.stream.SpinedBuffer$OfDouble) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfDouble$1Splitr A[THIS])
         j$.util.stream.SpinedBuffer.OfDouble.1Splitr.this$0 j$.util.stream.SpinedBuffer$OfDouble)
          (r8v0 'i' int)
          (r9v0 'i2' int)
          (r10v0 'i3' int)
          (r11v0 'i4' int)
         call: j$.util.stream.SpinedBuffer.OfDouble.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfDouble, int, int, int, int):void type: CONSTRUCTOR)
         in method: j$.util.stream.SpinedBuffer.OfDouble.1Splitr.newSpliterator(int, int, int, int):j$.util.Spliterator$OfPrimitive, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
        	... 65 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfDouble$1Splitr) = 
          (wrap: j$.util.stream.SpinedBuffer$OfDouble : 0x0002: IGET  (r1v0 j$.util.stream.SpinedBuffer$OfDouble) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfDouble$1Splitr A[THIS])
         j$.util.stream.SpinedBuffer.OfDouble.1Splitr.this$0 j$.util.stream.SpinedBuffer$OfDouble)
          (r8v0 'i' int)
          (r9v0 'i2' int)
          (r10v0 'i3' int)
          (r11v0 'i4' int)
         call: j$.util.stream.SpinedBuffer.OfDouble.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfDouble, int, int, int, int):void type: CONSTRUCTOR in method: j$.util.stream.SpinedBuffer.OfDouble.1Splitr.newSpliterator(int, int, int, int):j$.util.Spliterator$OfPrimitive, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:314)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	... 74 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: j$.util.stream.SpinedBuffer.OfDouble.1Splitr
        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:649)
        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
        	... 78 more
        */
    /* renamed from: j$.util.stream.SpinedBuffer$OfDouble */
    class OfDouble extends OfPrimitive implements DoubleConsumer {

        /* renamed from: j$.util.stream.SpinedBuffer$OfDouble$1Splitr  reason: invalid class name */
        class AnonymousClass1Splitr extends OfPrimitive.BaseSpliterator implements Spliterator.OfDouble {
            /* access modifiers changed from: package-private */
            public void arrayForOne(Object obj, int i, Object obj2) {
                ((DoubleConsumer) obj2).accept(((double[]) obj)[i]);
            }

            /* access modifiers changed from: package-private */
            public Spliterator.OfPrimitive arraySpliterator(Object obj, int i, int i2) {
                return Spliterators.spliterator((double[]) obj, i, i2 + i, 1040);
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Objects.$default$forEachRemaining((Spliterator.OfDouble) this, consumer);
            }

            /* access modifiers changed from: package-private */
            public Spliterator.OfPrimitive newSpliterator(int i, int i2, int i3, int i4) {
                return new AnonymousClass1Splitr(i, i2, i3, i4);
            }

            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Objects.$default$tryAdvance((Spliterator.OfDouble) this, consumer);
            }
        }

        OfDouble() {
        }

        OfDouble(int i) {
            super(i);
        }

        public void accept(double d) {
            preAccept();
            int i = this.elementIndex;
            this.elementIndex = i + 1;
            ((double[]) this.curChunk)[i] = d;
        }

        /* access modifiers changed from: protected */
        public void arrayForEach(Object obj, int i, int i2, Object obj2) {
            double[] dArr = (double[]) obj;
            DoubleConsumer doubleConsumer = (DoubleConsumer) obj2;
            while (i < i2) {
                doubleConsumer.accept(dArr[i]);
                i++;
            }
        }

        /* access modifiers changed from: protected */
        public int arrayLength(Object obj) {
            return ((double[]) obj).length;
        }

        public void forEach(Consumer consumer) {
            if (consumer instanceof DoubleConsumer) {
                forEach((DoubleConsumer) consumer);
            } else if (!Tripwire.ENABLED) {
                spliterator().forEachRemaining(consumer);
            } else {
                Tripwire.trip(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
                throw null;
            }
        }

        public Iterator iterator() {
            return Spliterators.iterator(spliterator());
        }

        public Object newArray(int i) {
            return new double[i];
        }

        /* access modifiers changed from: protected */
        public Object[] newArrayArray(int i) {
            return new double[i][];
        }

        public Spliterator.OfDouble spliterator() {
            return new AnonymousClass1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public String toString() {
            double[] dArr = (double[]) asPrimitiveArray();
            if (dArr.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.spineIndex), Arrays.toString(dArr)});
            }
            return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.spineIndex), Arrays.toString(Arrays.copyOf(dArr, 200))});
        }
    }

    /*  JADX ERROR: Inner class code generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:274)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: RETURN  
          (wrap: j$.util.stream.SpinedBuffer$OfInt$1Splitr : 0x000a: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfInt$1Splitr) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfInt A[THIS])
          (0 int)
          (wrap: int : 0x0002: IGET  (r3v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfInt A[THIS]) j$.util.stream.AbstractSpinedBuffer.spineIndex int)
          (0 int)
          (wrap: int : 0x0004: IGET  (r5v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfInt A[THIS]) j$.util.stream.AbstractSpinedBuffer.elementIndex int)
         call: j$.util.stream.SpinedBuffer.OfInt.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfInt, int, int, int, int):void type: CONSTRUCTOR)
         in method: j$.util.stream.SpinedBuffer.OfInt.spliterator():j$.util.Spliterator$OfInt, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
        	... 35 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfInt$1Splitr) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfInt A[THIS])
          (0 int)
          (wrap: int : 0x0002: IGET  (r3v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfInt A[THIS]) j$.util.stream.AbstractSpinedBuffer.spineIndex int)
          (0 int)
          (wrap: int : 0x0004: IGET  (r5v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfInt A[THIS]) j$.util.stream.AbstractSpinedBuffer.elementIndex int)
         call: j$.util.stream.SpinedBuffer.OfInt.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfInt, int, int, int, int):void type: CONSTRUCTOR in method: j$.util.stream.SpinedBuffer.OfInt.spliterator():j$.util.Spliterator$OfInt, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:314)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	... 44 more
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:274)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
        	... 48 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: RETURN  
          (wrap: j$.util.stream.SpinedBuffer$OfInt$1Splitr : 0x0009: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfInt$1Splitr) = 
          (wrap: j$.util.stream.SpinedBuffer$OfInt : 0x0002: IGET  (r1v0 j$.util.stream.SpinedBuffer$OfInt) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfInt$1Splitr A[THIS])
         j$.util.stream.SpinedBuffer.OfInt.1Splitr.this$0 j$.util.stream.SpinedBuffer$OfInt)
          (r8v0 'i' int)
          (r9v0 'i2' int)
          (r10v0 'i3' int)
          (r11v0 'i4' int)
         call: j$.util.stream.SpinedBuffer.OfInt.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfInt, int, int, int, int):void type: CONSTRUCTOR)
         in method: j$.util.stream.SpinedBuffer.OfInt.1Splitr.newSpliterator(int, int, int, int):j$.util.Spliterator$OfPrimitive, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
        	... 65 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfInt$1Splitr) = 
          (wrap: j$.util.stream.SpinedBuffer$OfInt : 0x0002: IGET  (r1v0 j$.util.stream.SpinedBuffer$OfInt) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfInt$1Splitr A[THIS])
         j$.util.stream.SpinedBuffer.OfInt.1Splitr.this$0 j$.util.stream.SpinedBuffer$OfInt)
          (r8v0 'i' int)
          (r9v0 'i2' int)
          (r10v0 'i3' int)
          (r11v0 'i4' int)
         call: j$.util.stream.SpinedBuffer.OfInt.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfInt, int, int, int, int):void type: CONSTRUCTOR in method: j$.util.stream.SpinedBuffer.OfInt.1Splitr.newSpliterator(int, int, int, int):j$.util.Spliterator$OfPrimitive, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:314)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	... 74 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: j$.util.stream.SpinedBuffer.OfInt.1Splitr
        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:649)
        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
        	... 78 more
        */
    /* renamed from: j$.util.stream.SpinedBuffer$OfInt */
    class OfInt extends OfPrimitive implements IntConsumer {

        /* renamed from: j$.util.stream.SpinedBuffer$OfInt$1Splitr  reason: invalid class name */
        class AnonymousClass1Splitr extends OfPrimitive.BaseSpliterator implements Spliterator.OfInt {
            /* access modifiers changed from: package-private */
            public void arrayForOne(Object obj, int i, Object obj2) {
                ((IntConsumer) obj2).accept(((int[]) obj)[i]);
            }

            /* access modifiers changed from: package-private */
            public Spliterator.OfPrimitive arraySpliterator(Object obj, int i, int i2) {
                return Spliterators.spliterator((int[]) obj, i, i2 + i, 1040);
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Objects.$default$forEachRemaining((Spliterator.OfInt) this, consumer);
            }

            /* access modifiers changed from: package-private */
            public Spliterator.OfPrimitive newSpliterator(int i, int i2, int i3, int i4) {
                return new AnonymousClass1Splitr(i, i2, i3, i4);
            }

            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Objects.$default$tryAdvance((Spliterator.OfInt) this, consumer);
            }
        }

        OfInt() {
        }

        OfInt(int i) {
            super(i);
        }

        public void accept(int i) {
            preAccept();
            int i2 = this.elementIndex;
            this.elementIndex = i2 + 1;
            ((int[]) this.curChunk)[i2] = i;
        }

        /* access modifiers changed from: protected */
        public void arrayForEach(Object obj, int i, int i2, Object obj2) {
            int[] iArr = (int[]) obj;
            IntConsumer intConsumer = (IntConsumer) obj2;
            while (i < i2) {
                intConsumer.accept(iArr[i]);
                i++;
            }
        }

        /* access modifiers changed from: protected */
        public int arrayLength(Object obj) {
            return ((int[]) obj).length;
        }

        public void forEach(Consumer consumer) {
            if (consumer instanceof IntConsumer) {
                forEach((IntConsumer) consumer);
            } else if (!Tripwire.ENABLED) {
                spliterator().forEachRemaining(consumer);
            } else {
                Tripwire.trip(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
                throw null;
            }
        }

        public Iterator iterator() {
            return Spliterators.iterator(spliterator());
        }

        public Object newArray(int i) {
            return new int[i];
        }

        /* access modifiers changed from: protected */
        public Object[] newArrayArray(int i) {
            return new int[i][];
        }

        public Spliterator.OfInt spliterator() {
            return new AnonymousClass1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public String toString() {
            int[] iArr = (int[]) asPrimitiveArray();
            if (iArr.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.spineIndex), Arrays.toString(iArr)});
            }
            return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.spineIndex), Arrays.toString(Arrays.copyOf(iArr, 200))});
        }
    }

    /*  JADX ERROR: Inner class code generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:274)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:249)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:238)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: RETURN  
          (wrap: j$.util.stream.SpinedBuffer$OfLong$1Splitr : 0x000a: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfLong$1Splitr) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfLong A[THIS])
          (0 int)
          (wrap: int : 0x0002: IGET  (r3v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfLong A[THIS]) j$.util.stream.AbstractSpinedBuffer.spineIndex int)
          (0 int)
          (wrap: int : 0x0004: IGET  (r5v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfLong A[THIS]) j$.util.stream.AbstractSpinedBuffer.elementIndex int)
         call: j$.util.stream.SpinedBuffer.OfLong.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfLong, int, int, int, int):void type: CONSTRUCTOR)
         in method: j$.util.stream.SpinedBuffer.OfLong.spliterator():j$.util.Spliterator$OfLong, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
        	... 35 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfLong$1Splitr) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfLong A[THIS])
          (0 int)
          (wrap: int : 0x0002: IGET  (r3v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfLong A[THIS]) j$.util.stream.AbstractSpinedBuffer.spineIndex int)
          (0 int)
          (wrap: int : 0x0004: IGET  (r5v0 int) = (r7v0 'this' j$.util.stream.SpinedBuffer$OfLong A[THIS]) j$.util.stream.AbstractSpinedBuffer.elementIndex int)
         call: j$.util.stream.SpinedBuffer.OfLong.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfLong, int, int, int, int):void type: CONSTRUCTOR in method: j$.util.stream.SpinedBuffer.OfLong.spliterator():j$.util.Spliterator$OfLong, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:314)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	... 44 more
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:274)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
        	... 48 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: RETURN  
          (wrap: j$.util.stream.SpinedBuffer$OfLong$1Splitr : 0x0009: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfLong$1Splitr) = 
          (wrap: j$.util.stream.SpinedBuffer$OfLong : 0x0002: IGET  (r1v0 j$.util.stream.SpinedBuffer$OfLong) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfLong$1Splitr A[THIS])
         j$.util.stream.SpinedBuffer.OfLong.1Splitr.this$0 j$.util.stream.SpinedBuffer$OfLong)
          (r8v0 'i' int)
          (r9v0 'i2' int)
          (r10v0 'i3' int)
          (r11v0 'i4' int)
         call: j$.util.stream.SpinedBuffer.OfLong.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfLong, int, int, int, int):void type: CONSTRUCTOR)
         in method: j$.util.stream.SpinedBuffer.OfLong.1Splitr.newSpliterator(int, int, int, int):j$.util.Spliterator$OfPrimitive, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
        	... 65 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: CONSTRUCTOR  (r0v0 j$.util.stream.SpinedBuffer$OfLong$1Splitr) = 
          (wrap: j$.util.stream.SpinedBuffer$OfLong : 0x0002: IGET  (r1v0 j$.util.stream.SpinedBuffer$OfLong) = 
          (r7v0 'this' j$.util.stream.SpinedBuffer$OfLong$1Splitr A[THIS])
         j$.util.stream.SpinedBuffer.OfLong.1Splitr.this$0 j$.util.stream.SpinedBuffer$OfLong)
          (r8v0 'i' int)
          (r9v0 'i2' int)
          (r10v0 'i3' int)
          (r11v0 'i4' int)
         call: j$.util.stream.SpinedBuffer.OfLong.1Splitr.<init>(j$.util.stream.SpinedBuffer$OfLong, int, int, int, int):void type: CONSTRUCTOR in method: j$.util.stream.SpinedBuffer.OfLong.1Splitr.newSpliterator(int, int, int, int):j$.util.Spliterator$OfPrimitive, dex: classes2.dex
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:314)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
        	... 74 more
        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: j$.util.stream.SpinedBuffer.OfLong.1Splitr
        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:649)
        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
        	... 78 more
        */
    /* renamed from: j$.util.stream.SpinedBuffer$OfLong */
    class OfLong extends OfPrimitive implements LongConsumer {

        /* renamed from: j$.util.stream.SpinedBuffer$OfLong$1Splitr  reason: invalid class name */
        class AnonymousClass1Splitr extends OfPrimitive.BaseSpliterator implements Spliterator.OfLong {
            /* access modifiers changed from: package-private */
            public void arrayForOne(Object obj, int i, Object obj2) {
                ((LongConsumer) obj2).accept(((long[]) obj)[i]);
            }

            /* access modifiers changed from: package-private */
            public Spliterator.OfPrimitive arraySpliterator(Object obj, int i, int i2) {
                return Spliterators.spliterator((long[]) obj, i, i2 + i, 1040);
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Objects.$default$forEachRemaining((Spliterator.OfLong) this, consumer);
            }

            /* access modifiers changed from: package-private */
            public Spliterator.OfPrimitive newSpliterator(int i, int i2, int i3, int i4) {
                return new AnonymousClass1Splitr(i, i2, i3, i4);
            }

            public /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return Objects.$default$tryAdvance((Spliterator.OfLong) this, consumer);
            }
        }

        OfLong() {
        }

        OfLong(int i) {
            super(i);
        }

        public void accept(long j) {
            preAccept();
            int i = this.elementIndex;
            this.elementIndex = i + 1;
            ((long[]) this.curChunk)[i] = j;
        }

        /* access modifiers changed from: protected */
        public void arrayForEach(Object obj, int i, int i2, Object obj2) {
            long[] jArr = (long[]) obj;
            LongConsumer longConsumer = (LongConsumer) obj2;
            while (i < i2) {
                longConsumer.accept(jArr[i]);
                i++;
            }
        }

        /* access modifiers changed from: protected */
        public int arrayLength(Object obj) {
            return ((long[]) obj).length;
        }

        public void forEach(Consumer consumer) {
            if (consumer instanceof LongConsumer) {
                forEach((LongConsumer) consumer);
            } else if (!Tripwire.ENABLED) {
                spliterator().forEachRemaining(consumer);
            } else {
                Tripwire.trip(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
                throw null;
            }
        }

        public Iterator iterator() {
            return Spliterators.iterator(spliterator());
        }

        public Object newArray(int i) {
            return new long[i];
        }

        /* access modifiers changed from: protected */
        public Object[] newArrayArray(int i) {
            return new long[i][];
        }

        public Spliterator.OfLong spliterator() {
            return new AnonymousClass1Splitr(0, this.spineIndex, 0, this.elementIndex);
        }

        public String toString() {
            long[] jArr = (long[]) asPrimitiveArray();
            if (jArr.length < 200) {
                return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.spineIndex), Arrays.toString(jArr)});
            }
            return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.spineIndex), Arrays.toString(Arrays.copyOf(jArr, 200))});
        }
    }

    /* renamed from: j$.util.stream.SpinedBuffer$OfPrimitive */
    abstract class OfPrimitive extends AbstractSpinedBuffer implements Iterable, Iterable {
        Object curChunk = newArray(16);
        Object[] spine;

        /* renamed from: j$.util.stream.SpinedBuffer$OfPrimitive$BaseSpliterator */
        abstract class BaseSpliterator implements Spliterator.OfPrimitive {
            final int lastSpineElementFence;
            final int lastSpineIndex;
            Object splChunk;
            int splElementIndex;
            int splSpineIndex;

            BaseSpliterator(int i, int i2, int i3, int i4) {
                this.splSpineIndex = i;
                this.lastSpineIndex = i2;
                this.splElementIndex = i3;
                this.lastSpineElementFence = i4;
                Object[] objArr = OfPrimitive.this.spine;
                this.splChunk = objArr == null ? OfPrimitive.this.curChunk : objArr[i];
            }

            /* access modifiers changed from: package-private */
            public abstract void arrayForOne(Object obj, int i, Object obj2);

            /* access modifiers changed from: package-private */
            public abstract Spliterator.OfPrimitive arraySpliterator(Object obj, int i, int i2);

            public int characteristics() {
                return 16464;
            }

            public long estimateSize() {
                int i = this.splSpineIndex;
                int i2 = this.lastSpineIndex;
                if (i == i2) {
                    return ((long) this.lastSpineElementFence) - ((long) this.splElementIndex);
                }
                long[] jArr = OfPrimitive.this.priorElementCount;
                return ((jArr[i2] + ((long) this.lastSpineElementFence)) - jArr[i]) - ((long) this.splElementIndex);
            }

            public void forEachRemaining(Object obj) {
                int i;
                java.util.Objects.requireNonNull(obj);
                int i2 = this.splSpineIndex;
                int i3 = this.lastSpineIndex;
                if (i2 < i3 || (i2 == i3 && this.splElementIndex < this.lastSpineElementFence)) {
                    int i4 = this.splElementIndex;
                    while (true) {
                        i = this.lastSpineIndex;
                        if (i2 >= i) {
                            break;
                        }
                        OfPrimitive ofPrimitive = OfPrimitive.this;
                        Object obj2 = ofPrimitive.spine[i2];
                        ofPrimitive.arrayForEach(obj2, i4, ofPrimitive.arrayLength(obj2), obj);
                        i4 = 0;
                        i2++;
                    }
                    OfPrimitive.this.arrayForEach(this.splSpineIndex == i ? this.splChunk : OfPrimitive.this.spine[i], i4, this.lastSpineElementFence, obj);
                    this.splSpineIndex = this.lastSpineIndex;
                    this.splElementIndex = this.lastSpineElementFence;
                }
            }

            public Comparator getComparator() {
                throw new IllegalStateException();
            }

            public /* synthetic */ long getExactSizeIfKnown() {
                return Objects.$default$getExactSizeIfKnown(this);
            }

            public /* synthetic */ boolean hasCharacteristics(int i) {
                return Objects.$default$hasCharacteristics(this, i);
            }

            /* access modifiers changed from: package-private */
            public abstract Spliterator.OfPrimitive newSpliterator(int i, int i2, int i3, int i4);

            public boolean tryAdvance(Object obj) {
                java.util.Objects.requireNonNull(obj);
                int i = this.splSpineIndex;
                int i2 = this.lastSpineIndex;
                if (i >= i2 && (i != i2 || this.splElementIndex >= this.lastSpineElementFence)) {
                    return false;
                }
                Object obj2 = this.splChunk;
                int i3 = this.splElementIndex;
                this.splElementIndex = i3 + 1;
                arrayForOne(obj2, i3, obj);
                if (this.splElementIndex == OfPrimitive.this.arrayLength(this.splChunk)) {
                    this.splElementIndex = 0;
                    int i4 = this.splSpineIndex + 1;
                    this.splSpineIndex = i4;
                    Object[] objArr = OfPrimitive.this.spine;
                    if (objArr != null && i4 <= this.lastSpineIndex) {
                        this.splChunk = objArr[i4];
                    }
                }
                return true;
            }

            public Spliterator.OfPrimitive trySplit() {
                int i = this.splSpineIndex;
                int i2 = this.lastSpineIndex;
                if (i < i2) {
                    int i3 = this.splElementIndex;
                    OfPrimitive ofPrimitive = OfPrimitive.this;
                    Spliterator.OfPrimitive newSpliterator = newSpliterator(i, i2 - 1, i3, ofPrimitive.arrayLength(ofPrimitive.spine[i2 - 1]));
                    int i4 = this.lastSpineIndex;
                    this.splSpineIndex = i4;
                    this.splElementIndex = 0;
                    this.splChunk = OfPrimitive.this.spine[i4];
                    return newSpliterator;
                } else if (i != i2) {
                    return null;
                } else {
                    int i5 = this.lastSpineElementFence;
                    int i6 = this.splElementIndex;
                    int i7 = (i5 - i6) / 2;
                    if (i7 == 0) {
                        return null;
                    }
                    Spliterator.OfPrimitive arraySpliterator = arraySpliterator(this.splChunk, i6, i7);
                    this.splElementIndex += i7;
                    return arraySpliterator;
                }
            }
        }

        OfPrimitive() {
        }

        OfPrimitive(int i) {
            super(i);
        }

        private void inflateSpine() {
            if (this.spine == null) {
                Object[] newArrayArray = newArrayArray(8);
                this.spine = newArrayArray;
                this.priorElementCount = new long[8];
                newArrayArray[0] = this.curChunk;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void arrayForEach(Object obj, int i, int i2, Object obj2);

        /* access modifiers changed from: protected */
        public abstract int arrayLength(Object obj);

        public Object asPrimitiveArray() {
            long count = count();
            if (count < 2147483639) {
                Object newArray = newArray((int) count);
                copyInto(newArray, 0);
                return newArray;
            }
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }

        /* access modifiers changed from: protected */
        public long capacity() {
            int i = this.spineIndex;
            if (i == 0) {
                return (long) arrayLength(this.curChunk);
            }
            return ((long) arrayLength(this.spine[i])) + this.priorElementCount[i];
        }

        /* access modifiers changed from: protected */
        public int chunkFor(long j) {
            if (this.spineIndex == 0) {
                if (j < ((long) this.elementIndex)) {
                    return 0;
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else if (j < count()) {
                for (int i = 0; i <= this.spineIndex; i++) {
                    if (j < this.priorElementCount[i] + ((long) arrayLength(this.spine[i]))) {
                        return i;
                    }
                }
                throw new IndexOutOfBoundsException(Long.toString(j));
            } else {
                throw new IndexOutOfBoundsException(Long.toString(j));
            }
        }

        public void clear() {
            Object[] objArr = this.spine;
            if (objArr != null) {
                this.curChunk = objArr[0];
                this.spine = null;
                this.priorElementCount = null;
            }
            this.elementIndex = 0;
            this.spineIndex = 0;
        }

        public void copyInto(Object obj, int i) {
            long j = (long) i;
            long count = count() + j;
            if (count > ((long) arrayLength(obj)) || count < j) {
                throw new IndexOutOfBoundsException("does not fit");
            } else if (this.spineIndex == 0) {
                System.arraycopy(this.curChunk, 0, obj, i, this.elementIndex);
            } else {
                for (int i2 = 0; i2 < this.spineIndex; i2++) {
                    Object[] objArr = this.spine;
                    System.arraycopy(objArr[i2], 0, obj, i, arrayLength(objArr[i2]));
                    i += arrayLength(this.spine[i2]);
                }
                int i3 = this.elementIndex;
                if (i3 > 0) {
                    System.arraycopy(this.curChunk, 0, obj, i, i3);
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void ensureCapacity(long j) {
            long capacity = capacity();
            if (j > capacity) {
                inflateSpine();
                int i = this.spineIndex;
                while (true) {
                    i++;
                    if (j > capacity) {
                        Object[] objArr = this.spine;
                        if (i >= objArr.length) {
                            int length = objArr.length * 2;
                            this.spine = Arrays.copyOf(objArr, length);
                            this.priorElementCount = Arrays.copyOf(this.priorElementCount, length);
                        }
                        int chunkSize = chunkSize(i);
                        this.spine[i] = newArray(chunkSize);
                        long[] jArr = this.priorElementCount;
                        int i2 = i - 1;
                        jArr[i] = jArr[i2] + ((long) arrayLength(this.spine[i2]));
                        capacity += (long) chunkSize;
                    } else {
                        return;
                    }
                }
            }
        }

        public void forEach(Object obj) {
            for (int i = 0; i < this.spineIndex; i++) {
                Object[] objArr = this.spine;
                arrayForEach(objArr[i], 0, arrayLength(objArr[i]), obj);
            }
            arrayForEach(this.curChunk, 0, this.elementIndex, obj);
        }

        public abstract Object newArray(int i);

        /* access modifiers changed from: protected */
        public abstract Object[] newArrayArray(int i);

        /* access modifiers changed from: protected */
        public void preAccept() {
            if (this.elementIndex == arrayLength(this.curChunk)) {
                inflateSpine();
                int i = this.spineIndex;
                int i2 = i + 1;
                Object[] objArr = this.spine;
                if (i2 >= objArr.length || objArr[i + 1] == null) {
                    ensureCapacity(capacity() + 1);
                }
                this.elementIndex = 0;
                int i3 = this.spineIndex + 1;
                this.spineIndex = i3;
                this.curChunk = this.spine[i3];
            }
        }

        public abstract Spliterator spliterator();
    }

    SpinedBuffer() {
    }

    private void inflateSpine() {
        if (this.spine == null) {
            Object[][] objArr = new Object[8][];
            this.spine = objArr;
            this.priorElementCount = new long[8];
            objArr[0] = this.curChunk;
        }
    }

    public void accept(Object obj) {
        if (this.elementIndex == this.curChunk.length) {
            inflateSpine();
            int i = this.spineIndex;
            int i2 = i + 1;
            Object[][] objArr = this.spine;
            if (i2 >= objArr.length || objArr[i + 1] == null) {
                ensureCapacity(capacity() + 1);
            }
            this.elementIndex = 0;
            int i3 = this.spineIndex + 1;
            this.spineIndex = i3;
            this.curChunk = this.spine[i3];
        }
        Object[] objArr2 = this.curChunk;
        int i4 = this.elementIndex;
        this.elementIndex = i4 + 1;
        objArr2[i4] = obj;
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    /* access modifiers changed from: protected */
    public long capacity() {
        int i = this.spineIndex;
        if (i == 0) {
            return (long) this.curChunk.length;
        }
        return ((long) this.spine[i].length) + this.priorElementCount[i];
    }

    public void clear() {
        Object[][] objArr = this.spine;
        if (objArr != null) {
            this.curChunk = objArr[0];
            int i = 0;
            while (true) {
                Object[] objArr2 = this.curChunk;
                if (i >= objArr2.length) {
                    break;
                }
                objArr2[i] = null;
                i++;
            }
            this.spine = null;
            this.priorElementCount = null;
        } else {
            for (int i2 = 0; i2 < this.elementIndex; i2++) {
                this.curChunk[i2] = null;
            }
        }
        this.elementIndex = 0;
        this.spineIndex = 0;
    }

    public void copyInto(Object[] objArr, int i) {
        long j = (long) i;
        long count = count() + j;
        if (count > ((long) objArr.length) || count < j) {
            throw new IndexOutOfBoundsException("does not fit");
        } else if (this.spineIndex == 0) {
            System.arraycopy(this.curChunk, 0, objArr, i, this.elementIndex);
        } else {
            for (int i2 = 0; i2 < this.spineIndex; i2++) {
                Object[][] objArr2 = this.spine;
                System.arraycopy(objArr2[i2], 0, objArr, i, objArr2[i2].length);
                i += this.spine[i2].length;
            }
            int i3 = this.elementIndex;
            if (i3 > 0) {
                System.arraycopy(this.curChunk, 0, objArr, i, i3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void ensureCapacity(long j) {
        long capacity = capacity();
        if (j > capacity) {
            inflateSpine();
            int i = this.spineIndex;
            while (true) {
                i++;
                if (j > capacity) {
                    Object[][] objArr = this.spine;
                    if (i >= objArr.length) {
                        int length = objArr.length * 2;
                        this.spine = (Object[][]) Arrays.copyOf(objArr, length);
                        this.priorElementCount = Arrays.copyOf(this.priorElementCount, length);
                    }
                    int chunkSize = chunkSize(i);
                    Object[][] objArr2 = this.spine;
                    objArr2[i] = new Object[chunkSize];
                    long[] jArr = this.priorElementCount;
                    int i2 = i - 1;
                    jArr[i] = jArr[i2] + ((long) objArr2[i2].length);
                    capacity += (long) chunkSize;
                } else {
                    return;
                }
            }
        }
    }

    public void forEach(Consumer consumer) {
        for (int i = 0; i < this.spineIndex; i++) {
            for (Object accept : this.spine[i]) {
                consumer.accept(accept);
            }
        }
        for (int i2 = 0; i2 < this.elementIndex; i2++) {
            consumer.accept(this.curChunk[i2]);
        }
    }

    public /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(C$r8$wrapper$java$util$function$Consumer$VWRP.convert(consumer));
    }

    public Iterator iterator() {
        return Spliterators.iterator(spliterator());
    }

    public Spliterator spliterator() {
        return new AnonymousClass1Splitr(0, this.spineIndex, 0, this.elementIndex);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        forEach(new SpinedBuffer$$ExternalSyntheticLambda0((List) arrayList));
        return "SpinedBuffer:" + arrayList.toString();
    }
}
