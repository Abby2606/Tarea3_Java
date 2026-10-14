package Simulador;

import Entidades.*;
import MecanicasCombate.*;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lector {

    /* Este metodo permite cargar el catalogo (desde movimientos.json) de ataques y retornar un Map: nombre -> Ataque
        de esta forma se hace sencillo instanciar los ataques segun su categoria y entregarselos directamente a cada
        Javaling en base al nombre del ataque
    */
    public static Map<String, Ataque> cargarMovimientos(String rutaArchivos) {
        Map<String, Ataque> catalogoAtaques = new HashMap<>();
        Gson gson = new Gson();
        FileReader lector = null;

        try{
            lector = new FileReader(rutaArchivos);
            JsonArray jsonArray = gson.fromJson(lector, JsonArray.class);

            for(JsonElement ataque: jsonArray) {
                JsonObject clave = ataque.getAsJsonObject();
                String nombre = clave.get("nombre").getAsString();
                String categoria = clave.get("categoria").getAsString();

                Ataque nuevoAtaque = null;

                if (categoria.equals("Físico") || categoria.equals("Fisico") || categoria.equals("fisico") || categoria.equals("físico")) {
                    TipoElemental tipo = TipoElemental.valueOf(clave.get("elemento").getAsString().toUpperCase());
                    int potencia = clave.get("potencia").getAsInt();
                    nuevoAtaque = new AtaqueFisico(nombre, tipo, potencia);
                }

                else if (categoria.equals("Especial") || categoria.equals("especial")) {
                    TipoElemental tipo = TipoElemental.valueOf(clave.get("elemento").getAsString().toUpperCase());
                    int potencia = clave.get("potencia").getAsInt();
                    nuevoAtaque = new AtaqueEspecial(nombre, tipo, potencia);
                }

                else if (categoria.equals("Estado") || categoria.equals("estado")) {
                    String statAfectado = clave.get("stat_afectado").getAsString();
                    double multiplicador = clave.get("multiplicador").getAsDouble();
                    nuevoAtaque = new AtaqueEstado(nombre, null, statAfectado, multiplicador);
                }

                if (nuevoAtaque != null) {
                    catalogoAtaques.put(nombre, nuevoAtaque);
                }
            }
        }catch(Exception e){
            System.err.println("Error al leer el archivo movimientos.json");
        }finally {
            if (lector != null){
                try{
                    lector.close();
                }
                catch(IOException e){
                    System.err.println("Error al cerrar el archivo movimientos.json");
                }
            }
        }
        return catalogoAtaques;
    }

    /* Este método se encarga de leer equipos.json y generar las instancias de los Javalings de cada equipo para
        almacenarlos en una lista de equipos (List<Equipo>). Gracias al método cargarMovimientos, cada Javaling ya
        dispondrá de su objeto Ataque instanciado.
    */
    public static List<Equipo> cargarEquipos(String rutaArchivo, Map<String, Ataque> catalogoAtaques) {
        List<Equipo> listaEquipos = new ArrayList<>();
        Gson gson = new Gson();
        FileReader lector = null;

        try{
            lector = new FileReader(rutaArchivo);
            JsonArray jsonArray = gson.fromJson(lector, JsonArray.class);

            for(JsonElement equipos: jsonArray) {
                JsonObject equipo = equipos.getAsJsonObject();
                String nombreEquipo = equipo.get("nombre_equipo").getAsString();
                JsonArray javalings = equipo.getAsJsonArray("javalings");

                List<Javaling> integrantes = new ArrayList<>();

                for (JsonElement javatexto: javalings){
                    JsonObject javaling = javatexto.getAsJsonObject();

                    String nombre = javaling.get("nombre").getAsString();
                    String tipotexto = javaling.get("tipo").getAsString();
                    TipoElemental tipo = TipoElemental.valueOf(tipotexto.toUpperCase());

                    JsonObject stats = javaling.getAsJsonObject("stats");
                    int hp = stats.get("hp").getAsInt();
                    int ataque = stats.get("ataque").getAsInt();
                    int defensa = stats.get("defensa").getAsInt();
                    int ataqueEspecial = stats.get("ataque_especial").getAsInt();
                    int defensaEspecial = stats.get("defensa_especial").getAsInt();
                    int velocidad = stats.get("velocidad").getAsInt();

                    JsonArray ataquestexto = javaling.getAsJsonArray("movimientos");
                    List<Ataque> ataques = new ArrayList<>();

                    for(JsonElement ataquetexto: ataquestexto) {
                        String nombreataque = ataquetexto.getAsString();
                        if (catalogoAtaques.containsKey(nombreataque)) {
                            ataques.add(catalogoAtaques.get(nombreataque));
                        }
                        else {
                            System.out.println("El movimiento "+ nombreataque + " no existe");
                        }

                    }

                    Javaling javalingEquipo = new Javaling(nombre, tipo, hp, ataque, defensa, ataqueEspecial, defensaEspecial, velocidad, ataques);
                    integrantes.add(javalingEquipo);
                }

                Equipo equipoJavalings = new Equipo(nombreEquipo, integrantes);
                listaEquipos.add(equipoJavalings);
           }
        }catch(Exception e){
            System.err.println("Error al leer el archivo equipos.json");
            e.printStackTrace();
        }finally {
            if (lector != null){
                try{
                    lector.close();
                }
                catch(IOException e){
                    System.err.println("Error al cerrar el archivo equipos.json");
                }
            }
        }
        return listaEquipos;
    }
}
