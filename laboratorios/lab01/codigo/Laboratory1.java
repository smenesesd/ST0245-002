import java.math.*;

/**
 *
 * @author Neller Pellegrino, Samuel Meneses
 * This class contains the methods that solve points 1.1 and 1.2 of laboratory
 * practice 1
 */
public class Laboratory1 {
    /**
     * This method calculates the longest common sequence between two strings
     * @param x First string
     * @param y Second string
     * @return length of the largest common sequence between cadena
     */
    public static int lcsDNA(String x, String y) {
        return lcsDNAAux(x, y, x.length(), y.length());
    }
    /**
     * This method is an auxiliar for lcsDNA
     * @param x first characters string
     * @param y second characters string
     * @param n length of cadena1
     * @param m length of cadena 2
     * @return length of the largest common sequence between two strings
     */
    public static int lcsDNAAux(String x, String y, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }if(x.charAt(n - 1) == y.charAt(m - 1)){
            return 1 + lcsDNAAux(x , y,n - 1, m - 1);
        }else{
            return Math.max(lcsDNAAux(x , y, n ,m - 1), lcsDNAAux(x , y, n - 1 , m));
        }
    }

    /**
     * This method calculates how many ways there are for organizing rectangles
     * of 1x2 in a rectangle of 2xn
     * @param n side n of the rectangle 2xn
     * @return number of ways that rectangles of 1x2 can be organized
     * in a rectangle of 2xn
     */
    public static int ways(int n){
            if(n <= 2) return n;
            return ways(n - 1)+ ways(n - 2);
        }
    }
