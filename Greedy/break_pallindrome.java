// https://leetcode.com/problems/break-a-palindrome/description/

public class break_pallindrome {

    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n==1) return "";     // for length 1

        char[] arr = palindrome.toCharArray();

        for(int i=0; i<n/2; i++){
            if(arr[i] != 'a'){
                arr[i] = 'a';
                return new String(arr);
            }
        }

        // All characters are 'a', so change last to 'b'
        arr[n-1] = 'b';
        return new String(arr); 
    }
    
}
