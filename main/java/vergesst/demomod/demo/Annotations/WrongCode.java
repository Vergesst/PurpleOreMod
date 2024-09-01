package vergesst.demomod.demo.Annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
//@Retention(RetentionPolicy.RUNTIME)
public @interface WrongCode {
    boolean value() default false;
}
