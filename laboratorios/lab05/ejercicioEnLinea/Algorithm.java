public class Algorithm {


    /*public static boolean DFSColorFC(Tree tree) {
        return DFSColorFCAux(tree.getFirst(), 1);
    }

    private static boolean DFSColorFCAux(Node first, int color) {

     }
     */

     public static boolean DFSColorFC(DiGraphAM a){
        String[] visitados = new String[a.size];
        int origen = a.getFirst();
        return DFSColorFCAux(a, origen, visitados, "verde");
    }

    private static boolean DFSColorFCAux(DiGraphAM a, int origen, String[] v, String color){
        if(v[origen] == null){
            for(Integer s : a.getSuccessors(origen)){ 
                if(color.equals("verde")){
                    v[origen] = "amarillo"; 
                    if(!DFSColorFCAux(a, s, v, "amarillo")){
                        return false;
                    }
                }else{   
                    v[origen] = "verde";
                    if(!DFSColorFCAux(a, s, v, "verde")){
                        return false;
                    }                    
                }
            }
        }else{
            if(v[origen].equals(color)){
                return false;
            }else{ 
                if(color.equals("verde")){
                    v[origen] = "amarillo";
                    return true;
                }else{
                    v[origen] = "verde";
                    return true;
                }
            }            
        }      
        return true;
    }
}
