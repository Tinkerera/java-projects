import java.util.Scanner;

public class Solution {
    public static void checkNumber(int n, int p) throws Exception {
        if (n == 0 && p == 0){
            throw new Exception("n and p should not be zero.");
        }
        else if (n < 0 || p < 0){
            throw new Exception("n or p should not be negative");
        } else {
            System.out.println((int)Math.pow(n, p));
        }}
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        int p;
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            n = scanner.nextInt();
            p = scanner.nextInt();
            try {
                checkNumber(n, p);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}