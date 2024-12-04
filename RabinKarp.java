import java.io.*;
import java.util.Random;

public class RabinKarp {
    private final static int d = 256;
    private final static int q = 997;
    private final static int numberOfTests = 10;
    private static int op;
    private static int[] testTxt = {10,100,1000,10000,100000,1000000};
    private static int[] testPat = {2,26,85,311,9974,60400};

    public static void main(String[] args) throws IOException {
        String txt;
        String pat;
        long startTime;
        long endTime;
        long totalExecutionTime;
        double meanExecutionTime;

        for (int i = 1; i <= 7; i++) {
            System.out.println("\nCaso de Teste " + i);

            totalExecutionTime = 0;
            for (int j = 0; j < numberOfTests; j++) {
                txt = generateRandomString(testTxt[i-1]);
                pat = generateRandomString(testPat[i-1]);
                op = 0;
                startTime = System.nanoTime();
                rabinKarpRollingHash(pat, txt);
                endTime = System.nanoTime();
                totalExecutionTime += (endTime - startTime);
            }

            meanExecutionTime = totalExecutionTime / numberOfTests;
    
            System.out.println("Tempo Médio de execução: " + meanExecutionTime + " ns");
            System.out.println("Número de operações: " + op);
            
        }
    }

    public static String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString();
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