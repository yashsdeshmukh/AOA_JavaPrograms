package aoaPrograms;

public class StringMatching {
	public final static int d = 256;
	
	static void nSearch(String txt, String pat)
    {
        int patternLength = pat.length();
        int textLength = txt.length();
 
        /* A loop to slide pattern one by one */
        for (int i = 0; i <= textLength - patternLength; i++) {
 
            int j;
 
            /* For current index i, check for pattern
              match */
            for (j = 0; j < patternLength; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
 
            if (j == patternLength) // if pat[0...M-1] = txt[i, i+1, ...i+M-1]
                System.out.println("Pattern found at shift " + i);
        }
    }
	
	static void rSearch( String txt,String pat, int q)
    {
        int patternLength = pat.length();
        int textLength = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;
      
        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < patternLength-1; i++)
            h = (h*d)%q;     
        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < patternLength; i++)
        {
            p = (d*p + pat.charAt(i))%q;
            t = (d*t + txt.charAt(i))%q;
        }     
        // Slide the pattern over text one by one
        for (i = 0; i <= textLength - patternLength; i++)
        {
            // Check the hash values of text and pattern.
            if ( p == t )
            {
                /* Check for characters one by one */
                for (j = 0; j < patternLength; j++)
                {
                	//Spurious Hit
                    if (txt.charAt(i+j) != pat.charAt(j))
                        break;
                }      
                // Valid Hit
                if (j == patternLength)
                    System.out.println("Pattern found at shift " + i);
            }     
            // Calculate hash value for next text
            if ( i < textLength-patternLength )
            {
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+patternLength))%q;
                if (t < 0)
                	t = (t + q);
            }
        }
    }
     
	static void KMPSearch( String txt,String pat)
    {
        int patternLength = pat.length();
        int textLength = txt.length();
  
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[patternLength];
        int j = 0; // index for pat[]
  
        // Pre-process the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, patternLength, lps);
  
        int i = 0; // index for txt[]
        while (i < textLength) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == patternLength) {
                System.out.println("Found pattern "+ "at shift " + (i - j));
                j = lps[j - 1];
            }
            // mismatch after j matches
            else if (i < textLength && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
    }
  
    static void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0
  
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        String txt = "YASHDESHMUKHWARRENFERNANDESLINYMATHEW";
        String pat = "DES";
        System.out.println("Naive");
        nSearch(txt,pat);
        System.out.println();
        System.out.println("Rabin Karp");
        rSearch(txt,pat,101);
        System.out.println();
        System.out.println("Knuth Morris Pratt");
        KMPSearch(txt,pat);
    }

}
