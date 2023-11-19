package Annotation;

public @interface MyFirstAnnotation {
    String author() default "John Doe";
    String description() default "A simple custom annotation";
    int version() default 1;
}
