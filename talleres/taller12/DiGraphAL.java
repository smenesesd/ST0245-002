import javafx.util.Pair;
import java.util.ArrayList;
import java.util.LinkedList;

//GRAFO CON LISTAS
public class DigraphAL extends Graph
{
    private ArrayList<LinkedList<Pair<Integer,Integer>>> nodo;

    public DigraphAL(int size) {
        super(size);
        nodo = new ArrayList<>();
        for (int i = 0; i < size + 1; i++) {
            nodo.add(new LinkedList<>());
        }
    }
    public void addArc(int source, int destination, int weight){
        nodo.get(source).add(new Pair<>(destination,weight));
    }
    public int getWeight(int source, int destination) {
        int result = 0;
        for (Pair<Integer, Integer> integerIntegerPair : nodo.get(source)) {
            if (integerIntegerPair.getKey() == destination) result = integerIntegerPair.getValue();
        }
        return result;
    }
    public ArrayList<Integer> getSuccessors(int vertice){
        ArrayList<Integer> n = new ArrayList<>();

        nodo.get(vertice).forEach(i -> n.add(i.getKey()));

        return n;
    }

    /**
     * Método para recorrer por DFS y buscar si se puede llegar desde un grafo hasta a otro.
     *
     * @param g Grafo con el nodo dado.
     * @param origin donde se empieza a buscar.
     * @param destination donde se quiere llegar.
     * @return si esta el destino entonces se devuelve true.
     */
    public boolean isThereARoadDFS(Graph g, int origin, int destination){
        LinkedList<Integer> visitados = new LinkedList<>();
        return isThereARoadDFS(origin, destination, visitados);
    }
    /**
     * Método para recorrer por DFS y buscar si se puede llegar desde un grafo hasta a otro.
     *
     * @param origin donde se empieza a buscar.
     * @param destination donde se quiere llegar.
     * @return si esta el destino entonces se devuelve true.
     */
    public boolean isThereARoadDFS(int origin, int destination, LinkedList<Integer> visitados){
        visitados.add(origin);
        if(origin == destination){
            return true;
        }
        for(Integer s : getSuccessors(origin)){
            if(!visitados.contains(s)){
                if(isThereARoadDFS(s,destination,visitados)){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Método para recorrer por BFS y buscar si se puede llegar desde un grafo hasta a otro.
     *
     * @param origin donde se empieza a buscar.
     * @param destination donde se quiere llegar.
     * @return si esta el destino entonces se devuelve true.
     */
    public boolean isThereARoadBFS(Graph g, int origin, int destination){
        LinkedList<Integer> aVisitar = new LinkedList<>();
        for(Integer s: g.getSuccessors(origin)){
            aVisitar.add(s);
        }
        LinkedList<Integer> visitados = new LinkedList<>();
        visitados.add(origin);
        aVisitar.add(origin);
        if(origin == destination){
            return true;
        }
        while(!aVisitar.isEmpty()){
            int temp = aVisitar.pop();
            if(temp == destination){
                return true;
            }
            visitados.add(temp);
            for(Integer sigueinte: g.getSuccessors(temp)){
                if(!visitados.contains(sigueinte)){
                    aVisitar.add(sigueinte);
                }
            }
        }
        return false;
    }
}
