package Simulador;
import Entidades.Equipo;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class GestorTorneo {
    private Queue<Equipo> bracket;
    private JuezCombate juez;

    public GestorTorneo(List<Equipo> equiposParticipantes) {
        this.bracket = new LinkedList<>(equiposParticipantes);
        this.juez = new JuezCombate();
    }

    public void iniciarTorneo() {
       // Lógica para iniciar el torneo, emparejando equipos y simulando combates hasta determinar un ganador
    }
}
