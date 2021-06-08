package grafolista;

public class Arista {
    
    //Atributos
    private int destino;
    
    //Constructor
    public Arista(int destino) {
        this.destino = destino;
    }
    
    //Devuelve el destino de una arista
    public int getDestino(){
        return destino;
    }

    // Devuelve verdadero si dos aristas indican el mismo destino
    public boolean equals(Object n) {
        Arista a = (Arista)n;
        return destino == a.destino;
    }
}