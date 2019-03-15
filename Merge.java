import java.util.Arrays;

public class Merge{
  public static void mergesort(int[] data){
    mergesort(data,0,data.length);
  }

  private static void mergesort(int[] data, int lo, int hi){
    if(lo < hi && data.length > 1){
      int[] left,right;
      left = new int[hi/2];
      right = new int[data.length-left.length];
      for(int i = 0; i<left.length;i++){
        left[i]=data[i];
      }
      int n = 0;
      for(int i = left.length; i < data.length; i++){
        System.out.println(""+i+" "+data[i]);
        right[n]=data[i];
        n++;
      }
      mergesort(left,lo,left.length);
      mergesort(right,left.length+1,hi);
      merge(left,right);
    }
  }

  private static void merge(int[] in1, int[] in2){
    int[] out = new int[in1.length+in2.length];
    int current1 = 0;
    int current2 = 0;
    
    for(int i = 0; i < in1.length+in2.length; i++){
      System.out.println(current1);
      System.out.println(current2);
      if(current2>=in2.length||in1[current1]<in2[current2]){
        out[i]=in1[current1];
        current1++;
      }
      if(current1>=in1.length||in2[current2]<in1[current1]){
        out[i]=in2[current2];
        current2++;
      }
    }
  }

  public static void main(String args[]){
    int[] ary = {30,20,1};
    mergesort(ary);
    System.out.println(ary);
  }

}
