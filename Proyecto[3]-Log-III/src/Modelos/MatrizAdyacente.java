package Modelos;

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
}
