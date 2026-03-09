import java.io.*;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int result = calculate(a, b);
        System.out.println(result);
    }
    public static int calculate(long a, long b) {
        int mod = 107;
        long result = 1;
        a = a % mod;
        while (b > 0) {
            if (b % 2 == 1) {   
                result = (result * a) % mod;
            }
            a = (a * a) % mod;     
            b = b / 2;              
        }
        return (int) result;
    }
}