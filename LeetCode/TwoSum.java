import java.util.Arrays;

class TwoSum{
	public int[] twoSum(int[] nums, int target){
		int[] answer = new int[2];
		for (int i = 0; i < nums.length; i++){
			for (int j = 0; j < nums.length; j++){
				if (nums[i]+nums[j] == target && i!=j){
					answer[0] = i;
					answer[1] = j;
					break;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		TwoSum test = new TwoSum();
		/*Included test case*/
		int[] arr = {1,2,5,6,7};
		/*Way I thought to print answer, but just prints
		the answer array's location in memory*/
		//System.out.println((test.twoSum(arr, 12)));
		/*Regular toString doesn't work here since you want to print an array
		Instead, use Arrays.toString()*/
		System.out.println(Arrays.toString(test.twoSum(arr, 12)));
	}
}