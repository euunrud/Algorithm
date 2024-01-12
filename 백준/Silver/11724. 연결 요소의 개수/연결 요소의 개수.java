import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static ArrayList<Boolean> check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sn = new StringTokenizer(br.readLine());
        int n, m;
        n = Integer.parseInt(sn.nextToken());
        m = Integer.parseInt(sn.nextToken());

        list = new ArrayList[n + 1];
        check = new ArrayList<>(Collections.nCopies(n + 1, false));

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        int n1, n2;
        for (int i = 0; i < m; i++) {
            sn = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(sn.nextToken());
            n2 = Integer.parseInt(sn.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (check.get(i) == false) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    static public void DFS(int index) {
         if(check.get(index) == true) {
            return;
        }

        check.set(index, true);
        for (int i : list[index]) {
            if (check.get(i) == false) {
                DFS(i);
            }
        }
    }
}
