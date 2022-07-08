import java.util.HashMap;

class RomanToInt {
    public int romanToInt(String s) {
        int decNum = 0;
        HashMap<Character, Integer> values = new HashMap <Character, Integer>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
        
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
                if (i<ch.length-1){
                /**ch.length-1 = (5)-1 = 4 */
                    if (values.get(ch[i]) < values.get(ch[i+1])){
                        decNum -= values.get(ch[i]);
                    }
                    else{
                        decNum += values.get(ch[i]);
                    }
                }
                else{
                    decNum += values.get(ch[i]);
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