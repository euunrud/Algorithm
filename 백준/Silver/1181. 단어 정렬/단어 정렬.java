import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();
        for(int i = 0; i < num; i++) {
            String s = br.readLine();
            if(!set.contains(s))
                set.add(s);
        }
        int size = set.size();
        String[] arr = new String[size];
        int idx = 0;
        for(String s: set) {
            arr[idx++] = s; 
        }
        
        Arrays.sort(arr, (a, b) -> {
            if(a.length() == b.length())
                return a.compareTo(b);
            return a.length() - b.length();
        });
        
        for(int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
        
    }
}