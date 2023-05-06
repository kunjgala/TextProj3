package project3;


public class RK {
  
  public int match(String T, String P) {
    T = T.toLowerCase();
    P = P.toLowerCase();
    int n = T.length();
    int m = P.length();
    // System.out.println("hash pat: " + computeHash(P));
    // int x = computeHash(T.substring(0,P.length()));
    // System.out.println(x);
    // System.out.println(shiftHash(T, P, x, 1));
    int hashP = computeHash(P);
    // System.out.println("hashp: "+ hashP);
    int f = -1;
    for(int i=0;i<n-m+1;i++) {
      if(i==0) {
        f = computeHash(T.substring(0,m));
      }
      else {
          f = shiftHash(T, P, f, i);
          // System.out.println("shift hash for index "+i);
          // System.out.println("f: "+f);
      }
          if(f==hashP) {
          //  System.out.println("compared");
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
      if(hash!=-1) hash = hash + ((int) Math.pow(256, n-i)*(int)(P.charAt(i-1)-'a' +1));
      else hash = ((int) Math.pow(256, n-i)*(int)(P.charAt(i-1)-'a' +1));
    }
    return hash;
  }

  // public int shiftHash(String T, String P, int oldHash, int idx) {
  //   int newHash = 10*oldHash;
  //   newHash = newHash ^ ((int) Math.pow(10, P.length())*(int)(T.charAt(idx-1)-'a' +1));
  //   newHash = newHash ^ (int)(T.charAt(idx+P.length()-1)-'a' +1);
  //   return newHash<<P.length();
  // }

  public int shiftHash(String T, String P, int oldHash, int idx) {
    int newHash = oldHash - ((int) Math.pow(256, P.length()-1)*(int)(T.charAt(idx-1)-'a' +1));
    newHash = newHash*256;
    newHash = newHash + (int)(T.charAt(idx+P.length()-1)-'a' +1);
    return newHash;
  }

}