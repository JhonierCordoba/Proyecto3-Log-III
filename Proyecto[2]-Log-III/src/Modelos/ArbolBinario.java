package Modelos;

import java.util.Random;
import java.util.Stack;

public class ArbolBinario {
    private NodoDoble raiz;

    public void ArbolBinario() {

    }

    public void ArbolBinario(NodoDoble r) {
        this.raiz = r;
    }

    public void construirArbolAleatorio(String[] arreglo) {
        if (arreglo == null) {
            return;
        }
        this.raiz = new NodoDoble(arreglo[0]);
        Random rnd = new Random();
        NodoDoble p = this.raiz;
        NodoDoble ap = p;
        Boolean d = null;
        for (int i = 1; i < arreglo.length; i++) {
            while (p != null) {
                if (rnd.nextBoolean()) {
                    ap = p;
                    d = true;
                    p = p.retornaLD();
                } else {
                    ap = p;
                    d = false;
                    p = p.retornaLI();
                }
            }
            p = new NodoDoble(arreglo[i]);
            if (d == null) {
                return;
            }
            if (d) {
                ap.asignaLD(p);
            } else {
                ap.asignaLI(p);
            }
            p = this.raiz;
        }
    }

    public NodoDoble construirArbolVector(String[] vector, int i) {
        NodoDoble r = new NodoDoble(vector[i]);
        NodoDoble izq,der;
        try {
            izq =construirArbolVector(vector, this.retornaHijoIzquierdo(i));
            if(izq.retornaDato() != null){
                r.asignaLI(izq);
            }
        } catch (Exception e) {
            // Nada
        }
        try {
            der = construirArbolVector(vector, this.retornaHijoDerecho(i));
            if(der.retornaDato() != null){
                r.asignaLD(der);
            }
        } catch (Exception e) {
            // Nada
        }
        this.raiz = r;
        return r;
    }

    public int retornaHijoIzquierdo(int i) {
        int pos = 2 * (i + 1);
        return pos - 1;
    }

    public int retornaHijoDerecho(int i) {
        int pos = 2 * (i + 1) + 1;
        return pos - 1;
    }
}
