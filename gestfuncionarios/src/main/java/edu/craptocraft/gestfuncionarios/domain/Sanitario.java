package edu.craptocraft.gestfuncionarios.domain;

public class Sanitario extends Persona {
    String especialidad;
    int diasTrabajados;

    public Sanitario(int id, String nombre, String primerApellido, String segundoApellido,
            String especialidad, int diasTrabajados) {

        super(id, nombre, primerApellido, segundoApellido);
        Persona.contador += 1;
        this.especialidad = especialidad;
        this.diasTrabajados = diasTrabajados;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    @Override
    public String toString() {
        StringBuilder informacion = new StringBuilder();

        informacion.append("\nID: " + this.getId());
        informacion.append("\nNombre: " + this.getNombre());
        informacion.append("\nApellido1: " + this.getPrimerApellido());
        informacion.append("\nApellido2: " + this.getSegundoApellido());
        informacion.append("\nTitulación: " + this.getEspecialidad());
        informacion.append("\nPuntos: " + this.getDiasTrabajados());

        return informacion.toString();
    }
}
