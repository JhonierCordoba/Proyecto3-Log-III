package Modelos;

import java.util.ArrayList;

public class MatrizAdyacente {
    
    
    MatrizForma1 p;
    
    public MatrizAdyacente(int n) {
        this.p = new MatrizForma1(n, n);
        p.contruyeNodosCabeza();
    }
    
    public MatrizForma1 retornaM1(){
        return p;
    }
    
    public int retornaNv(){
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
    }

    public ArrayList DFS(int v){
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> o;
        o = this.p.DFS(v, l);
        return o;
    }

    public ArrayList BFS(int v){
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> o = new ArrayList<>();
        o = this.p.BFS(v, l, o);
        return o;
    }
}
