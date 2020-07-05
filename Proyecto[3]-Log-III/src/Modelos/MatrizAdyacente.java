package Modelos;

import java.util.ArrayList;
import java.util.Stack;

public class MatrizAdyacente {
    
    
    private MatrizForma1 p;
    private int lados = 0;
    
    public MatrizAdyacente(int n) {
        this.p = new MatrizForma1(n, n);
        p.contruyeNodosCabeza();
    }
    
    public MatrizForma1 retornaM1() {
        return p;
    }
    
    public int retornaNv() {
        return this.p.retornaNumeroFilas();
    }
    
    public void agregarConexion(int i, int j, int price) {
        Tripleta t = new Tripleta(i, j, price);
        NodoDoble x = new NodoDoble(t);
        this.p.conectaPorFilas(x);
        this.p.conectaPorColumnas(x);
        t = new Tripleta(j, i, price);
        x = new NodoDoble(t);
        this.p.conectaPorFilas(x);
        this.p.conectaPorColumnas(x);
        this.lados++;
    }
    
    public ArrayList DFS(int v) {
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> o;
        o = this.p.DFS(v, l);
        return o;
    }
    
    public ArrayList BFS(int v) {
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> o = new ArrayList<>();
        o = this.p.BFS(v, l, o);
        return o;
    }

    public boolean esConectado(){
        int v = 1;
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> o;
        o = this.p.DFS(v, l);
        return o.size() == this.p.retornaNumeroFilas();
    }

    public int retornaLados(){
        return this.lados;
    }

    public boolean esCiclico(){
        return retornaLados() >= this.p.retornaNumeroFilas();
    }

    public boolean esLibre(){
        return esConectado() && !esCiclico();
    }

    public ArrayList puntosdeArticulacion(){
        ArrayList<Integer> j = new ArrayList<>();
        MatrizAdyacente l = this;
        for(int i = 0; i < this.retornaNv(); i++) {
            l.retornaM1().eliminarNodoCabeza(i);
            if (l.esConectado()){
                j.add(i);
            }
            i++;
        }
        return j;
    }
}
