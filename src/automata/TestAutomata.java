package automata;
import javax.swing.JOptionPane;
public class TestAutomata {
    public static void main(String args[]){
        String cad="Automata que verifica si una cadena de texto\nque teclee el usuario es un numero entero",s="";
        Grafo a = new Grafo();
        a.CreateMaxListAdy();
        JOptionPane.showMessageDialog(null,cad,"Automata",JOptionPane.INFORMATION_MESSAGE);
        cad = JOptionPane.showInputDialog(null,"Ingresa un numero entero","Negativo o Positivo");
        //Limpiamos los espacios que el usuario teclee
        cad = cad.replace(" ","");
        if(a.RecorrerGrafo(cad)){
            s = "¡La cadena que tecleaste, si es un numero entero!\n\tNumero Entero: "+cad;
            JOptionPane.showMessageDialog(null,s,"Automata",JOptionPane.INFORMATION_MESSAGE);
        }else{
            s = "¡La cadena que tecleaste, no es un numero entero!\n\tCadena: "+cad;
            JOptionPane.showMessageDialog(null,s,"Automata",JOptionPane.ERROR_MESSAGE);
        }
    }
}
