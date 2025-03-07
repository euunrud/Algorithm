import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		
		//n의 범위가 1 ~ 100이기에 int로 받을 수 없음. 
        int n = sc.nextInt();
        String num = sc.next();
        char[] numArr = num.toCharArray();
        int rslt = 0;
        for(int i = 0; i < n; i++) {
            rslt += numArr[i] - '0';
        }
        
        System.out.println(rslt);
    }
}