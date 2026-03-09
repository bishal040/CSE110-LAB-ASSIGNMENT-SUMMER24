import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class E {

    public static long[] solve(long a, long n, long m) {
        if (n == 0) {
            return new long[]{0, 1};
        }

        if (n % 2 == 0) {
            long[] temp = solve(a, n / 2, m);
            long sum_k = temp[0];
            long pow_k = temp[1];

            long sum_n = (sum_k * (1 + pow_k)) % m;
            long pow_n = (pow_k * pow_k) % m;
            
            return new long[]{sum_n, pow_n};
        } else {
            long[] temp = solve(a, n - 1, m);
            long sum_k = temp[0];
            long pow_k = temp[1];
            
            long pow_n = (pow_k * a) % m;
            long sum_n = (sum_k + pow_n) % m;

            return new long[]{sum_n, pow_n};
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());

            long result = solve(a % m, n, m)[0];
            sb.append(result).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}