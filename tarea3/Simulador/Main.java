package Simulador;

import Entidades.Equipo;
import Entidades.Javaling;
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

        //Prueba carga Json
        System.out.println("=== PROBANDO CARGA DE MOVIMIENTOS ===");
        System.out.println("Total de movimientos cargados en el catálogo: " + catalogo.size());
        for (String nombreAtaque : catalogo.keySet()) {
            System.out.println(" - Movimiento: " + nombreAtaque + " [" + catalogo.get(nombreAtaque).getClass().getSimpleName() + "]");
        }

        System.out.println("\n=== PROBANDO CARGA DE EQUIPOS Y JAVALINGS ===");
        System.out.println("Total de equipos cargados: " + equipos.size());

        for (Equipo eq : equipos) {
            System.out.println("\n[EQUIPO] " + eq.getNombre());
            for (Javaling jav : eq.getIntegrantes()) {
                System.out.println("   --> Javaling: " + jav.getNombre() +
                                   " | Tipo: " + jav.getTipo() +
                                   " | HP: " + jav.getHpMaximo() +
                                   " | Velocidad: " + jav.getVelocidad());
                System.out.println("       Movimientos asignados (" + jav.getMovimientos().size() + "):");
                for (Ataque atk : jav.getMovimientos()) {
                    System.out.println("         * " + atk.getNombre());
                }
            }
        }

        System.out.println("\n=== VERIFICACIÓN DE ESTRUCTURA FINALIZADA ===");


        //GestorTorneo torneo = new GestorTorneo(equipos);
        //torneo.iniciarTorneo();
    }
}
