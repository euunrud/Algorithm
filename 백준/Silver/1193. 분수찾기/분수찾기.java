import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int l = 1;
        int sum = 1;
        
        while (sum < x) {
            l++;
            sum += l;
        }

        int diff = sum - x;
        int a, b;
        if (l % 2 == 0) {
            a = l - diff;
            b = 1 + diff;
        } else {
            a = 1 + diff;
            b = l - diff;
        }

        System.out.print(a + "/" + b);
    }
}