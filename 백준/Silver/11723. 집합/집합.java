import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int mask = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < t; i++) {
            String[] arr = br.readLine().split(" ");
            int n = 0;
            if(arr.length > 1) 
                n = Integer.parseInt(arr[1]);
            if(arr[0].equals("add"))
                mask |= (1 << n);
            else if(arr[0].equals("check"))
                sb.append(((mask & (1 << n)) != 0 ? 1: 0) + "\n");
            else if(arr[0].equals("remove"))
                mask &= ~(1 << n);
            else if(arr[0].equals("toggle"))
                mask ^= (1 << n);
            else if(arr[0].equals("all"))
                mask = (1 << 21) - 1;
            else if(arr[0].equals("empty"))
                mask = 0;
        }
        System.out.println(sb.toString());
    }
}