package edu.craptocraft.gestfuncionarios.gestion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import edu.craptocraft.gestfuncionarios.domain.Docente;
import edu.craptocraft.gestfuncionarios.domain.Persona;
import edu.craptocraft.gestfuncionarios.domain.Plaza;
import edu.craptocraft.gestfuncionarios.domain.Sanitario;

public class GestFuncionarios implements Gestion {

    List<Plaza> adjudicacionesDocentes = new ArrayList<Plaza>();
    List<Plaza> adjudicacionesSanitarios = new ArrayList<Plaza>();
    List<Plaza> adjudicacionesVacias = new ArrayList<Plaza>();

    public GestFuncionarios() {
    };

    @Override
    public void adjudicarPlazas(List<Persona> personas, List<Plaza> plazas) {

        for (Plaza plaza : plazas) {

            Persona maxDocente = this.maxPuntos(personas);
            Persona maxSanitario = this.maxDiasTrabajados(personas);

            if (plaza.getTipoPlaza().equals("D") && !plaza.isAdjudicada() && maxDocente != null) {

                plaza.setPersona(maxDocente);
                plaza.setAdjudicada(true);
                personas.remove(maxDocente);
                this.adjudicacionesDocentes.add(plaza);
            }

            else if (plaza.getTipoPlaza().equals("S") && !plaza.isAdjudicada() && maxSanitario != null) {

                plaza.setPersona(maxSanitario);
                plaza.setAdjudicada(true);
                personas.remove(maxSanitario);
                this.adjudicacionesSanitarios.add(plaza);
            }

            else {

                this.adjudicacionesVacias.add(plaza);
            }

        }

        this.mostrar();
    }

    public Persona maxPuntos(List<Persona> personas) {

        Optional<Docente> maxDocente = personas.stream().filter(Docente.class::isInstance)
                .map(Docente.class::cast)
                .max(Comparator.comparing(Docente::getPuntos));

        return maxDocente.isPresent() ? maxDocente.get() : null;

    }

    public Persona maxDiasTrabajados(List<Persona> personas) {

        Optional<Sanitario> maxSanitario = personas.stream().filter(Sanitario.class::isInstance)
                .map(Sanitario.class::cast)
                .max(Comparator.comparing(Sanitario::getDiasTrabajados));

        return maxSanitario.isPresent() ? maxSanitario.get() : null;
    }

    public void mostrarAdjudicaciones(List<Plaza> adjudicaciones) {

        adjudicaciones.stream().filter(adjudicacion -> adjudicacion.getPersona() != null).forEach(
                adjudicacion -> System.out.println(adjudicacion.toString() + adjudicacion.getPersona().toString()));

        adjudicaciones.stream().filter(adjudicacion -> adjudicacion.getPersona() == null).forEach(
                adjudicacion -> System.out.println(adjudicacion.toString()));
    }

    public void mostrar() {

        System.out.println("============================================");
        System.out.println("La última adjudicación de plazas ha producido");
        System.out.println("los siguientes resultados para SANITARIOS");
        System.out.println("============================================");

        mostrarAdjudicaciones(this.adjudicacionesSanitarios);
        System.out.println("============================================");
        System.out.println("La última adjudicación de plazas ha producido");
        System.out.println("los siguientes resultados para DOCENTES");
        System.out.println("============================================");

        mostrarAdjudicaciones(this.adjudicacionesDocentes);

        System.out.println("============================================");
        System.out.println("La última adjudicación de plazas ha producido");
        System.out.println("los siguientes resultados dejando VACIAS:");
        System.out.println("============================================");

        mostrarAdjudicaciones(this.adjudicacionesVacias);

        System.out.println("\nTotal trabajadores: " + Persona.contador);

    }

    public static void simularAdjudicacion() {

        GestFuncionarios gestion = new GestFuncionarios();

        List<Persona> trabajadores = new ArrayList<Persona>();
        Persona maria = new Docente(9, "maria", "app1", "app2", "Crack", 2.0);
        Persona pepe = new Docente(1, "pepe", "app1", "app2", "Top", 4.3);
        Persona juan = new Docente(2, "juan", "app1", "app2", "Super Crack", 5.3);
        Persona julia = new Sanitario(3, "julia", "app1", "app2", "Mejor", 6);
        Persona luisa = new Sanitario(6, "luisa", "app1", "app2", "Super Crack", 8);
        Persona sofia = new Sanitario(3, "sofia", "app1", "app2", "Crack", 1);
        Persona nacho = new Sanitario(6, "nacho", "app1", "app2", "Super", 13);
        Persona francesc = new Sanitario(12, "francesc", "app1", "app2", "Super", 20);

        trabajadores.add(maria);
        trabajadores.add(pepe);
        trabajadores.add(juan);
        trabajadores.add(julia);
        trabajadores.add(luisa);
        trabajadores.add(sofia);
        trabajadores.add(nacho);
        trabajadores.add(francesc);

        List<Plaza> plazas = new ArrayList<Plaza>();

        Plaza plazaUno = new Plaza(1, "D");
        Plaza plazaDos = new Plaza(2, "S");
        Plaza plazaTres = new Plaza(3, "S");
        Plaza plazaCuatro = new Plaza(4, "D");
        Plaza plazaCinco = new Plaza(5, "S");
        Plaza plazaSeis = new Plaza(6, "S");
        Plaza plazaSiete = new Plaza(7, "D");
        Plaza plazaOcho = new Plaza(8, "D");
        Plaza plazaDiez = new Plaza(10, "D");

        plazas.add(plazaUno);
        plazas.add(plazaDos);
        plazas.add(plazaTres);
        plazas.add(plazaCuatro);
        plazas.add(plazaCinco);
        plazas.add(plazaSeis);
        plazas.add(plazaSiete);
        plazas.add(plazaOcho);
        plazas.add(plazaDiez);

        gestion.adjudicarPlazas(trabajadores, plazas);
    }
}
