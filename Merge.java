import java.util.Arrays;

public class Merge{
  public static void mergesort(int[] data){
    mergesort(data,0,data.length-1);
  }

  private static void mergesort(int[] data, int lo, int hi){
    if(lo < hi){
      int[] left,right;

      left = new int[data.length/2];
      right = new int[data.length-left.length];
      for(int i = 0; i<left.length;i++){
        left[i]=data[i];
      }
      int n = 0;
      for(int i = left.length; i < data.length; i++){
        right[n]=data[i];
        n++;
      }

      //System.out.println("lo: "+lo+"\tleft.length: "+left.length+"\thi: "+hi);
      mergesort(left,lo,lo+left.length-1);
      mergesort(right,lo+left.length,hi);
      //System.out.println("left: "+Arrays.toString(left));
      //System.out.println("right: "+Arrays.toString(right));
      merge(left,right,data);
    }
  }

  private static void mergesortOpt(int[] data, int[] temp, int lo, int hi){
    if(lo<hi){
      int mid = (lo+hi)/2
      mergesortOpt(temp,data,lo,mid);
      mergesortOpt(temp,data,mid+1);
      merge(temp,data,lo,hi);
    }
  }
  
  private static void merge(int in[], int out[],int lo, int hi){
    
  }

  private static void merge(int[] in1, int[] in2, int[] out){
    int current1 = 0;
    int current2 = 0;

    //System.out.println("in1: "+ Arrays.toString(in1));
    //System.out.println("in2: "+Arrays.toString(in2));
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
    //System.out.println("Done merging: "+Arrays.toString(out));
  }

  public static void main(String args[]){
    int[] ary = new int[20];
    for(int i = 0; i < ary.length;i++){
      ary[i]=(int)(Math.random()*20)+1;
    }
    System.out.println(Arrays.toString(ary));
    mergesort(ary);
    System.out.println(Arrays.toString(ary));
  }

}
