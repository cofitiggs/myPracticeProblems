import java.util.HashMap;
import java.util.Map;

class RomanToInt {
    private final Map<Character, Integer> values;

    RomanToInt (){
        values = new HashMap<>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
    }

    public int romanToInt(String s) {
        int decNum = 0;
        if (s.length()==1){
            decNum = values.get(s.charAt(0));
        }
        else{
            /*Test string: XVIII = 18
            Splits into array indices 0-4*/
            char[] ch = s.toCharArray();
            /**Made an array of essentially char[] ch = {'X','V','I','I','I'}
             * elements = 5
             * length = 5
             * last index = 4
            */
            for (int i=0; i<ch.length; i++){
                /** i will go from 0-4 mirroring indices of array*/
                if (i<ch.length-1) {
                /**ch.length-1 = (5)-1 = 4 */
                    if (values.get(s.charAt(i)) < values.get(s.charAt(i+1))) {
                        decNum -= values.get(s.charAt(i));
                    } else {
                        decNum += values.get(s.charAt(i));
                    }
                } else {
                    decNum += values.get(s.charAt(i));
                }
                //System.out.println("The value of decNum at index "+i+" is "+decNum);
            }
        }
        return decNum;
    }
    public static void main(String[] args) {
        RomanToInt test = new RomanToInt();
        String nineteenFortyNine = "MCMXLIX";
        System.out.println("Your answer is: "+test.romanToInt(nineteenFortyNine));
    }
}