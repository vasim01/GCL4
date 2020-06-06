import java.util.Scanner;

public class SumOfNNumbers{

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        firstSolution(n); // complexity : O(n)
        optimizedSolution(n); // complexity : O(1)
    }

    private static void firstSolution(int n){
        System.out.println("Entered value: " + n);
        int num = 0;
        for(int i =1; i<=n; i++){
                num = num + i;
        }
        System.out.println(String.format("First Solution: Sum Of %s values is %s", n, num));
        System.out.println("Complexity: {O(n)}");
    }

    private static void optimizedSolution(int n){
        System.out.println(String.format("Optimized Solution: Sum Of %s values is %s", n, n*(n+1)/2));
        System.out.println("Complexity: {O(1)}");
    }
}