// 258_Add_Digits.java
// 2ms 95% Total Accepted: 105152 Total Submissions: 214374 Difficulty: Easy
public class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
