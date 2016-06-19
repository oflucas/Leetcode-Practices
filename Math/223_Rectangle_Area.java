// 5ms 64% Total Accepted: 39808 Total Submissions: 131315 Difficulty: Easy
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long olX1 = Math.max(A, E), olY1 = Math.max(B, F), olX2 = Math.min(C, G), olY2 = Math.min(D, H);
        long olArea = Math.max(olX2 - olX1, 0) * Math.max(olY2 - olY1, 0);
        return (int)((C - A) * (D - B) + (G - E) * (H - F) - olArea);
    }
}
