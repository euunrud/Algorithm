import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int dist = n2 - n1;
            int k = (int)Math.sqrt(dist);

            int c;
            if(k * k == dist)
                c = 2 * k - 1;
            else if(dist <= k * k + k)
                c = 2 * k;
            else
                c = 2 * k + 1;

            System.out.println(c);
        }
    }
}
