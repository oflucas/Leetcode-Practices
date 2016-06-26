//158_Read_N_Characters_Given_Read4_II - Call multiple times
//3ms 61% Total Accepted: 10596 Total Submissions: 44869 Difficulty: Hard
/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int read4Size = 4, n_read4 = read4Size, i = read4Size;
    private char[] read4buf = new char[read4Size];
    
    public int read(char[] buf, int n) {
        int k = 0;
        while (n_read4 == read4Size && k < n) {
            if (i < read4Size)
                buf[k++] = read4buf[i++];
            else { // i == read4Size
                i = 0;
                n_read4 = read4(read4buf);
            }
        }
        if (n_read4 < read4Size)
            while (k < n && i < n_read4)
                buf[k++] = read4buf[i++];
        
        return k;
    }
}
