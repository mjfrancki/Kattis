import java.util.Scanner;

public class DifferentProblem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(input.hasNext()){
          
          long first = input.nextLong();
          long second = input.nextLong();
          long ans = Math.abs(first - second);
          System.out.println(ans);
        }
    }
}