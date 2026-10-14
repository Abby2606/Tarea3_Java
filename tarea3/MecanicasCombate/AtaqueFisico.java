package MecanicasCombate;
import Entidades.Javaling;

public class AtaqueFisico extends Ataque {
    private int potencia;

    // Constructor
    public AtaqueFisico(String nombre, TipoElemental tipo, int potencia) {
        super(nombre, tipo);
        this.potencia = potencia;
    }

    // Getter
    public int getPotencia() {return potencia;}

    private double calcDanoFisico(int atk, int def) {
        return 0.0;//Logica pendiente
    }

    @Override
    public int ejecutar(Javaling atacante, Javaling defensor) {
        // Implementación del ataque físico
        return 0; // Retorna el daño calculado
    }

}
