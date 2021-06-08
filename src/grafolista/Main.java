package grafolista;

public class Main {
    public static void main(String[] args) {
        
        Grafo grafoLista = new Grafo();

        /**
         * Se crean los vértices en cualquier orden, si se intenta crear un vértice
         * que ya existe, lo descarta.
         */
        grafoLista.nuevoVertice("1");
        grafoLista.nuevoVertice("4");
        grafoLista.nuevoVertice("3");
        grafoLista.nuevoVertice("5");
        grafoLista.nuevoVertice("2");
        grafoLista.nuevoVertice("3");

        //Se ordena la lista de vértices
        grafoLista.ordenarLista();

        System.out.println("");
        
        try {
            /**
             * Se crean las aristas entre vértices, si se intenta crear una arista
             * que ya existe, ses descarta
             */
            grafoLista.nuevaArista("1", "3");
            grafoLista.nuevaArista("1", "4");
            grafoLista.nuevaArista("2", "3");
            grafoLista.nuevaArista("3", "1");
            grafoLista.nuevaArista("5", "1");
            grafoLista.nuevaArista("5", "2");
            grafoLista.nuevaArista("5", "3");
            grafoLista.nuevaArista("5", "4");
            grafoLista.nuevaArista("5", "3");

            System.out.println("");
            
            //Se borran las aristas existentes entre vértices
            grafoLista.borrarArista("5", "2");

            System.out.println("");
            
            //Se muestra la lista de adyacencia, en orden alfabético, del grafo
            grafoLista.mostrarListaAdyacencia();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}