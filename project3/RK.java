package project3;


public class RK {
  
  public int match(String T, String P) {
    T = T.toLowerCase();
    P = P.toLowerCase();
    int n = T.length();
    int m = P.length();
    int hashP = computeHash(P);
    int f = -1;
    for(int i=0;i<n-m+1;i++) {
      if(i==0) {
        f = computeHash(T.substring(0,m));
      }
      else {
          f = shiftHash(T, P, f, i);
      }
          if(f==hashP) {
            int j =0;
            while(j<m && T.charAt(i+j)==P.charAt(j)) {
              j++;  
            }
            if(j==m) return i;
          }
        
      } 
    return -1;
  }

  public int computeHash(String P) {
    int n = P.length();
    int hash = -1;
    for(int i=1;i<=n;i++) {
      if(hash!=-1) hash = hash ^ ((int)(P.charAt(i-1)-'a' +1)<<(n-i));
      else hash = ((int)(P.charAt(i-1)-'a' +1)<<(n-i));
    }
    return hash;
  }

  public int shiftHash(String T, String P, int oldHash, int idx) {
    int newHash = oldHash<<1;
    newHash = newHash ^ ((int)(T.charAt(idx-1)-'a' +1)<<(P.length()));
    newHash = newHash ^ (int)(T.charAt(idx+P.length()-1)-'a' +1);
    return newHash;
  }

}