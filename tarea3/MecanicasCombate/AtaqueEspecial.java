package MecanicasCombate;
import Entidades.Javaling;

public class AtaqueEspecial extends Ataque {
    private int potencia;

    // Constructor
    public AtaqueEspecial(String nombre, TipoElemental tipo, int potencia) {
        super(nombre, tipo);
        this.potencia = potencia;
    }

    // Getter
    public int getPotencia() {return potencia;}

    private double calcDanoEspecial(int atkEsp, int defEsp) {
        return 0.0;//Logica pendiente
    }

    @Override
    public int ejecutar(Javaling atacante, Javaling defensor) {
        // Implementación del ataque especial
        return 0; // Retorna el daño calculado
    }

}
