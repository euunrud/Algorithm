import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String[] arr = s.split("\\.", -1);

        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length();
            if (len % 2 != 0) {
                System.out.println("-1");
                return;
            }

            while (len >= 4) {
                sb.append("AAAA");
                len -= 4;
            }
            if (len == 2)
                sb.append("BB");

            if (i + 1 != arr.length)
                sb.append(".");
        }

        System.out.println(sb.toString());
    }
}
