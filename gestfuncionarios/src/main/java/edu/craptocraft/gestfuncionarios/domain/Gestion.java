package edu.craptocraft.gestfuncionarios.domain;

import java.util.List;
import java.util.Map;

public interface Gestion {

    void adjudicarPlazas(List<Persona> personas, List<Plaza> plazas);

    void mostrarAdjudicaciones(List<Plaza> adjudicaciones);

}
