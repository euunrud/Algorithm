
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = new int[9];
        int[] cp = new int[9];
        for(int i = 1; i <= 8; i++) {
           scores[i] = Integer.parseInt(br.readLine());
           cp[i] = scores[i];
        }
        Arrays.sort(cp);
        int num = cp[4];
        int rslt = 0;
        for(int i = 4; i <= 8; i++) {
           rslt += cp[i];
        }
        
        System.out.println(rslt);
        for(int i = 1; i <= 8; i++) {
           if(scores[i] >= num) {
               System.out.print(i + " ");
           }
        }
    }
}