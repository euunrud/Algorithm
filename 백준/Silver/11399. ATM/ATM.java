import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num; i++) 
            arr[i] = sc.nextInt();

        int minIdx, temp;
        for(int i = 0; i < num - 1; i++) {
            int min = arr[i];
            minIdx = i;
            for (int j = i + 1; j < num; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    minIdx = j;
                }
            }
            if(min != arr[i]) {
                temp = arr[i];
                arr[i] = min;
                arr[minIdx] = temp;
            }
        }
        //System.out.println("arr - " + Arrays.toString(arr));
        int sum = 0;
        for(int i = 0; i < num; i++) {
            int s = 0;
            for(int j = 0; j < i; j++)
                s += arr[j];
            sum += s + arr[i];
        }
        System.out.println(sum);
    }
}