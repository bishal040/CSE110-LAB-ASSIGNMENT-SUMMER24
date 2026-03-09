import java.io.*;
import java.util.StringTokenizer;
public class D {
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String line = bf.readLine();
    StringTokenizer st = new StringTokenizer(line);
    int[] arr1 = new int[Integer.parseInt(st.nextToken())];
    line = bf.readLine();
    st = new StringTokenizer(line);
    for(int i =0; i< arr1.length; i++){
      arr1[i]=Integer.parseInt(st.nextToken());
    }
    line = bf.readLine();
    st = new StringTokenizer(line);
    int[] arr2 = new int[Integer.parseInt(st.nextToken())];
    line = bf.readLine();
    st = new StringTokenizer(line);
    for(int i =0; i< arr2.length; i++){
      arr2[i]=Integer.parseInt(st.nextToken());
    }
    int[] result = merge(arr1,arr2);
    for(int elem : result){
      bw.write(elem + " ");
    }
    bf.close();
    bw.flush();
    bw.close();
  }
  private static int[] merge(int[] arr1, int[] arr2){
    int[] result = new int[arr1.length + arr2.length];
    int p1 = 0, p2 = 0, count = 0;
    while(p1 < arr1.length && p2 < arr2.length){
        if(arr1[p1] <= arr2[p2]){
            result[count++] = arr1[p1++];
        } else {
            result[count++] = arr2[p2++];
        }
    }
    while(p1 < arr1.length){
        result[count++] = arr1[p1++];
    }
    while(p2 < arr2.length){
        result[count++] = arr2[p2++];
    }
    return result;
  }
}