
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = s.split("(?=[+-])|(?<=[+-])");
        int rslt = Integer.parseInt(arr[0]);
        
        for(int i = 1; i < arr.length; i += 2) {
            if(arr[i].equals("-")) {
                int sum = Integer.parseInt(arr[i + 1]);
                i += 2;
                
                while(i < arr.length) {
                    if(arr[i].equals("+"))
                        sum += Integer.parseInt(arr[i + 1]);
                    else {
                        i -= 2;
                        break;
                    }
                    i += 2;
                }
                rslt -= sum;
            }else {
                rslt += Integer.parseInt(arr[i + 1]);
            }
        }
        
        System.out.println(rslt);
    }
}