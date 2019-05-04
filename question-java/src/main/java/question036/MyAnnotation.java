package question036;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {

    enum Priority {LOW, MEDIUM, HIGH}

    enum Status {STARTED, NOT_STARTED}

    String author() default "poldi";

    Priority priority() default Priority.LOW;

    Status status() default Status.NOT_STARTED;
}
