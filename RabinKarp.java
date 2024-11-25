public class RabinKarp {
    private final static int d = 256;
    private final static int q = 997;

    public static void main(String[] args)
    {
        String txt1 = "abcdabadbc";
        String txt2 = "abcdabadbcabcdabadbc";
        String txt3 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt4 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt5 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt6 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt7 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt8 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt9 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt10 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        
        String pat = "issk";
 
        System.out.println("\nTXT1");
        rabinKarpRollingHash(pat, txt1);
        System.out.println("\nTXT2");
        rabinKarpRollingHash(pat, txt2);
        System.out.println("\nTXT3");
        rabinKarpRollingHash(pat, txt3);
        System.out.println("\nTXT4");
        rabinKarpRollingHash(pat, txt4);
        System.out.println("\nTXT5");
        rabinKarpRollingHash(pat, txt5);
        System.out.println("\nTXT6");
        rabinKarpRollingHash(pat, txt6);
        System.out.println("\nTXT7");
        rabinKarpRollingHash(pat, txt7);
        System.out.println("\nTXT8");
        rabinKarpRollingHash(pat, txt8);
        System.out.println("\nTXT9");
        rabinKarpRollingHash(pat, txt9);
        System.out.println("\nTXT10");
        rabinKarpRollingHash(pat, txt10);
    }
 
    private static void rabinKarpRollingHash(String pat, String txt) {
        int op = 0;
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0;
        int t = 0;
        int h = 1;
 
        for (i = 0; i < M - 1; i++) {
            op++;
            h = (h * d) % q;
        }
        
        for (i = 0; i < M; i++) {
            op++;
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        
        for (i = 0; i <= N - M; i++) {
            op++;
            if (p == t) {
                for (j = 0; j < M; j++) {
                    op++;
                    if (txt.charAt(i + j) != pat.charAt(j)) break;
                }
                
                if (j == M) System.out.println("Pattern found at index " + i);
            }
            
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

                if (t < 0) t = (t + q);
            }
        }
        System.out.println("op=" + op);
    }
}