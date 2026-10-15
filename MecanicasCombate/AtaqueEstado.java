package MecanicasCombate;
import Entidades.Javaling;

public class AtaqueEstado extends Ataque {
    private String statAfectado;
    private Boolean fueUsado;
    private double multiplicador;

    // Constructor
    public AtaqueEstado(String nombre, TipoElemental tipo, String statAfectado, double multiplicador) {
        super(nombre, tipo);
        this.statAfectado = statAfectado;
        this.fueUsado = false;
        this.multiplicador = multiplicador;
    }
    // Getter
    public String getStatAfectado() {return statAfectado;}

    private void aplicarCambio(Javaling atacante) {
        this.fueUsado = true;
        // Aquí se implementaría la lógica para aplicar el cambio de estado al atacante.
    }


    @Override
    public int ejecutar(Javaling atacante, Javaling defensor) {
        aplicarCambio(atacante);
        // Según las reglas del juego, los ataques de estado solo se pueden usar una vez
        // por Javaling en todo el combate. Habrá que agregar una condición aquí
        // (ej: if (this.fueUsado) { return 0; // o bloquear la acción }) para impedir
        // que se vuelva a ejecutar en turnos posteriores.
        return 0;
    }

}
