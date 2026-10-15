package Entidades;
import java.util.List;

public class Equipo {
    private String nombre;
    private List<Javaling> integrantes;
    private int indiceActivo;

    // Constructor
    public Equipo(String nombre, List<Javaling> integrantes) {
        this.nombre = nombre;
        this.integrantes = integrantes;
        this.indiceActivo = 0;
    }
    // Getters
    public String getNombre() {return nombre;}
    public List<Javaling> getIntegrantes() {return integrantes;}
    public int getIndiceActivo() {return indiceActivo;}
    public Javaling getJavalingActivo() {
        if (indiceActivo >= 0 && indiceActivo < integrantes.size()) {
            return integrantes.get(indiceActivo);
        }
        return null;
    }

    public void hacerCambio(int nuevoIndice) {
        if (nuevoIndice >= 0 && nuevoIndice < integrantes.size()) {
            this.indiceActivo = nuevoIndice;
        }
    }

    public boolean estaDerrotado() {
        for (Javaling i : integrantes) {
            if (!i.estaDebilitado()) {
                return false;
            }
        }
        return true;
    }

    public int obtenerSiguienteJavaling() {
        for (int i = 0; i < integrantes.size(); i++) {
            if (!integrantes.get(i).estaDebilitado()) {
                return i;
            }
        }
        return -1;
    }

}
