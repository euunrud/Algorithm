import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            boolean ch = true;
            boolean[] use = new boolean[n];

            for(int j = 0; j < n - 1; j++) {
                if(arr[i][j] == arr[i][j + 1]) continue;
                if(Math.abs(arr[i][j] - arr[i][j + 1]) != 1) {
                    ch = false;
                    break;
                }

                if(arr[i][j] == arr[i][j + 1] + 1) {
                    for(int a = j + 1; a <= j + l; a++) {
                        if(a >= n || arr[i][a] != arr[i][j + 1] || use[a]) {
                            ch = false;
                            break;
                        }
                    }
                    
                    if(!ch) break;
                    for(int a = j + 1; a <= j + l; a++)
                        use[a] = true;
                    j += l - 1;
                } else {
                    for(int a = j; a > j - l; a--) {
                        if(a < 0 || arr[i][a] != arr[i][j] || use[a]) {
                            ch = false;
                            break;
                        }
                    }
                    
                    if(!ch) break;
                    for(int a = j; a > j - l; a--)
                        use[a] = true;
                }
            }
            if(ch) cnt++;
        }

        for(int j = 0; j < n; j++) {
            boolean ch = true;
            boolean[] use = new boolean[n];

            for(int i = 0; i < n - 1; i++) {
                if(arr[i][j] == arr[i + 1][j]) continue;
                if(Math.abs(arr[i][j] - arr[i + 1][j]) != 1) {
                    ch = false;
                    break;
                }

                if(arr[i][j] == arr[i + 1][j] + 1) {
                    for(int a = i + 1; a <= i + l; a++) {
                        if(a >= n || arr[a][j] != arr[i + 1][j] || use[a]) {
                            ch = false;
                            break;
                        }
                    }
                    
                    if(!ch) break;
                    for(int a = i + 1; a <= i + l; a++)
                        use[a] = true;
                    i += l - 1;
                } else {
                    for(int a = i; a > i - l; a--) {
                        if(a < 0 || arr[a][j] != arr[i][j] || use[a]) {
                            ch = false;
                            break;
                        }
                    }
                    
                    if(!ch) break;
                    for(int a = i; a > i - l; a--)
                        use[a] = true;
                }
            }
            if(ch) cnt++;
        }

        System.out.println(cnt);
    }
}