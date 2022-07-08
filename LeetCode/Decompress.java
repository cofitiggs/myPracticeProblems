import java.util.ArrayList;
import java.util.Arrays;

class Decompress {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int quantity = 0;
        for (int i=0; i< nums.length; i++){
            if (i%2==0){
                quantity = nums[i];
                continue;
            }
            else{
                for (int j=0; j<quantity; j++){
                    list.add(nums[i]);
                }
            }
        }
        //need integer array to retun for solution
        int size = list.size();
        int[] sol = new int[size];
        for (int k=0; k<sol.length; k++){
            sol[k] = list.get(k);
        }
        //return integer array
        return sol;
    }

    public static void main(String[] args) {
        Decompress test = new Decompress();
        int[] arr = {0,1,2,3,4,5};
        int[] arr2 = {10,1};
        System.out.println(Arrays.toString(test.decompressRLElist(arr)));
    }
}