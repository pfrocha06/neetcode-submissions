class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
        
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                return false;
            }

            left++;
            right--;
        }

    return true;
    }
}
