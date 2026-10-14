package MecanicasCombate;
import Entidades.Javaling;

public abstract class Ataque {
    protected String nombre;
    protected TipoElemental tipo;

    //Constructor y getters
    public Ataque(String nombre, TipoElemental tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoElemental getTipo() {
        return tipo;
    }

    //metodo ejecutar(atacante, defensor) se implementa en las subclases segun corresponda
    public abstract int ejecutar(Javaling atacante, Javaling defensor);
}
