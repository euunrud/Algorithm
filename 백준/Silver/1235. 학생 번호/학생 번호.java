import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        String[] arr = new String[n];
        for(int i = 0; i < n; i++)
            arr[i] = br.readLine();
        
        int len = arr[0].length();
        for(int i = 1; i <= len; i++) {
            Set<String> set = new HashSet<>();
            boolean ch = true;
            
            for(int j = 0; j < n; j++) {
                String s = arr[j].substring(len - i, len);
                if(set.contains(s)) {
                    ch = false;
                    break;
                }
                set.add(s);
            }
            if(ch == true) {
                System.out.println(i);
                break;
            }
        }
    }
}