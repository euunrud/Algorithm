import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        long[] ch = new long[n > 3 ? n + 1:4];
        if(n == 1){
            System.out.println(1);
            return;
        }
        ch[1] = 1;
        ch[2] = 1;
        ch[3] = 2;
        for(int i = 3; i < n + 1; i++) {
            ch[i] = ch[i - 2] + ch[i - 1];
        }
        System.out.println(ch[n]);
    }
}