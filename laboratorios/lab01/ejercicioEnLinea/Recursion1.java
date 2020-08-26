/**
 *
 * @author Neller Pellegrino , Samuel Meneses
 */
public class Recursion1{
    public int triangle(int rows) {
        if (rows == 0) return 0; //C
        return rows + triangle(rows - 1); //C + T(n-1)
        //MODELO: T(n) =   |C, n=0
        //                 |C + T(n-1), n>0
        //ECUACION DE RECURRENCIA:
        //          T(n) = C*n + C1
        //CÁLCULO DE COMPLEJIDAD:
        //          O(C*n + C1)
        //          O(C*n)      -> Por regla de la suma
        //          O(n)        -> Por regla de la multiplicación
    }

    public boolean nestParen(String str) {
        if(str.length() == 0){
            return true;
        }if(str.charAt(0) =='(' && str.charAt(str.length() - 1) == ')'){
            return nestParen(str.substring(1,str.length() - 1));
        }
        return false;
    }

    public int count11(String str) {
        if(str.length() <= 1){
            return 0;
        }if(str.charAt(0) =='1' && str.charAt(1) == '1'){
            return count11(str.substring(2)) + 1;
        }else{
            return count11(str.substring(1));
        }
    }

    public String endX(String str) {
        if(str.length() == 0){
            return "";
        }if(str.charAt(0) == 'x'){
            return endX(str.substring(1)) + str.charAt(0);
        }else{
            return str.charAt(0) + endX(str.substring(1));
        }
    }
    

    public String changePi(String str) {
        if(str.length() <= 1){
            return str;
        }if(str.charAt(0) == 'p' && str.charAt(1) == 'i'){
            return "3.14" + changePi(str.substring(2));
        }else{
            return str.substring(0,1)+ changePi(str.substring(1));
        }
    }
}
