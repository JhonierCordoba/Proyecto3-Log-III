package Root;

public class MatrizEnForma1 {
    private NodoDoble mat;

    public MatrizEnForma1(int m, int n) {
        Tripleta t = new Tripleta(m, n, null);
        this.mat = new NodoDoble(t);
        t.asignaValor(mat);
        this.mat.asignaDato(t);
    }

    public void contruyeNodosCabeza() {
        Tripleta t = (Tripleta) mat.retornaDato();
        int m = t.retornaFila();
        int n = t.retornaColumna();
        int p = mayor(m, n);
        NodoDoble ultimo = mat;
        for (int i = 0; i < p; i++) {
            t = new Tripleta(0, 0, mat);
            NodoDoble x = new NodoDoble(t);
            x.asignaLD(x);
            x.asignaLI(x);
            t = (Tripleta) ultimo.retornaDato();
            t.asignaValor(x);
            ultimo.asignaDato(t);
            ultimo = x;
        }
    }

    public void conectaPorFilas(NodoDoble x) {
        Tripleta t = (Tripleta) x.retornaDato();
        int f = t.retornaFila();
        int c = t.retornaColumna();
        t = (Tripleta) mat.retornaDato();
        NodoDoble p = (NodoDoble) t.retornaValor();
        for (int i = 1; i < f; i++) {
            t = (Tripleta) p.retornaDato();
            p = (NodoDoble) t.retornaValor();
        }
        NodoDoble aq = p;
        NodoDoble q = p.retornaLD();
        t = (Tripleta) q.retornaDato();
        int cq = t.retornaColumna();
        while (q != p && c > cq) {
            aq = q;
            q = q.retornaLD();
            t = (Tripleta) q.retornaDato();
            cq = t.retornaColumna();
        }
        aq.asignaLD(x);
        x.asignaLD(q);
        t = (Tripleta) p.retornaDato();
        f = t.retornaFila() + 1;
        t.asignaFila(f);
        p.asignaDato(t);
    }

    public void conectaPorColumnas(NodoDoble x) {
        Tripleta t = (Tripleta) x.retornaDato();
        int f = t.retornaFila();
        int c = t.retornaColumna();
        t = (Tripleta) mat.retornaDato();
        NodoDoble p = (NodoDoble) t.retornaValor();
        for (int i = 1; i < c; i++) {
            t = (Tripleta) p.retornaDato();
            p = (NodoDoble) t.retornaValor();
        }
        NodoDoble aq = p;
        NodoDoble q = p.retornaLI();
        t = (Tripleta) q.retornaDato();
        int fq = t.retornaFila();
        while (q != p && f > fq) {
            aq = q;
            q = q.retornaLI();
            t = (Tripleta) q.retornaDato();
            fq = t.retornaFila();
        }
        aq.asignaLI(x);
        x.asignaLI(q);
        t = (Tripleta) p.retornaDato();
        c = t.retornaColumna() + 1;
        t.asignaColumna(c);
        p.asignaDato(t);
    }

    public void recorrePorFilas() { // Modificado
        Tripleta t = (Tripleta) mat.retornaDato();
        NodoDoble p = (NodoDoble) t.retornaValor();
        NodoDoble q;
        // int f, c;
        // Object v;
        while (p != mat) {
            q = p.retornaLD();
            while (q != p) {
                t = (Tripleta) q.retornaDato();
                // f = t.retornaFila();
                // c = t.retornaColumna();
                // v = t.retornaValor();
                // escriba(f, c, v);
                escriba(t);
                q = q.retornaLD();
            }
            t = (Tripleta) p.retornaDato();
            p = (NodoDoble) t.retornaValor();
        }
    }

    public void recorrePorColumnas() { // Modificado
        Tripleta t = (Tripleta) mat.retornaDato();
        NodoDoble p = (NodoDoble) t.retornaValor();
        NodoDoble q;
        // int f, c;
        // Object v;
        while (p != mat) {
            q = p.retornaLI();
            while (q != p) {
                t = (Tripleta) q.retornaDato();
                // f = t.retornaFila();
                // c = t.retornaColumna();
                // v = t.retornaValor();
                // escriba(f, c, v);
                escriba(t);
                q = q.retornaLI();
            }
            t = (Tripleta) p.retornaDato();
            p = (NodoDoble) t.retornaValor();
        }
    }

    public void escriba(Tripleta t) { // Original
        System.out.println("( " + t.retornaFila() + ", " + t.retornaColumna() + ", " + t.retornaValor() + " )");
    }
    
    public int mayor(int a, int b) {  // Original
        return a > b ? a : b;
    }
}