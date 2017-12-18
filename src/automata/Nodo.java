package automata;
public class Nodo {
    public String etiqueta;
    public Nodo sig;
    public Nodo(String et){
        this.etiqueta = et;
        this.sig = null;
    }
}
