import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int n = num;
        int cnt = 0;

        while(n > 0) {
            n/=10;
            cnt++;
        }
        int[] arr = new int[cnt];
        n = num;
        for(int i = 0; i < cnt; i++) {
            arr[i] = n % 10;
            n /= 10;
        }
        int temp;
        for(int i = 0; i < cnt - 1; i++) {
            int max = arr[i];
            int maxIdx = i;
            for(int j = i + 1; j < cnt; j++) {
                if(arr[j] > max) {
                    maxIdx = j;
                    max = arr[j];
                }
            }
            if (max != arr[i]) {
                temp = arr[i];
                arr[i] = max;
                arr[maxIdx] = temp;
            }
        }

        n = arr[0];
        for(int i = 1; i < cnt; i++) {
            n = n * 10 + arr[i];
        }
        System.out.println(n);
    }
}
