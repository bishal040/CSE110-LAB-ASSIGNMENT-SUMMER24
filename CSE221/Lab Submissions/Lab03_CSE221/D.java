import java.io.*;
import java.util.*;

public class D{
    static final long MOD = 1000000007;

    static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        C[0][0] = (A[0][0] * B[0][0] % MOD + A[0][1] * B[1][0] % MOD) % MOD;
        C[0][1] = (A[0][0] * B[0][1] % MOD + A[0][1] * B[1][1] % MOD) % MOD;
        C[1][0] = (A[1][0] * B[0][0] % MOD + A[1][1] * B[1][0] % MOD) % MOD;
        C[1][1] = (A[1][0] * B[0][1] % MOD + A[1][1] * B[1][1] % MOD) % MOD;
        return C;
    }

    static long[][] matrixPower(long[][] A, long power) {
        long[][] result = { {1, 0}, {0, 1} };
        while (power > 0) {
            if ((power & 1) == 1) result = multiply(result, A);
            A = multiply(A, A);
            power >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a11 = Long.parseLong(st.nextToken());
            long a12 = Long.parseLong(st.nextToken());
            long a21 = Long.parseLong(st.nextToken());
            long a22 = Long.parseLong(st.nextToken());
            long[][] A = { {a11, a12}, {a21, a22} };
            long X = Long.parseLong(br.readLine());
            long[][] res = matrixPower(A, X);
            sb.append(res[0][0]).append(" ").append(res[0][1]).append("\n");
            sb.append(res[1][0]).append(" ").append(res[1][1]).append("\n");
        }
        System.out.print(sb);
    }
}