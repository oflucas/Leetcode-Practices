// Total Accepted: 29634
// Total Submissions: 72822
// Difficulty: Medium
// 31ms 78%

public class Solution {
    public int maxProduct(String[] words) {
        int n = words.length, i = 0;
        int[] mark = new int[n];

//        Arrays.sort(words, new Comparator<String>(){
//            @Override
//            public int compare(String a, String b) {
//                return b.length() - a.length();
//            }
//        });
        
        for (String w : words) {
            char[] ch = w.toCharArray();
            int t = 0;
            for (char c : ch)
                t |= 1 << (c - 'a');
            mark[i++] = t;
        }
        
        int ans = 0;
        for (i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if ((mark[i] & mark[j]) == 0)
                    ans = Math.max(ans, words[i].length() * words[j].length());
        return ans;
    }
}