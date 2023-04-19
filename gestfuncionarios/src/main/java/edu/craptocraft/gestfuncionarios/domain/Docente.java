package edu.craptocraft.gestfuncionarios.domain;

public class Docente extends Persona {
    String titulacion;
    double puntos;

    public Docente(String nombre, String primerApellido, String segundoApellido,
            String titulacion, double puntos) {

        super(nombre, primerApellido, segundoApellido);
        Persona.contador += 1;
        this.titulacion = titulacion;
        this.puntos = puntos;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        StringBuilder informacion = new StringBuilder();

        informacion.append("\nID: " + this.getId());
        informacion.append("\nNombre: " + this.getNombre());
        informacion.append("\nApellido1: " + this.getPrimerApellido());
        informacion.append("\nApellido2: " + this.getSegundoApellido());
        informacion.append("\nTitulación: " + this.getTitulacion());
        informacion.append("\nPuntos: " + this.getPuntos());

        return informacion.toString();
    }
}
