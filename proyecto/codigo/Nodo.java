import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.LinkedList;

public class Nodo extends Impurezas{
    private String[][] matriz;
    private Nodo izq;
    private Nodo der;
    private int laColumna;
    private String elValor;

    Impurezas im = new Impurezas();
    BufferReader nuevo = new BufferReader();
    int longitudInicial = nuevo.getLongitud();
    public static LinkedList<Pair<Integer, String>> struct2 = new  LinkedList<Pair<Integer, String>>();
    int[] d = new int[]{0, 1, 2, 3, 4, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 32, 33, 34, 37, 38, 39, 40, 41, 43, 45, 46, 47, 48, 49, 50, 52, 53, 56, 57, 58, 59, 61, 62, 63, 64, 74, 75, 76};
    List<Integer> otra = Arrays.stream(d).boxed().collect(Collectors.toList());
    TreeSet<Integer> valoresNoAceptados = new TreeSet<Integer>();

    public Nodo (String[][] m){
        valoresNoAceptados.addAll(otra);
        if (m.length <= ((longitudInicial*33)/100)){
            matriz = m;
            calcularSiHayExitoONOEnUnaMatriz(m);
        }
        else{
            matriz = m;
            Pair<Integer,String> data = encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(m);
            struct2.add(data);
            laColumna = data.getKey();
            elValor = data.getValue();
            im.calcularLaImpurezaPonderada(m, laColumna, elValor);
            String[][] mI = im.matrizValoresDiferentes;
            String[][] mD = im.matrizValoresIguales;
            Nodo izq = new Nodo(mI);
            Nodo der = new Nodo(mD);
        }
    }

    public void calcularSiHayExitoONOEnUnaMatriz(String[][] m){
        float verdaderosPositivos = 0;
        float verdaderosTotales = BufferReader.datosImportantes();
        for(int i = 0; i < m.length; i++){
            if(m[i][m[0].length-1].equals("0")){
                verdaderosPositivos++;
            }
        }
        System.out.println("La precision es: " + (verdaderosPositivos/m.length));
        System.out.println("Los recuperados son: " + (verdaderosPositivos/verdaderosTotales));
        //System.out.println("La exactitud es: " + ((verdaderosPositivos + (verdaderosPositivos-m.length))/longitudInicial));
    }

    public TreeSet<String> sacarLosValoresDiferentesSinRepetirDeUnaVariable(String[][] m, int posVariable){
        TreeSet<String> respuesta = new TreeSet();
        for (int fila = 0; fila < m.length; fila++){
            respuesta.add(m[fila][posVariable]);
        }
        return respuesta;
    }

    public Pair<Integer,String> encontrarEnQuePosEstaLaMejorVariableYQueValorDeboCompararEnLaCondicion(String[][] m){
        float laImpurezaMenorDentreTodoElmundo = 1;
        String elMejorValorDentreTodoElMundo = "";
        int laPosDeLaVariableDondeEstaElMejorValor = -1;
        for (int columna = 0; columna < m[0].length - 1; columna++){
            TreeSet<String> valores = sacarLosValoresDiferentesSinRepetirDeUnaVariable(m, columna);
            for (String unValor : valores){
                float impurezaPonderadaDeEstaColumnaConEsteValor = calcularLaImpurezaPonderada(m, columna, unValor);
                if (impurezaPonderadaDeEstaColumnaConEsteValor < laImpurezaMenorDentreTodoElmundo){
                    laImpurezaMenorDentreTodoElmundo = impurezaPonderadaDeEstaColumnaConEsteValor;
                    elMejorValorDentreTodoElMundo = unValor;
                    laPosDeLaVariableDondeEstaElMejorValor = columna;
                }
            }
        }
        Pair<Integer,String> respuesta = new Pair(laPosDeLaVariableDondeEstaElMejorValor, elMejorValorDentreTodoElMundo);
        return respuesta;
    }

}
