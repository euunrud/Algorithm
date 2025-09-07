import java.io.*;
import java.util.*;

class Main {
    static long start;
    static long end;
    static int size;
    static boolean[] check;
    public static void eratos() {
        for(int i = 2; i <= size; i++) {
            check[i] = true;
        }
        
        for(int i = 2; i <= size; i++) {
            if(check[i] == true) {
                for(long j = (long)i * i; j <= size; j += i) {
                    if(j > size){
                        break;
                    }
                    check[(int)j] = false;
                }
            }
        }
        /**for(int i = 2; i <= end; i++) {
            if(check[i] == true) {
               System.out.println(check[i] + " -- " + i);
            }
        }**/
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());
        
        size = (int)Math.sqrt(end);
        check = new boolean[size + 1];
        eratos();
        
        int cnt = 0;
        for(int i = 2; i <= size; i++) {
            if(check[i] == true) {
                for(long j = (long)i * i; j <= end; j *= i) {
                    if(j >= start) {
                        cnt++;
                    }
                    if (j > end / i) break;
                }
            }
        }
        
        System.out.println(cnt);
    }
}