package leetcode_KejiHu;
import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters
 * 
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * @author hukeji
 *
 * Solution: 
 * start with an index, say startIdx, add each subsequent characters that appears for
 * the first time to a hash set. If the character has been seen before at index
 * endIdx, then the substring from startIdx to endIdx is the longest substring that
 * is available starting from index startIdx. 
 * 
 * Then, in the next iteration, remove the character at startIdx from the hash set
 * and try to find a longest substring from index startIdx + 1. Keep an integer currentMax
 * and update it if localMax > currentMax
 */
public class Problem003 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int currentMax = 0;
		int localLength = 0;
		HashSet<Character> charSet = new HashSet<Character>();
		int endIdx = 0;
		for (int i = 0; i < s.length(); ++i) {
			//remove the character at index startIdx
			if (i != 0) {
				charSet.remove(s.charAt(i - 1));
				localLength--;
			}

			//keep adding new appeared characters to the hash set
			while (!charSet.contains(s.charAt(endIdx))) {
				charSet.add(s.charAt(endIdx));
				endIdx++;
				localLength++;
				if (endIdx == s.length()) {
					break;
				}
			}
			
			//update the golbal maximum
			if (localLength > currentMax) {
				currentMax = localLength;
			}
			
			//break the loop if the end of string is reached.
			//the time complexity for this problem is O(n).
			if (endIdx == s.length())
				break;
		}
		return currentMax;
	}

	public static void main(String[] args) {
		System.out.println(new Problem003().lengthOfLongestSubstring("pwwkew"));
	}
}
