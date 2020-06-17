package Root;

/**
 *
 * @author JuanZea
 */
public class Program {
    public static void main(String[] args) {

        Tripleta t1 = new Tripleta(2, 2, "juan");
        Tripleta t2 = new Tripleta(1, 1, "first");
        Tripleta t3 = new Tripleta(3, 5, "Zea");
        Tripleta t4 = new Tripleta(3, 1, 7);
        Tripleta t5 = new Tripleta(1, 3, 29);
        Tripleta tx = new Tripleta(3, 5, 0);
        //MatrizEnTripletas m = new MatrizEnTripletas(3, 3);  // Forma1
        MatrizEnTripletas m = new MatrizEnTripletas(tx);      // Forma2
        m.insertTripleta_v2(t1);
        m.insertTripleta_v2(t2);
        m.insertTripleta_v2(t3);
        m.insertTripleta_v2(t4);
        m.insertTripleta_v2(t5);
        m.printMatriz();
        m.showMatrizEnTripletas();
        MatrizEnTripletas mt = m.transpose();
        mt.printMatriz();
        mt.showMatrizEnTripletas();

    }
    
}