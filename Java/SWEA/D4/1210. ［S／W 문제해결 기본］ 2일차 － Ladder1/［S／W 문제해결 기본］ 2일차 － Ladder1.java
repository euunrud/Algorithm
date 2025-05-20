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
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Solution {
	static int[][] arr;
	static boolean[][] check;
	static boolean sn = false;
	static void DFS(int i, int j) {
		if(arr[i][j] == 2) {
			sn = true;
			return;
		}else if(i == 99) {
			return;
		}
		
		check[i][j] = true;
		if((j > 0) && (arr[i][j - 1] == 1)&& (check[i][j - 1] == false)) {
			DFS(i, j - 1);
		}else if((j < 99) && arr[i][j + 1] == 1 && check[i][j + 1] == false) {
			DFS(i, j + 1);
		}else {
			DFS(i + 1, j);
		}
		check[i][j] = false;
		
		return;
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int t = 1; t <= 10; t++) {
			sn = false;
			int num = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			check = new boolean[100][100];
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int rslt = -1;
			for(int j = 0; j < 100; j++) {
				if(arr[0][j] == 1) {
					DFS(0, j);
					if(sn == true) {
						rslt = j;
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + rslt);
		}
		
	}
}
