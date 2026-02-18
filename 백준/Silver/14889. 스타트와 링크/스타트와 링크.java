import java.io.*;
import java.util.*;

public class Main {
    static int rslt = Integer.MAX_VALUE;
    static int n;
    static int[][] arr;
    static int calc(Set<Integer> t) {
        int sum = 0;
        for(int i = 0; i < n; i++)
            for(int j = i + 1; j < n; j++)
                if(t.contains(i) && t.contains(j))
                    sum += arr[i][j] + arr[j][i];
        return sum;
    }
    static void pick(int cnt, int idx, Set<Integer> team) {
        if(idx > n) return;
        if(cnt == n / 2) {
            Set<Integer> team2 = new HashSet<>();
            for(int j = 0; j < n; j++)
                if(!team.contains(j))
                    team2.add(j);
                    
            rslt = Math.min(Math.abs(calc(team) - calc(team2)), rslt);
            return;
        }
        
        for(int i = idx; i < n; i++) {
            team.add(i);
            pick(cnt + 1, i + 1, team);
            team.remove(i);
        }
        return;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        Set<Integer> team = new HashSet<>();
        for(int i = 1; i < n; i++) {
            team = new HashSet<>();
            team.add(0);
            team.add(i);
            pick(2, i + 1, team);
            if(team.size() != n / 2)  continue;
        }
        
         System.out.print(rslt);
    }
}