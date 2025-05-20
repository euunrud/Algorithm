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
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> st;
		for(int t = 1; t <= 10; t++) {
			int num = Integer.parseInt(br.readLine());
			st = new Stack<>();
			String s = br.readLine();
			String[] arr = s.split("");
			for(int i = 0; i < num; i++) {
				String a = arr[i];
				//System.out.println("Arr - " + a);
				if(a.equals("(") || a.equals("[") || a.equals("<") || a.equals("{")) {
					st.push(a);
				}
				else {
					String p = st.peek();
					if(a.equals(")")) {
						if(!p.equals("(")) {
							break;
						}
					}else if(a.equals("]")) {
						if(!p.equals("[")) {
							break;
						}
					}else if(a.equals(">")) {
						if(!p.equals("<")) {
							break;
						}
					}else if(a.equals("}")) {
						if(!p.equals("{")) {
							break;
						}
					}
                    st.pop();
					//System.out.print(st.pop() + " pp");
					
				}
			}
			if(!st.isEmpty()) {
//				while(!st.isEmpty()) {
//					System.out.print(" " + st.pop());
//				}
				System.out.println("#"+ t + " 0");
			}else {
				System.out.println("#"+ t + " 1");				
			}
			
		}
	}
}