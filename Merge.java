import java.util.Arrays;

public class Merge{
  public static void mergesort(int[] data){
    mergesort(data,0,data.length);
  }

  private static void mergesort(int[] data, int lo, int hi){
    if(lo < hi && data.length > 1){
      int[] left,right;

      left = new int[(hi-lo)/2];
      right = new int[data.length-left.length];
      for(int i = 0; i<left.length;i++){
        left[i]=data[i];
      }
      int n = 0;
      for(int i = left.length; i < data.length; i++){
        right[n]=data[i];
        n++;
      }

      mergesort(left,lo,left.length);
      mergesort(right,left.length+1,hi);
      //System.out.println("left: "+Arrays.toString(left));
      //System.out.println("right: "+Arrays.toString(right));
      merge(left,right,data);
    }
  }

  private static void merge(int[] in1, int[] in2, int[] out){
    int current1 = 0;
    int current2 = 0;

    System.out.println("in1: "+ Arrays.toString(in1));
    System.out.println("in2: "+Arrays.toString(in2));
    //System.out.println(in1.length+in2.length);

    for(int i = 0; i < in1.length+in2.length; i++){
      /*
      System.out.println("out: "+Arrays.toString(out));
      System.out.println("i "+ i);
      System.out.println("current1: "+ current1);
      System.out.println("current2: "+ current2);
      */
      if(current2>=in2.length||current1<in1.length&&in1[current1]<in2[current2]){
        //System.out.println("current1: "+current1+" value: "+ in1[current1]);
        out[i]=in1[current1++];
      }
      else{
        //System.out.println("current2: "+current2);
        out[i]=in2[current2++];
      }
    }
    System.out.println("Done merging: "+Arrays.toString(out));
  }

  public static void main(String args[]){
    int[] ary = {30,20,1,7,10,15,1,4};
    mergesort(ary);
    System.out.println(Arrays.toString(ary));
  }

}
