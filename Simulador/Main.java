package Simulador;

import Entidades.Equipo;
import MecanicasCombate.Ataque;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args){

        if (args.length < 2) {
            System.err.println("Archivos necesarios movimientos.json equipos.json");
            return;
        }

        Map<String, Ataque> catalogo = Lector.cargarMovimientos(args[0]);
        List<Equipo> equipos = Lector.cargarEquipos(args[1], catalogo);

        if (equipos.isEmpty()) {
            System.err.println("Error: No se pudieron cargar los equipos.");
            return;
        }

        GestorTorneo torneo = new GestorTorneo(equipos);
        torneo.iniciarTorneo();
    }
}
