package Modelos;

public class MatrizAdyacente {
    
    
    MatrizEnTripletas mT;
//    MatrizEnForma1 m1;
//    MatrizEnForma2 m2;
    
    /**
     *
     * @param tipo 0: MatrizEnTripletas, 1:MatrizEnForma1, 2:MatrizEnForma2
     */
    public MatrizAdyacente(int tipo){
        switch (tipo){
            case 0:{
                mT = new MatrizEnTripletas();
            }
        }
    }
}
