import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while(n > 0) {
            if(n % 2 == 1)
                sb.append("1");
            else
                sb.append("0");
            n /= 2;
        }
        
        System.out.println(sb.reverse().toString());
    }
}