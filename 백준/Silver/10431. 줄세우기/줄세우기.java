import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int p = Integer.parseInt(br.readLine());

        for (int t = 0; t < p; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int testCase = Integer.parseInt(st.nextToken());
            int[] arr = new int[20];
            int count = 0;

            for (int i = 0; i < 20; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i < 20; i++)
                for (int j = 0; j < i; j++)
                    if (arr[j] > arr[i]) {
                        int temp = arr[i];
                        for (int k = i; k > j; k--) {
                            arr[k] = arr[k - 1];
                            count++;
                        }

                        arr[j] = temp;
                        break;
                    }
           
            sb.append(testCase).append(" ").append(count).append("\n");
        }

        System.out.print(sb);
    }
}