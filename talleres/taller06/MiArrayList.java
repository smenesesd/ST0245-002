import java.util.Arrays;

/**
 * La clase MiArrayList tiene la intención de representar un objeto que simule el comportamiento
 * de la clase ya implementada "ArrayList"
 * es claro que no se puede utilizar dicha estructura ya utilizada dentro de este ejercicio.
 * Para más información de la clase ArrayList:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
 *
 *
 * @author Neller Pellegrino, Samuel Meneses
 * @version 1
 */

public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[];

    /**
     * El metodo constructor se utiliza para incializar
     * variables a valores neutros como 0 o null.
     * El contructor no lleva parámetros en este caso.
     */
    public MiArrayList() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];
    }


    /**
     * Tiene la intención de retornar la longitud del objeto
     * @return longitud del objeto
     *
     * El size esta influenciado por las funciones add y del
     */
    public int size() {

        return size;
    }

    /**
     * @param e el elemento a guardar
     * Agrega un elemento e a la última posición de la lista
     *
     */
    public void add(int e) {
        int [] nuevo = new int[elements.length];
        if(elements.length == 0){
            elements[0] = e;
        }else {

            for (int i = 0; i < nuevo.length - 1; i++) {
                nuevo[i] = elements[i];
            }
            nuevo[nuevo.length - 1] = e;
        }
    }


    /**
     * @param i es un íncide donde se encuentra el elemento posicionado
     * Retorna el elemento que se encuentra en la posición i de la lista.
     *
     */
    public int get(int i) {
        return elements[i];
    }


    /**
     * @param index es la posicion en la cual se va agregar el elemento
     * @param e el elemento a guardar
     * Agrega un elemento e en la posición index de la lista
     *
     */
    public void add(int index, int e) {
        int [] nuevo = new int[elements.length];
        if (elements.length == 0){
            elements[0] = e;
        }else if (index < elements.length){
            int temp = elements[index];
            for (int i = 0; i < index; i++) {
                nuevo[i] = elements[i];
            }
            nuevo[index] = e;
            nuevo[index + 1] = temp;
            for (int i = index + 2; i < elements.length; i++) {
                nuevo[i] = elements[i];
            }
        }
    }

    /**
     * @param index es la posicion en la cual se va eliminar el elemento
     *
     * ELimina el elemento  en la posición index de la lista
     *
     */
    public void del(int index){
        int[] nuevo = new int[elements.length - 2];
        if (elements.length >= 2){
            for (int i = 0; i < index; i++) {
                nuevo[i] = elements[i];
            }
            elements[index] = elements[index + 1];

            for (int i = index + 2; i < elements.length; i++) {
                nuevo[i] = elements[i];
            }
        }
    }
}
