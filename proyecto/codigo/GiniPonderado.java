public class GiniPonderado {

    public float calcularElGiniPonderado(String[][] laMatrizDelNodoDeLaIzquierda, String[][] laMatrizDelNodoDeLaDerecha){
        float elGiniDeLaMatrizDeLaIzquierda = sacarElGiniDeUnaMatriz(laMatrizDelNodoDeLaIzquierda);
        float elGiniDeLaMatrizDeLaDerecha = sacarElGiniDeUnaMatriz(laMatrizDelNodoDeLaDerecha);
        float elGiniPonderado = (elGiniDeLaMatrizDeLaIzquierda*laMatrizDelNodoDeLaIzquierda.length +
                elGiniDeLaMatrizDeLaDerecha*laMatrizDelNodoDeLaDerecha.length) /  (laMatrizDelNodoDeLaIzquierda.length + laMatrizDelNodoDeLaDerecha.length);
        return elGiniPonderado;
    }
}
