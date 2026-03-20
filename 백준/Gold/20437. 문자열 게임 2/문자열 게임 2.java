import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            char[] arr = s.toCharArray();
            int[] rslt = {s.length() + 1, 0};
            
            Map<Character, List<Integer>> map = new HashMap<>();
            for(int j= 0; j < 26; j++) 
                map.put((char)('a' + j), new ArrayList<>());
            for(int j = 0; j < s.length(); j++)
                map.get(arr[j]).add(j);
            
            for(int j = 0; j < 26; j++) {
                char a = (char)('a' + j);
                for(int l = 0; l <= map.get(a).size() - k; l++) {
                    int len = map.get(a).get(l + k - 1) - map.get(a).get(l) + 1;
                    rslt[0] = rslt[0] > len ? len : rslt[0]; 
                    rslt[1] = rslt[1] < len ? len : rslt[1];
                }
            }
            
            if(rslt[0] > s.length() || rslt[1] == 0) 
                sb.append("-1\n"); 
            else 
                sb.append(rslt[0] + " " + rslt[1] + "\n");
        }
        
        System.out.print(sb.toString());
    }
}