import java.util.Arrays;

public class Merge{
  public static void mergesort(int[] data){
    //mergesort(data,0,data.length-1);
    int[] temp = new int[data.length];
    for(int i = 0; i < data.length;i++){
      temp[i]=data[i];
    }
    mergesortOpt(data,temp,0,data.length-1);
  }
  
  //bounded
  public static void insertionSort(int[] data, int lo, int hi){
    for (int i = lo+1; i<=hi;i++){
      int x = data[i];
      int n = i;
      while (n > lo && x < data[n-1]){
        data[n]=data[n-1];
        n--;
      }
      data[n]=x;
    }
  }
  
  //not bounded
  public static void insertionSort(int[] data){
    for (int i = 1; i<data.length;i++){
      int x = data[i];
      int n = i;
      while (n > 0 && x < data[n-1]){
        data[n]=data[n-1];
        n--;
      }
      data[n]=x;
    }
  }
  
  
  //creating new arrays each time
  private static void mergesort(int[] data, int lo, int hi){
    if(lo+100 < hi){
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
    else{
      insertionSort(data);
    }
  }
  
  //switching b/w 2 arrays
  private static void mergesortOpt(int[] data, int[] temp, int lo, int hi){
    if(lo+100<hi){
      int mid = (lo+hi)/2;
      mergesortOpt(temp,data,lo,mid);
      mergesortOpt(temp,data,mid+1,hi);
      merge(temp,data,lo,hi);
    }
    else{
      insertionSort(data,lo,hi);
    }

  }
  
  //merging the data with temp array
  private static void merge(int in[], int out[],int lo, int hi){
    int mid = (lo+hi)/2+1;
    int current = mid;
    for(int i = lo; i <= hi; i++){
      if(current>hi||lo<mid&&in[lo]<in[current]){
        out[i]=in[lo++];
      }
      else out[i]=in[current++];
    }
  }

   //merging left and right arrays into data
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
    int[] ary = new int[7];
    for(int i = 0; i < ary.length;i++){
      ary[i]=(int)(Math.random()*100)+1;
    }
    System.out.println(Arrays.toString(ary));
    mergesort(ary);
    System.out.println(Arrays.toString(ary));
  }

}
