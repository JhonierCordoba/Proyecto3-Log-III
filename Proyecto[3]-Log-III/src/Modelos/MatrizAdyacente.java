package Modelos;

public class MatrizAdyacente {
    
    
    int[][] m;
    
    /**
     * @param tipo 0: MatrizEnTripletas, 1:MatrizEnForma1, 2:MatrizEnForma2
     */
    public MatrizAdyacente(int tipo) {
    }
    
    public void agregarConexion(int i, int j) {
        System.out.println("primero: " + i + "segundo: " + j);
        this.m[i][j] = 1;
        this.m[j][i] = 1;
    }

    public void tamaño_Ma(int n){
        this.m = new int[n][n];
    }
}
