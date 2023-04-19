package edu.craptocraft.gestfuncionarios.domain;

public class Persona {
    int id;
    String nombre;
    String primerApellido;
    String segundoApellido;
    public static int contador = 1;

    public Persona(String nombre, String primerApellido, String segundoApellido) {
        this.id = Persona.contador;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    @Override
    public String toString() {
        StringBuilder informacion = new StringBuilder();

        informacion.append("\nID: " + this.getId());
        informacion.append("\nNombre: " + this.getNombre());
        informacion.append("\nApellido1: " + this.getPrimerApellido());
        informacion.append("\nApellido2: " + this.getSegundoApellido());

        return informacion.toString();
    }

}
