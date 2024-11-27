import java.io.*;

public class RabinKarp {
    private final static int d = 256;
    private final static int q = 997;
    private static int countOp = 0;
    /// TODO: implement global countOP, remember to redefine it, in each call

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("veryLargeString.txt"));
        String txt1 = "abcdabadbc";
        String txt2 = "abcdabadbcabcdabadbc";
        String txt3 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt4 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt5 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt6 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt7 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt8 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";
        String txt9 = "abcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbcabcdabadbc";

        String txt10 = br.readLine();

        br.close();
        
        String pat = "abc";

        System.out.println("\nTXT10");
        patternMatcherIterative(pat, txt10);
        rabinKarpHash(pat, txt10);
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
        System.out.println("rabinKarpRollingHash: op=" + op);
    }

    private static void patternMatcherIterative(String pat , String txt) {
        int op = 0;
        boolean found = true;
        for(int i = 0; i < txt.length() - pat.length() + 1; i++) {

            op++;
            if(txt.charAt(i) == pat.charAt(0)) {
                for(int j = 0; j < pat.length(); j++) {
                    op++;
                    if(txt.charAt(i + j) != pat.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) System.out.println("Pattern found at index " + i);
            }
            found = true;
        }
        System.out.println("patterMatcherIterative: op=" + op);
    }

    private static void rabinKarpHash(String pat, String txt) {
        int op = 0;
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);
        boolean found = true;

        for (int i = 0; i <= N - M; i++) {
            op++;
            long txtHash = hash(txt.substring(i, i+M), M);
            if (patHash == txtHash){

                for(int j = 0; j < pat.length(); j++) {
                    op++;
                    if(txt.charAt(i + j) != pat.charAt(j)) {
                        found = false;
                        break;
                    }
                }
                if (found) System.out.println("Pattern found at index " + i);
            }
            found = true;
        }
        System.out.println("rabinKarpHash: op=" + op);
    }

    private static long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (h * d + s.charAt(j)) % q;
        return h;
    }
}