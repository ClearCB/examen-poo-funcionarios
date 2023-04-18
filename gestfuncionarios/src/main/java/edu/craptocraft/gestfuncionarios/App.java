package edu.craptocraft.gestfuncionarios;

import java.util.ArrayList;
import java.util.List;

import edu.craptocraft.gestfuncionarios.domain.Docente;
import edu.craptocraft.gestfuncionarios.domain.GestFuncionarios;
import edu.craptocraft.gestfuncionarios.domain.Persona;
import edu.craptocraft.gestfuncionarios.domain.Plaza;
import edu.craptocraft.gestfuncionarios.domain.Sanitario;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        GestFuncionarios gestion = new GestFuncionarios();

        List<Persona> trabajadores = new ArrayList<Persona>();
        Persona maria = new Docente(9, "maria", "app1", "app2", "Crack", 2);
        Persona pepe = new Docente(1, "pepe", "app1", "app2", "Crack", 4);
        Persona juan = new Docente(2, "juan", "app1", "app2", "Crack", 5);
        Persona julia = new Sanitario(3, "julia", "app1", "app2", "Crack", 6);
        Persona luisa = new Sanitario(6, "luisa", "app1", "app2", "Crack", 8);

        trabajadores.add(maria);
        trabajadores.add(pepe);
        trabajadores.add(juan);
        trabajadores.add(julia);
        trabajadores.add(luisa);

        List<Plaza> plazas = new ArrayList<Plaza>();

        Plaza plazaUno = new Plaza(1, "D");
        Plaza plazaDos = new Plaza(2, "S");
        Plaza plazaTres = new Plaza(3, "S");
        Plaza plazaCuatro = new Plaza(4, "D");
        Plaza plazaCinco = new Plaza(5, "D");
        Plaza plazaSix = new Plaza(5, "D");
        Plaza plazaSiete = new Plaza(5, "D");
        Plaza plazaOcho = new Plaza(5, "D");

        plazas.add(plazaUno);
        plazas.add(plazaDos);
        plazas.add(plazaTres);
        plazas.add(plazaCuatro);
        plazas.add(plazaCinco);
        plazas.add(plazaSix);
        plazas.add(plazaSiete);
        plazas.add(plazaOcho);

        gestion.adjudicarPlazas(trabajadores, plazas);

    }
}
