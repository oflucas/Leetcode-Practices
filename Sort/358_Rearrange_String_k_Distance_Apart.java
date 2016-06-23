//358_Rearrange_String_k_Distance_Apart.java
//14ms 95% Total Accepted: 598 Total Submissions: 2310 Difficulty: Hard
public class Solution {
    private final static int sizeAZ = 26;
    public String rearrangeString(String str, int k) {
        if (k <= 1) return str;
        char[] c = str.toCharArray();
        int[][] cnt = new int[sizeAZ][2];
        int len = c.length;
        for (int i = 0; i < sizeAZ; cnt[i][0] = i++); // save letter id
        for (int i = 0; i < len; c[i++] = '*')
            cnt[c[i] - 'a'][1]++;
        
        // Sort according to occurance frequency, descending
        Arrays.sort(cnt, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        
        int nBin = (len - 1) / k + 1, sizeLastBin = len % k;
        int[] idx = new int[nBin];
        //System.out.println(nBin + ",,," + sizeLastBin);
        for (int u = 0, i = 0; u < sizeAZ; u++) if (cnt[u][1] > 0) {
            char ch = (char)(cnt[u][0] + 'a');
            int m = cnt[u][1];
            if (m > nBin) return ""; // Bins are not enough for ch, for sure
            for (int y = 0; y < m; y++) {
                while (idx[i] >= binSize(i, k, len)) 
                    i = (i + 1) % nBin;

                int offset = i * k;
                if (idx[i] > 0 && c[offset + idx[i] - 1] == ch) 
                    return ""; //same letter falls in same bin
                c[offset + idx[i]++] = ch;
                i = (i + 1) % nBin;
            }
        }
        return new String(c);
    }
    
    private int binSize(int i, int k, int len) {
        return Math.min(len - i * k, k);
    }
}
