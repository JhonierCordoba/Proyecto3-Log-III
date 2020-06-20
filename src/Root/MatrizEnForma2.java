package Root;

public class MatrizEnForma2 {
    NodoDoble mat;

    public MatrizEnForma2(int m, int n) {
        Tripleta t = new Tripleta(m, n, null);
        mat = new NodoDoble(t);
        Tripleta tx = new Tripleta(null, null, null);
        NodoDoble x = new NodoDoble(tx);
        x.asignaLD(x);
        x.asignaLI(x);
        mat.asignaLD(x);
    }

    public void conectaPorFilas(NodoDoble x) {
        NodoDoble p, q, anterior;
        Tripleta tq, tx;
        int i;
        tx = (Tripleta) x.retornaDato();
        p = this.nodoCabeza();
        anterior = p;
        q = p.retornaLD();
        tq = (Tripleta) q.retornaDato();
        while (q != p && tq.retornaFila() < tx.retornaFila()) {
            anterior = q;
            q = q.retornaLD();
            tq = (Tripleta) q.retornaDato();
        }
        while (q != p && tq.retornaFila() == tx.retornaFila() && tq.retornaColumna() < tx.retornaColumna()) {
            anterior = q;
            q = q.retornaLD();
            tq = (Tripleta) q.retornaDato();
        }
        anterior.asignaLD(x);
        x.asignaLD(q);
    }

    public void conectaPorColumnas(NodoDoble x) {
        NodoDoble p, q, anterior;
        Tripleta tq, tx;
        int i;
        tx = (Tripleta) x.retornaDato();
        p = this.nodoCabeza();
        anterior = p;
        q = p.retornaLI();
        tq = (Tripleta) q.retornaDato();
        while (q != p && tq.retornaColumna() < tx.retornaColumna()) {
            anterior = q;
            q = q.retornaLI();
            tq = (Tripleta) q.retornaDato();
        }
        while (q != p && tq.retornaColumna() == tx.retornaColumna() && tq.retornaFila() < tx.retornaFila()) {
            anterior = q;
            q = q.retornaLI();
            tq = (Tripleta) q.retornaDato();
        }
        anterior.asignaLI(x);
        x.asignaLI(q);
    }

    public NodoDoble primerNodo() {
        return mat;
    }

    public NodoDoble nodoCabeza() {
        return mat.retornaLD();
    }

    public boolean esVacia() {
        NodoDoble p = mat.retornaLD();
        return p.retornaLI() == p && p.retornaLD() == p; // ¿Con una no es suficiente?
    }

    public boolean finDeRecorrido(NodoDoble p) {
        return p == this.nodoCabeza();
    }

    public void muestraMatriz() { // Modificado
        // int qf, qc, qv;
        NodoDoble q;
        Tripleta tq;
        q = nodoCabeza().retornaLD();
        while (!finDeRecorrido(q)) {
            tq = (Tripleta) q.retornaDato();
            // qf = tq.retornaFila();
            // qc = tq.retornaColumna();
            // qv = (int)tq.retornaValor();
            // escribe(qf, qc, qv);
            escribe(tq);
            q = q.retornaLD();
        }
    }

    public void escribe(Tripleta t) {
        System.out.println("( " + t.retornaFila() + ", " + t.retornaColumna() + ", " + t.retornaValor() + " )");
    }
}