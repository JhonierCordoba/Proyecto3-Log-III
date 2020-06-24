package Modelos;

import java.util.Stack;

public class ArbolBinario {
    private NodoLg primero,ultimo;

    public void ConstruirArbol(String s){
        Stack pila = new Stack();
        NodoLg x = new NodoLg();
        this.primero = x;
        this.ultimo = x;
        int n = s.length();
        String dato = "";
        for (int i = 1; i < n - 1; i++) { // Se ignorarán los paréntesis frontera
            switch (s.charAt(i)) {
                default: {
                    dato += s.charAt(i);
                    break;
                }
                case ',': {
                    if (dato != null) {
                        this.ultimo.asignaDato(dato);
                    }
                    dato = "";
                    x = new NodoLg();
                    this.ultimo.asignaLiga(x);
                    ultimo = x;
                    break;
                }
                case '(': {
                    pila.push(ultimo);
                    x = new NodoLg();
                    ultimo.cambiaSw();
                    ultimo.asignaDato(x);
                    ultimo = x;
                    break;
                }
                case ')': {
                    if (dato != null) {
                        this.ultimo.asignaDato(dato);
                    }
                    dato = null;
                    ultimo = (NodoLg) pila.pop();
                    break;
                }
            }
    }
}}
