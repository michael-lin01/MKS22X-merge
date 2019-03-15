public class Merge{
  public static void mergesort(int[] data){
    mergesort(data,0,data.length);
  }

  private static void mergesort(int[] data, int lo, int hi){
    if(lo < hi){
      int[] left,right;
      left = new int[hi/2];
      right = new int[data.length-hi/2];

      for(int i = 0; i<left.length;i++){
        left[i]=data[i];
      }
      for(int i = left.length; i < data.length; i++){
        right[i]=data[i];
      }

      mergesort(left,0,left.length);
      mergesort(right,0,right.length);
      merge(left,right);
    }
  }

  private static void merge(int[] in1, int[] in2){
    int[] out = new int[in1.length+in2.length];
    int current1 = 0;
    int current2 = 0;
    for(int i = 0; i < in1.length+in2.length; i++){
      if(in1[current1]<in2[current2]){
        
      }
    }
  }




}
