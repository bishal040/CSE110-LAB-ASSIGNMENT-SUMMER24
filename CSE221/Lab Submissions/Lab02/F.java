import java.io.*;
import java.util.StringTokenizer;
public class F {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] freq = new int[n + 1]; 
        int distinct = 0;
        int left = 0, maxLen = 0;
        for (int right = 0; right < n; right++) {
            if (freq[arr[right]] == 0) distinct++;
            freq[arr[right]]++;
            while (distinct > k) {
                freq[arr[left]]--;
                if (freq[arr[left]] == 0) distinct--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        bw.write(maxLen + "\n");
        bw.close();
        bf.close();
    }
}