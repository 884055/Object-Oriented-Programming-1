package it.unive.dais.po1.vehicles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target( {
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.PARAMETER
})
public @interface Speed {
    String type() default "kmh";
    boolean forward();
}
