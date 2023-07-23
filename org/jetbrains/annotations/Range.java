package org.jetbrains.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE_USE})
@Retention(RetentionPolicy.CLASS)
public @interface Range {
    long from();

    /* renamed from: to */
    long mo43743to();
}
