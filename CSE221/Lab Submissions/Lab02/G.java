import java.io.*;
import java.util.StringTokenizer;

public class G {
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line = bf.readLine();
    StringTokenizer st = new StringTokenizer(line);
    int[] arr = new int[Integer.parseInt(st.nextToken())];
    int[][] range = new int[Integer.parseInt(st.nextToken())][2];
    int[] count = new int[range.length];
    line = bf.readLine();
    st = new StringTokenizer(line);
    for(int i=0; i<range.length; i++){
      String line1 = bf.readLine();
      StringTokenizer st1 = new StringTokenizer(line1);
        range[i][0] = Integer.parseInt(st1.nextToken());
        range[i][1] = Integer.parseInt(st1.nextToken());
    }
    for(int i=0; i< arr.length;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    for(int i=0; i<range.length;i++){
      int left = lowerBound(arr, range[i][0]);
      int right = upperBound(arr, range[i][1]);
      count[i] = right - left;
    }
    for(int elem: count){
      bw.write(elem + " ");
      bw.newLine();
    }
    bw.flush();
    bw.close();
    bf.close();
  }
  private static int lowerBound(int[] arr, int x) {
    int left = 0, right = arr.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] < x) left = mid + 1;
      else right = mid;
    }
    return left;
  }
  private static int upperBound(int[] arr, int x) {
    int left = 0, right = arr.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] <= x) left = mid + 1;
      else right = mid;
    }
    return left;
}
}
