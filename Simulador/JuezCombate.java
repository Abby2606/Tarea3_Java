package Simulador;
import Entidades.*;
import MecanicasCombate.*;
import java.util.List;
import java.util.ArrayList;

public class JuezCombate {
    private List<String> logMatch;

    // Constructor
    public JuezCombate() {
        this.logMatch = new ArrayList<>();
    }

    public Equipo simularMatch(Equipo local, Equipo visitante) {
        // Lógica para simular el combate entre los dos equipos
        // Se puede implementar un bucle que continúe hasta que uno de los equipos pierda todos sus Javaling
        // Durante cada turno, se pueden registrar las acciones en logMatch
        // Al final, se devuelve el equipo ganado
        return local; //temporal para que compile, se debe reemplazar con la lógica real
    }

    private class RegistroTurno {
        private int numeroTurno;
        private List<String> eventosDelTurno;

        // Constructor
        public RegistroTurno(int numeroTurno) {
            this.numeroTurno = numeroTurno;
            this.eventosDelTurno = new ArrayList<>();
            GestorTorneo.escribirArchivo("Turno " + numeroTurno, true);
        }

        // Getters
        public List<String> getEventosDelTurno() {return eventosDelTurno;}
        public int getNumeroTurno() {return numeroTurno;}

        // Métodos
        public void registrarEntra(String evento){
            String mensaje = "[ENTRA] " + evento;
            eventosDelTurno.add(mensaje);
            logMatch.add(mensaje);
            GestorTorneo.escribirArchivo(mensaje, true);
        }
        public void registrarEstado(String evento) {
            String mensaje = "[ESTADO] " + evento;
            eventosDelTurno.add(mensaje);
            logMatch.add(mensaje);
            GestorTorneo.escribirArchivo(mensaje, true);
        }

        public void registrarCambio(String evento) {
            String mensaje = "[CAMBIO] " + evento;
            eventosDelTurno.add(mensaje);
            logMatch.add(mensaje);
            GestorTorneo.escribirArchivo(mensaje, true);
        }

        public void registrarAtaque(String evento) {
            String mensaje = "[ATAQUE] " + evento;
            eventosDelTurno.add(mensaje);
            logMatch.add(mensaje);
            GestorTorneo.escribirArchivo(mensaje, true);
        }

        public void registrarKO(String evento) {
            String mensaje = "[KO] " + evento;
            eventosDelTurno.add(mensaje);
            logMatch.add(mensaje);
            GestorTorneo.escribirArchivo(mensaje, true);
        }
    }
}
