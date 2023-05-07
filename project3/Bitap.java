package project3;
import java.util.*;

public class Bitap {
  
  public int match(String T, String P) {
    T = T.toLowerCase();
    P = P.toLowerCase();
    char[] T_array = T.toCharArray();
    char[] P_array = P.toCharArray();
    int m = P_array.length;
    int n = T_array.length;
    long mask = ~1;
    long mask_vector[] = generatemask( P_array, m);
    int idx = searchIndex( mask_vector, mask, n, m, T_array);
    return idx;
    }

    public long[] generatemask(char[] P_array, int m) {
      long mask_vector[] = new long[256 + 1];
      for (int i = 0; i <= 256; ++i) mask_vector[i] = ~0;
      for (int i = 0; i < m; ++i) {
        long shift = (1L << i);
        shift = ~shift;
        mask_vector[P_array[i]] &= shift;
      }
      return mask_vector;
    }

    public int searchIndex(long[] mask_vector, long mask,int n,int m, char[] T_array) {
      for (int i = 0; i < n; ++i) {     
        mask |= mask_vector[T_array[i]];
        mask <<= 1;
        long check = (1L << m);
        check = mask & check;
        if ( check == 0) return i - m + 1;
      }
      return -1;
    }

}
