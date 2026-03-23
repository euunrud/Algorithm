import java.util.*;
import java.io.*;

class Main {
    static int max = Integer.MIN_VALUE;
    public static int calc(char[] arr, boolean[] ch) {
        int sum = 0;
        for(int i = 0; i < arr.length; i += 2) {
            if(ch[i] == true) {
                int rslt = (int)(arr[i] - '0');;
                if(arr[i + 1] == '+')
                    rslt += (int)(arr[i + 2] - '0');
                else if(arr[i + 1] == '-')
                    rslt -= (int)(arr[i + 2] - '0');
                else if(arr[i + 1] == '*')
                    rslt *= (int)(arr[i + 2] - '0');
                
                if(i - 1 >= 0) {
                    if(arr[i - 1] == '+')
                        sum += rslt;
                    else if(arr[i - 1] == '-')
                        sum -= rslt;
                    else if(arr[i - 1] == '*')
                        sum *= rslt;
                }else
                    sum += rslt;
                i += 2;
            }
            else {
                if(i - 1 >= 0) {
                    if(arr[i - 1] == '+')
                        sum += (int)(arr[i] - '0');
                    else if(arr[i - 1] == '-')
                        sum -= (int)(arr[i] - '0');
                    else if(arr[i - 1] == '*')
                        sum *= (int)(arr[i] - '0');
                }else
                    sum += (int)(arr[i] - '0');
            }
        }
        
        return sum;
    }
    
    public static void dfs(char[] arr, int idx, boolean[] ch) {
        if(idx == arr.length - 1) {
            int sum = calc(arr, ch);
            max = max > sum ? max : sum;
            return;
        }
        
        dfs(arr, idx + 2, ch);
        if(ch[idx] == false) {
            for(int i = idx; i <= idx + 2; i++)
                ch[i] = true;
            dfs(arr, idx + 2, ch);
            for(int i = idx; i <= idx + 2; i++)
                ch[i] = false;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] arr = s.toCharArray();
        boolean[] ch = new boolean[arr.length];
        
        //홀수에 연산자, 짝수에 숫자
        dfs(arr, 0, ch);
        System.out.print(max);
    }
}