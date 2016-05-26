package leetcode_KejiHu;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author hukeji
 * 
 * The idea is to push every number of array to hash map
 * for the first time when traverse the array.
 * For the second time, traverse the array, and find
 * if the hash map contains the number target - nums[i]
 *
 */
public class Problem001 {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		//push numbers with its indices to the indexMap
		for (int i = 0; i < nums.length; ++i) {
			indexMap.put(nums[i], i);
		}
		
		//for each number, check if num1 + num2 = target
		for (int i = 0; i < nums.length; ++i) {
			int cur = target - nums[i];
			Integer ind = indexMap.get(cur);
			if (ind != null && ind != i) {
				return new int[] { i, indexMap.get(cur) };
			}
		}
		return new int[] {};
	}

}