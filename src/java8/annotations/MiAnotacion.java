package java8.annotations;

public @interface MiAnotacion {
    String nombre();
    boolean habilitado() default true;
}
