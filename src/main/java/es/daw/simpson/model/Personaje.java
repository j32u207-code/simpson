package es.daw.simpson.model;

/**
 * Record (Java 16+)
 * Pensada para solo guardar datos
 * Los getters no llevan getX() ytiene equals,hashcode,toString...
 *
 * Son INMUTABLES: una vez creado el personaje, no se puede cambiar
 */
public record Personaje(
    String nombre,
    String apellido,
    int edad,
    String ocupacion,
    String lugar,
    boolean principal

) {

    //Puede haber metodos...
    public String nombreCompleto(){
        return apellido.isBlank()? nombre :nombre + " " + apellido;

    }

    public boolean esMenor(){
        return edad < 18;

    }
}
