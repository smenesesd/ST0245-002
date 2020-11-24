import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.LinkedList;

class Impurezas{

    static String[][] matrizValoresIguales;
    static String[][] matrizValoresDiferentes;


    public TreeSet<String> sacarLosValoresDiferentesSinRepetirDeUnaVariable(String[][] m, int posVariable){
        TreeSet<String> respuesta = new TreeSet();
        for (int fila = 0; fila < m.length; fila++){
            respuesta.add(m[fila][posVariable]);
        }
        return respuesta;
    }

    private static int enCuantasFilasLaVariableEsIgualALaCondicion(String[][] m, int variable, String valor){
        int enCuantasFilasLaVariableEsIgualALaCondicion = 0;
        for (int filas = 0; filas < m.length; filas++){
            if (m[filas][variable].equals(valor)){
                enCuantasFilasLaVariableEsIgualALaCondicion++;
            }
        }
        return enCuantasFilasLaVariableEsIgualALaCondicion;
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
    public static float sacarElGiniDeUnaMatriz(String[][] m){ // IG = 1 - (p0)^2 - (p1)^2
        int enCuantasFilasElExitoEsFalsoEsDecir0 = enCuantasFilasLaVariableEsIgualALaCondicion(m, m[0].length-1, "0");
        int enCuantasFilasElExitoEsVerdaderoEsDecir1 = m.length - enCuantasFilasElExitoEsFalsoEsDecir0;
        double temp = 1 - Math.pow(enCuantasFilasElExitoEsFalsoEsDecir0/m.length,2) - Math.pow(enCuantasFilasElExitoEsVerdaderoEsDecir1/m.length,2);
        float gini = (float) temp;
        return gini;
    }

    public float calcularElGiniPonderado(String[][] laMatrizDelNodoDeLaIzquierda, String[][] laMatrizDelNodoDeLaDerecha){
        float elGiniDeLaMatrizDeLaIzquierda = sacarElGiniDeUnaMatriz(laMatrizDelNodoDeLaIzquierda);
        float elGiniDeLaMatrizDeLaDerecha = sacarElGiniDeUnaMatriz(laMatrizDelNodoDeLaDerecha);
        float elGiniPonderado = (elGiniDeLaMatrizDeLaIzquierda*laMatrizDelNodoDeLaIzquierda.length +
                elGiniDeLaMatrizDeLaDerecha*laMatrizDelNodoDeLaDerecha.length) /  (laMatrizDelNodoDeLaIzquierda.length + laMatrizDelNodoDeLaDerecha.length);
        return elGiniPonderado;
    }


    // IG = 1 - (p0)^2 - (p1)^2. P0 = exito/total P1 = NoExito/total
    public static float laImpurezaDeLosDatosDeUnaMatriz(String[][] m){
        float impureza = 0;
        if (m.length > 0){
            int losQueTienenExito = 0;
            for (int fila = 0; fila < m.length; fila++){
                if (m[fila][m[0].length-1].equals("1")){
                    losQueTienenExito++;
                }
            }
            int losQueNoTienenExito = m.length - losQueTienenExito;
            float proporcionDeLosQueTienenExito = losQueTienenExito/m.length;
            float proporcionDeLosQueNoTieneExito = losQueNoTienenExito/m.length;
            impureza = 1 - (proporcionDeLosQueTienenExito*proporcionDeLosQueTienenExito) - (proporcionDeLosQueNoTieneExito*proporcionDeLosQueNoTieneExito);
        }
        return impureza;
    }


    // IP = (Iizq*cuantosHayALaIzquierda + Ider*cuantosHayALaDerecha) / El numero total de datos
    public static float calcularLaImpurezaPonderada(String[][] m, int posVariable, String valor){
        int enCuantosEstudiantesLaVariableEsIgualAlValor = 0;
            for (int fila = 0; fila < m.length; fila++){
                if (m[fila][posVariable].equals(valor)){ // por ejemplo, valor es 3, 10 SMLVM, Masculino
                    enCuantosEstudiantesLaVariableEsIgualAlValor++;
                }
            }
        int enCuantosEstudiantesLaVariableNOEsIgualAlValor = m.length - enCuantosEstudiantesLaVariableEsIgualAlValor;
        matrizValoresIguales = new String[enCuantosEstudiantesLaVariableEsIgualAlValor][m[0].length];
        matrizValoresDiferentes = new String[enCuantosEstudiantesLaVariableNOEsIgualAlValor][m[0].length];
        // Copiar los datos a las matrices
        int fila = 0;
        int filaN1 = 0;
        int filaN2=0;
        while(fila<m.length )
        {
            if(m[fila][posVariable].equals(valor))
            {
                matrizValoresIguales[filaN1]=m[fila];
                fila++;filaN1++;
            }else
            {
                matrizValoresDiferentes[filaN2]=m[fila];
                fila++;filaN2++;
            }
        }

        float giniIzquierda = laImpurezaDeLosDatosDeUnaMatriz(matrizValoresDiferentes);
        float giniDerecha = laImpurezaDeLosDatosDeUnaMatriz(matrizValoresIguales);
        float total = matrizValoresIguales.length + matrizValoresDiferentes.length;
        float impurezaPonderada = (giniIzquierda* matrizValoresDiferentes.length) + (giniDerecha * matrizValoresIguales.length)/total;
        return impurezaPonderada;
    }
}

