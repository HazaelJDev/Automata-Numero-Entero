package automata;
public class Grafo {
    public Object mAdy[][] = new Object[5][5];
    public Nodo lAdy[] = new Nodo[5];
    public int i=0,j=0,k=0,c=0;
    public Nodo ultimo;
    public void CreateMaxListAdy(){
        //LLenamos la matriz de Adyciencia
        mAdy[0][0] = "Nodos";
        mAdy[0][1] = "Inicio";
        mAdy[0][2] = "Q1";
        mAdy[0][3] = "Entero";
        mAdy[0][4] = "Error";
        
        mAdy[1][0] = "Inicio";
        mAdy[1][1] = 0;
        mAdy[1][2] = 1;
        mAdy[1][3] = 1;
        mAdy[1][4] = 1;
        
        mAdy[2][0] = "Q1";
        mAdy[2][1] = 0;
        mAdy[2][2] = 0;
        mAdy[2][3] = 1;
        mAdy[2][4] = 1;
        
        mAdy[3][0] = "Entero";
        mAdy[3][1] = 0;
        mAdy[3][2] = 0;
        mAdy[3][3] = 1;
        mAdy[3][4] = 1;
        
        mAdy[4][0] = "Error";
        mAdy[4][1] = 0;
        mAdy[4][2] = 0;
        mAdy[4][3] = 0;
        mAdy[4][4] = 0;
        //Llenamos la lista de adyaciencia
        for (i  = 1; i <= 4; i++) {
            lAdy[i-1] = new Nodo(mAdy[i][0].toString());
            ultimo = lAdy[i-1];
            for (j = 1;j <= 4; j++) {
                if(Integer.parseInt(mAdy[i][j].toString()) == 1){
                    Nodo nuevo = new Nodo(mAdy[0][j].toString());
                    ultimo.sig = nuevo;
                    ultimo = nuevo;
                }
            }
        }
    }
    
    public void ViewMaxListAdy(){
        System.out.println("\t\"Matriz de Adyacencia\"");
        for (i = 0;i < mAdy.length; i++) {
            for (j = 0; j < mAdy[i].length; j++) {
                System.out.print(mAdy[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("\n\t\"Lista de Adyacencia\"");
        Nodo reco;
        for (i = 0;i < lAdy.length; i++) {
            reco = lAdy[i];
            while(reco!=null){
                System.out.print(reco.etiqueta+" --> ");
                reco = reco.sig;
            }
            System.out.println();
        }
    }
    
    public boolean RecorrerGrafo(String numero){
        Nodo reco = lAdy[0];
        while(reco.etiqueta!="Entero" || (k<numero.length())){
            c = (int)numero.charAt(k);
            switch(reco.etiqueta){
                case "Inicio":
                    if (c >= 48 && c <= 57) {
                        reco = ObtenerSigEstado("Entero",reco);
                    }else if(c == 43 || c == 45){
                        reco = ObtenerSigEstado("Q1",reco);
                    }else{
                        reco = ObtenerSigEstado("Error",reco);
                    }
                break;
                case "Q1":
                    if (c >= 48 && c <= 57) {
                        reco = ObtenerSigEstado("Entero",reco);
                    }else{
                        reco = ObtenerSigEstado("Error",reco);
                    }
                break;
                case "Entero":
                    if (c >= 48 && c <= 57) {
                        reco = ObtenerSigEstado("Entero",reco);
                    }else{
                        reco = ObtenerSigEstado("Error",reco);
                    }
                break;
            }
            if (reco.etiqueta == "Error") {
                return false;
            }
            k++;
        }
        //Si acabamos de recorrer la cadena de texto con exito
        if(reco.etiqueta == "Entero"){
            return true;
        }else{
            return false;
        }
    }
    
    public Nodo ObtenerSigEstado(String estadosig,Nodo reco){
        int x = 0;
        /*
            Recorremos la lista donde reco vale una posicion del arreglo de adyacencia
            al principio y se detiene hasta encontrar el estado al cual vamos. 
        */
        while(reco.etiqueta!=estadosig){
            reco = reco.sig;
        }
        /*
            Una ves encontrado el estado en la lista ahora reco tomara la posicion de ese 
            estado pero en el arreglo para poder conectar con el siguiente estado adyacente.
        */
        while(lAdy[x].etiqueta!=reco.etiqueta){
            x++;
        }
        reco = lAdy[x];
        return reco;
    }
}
