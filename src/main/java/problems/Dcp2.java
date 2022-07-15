package problems;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/*
Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */

@Setter
@Getter
@RequiredArgsConstructor
public class Dcp2 {

    private final int[] arr;

    public int[] getEncodedArray(){
        int[] encoded = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            encoded[i] = getNotOmittedEncodedValue(i);
        }

        return encoded;
    }

    private int getNotOmittedEncodedValue(int ommitIndex){
        int sum = 1;

        for(int i = 0; i < arr.length; i++){
            if (ommitIndex != i) sum *= arr[i];
        }

        return sum;
    }

}