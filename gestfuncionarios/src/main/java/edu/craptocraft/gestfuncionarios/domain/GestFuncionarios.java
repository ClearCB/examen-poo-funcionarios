package edu.craptocraft.gestfuncionarios.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.RowFilter.Entry;

public class GestFuncionarios implements Gestion {

    List<Plaza> adjudicacionesDocentes = new ArrayList<Plaza>();
    List<Plaza> adjudicacionesSanitarios = new ArrayList<Plaza>();

    public GestFuncionarios() {
    };

    @Override
    public void adjudicarPlazas(List<Persona> personas, List<Plaza> plazas) {

        for (Plaza plaza : plazas) {

            for (Persona persona : personas) {

                if (persona instanceof Docente && plaza.getTipoPlaza().equals("D")) {

                    plaza.setPersona(persona);
                    plaza.setAdjudicada(true);
                    this.adjudicacionesDocentes.add(plaza);
                    break;
                }

                if (persona instanceof Sanitario && plaza.getTipoPlaza().equals("S")) {

                    plaza.setPersona(persona);
                    plaza.setAdjudicada(true);
                    this.adjudicacionesSanitarios.add(plaza);
                    break;
                }
            }
        }

        System.out.println("============================================");
        System.out.println("La última adjudicación de plazas ha producido");
        System.out.println("los siguientes resultados para DOCENTES");
        System.out.println("============================================");

        mostrarAdjudicaciones(this.adjudicacionesDocentes);

        System.out.println("============================================");
        System.out.println("La última adjudicación de plazas ha producido");
        System.out.println("los siguientes resultados para SANITARIOS");
        System.out.println("============================================");

        mostrarAdjudicaciones(this.adjudicacionesSanitarios);
    }

    public void mostrarAdjudicaciones(List<Plaza> adjudicaciones) {

        adjudicaciones.stream().forEach(
                adjudicacion -> System.out.println(adjudicacion.toString() + adjudicacion.getPersona().toString()));
    }

}
