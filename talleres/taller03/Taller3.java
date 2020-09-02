public class Taller3{


 public static void hanoi(int topN){
    hanoi(topN, "Tower1", "Tower2", "Tower3");
 }


 public static void hanoi(int topN, String a  , String b , String c  ){
   
    if (topN == 1){
        System.out.println(a + "->" + c);
    }
    else{ 
        hanoi(topN-1, a, c, b);
        hanoi(1, a , b, c    );
        hanoi(topN-1, b, a, c);
    }
 }

/**
    *
    * El método permutation es un auxiliar del proceso
    * @param str es la cadena a permutar
    */
    public static void permutation(String str) {
        permutation("", str);
    }
   
    /**
    *
    * El método permutationAux es el core del proceso, en el se busca conseguir
    * las posibles permutaciones que puede tener la cadena str
    * @param str es la cadena a permutar
    * @param prefix cadena auxiliar donde se guarda la cadena de salida
    *
    * Las cadenas de salida tienes una longitud de lenght de la cadena s
    * Ej: para la cadena ABC se tiene la salida: { ABC,ACB,BAC,BCA,CAB,CBA }
    * donde los caracteres no se repiten pero el orden tiene un papel importante.
    *
    */
    private static void permutationAux(String respuesta, String pregunta) {
        if (pregunta.length == 0)
                    System.out.println(respuesta);
                else
                    for (int i = 0; i < pregunta.length; i++)
                        permutationAux(pregunta.substring(1)//""+pregunta[i],
                                       pregunta.substring(0,i) + pregunta.substring (i+1));
                    //las que empiezan por a, las que empiezan las que b, las que empiezan por c
                    //permutationAux(""+"a", quitarUnaLetra(pregunta, "a") );
                   // permutationAux(""+"b", quitarUnaLetra(pregunta, "b"));
                   // permutationAux(""+"c", quitarUnaLetra(pregunta, "c"));
                   // permutationAux(""+"d", quitarUnaLetra(pregunta, "d"));
               
    }

}
