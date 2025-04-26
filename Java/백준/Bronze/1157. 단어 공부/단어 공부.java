import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char a : str.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int max = 0;
        char answer = '?';
        for (char a : map.keySet()) {
            if (map.get(a) > max) {
                max = map.get(a);
                answer = a;
            } else if (map.get(a) == max) {
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}
