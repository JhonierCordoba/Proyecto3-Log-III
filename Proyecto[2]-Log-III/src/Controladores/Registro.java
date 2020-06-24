package Controladores;

import Modelos.ListaGeneralizada;

public class Registro {
    private String nombre;
    private Object dato;

    public Registro(String nombre,Object lg){
        this.nombre = nombre;
        this.dato = lg;
    }

    public String retornaNombre(){
        return this.nombre;
    }

    public ListaGeneralizada retornaLg(){
        return (ListaGeneralizada) this.dato;
    }
}
