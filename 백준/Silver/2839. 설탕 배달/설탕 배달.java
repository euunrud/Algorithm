import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int rslt = -1;

        for (int f = n / 5; f >= 0; f--) {
            int rest = n - f * 5;
            if (rest % 3 == 0) {
                rslt = f + (rest / 3);
                break;
            }
        }

        System.out.print(rslt);
    }
}
