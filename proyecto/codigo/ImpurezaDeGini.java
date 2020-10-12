public class ImpurezaDeGini {
    public static float sacarElGiniDeUnaMatriz(String[][] m){ // IG = 1 - (p0)^2 + (p1)^2
        int ceros = enCuantasFilasLaVariableEsIgualALaCondicion(m, m[0].length-1, "0");
        int unos = m.length - ceros;
        float gini = 1 - ((ceros/m.length * ceros/m.length) + (unos/m.length*unos/m.length));
        return gini;
    }

    private static int enCuantasFilasLaVariableEsIgualALaCondicion(String[][] m, int variable, String valor){
        int enCuantasFilasLaVariableEsIgualALaCondicion = 0;
        for (int filas = 0; filas < m.length; filas++)
            if (m[filas][variable].equals(valor))
                enCuantasFilasLaVariableEsIgualALaCondicion++;
        return enCuantasFilasLaVariableEsIgualALaCondicion;
    }
}
