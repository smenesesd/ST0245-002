import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
     /**
     *the class FileReader is in charge of reading a file
     */
public class FileReader{
     /**
     * This method read a file
     * @param data is the name of the file (the file must be in the project folder or the file path must be entered)
     */
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
     /**
     * main 
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        FileReader.leerArchivo(data);
    }
}
