//calculadora polaca

 public static int polaca (String string){
        String[] prefixStr = string.split(" ");
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<prefixStr.length;i++){
            if(prefixStr[i].equals("+")){
                stack.push(stack.pop()+ stack.pop());
            }
            else if(prefixStr[i].equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(prefixStr[i].equals("-")){
                stack.push(stack.pop() - stack.pop());
            }
            else if(prefixStr[i].equals("/")){
                stack.push(stack.pop()/stack.pop());
            }
            else{
                stack.push(Integer.parseInt(prefixStr[i]));
            }
       }
       return stack.pop();
    }
    
    //param
    
     public static Stack<Integer> inversa (Stack<Integer> stack){
        int n = stack.size();
        Stack<Integer> temp= new Stack<Integer>();
          for(int i = 0; i < n; i++) 
            temp.push(stack.pop());
         return temp;
    }
    
    //param
    
     public static void cola (Queue<String> queue){
       while(!queue.isEmpty()){
            System.out.println("Atendiendo a "+queue.poll());
        }
    }
}
