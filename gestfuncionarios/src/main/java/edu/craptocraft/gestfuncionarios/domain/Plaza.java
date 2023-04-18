package edu.craptocraft.gestfuncionarios.domain;

public class Plaza {
    int id;
    String tipoPlaza;
    boolean adjudicada = false;
    Persona persona = null;

    public Plaza(int id, String tipoPlaza) {
        this.id = id;
        this.tipoPlaza = tipoPlaza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoPlaza() {
        return tipoPlaza;
    }

    public void setTipoPlaza(String tipoPlaza) {
        this.tipoPlaza = tipoPlaza;
    }

    public boolean isAdjudicada() {
        return adjudicada;
    }

    public void setAdjudicada(boolean adjudicada) {
        this.adjudicada = adjudicada;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        StringBuilder informacion = new StringBuilder();

        informacion.append("\nID Plaza: " + this.getId());
        informacion.append("\nTipo: " + this.getTipoPlaza());
        informacion.append("\nAdjudicada: " + this.isAdjudicada());

        return informacion.toString();
    }

}
