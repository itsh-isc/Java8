package java8.annotations;

public @interface MiAnotacion {
    String nombre();
    String usuario() default "Ivan";
    boolean habilitado() default true;
}
