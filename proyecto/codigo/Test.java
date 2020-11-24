import java.util.*;
public class Test extends Impurezas{

    public static LinkedList<Pair<Integer, String>> struct = Nodo.struct2;
    Impurezas im2 = new Impurezas();
    int longitudInicial = BufferReader.longitudTest;

    public void test(String [][] matriz, int cont){
        if(struct.isEmpty()){
            return;
        }
        Pair<Integer, String> nuevo = struct.removeFirst();
        im2.calcularLaImpurezaPonderada(matriz, nuevo.getKey(), nuevo.getValue());
        String[][] mI = im2.matrizValoresDiferentes;
        String[][] mD = im2.matrizValoresIguales;
        if(cont == 0){
            float verdaderosPositivos = 0;
            float verdaderosTotales = BufferReader.datosImportantesTest();
            for(int i = 0; i < mD.length; i++){
                if(mD[i][mD[0].length-1].equals("0")){
                    verdaderosPositivos++;
                }
            }
            System.out.println("La precision es: " + (verdaderosPositivos/mD.length));
            System.out.println("Los recuperados son: " + (verdaderosPositivos/verdaderosTotales));
            //System.out.println("La exactitud es: " + ((verdaderosPositivos + ())/longitudInicial));
        }
        if(cont == 1){
            cont++;
            test(mI, cont);
        }else {
            cont++;
            test(mI, cont);

            test(mD, cont);
        }
    }
}
