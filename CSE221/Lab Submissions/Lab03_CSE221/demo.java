import java.io.*;
import java.util.StringTokenizer;
public class demo {
  public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    int[] arr = new int[Integer.parseInt(st.nextToken())];
    st = new StringTokenizer(bf.readLine());
    for(int i = 0; i < arr.length; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    long inversion = mrgs(arr, 0, arr.length-1);
    System.out.println(inversion);
    printArray(arr);
  }
  public static long mrgs(int[] arr, int left, int right){
    if(left < right){
      int mid = left + (right-left)/2;
      long LC = mrgs(arr,left, mid);
      long RC = mrgs(arr, mid+1, right);
      long invCount = mrg(arr, left, mid, right);
      return LC + RC + invCount;
    }
    return 0;
  }
  public static long mrg(int[] arr, int left , int mid, int right){
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int inversion = 0;
    int[] leftArr = new int[n1];
    int[] rightArr = new int[n2];
    for(int i = 0 ; i < n1 ; i++){
      leftArr[i] = arr[left+i];
    }
    for(int j = 0 ; j < n2 ; j++){
      rightArr[j] = arr[mid+1+j];
    }
    int i = 0, j = 0, k = left;
    while(i < n1 && j < n2){
      if(leftArr[i] <= rightArr[j]){
        arr[k++] = leftArr[i++];
      }
      else{
        arr[k++] = rightArr[j++];
        inversion += (n1 - i) ;
      }
    }
    while(i < n1){
      arr[k++] = leftArr[i++];
    }
    while(j < n2){
      arr[k++] = rightArr[j++];
    }
    return inversion;
  }
  public static void printArray(int[] arr){
    for(int elem : arr){
      System.out.print(elem + " ");
    }
    System.out.println("");
  }
}
