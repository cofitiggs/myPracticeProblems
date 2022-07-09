// https://www.codewars.com/kata/515e271a311df0350d00000f

import java.util.Arrays;

public class SquareSum {

    public int squareSum(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .mapToInt(number -> number*number).sum();
    }

    public static void main(String[] args) {
        SquareSum squareSum = new SquareSum();
        int[] arr = {1, 2, 2};
        System.out.println(squareSum.squareSum(arr));
    }
}
