public class Main{

    public static void main(String[] args) {
        long inicio_leer = System.currentTimeMillis();
        BufferReader lector = new BufferReader();
        lector.leerDatos();
        Nodo nodo = new Nodo(lector.datos); //arbol entrenado
        Test test = new Test();
        lector.leerDatosTest();
        test.test(lector.datosTest, 0);
        long fin_leer = System.currentTimeMillis();
        long total_leer = fin_leer - inicio_leer;
        System.out.println("Tiempo de ejecucion de leer_archivo: " + total_leer + "ms");
        System.out.println();
        System.out.println("Memoria usada para leer_archivo:");
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
        System.out.println("MB: " + (double) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024)/1024);
    }
}
