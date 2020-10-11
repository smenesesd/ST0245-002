/**
* La clase UnaTablaDeHash, es un plantilla para crear nuestra propia estructura hash
* Dentro de sus características esta que tiene un string como llave (key) y un entero
* como valor (value)
* @author Neller Pellegrino, Samuel Meneses
* @version 1
*/
public class UnaTablaDeHash
{
   /*
   * Utilizamos array por simplicidad sin embargo el uso de este no permite manejar coliciones
   * de manera eficiente, por lo cual esta primera versión de hash no implementa colisiones, esta
   * característica se implementará posteriormente.
   */
    private LinkedList<Pair<String,Integer>>[] tabla;


   /**
   * Este método define el array utilizado con 10 posiciones de manera que tenemos un límite de 10 elementos
   * 
   */
   public UnaTablaDeHash(){
       tabla = new LinkedList[10];
        tabla[6] = new LinkedList<Pair<String,Integer>>();
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar
   * Este método se utiliza para darle una posicion dentro de la tabla, donde el %10 asegura que solo
   * se utilicen digitos de 0 a 10.
   */
   private int funcionHash(String k){
       return ((int) k.charAt(0)) % 10;
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar
   * Este método se utiliza para obtener el elmento con la clave k, se enlaza con funcionHash
   */
   public int get(String k){
        int posicion = funcionHash(k);
        int i = 0;
        while(!tabla[posicion].isEmpty()){
            if(tabla[posicion].get(i).getKey() == k){
                return tabla[posicion].get(i).getValue();
            }
            i++;
        }
        return -1; 
   }

   /**
   * @param k es la llave del elemento que servirá como referencia al buscar posteriormente
   * @param v es el valor asociado a la llave k
   * Este método se utiliza para agregar un nuevo elemento
   */
   public void put(String k, int v){
      Pair<String, Integer> datos = new Pair<>(k, v);
       int posicion = funcionHash(k);
       if(tabla[posicion] == null){
            tabla[posicion] = new LinkedList<Pair<String,Integer>>();
        }         
        tabla[posicion].add(datos);
   }
}
