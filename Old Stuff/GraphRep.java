import java.util.*;


public class GraphRep{



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = "";
        input = sc.nextLine();
       
    
      if(input.equals("Graph 1")){

      System.out.print(  "* a b c d e f" +"\n"+
                          "a 0 0 1 1 0 0"+"\n"+
                          "b 0 0 1 0 0 1"+"\n"+
                          "c 1 1 0 0 1 0"+"\n"+
                          "d 1 0 0 0 1 0"+"\n"+
                          "e 0 0 1 1 0 1"+"\n"+
                          "f 0 1 0 0 1 0"+"\n"+
                          "\n"+
                          "a | c d"+"\n"+
                          "b | c f"+"\n"+
                          "c | a b e"+"\n"+
                          "d | a e"+"\n"+
                          "e | c d f"+"\n"+
                          "f | b e"
                          );

      }

      if(input.equals("Graph 2")){


       System.out.print("* a b c d e"+"\n" +
                        "a 0 0 1 0 0"+"\n"+
                        "b 0 0 1 0 0"+"\n"+
                        "c 1 1 0 1 1"+"\n"+
                        "d 0 0 1 0 0"+"\n"+
                        "e 0 0 1 0 0"+"\n"+
                          
                          "\n"+
                          "a | c"+"\n"+
                          "b | c"+"\n"+
                          "c | a b d e"+"\n"+
                          "d | c"+"\n"+
                          "e | c"
                   
                          );



      }

      if(input.equals("Graph 3")){

       System.out.print("* a b c d e f g" +"\n"+
                          "a 0 1 1 1 1 0 0"+"\n"+
                          "b 1 0 0 1 0 1 0"+"\n"+
                          "c 1 0 0 0 0 0 1"+"\n"+
                          "d 1 1 0 0 0 1 0"+"\n"+
                          "e 1 0 0 0 0 0 1"+"\n"+
                          "f 0 1 0 1 0 0 0"+"\n"+
                          "g 0 0 1 0 1 0 0"+"\n"+
                          "\n"+
                          "a | b c d e"+"\n"+
                          "b | a d f"+"\n"+
                          "c | a g"+"\n"+
                          "d | a b f"+"\n"+
                          "e | a g"+"\n"+
                          "f | b d"+"\n"+
                          "g | c e"
                          );
    



      }
    

    }



}