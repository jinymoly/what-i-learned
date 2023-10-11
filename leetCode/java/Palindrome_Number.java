package leetCode.java;
/*
9. Palindrome Number

Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 

Follow up: Could you solve it without converting the integer to a string?

*/
public class Palindrome_Number {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        } else{
            String num = String.valueOf(x);
            int endOfNum = num.length() - 1;
            int half = num.length() / 2;
            
            for(int i = 0; i < half; i++){
                if(num.charAt(i) != num.charAt(endOfNum)){
                    return false;
                }
                endOfNum--; // 문자열의 중앙까지 올바른 팰린드롬 비교를 수행하기 위해 필수적
            }
            return true;
        }
    }

    public boolean isPalindromeWithoutConvertingTheIntegerToAString(int x){
        if(x < 0){
            return false;
        }

        int originNum = x;
        int reverseNum = 0;

        while(x > 0){
            int digit = x % 10;
            reverseNum = reverseNum * 10 + digit;
            x /= 10;
        }

        return originNum == reverseNum;

    }
}
