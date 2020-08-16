import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Lectura {
    public static void leerArchivo(String data){
        ArrayList<String>  datos = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        try{
            File fichero = new File(data);
            scan = new Scanner(fichero);
            while (scan.hasNextLine()){
                datos.add(scan.nextLine());
            }
        }catch (FileNotFoundException fnfe) {
            System.out.println(fnfe);}
        catch (Exception e){
            e.printStackTrace();
        }finally {
            scan.close();
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        FileReader.leerArchivo(data);
    }
}
