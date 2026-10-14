package Simulador;
import Entidades.Equipo;
import java.util.List;
import java.util.ArrayList;

public class JuezCombate {
    private List<String> logMatch;

    // Constructor
    public JuezCombate() {
        this.logMatch = new ArrayList<>();
    }

    public Equipo simularMatch(Equipo equipo1, Equipo equipo2) {
        // Lógica para simular el combate entre los dos equipos
        // Se puede implementar un bucle que continúe hasta que uno de los equipos pierda todos sus Javaling
        // Durante cada turno, se pueden registrar las acciones en logMatch
        // Al final, se devuelve el equipo ganado
        return equipo1; //temporal para que compile, se debe reemplazar con la lógica real
    }

    private class RegistroTurno {
        private int numeroTurno;
        private List<String> eventosDelTurno;

        public RegistroTurno(int numeroTurno) {
            this.numeroTurno = numeroTurno;
            this.eventosDelTurno = new ArrayList<>();
        }

        public void registrarEstado(String evento) {
            eventosDelTurno.add("[ESTADO]" + evento);
        }

        public void registrarCambio(String evento) {
            eventosDelTurno.add("[CAMBIO]" + evento);
        }

        public void registrarAtaque(String evento) {
            eventosDelTurno.add("[ATAQUE]" + evento);
        }

        public void registrarKO(String evento) {
            eventosDelTurno.add("[KO]" + evento);
        }
    }
}
