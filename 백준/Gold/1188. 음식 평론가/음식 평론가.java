import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Double n = Double.parseDouble(st.nextToken());
        Double m = Double.parseDouble(st.nextToken());

        int cnt = 0;
        for(int i = 1; i <= m; i++)
            if(i * n / m % 1.0 != 0)
                cnt++;
        
        System.out.print(cnt);
    }
}