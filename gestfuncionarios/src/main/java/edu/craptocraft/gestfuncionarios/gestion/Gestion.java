package edu.craptocraft.gestfuncionarios.gestion;

import java.util.List;

import edu.craptocraft.gestfuncionarios.domain.Persona;
import edu.craptocraft.gestfuncionarios.domain.Plaza;

public interface Gestion {

    void adjudicarPlazas(List<Persona> personas, List<Plaza> plazas);

    void mostrarAdjudicaciones(List<Plaza> adjudicaciones);

}
