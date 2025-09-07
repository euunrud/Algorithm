import java.io.*;
import java.util.*;

class Main {
    static int num;
    static int max;
    static int min;
    static int[] nums;
    static int[] op;
    public static void check(int n, int sum) {
        if(n == num) {
            max = sum > max ? sum : max;
            min = sum < min ? sum : min;
            return;
        }
        
        int rslt;
        for(int i = 0; i < 4; i ++) {
            if(op[i] > 0) {
                rslt = sum;
                op[i]--;
                if(i == 0) { //덧셈
                    rslt += nums[n];
                }else if(i == 1) { //뺄셈
                    rslt -= nums[n];
                }else if(i == 2) { //곱셈
                    rslt *= nums[n];
                }else if(i == 3){ //나눗셈
                    rslt /= nums[n];
                }
                check(n + 1, rslt);
                op[i]++;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        
        nums = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }
        max = -1000000000;
        min = 1000000000;
       
        check(1, nums[0]);
        System.out.println(max +"\n" + min);
    }
}