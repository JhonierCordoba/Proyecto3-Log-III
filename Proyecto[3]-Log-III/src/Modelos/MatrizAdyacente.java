package Modelos;

public class MatrizAdyacente {
    
    
    MatrizEnTripletas mT;
    
    /**
     * @param tipo 0: MatrizEnTripletas, 1:MatrizEnForma1, 2:MatrizEnForma2
     */
    public MatrizAdyacente(int tipo) {
        switch (tipo) {
            case 0: {
                mT = new MatrizEnTripletas();
            }
        }
    }
    
    public void agregarConexion(int i, int j) {
        System.out.println("primero: " + i + "segundo: " + j);
    }
}
