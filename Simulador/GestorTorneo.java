package Simulador;
import Entidades.Equipo;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorTorneo {
    private Queue<Equipo> bracket;
    private JuezCombate juez;

    // Constructor
    public GestorTorneo(List<Equipo> equiposParticipantes) {
        this.bracket = new LinkedList<>(equiposParticipantes);
        this.juez = new JuezCombate();
    }

    // Método
    public void iniciarTorneo() {
        if (bracket.isEmpty()) {
            System.out.println("No existen equipos inscritos en el torneo");
            return;
        }

        int numeroEnfrentamiento = 1;

        while (bracket.size() > 1) {
            Queue<Equipo> siguienteRonda = new LinkedList<>();

            while (!bracket.isEmpty()) {
                Equipo equipo1 = bracket.poll();
                Equipo equipo2 = bracket.poll();

                if(equipo2 != null){

                    String mensajeInicio = "[MATCH_INICIO] Enfrentamiento " + numeroEnfrentamiento + ": " + equipo1.getNombre() + " vs " + equipo2.getNombre();
                    escribirArchivo(mensajeInicio, false);

                    Equipo ganadorRonda = juez.simularMatch(equipo1, equipo2);
                    siguienteRonda.add(ganadorRonda);
                    numeroEnfrentamiento++;
                }
                else {
                    escribirArchivo("[INFO] " + equipo1.getNombre() + " avanza automáticamente por ausencia de rival.", true);
                    siguienteRonda.add(equipo1);
                }
            }
            bracket = siguienteRonda;
        }

        if (!bracket.isEmpty()) {
            Equipo ganador = bracket.poll();
            escribirArchivo("[TORNEO_FIN] Campeón del torneo: " + ganador.getNombre(), true);
        }
    }

    // Método util para la escritura en consola y en el archivo de salida resultados_torneo.txt
    public static void escribirArchivo(String texto, boolean mostrarEnConsola) {
        if (mostrarEnConsola) {
            System.out.println(texto);
        }
        try (PrintWriter out = new PrintWriter(new FileWriter("resultados_torneo.txt", true))) {
            out.println(texto);
        } catch (IOException e) {
            System.err.println("Error al escribir en resultados_torneo.txt: " + e.getMessage());
        }
    }
}
