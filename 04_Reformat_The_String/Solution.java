/*
Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).

You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.

Example 1:

Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.

Example 2:

Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.

Example 3:

Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.

Example 4:

Input: s = "covid2019"
Output: "c2o0v1i9d"

Example 5:

Input: s = "ab123"
Output: "1a2b3"

Constraints:

    1 <= s.length <= 500
    s consists of only lowercase English letters and/or digits.
*/
//I build two char arrays to store numbers and alphabets. And finally use stringbuilder to collect all the right answers. The time complexity: O(n).
class Solution {
    public String reformat(String s) {
        List<Character> num = new ArrayList<>();
		List<Character> alpha = new ArrayList<>();
		for(char c:s.toCharArray()) {
			if(Character.isDigit(c)) {
				num.add(c);
			}else {
				alpha.add(c);
			}
		}
		if(Math.abs(num.size()-alpha.size())>=2) {
			return "";
		}
		
		StringBuilder str = new StringBuilder();
		boolean number = (num.size() >= alpha.size() ? true:false);
		for(int i=0;i<s.length();i++) {
			if(number) {
				str.append(num.remove(0));
			}else {
				str.append(alpha.remove(0));
			}			
			number = !number;
		}
		return str.toString();
    }
}