import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int ball = 1;
        int a = 1;
        int b = 2;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a == ball) {
                ball = b;
            }else if(b == ball) {
                ball = a;
            }
        }
        
        System.out.println(ball);
        
    }
}