package Modelos;

public class MatrizAdyacente {
    
    
    MatrizForma1 p;
    
    public MatrizAdyacente(int n) {
        this.p = new MatrizForma1(n, n);
    }
    
    public void agregarConexion(int i, int j, int price) {
        Tripleta pt = new Tripleta(i, j, price);
        NodoDoble pn = new NodoDoble(pt);
        this.p.conectaPorFilas(pn);
        this.p.conectaPorColumnas(pn);
    }
}
