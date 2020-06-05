import java.util.ArrayList;

class JewelsInStones{
    public int numJewelsInStones(String J, String S) {
        ArrayList<Character> store = new ArrayList<>();
        char[] arr = J.toCharArray();
        char[] arr2 = S.toCharArray();
        int solution = 0;
        for (int i=0; i<arr.length; i++){
            store.add(arr[i]);
        }
        for (int j=0; j<arr2.length; j++){
            if (store.contains(arr2[j])){
                solution++;
            }
            else{
                solution+=0;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        JewelsInStones test = new JewelsInStones();
        /*included test case*/
        System.out.println(test.numJewelsInStones("aA", "aAAbbbb"));
    }

}