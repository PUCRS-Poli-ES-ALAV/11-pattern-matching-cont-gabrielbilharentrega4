// Pior Caso O(n)
// 28 + 3n

public class KMP { 

    public static void main(String args[]) 
    { 
        String string = "ABCDCBDCBDACBDABDCBADF"; // 1 
        String substring = "ADF"; // 1 
        new KMP().KMPSearch(substring, string); // 1  
    } 

    void KMPSearch(String substring, String string) 
    { 
        int M = substring.length();  // 1 
        int N = string.length();  // 1 
        int lps[] = new int[M];  // 1 
        int j = 0; // 1 
        computeLPSArray(substring, M, lps); // 1  
  
        int i = 0;  // 1 
        while (i < N) {  // n
            if (substring.charAt(j) == string.charAt(i)) { 
                j++;  // 1 
                i++;  // 1 
            } 
            if (j == M) {  // 1 
                System.out.println("Substring "
                                   + "esta na posição " + (i - j));  // 1 
                j = lps[j - 1];  // 1 
            } 
            else if (i < N && substring.charAt(j) != string.charAt(i)) {  // 1 
                if (j != 0)  // 1 
                    j = lps[j - 1];  // 1 
                else 
                    i = i + 1;  // 1 
            } 
        } 
    } 
  
    void computeLPSArray(String substring, int M, int lps[]) 
    { 
        int len = 0;  // 1 
        int i = 1;  // 1 
        lps[0] = 0;  // 1 

        while (i < M) {  // n
            if (substring.charAt(i) == substring.charAt(len)) {  // 1 
                len++;  // 1 
                lps[i] = len;  // 1 
                i++;  // 1 
            } 
            else 
            { 
                if (len != 0) { 
                    len = lps[len - 1];  // 1 
                } 
                else
                { 
                    lps[i] = len;  // 1 
                    i++;  // 1 
                } 
            } 
        } 
    } 
} 
