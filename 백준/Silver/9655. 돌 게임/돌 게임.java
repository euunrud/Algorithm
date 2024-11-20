import java.util.Scanner;

class Main {
    static int per;
    static void bfs(int n) {
        if(n == 0) {
            return;
        }
        if(n > 3) {
            n -= 3;
            per *= -1;
            bfs(n);
        }
        else {
            n -= 1;
            per *= -1;
            bfs(n);
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        per = -1;
        bfs(n);
        if(per == 1) {
            System.out.println("SK");
        }else {
            System.out.println("CY");
        }
        
    }
}