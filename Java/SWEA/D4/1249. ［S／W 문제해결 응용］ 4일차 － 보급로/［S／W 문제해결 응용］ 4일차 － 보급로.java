/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int[][] sum;
	static int min;
	public static void DFS(int j, int k, int n, int total) {
		if(j == n - 1 && k == n - 1) {
			//System.out.println("//// total " + total);
			if(total + arr[j][k] < min || min == -1) {
				min = total + arr[j][k];
				return;
			}
		}
		
		sum[j][k] = total + arr[j][k];
		total = sum[j][k];
		//System.out.println("j - " + j + " k - " + k + " arr " + arr[j][k] + " total " + total);
		if(j < n - 1) {
			if(sum[j + 1][k] == -1 || sum[j + 1][k] > total + arr[j + 1][k]) {
				DFS(j + 1, k, n, sum[j][k]);
			}
		}
		if(k < n - 1) {
			if(sum[j][k + 1] == -1 || sum[j][k + 1] > total + arr[j][k + 1]) {
				DFS(j, k + 1, n, sum[j][k]);
			}
		}
		if(j > 0) {
			if(sum[j - 1][k] == -1 || sum[j - 1][k] > total + arr[j - 1][k]) {
				DFS(j - 1, k, n, sum[j][k]);
			}
		}
		if(k > 0) {
			if(sum[j][k - 1] == -1 || sum[j][k - 1] > total + arr[j][k - 1]) {
				DFS(j, k - 1, n, sum[j][k]);
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < tc; i++) {
        	int n = Integer.parseInt(br.readLine());
        	arr = new int[n][n];
        	sum = new int[n][n];
        	for(int j = 0; j < n; j++) {
        		String s = br.readLine();
        		for(int k = 0; k < s.length(); k++) {
        			arr[j][k] = s.charAt(k) - '0'; //문자열 -> 숫자로 변경 방법
        			sum[j][k] = -1;
        		}
        	}
        	min = -1;
        	DFS(0, 0, n, arr[0][0]);
        	
        	System.out.println("#" + (i+1) + " " + min);
        }
	}
}