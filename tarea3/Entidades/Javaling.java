package Entidades;
import MecanicasCombate.TipoElemental;
import MecanicasCombate.Ataque;
import MecanicasCombate.Vulnerable;
import java.util.List;

public class Javaling implements Vulnerable {
    public String nombre;
    private TipoElemental tipo;
    private int hpMaximo;
    private int hpActual;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int velocidad;
    private List <Ataque> movimientos;

    // Constructor
    public Javaling(String nombre, TipoElemental tipo, int hpMaximo, int ataque, int defensa, int ataqueEspecial, int defensaEspecial, int velocidad, List<Ataque> movimientos) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.hpMaximo = hpMaximo;
        this.hpActual = hpMaximo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.movimientos = movimientos;
    }

    // Getters de variables miembro
    public String getNombre() {return nombre;}
    public TipoElemental getTipo() {return tipo;}
    public int getHpMaximo() {return hpMaximo;}
    public int getHpActual() {return hpActual;}
    public int getAtaque() {return ataque;}
    public int getDefensa() {return defensa;}
    public int getAtaqueEspecial() {return ataqueEspecial;}
    public int getDefensaEspecial() {return defensaEspecial;}
    public int getVelocidad() {return velocidad;}
    public List<Ataque> getMovimientos() {return movimientos;}


    public boolean estaDebilitado() {
        return this.hpActual <= 0;
    }

    public void recibirDano(int dano) {
        this.hpActual -= dano;
        if (this.hpActual < 0) {
            this.hpActual = 0;
        }
    }

    @Override
    public double multiplicadorDebilidad(TipoElemental elementoAtaque) {
        //logica de tabla de tipos pendiente
        //Retorna el multiplicador (2.0, 0.5, 0.0 o 1.0) frente a un ataque entrante. en base a la tabla de tipos.
        //Por ejemplo, si el ataque es super efectivo, retorna 2.0; si es poco efectivo, retorna 0.5; si no tiene efecto, retorna 0.0; y si es neutral,
        return 1.0;
    }
}
