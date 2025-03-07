// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) {
                max = arr[i];
            }
            sum += arr[i];
        }
        
		double aver = sum/max * 100.0/(double)n;
        System.out.println(aver);
    }
}