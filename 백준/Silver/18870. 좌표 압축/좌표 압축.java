import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] sorted = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(st.nextToken());
            arr[i] = v;
            sorted[i] = v;
        }

        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < n; i++)
            if (i == 0 || sorted[i] != sorted[i - 1])
                map.put(sorted[i], idx++);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i]));
            if (i + 1 < n) sb.append(' ');
        }

        System.out.print(sb.toString());
    }
}