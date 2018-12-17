public class Solution2 {

  // O(n)
  public int solution(int[] A) {
    // write your code in Java SE 8
    //cause p<q<r, we need at least 3 elements for the pit.
    int n = A.length;
    if(n<3)
      return -1;
    int max = -1;
    int p = 0;
    int q=-1, r=-1;
    boolean desc = true;
    for(int i = 0; i<n-1; i++){
      if(desc){
        while (i<(n-1) && A[i]>A[i+1]){
          i++;
        }
        if(i>p){
          desc=false;
          q = i;
        } else {
          desc = true;
          p = i+1;
        }
      }
      if(!desc){
        while (i<(n-1) && A[i]<A[i+1]){
          i++;
        }
        if(i>q){
          r = i;
        } else {
          p = i + 1;
        }
      }
      if(p<q && q<r && r<n){
        max = Math.max(Math.min(A[p]-A[q], A[r]-A[q]), max);
        p = r;
      }
      desc=true;
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(new Solution2().solution(new int[]{0, 1, 3, -2, 0, 1, 0, -3, 2, 3}));
    System.out.println(new Solution2().solution(new int[]{5,1, 10,2,10}));
    System.out.println(new Solution2().solution(new int[]{5,1, -3, -5, -8, 2, 2}));
    System.out.println(new Solution2().solution(new int[]{2,2,2,2,2}));
    System.out.println(new Solution2().solution(new int[]{1,2,3,-1,0}));
    System.out.println(new Solution2().solution(new int[]{1,3,1,2,0}));
    System.out.println(new Solution2().solution(new int[]{1, 1, 2, 5, 1, 8}));

    System.out.println(new Solution2().solution(new int[]{5,8, 10,2,10,1}));
  }
}
