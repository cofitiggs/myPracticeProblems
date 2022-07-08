class EvenDigitNums {
    public int findNumbers(int[] nums) {
        int solution = 0;
        //digitCount assignment moved from this line to current location
        int op = 0;
        for (int i=0; i<nums.length; i++){
            int digitCount = 0;
            op = nums[i];
            do{
                op/=10;
                digitCount++;
            }while (op>0);

            if (digitCount%2==0){
                solution++;
            }
        }
        return solution;
    }

    /*After looking at the problem again, I decided to see if
    I can solve it in an alternative fashion. */
    public int findNumbers2(int[] nums){
        int solution = 0;
        for (int i=0; i<nums.length; i++){
            String numDigits = String.valueOf(nums[i]);
            if (numDigits.length()%2==0){
                solution++;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        EvenDigitNums test = new EvenDigitNums();
        /*included test case*/
        int[] arr = {9595, 8176, 596, 800, 4576};
        System.out.println(test.findNumbers(arr));
        System.out.println(test.findNumbers2(arr));
    }
}