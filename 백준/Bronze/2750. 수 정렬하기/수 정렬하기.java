import java.util.*;
public class Main {

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        int fl = 0;
        for(int i = 0; i < num - 1; i++) {  //n개의 수를 버블 정렬하는데 n-1개를 확정하면 1개는 자동 확정이기에 n-1번 루프를 돔.
            for (int j = 0; j < num - i - 1; j++) {  // swap방식이 젤 큰 수가 맨뒤로 가게 되기에 이 줄이 j=0 ~ num - i - 1이 됨을 이해하기.
                if(arr[j] > arr[j + 1]) {
                    fl = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = fl;
                }
            }
        }
        for(int i = 0; i < num; i++)
            System.out.println(arr[i]);
    }

}