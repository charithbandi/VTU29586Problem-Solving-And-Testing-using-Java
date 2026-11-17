import java.io.*;
import java.util.*;

public class Solution {

    // Generic method to print array elements of any type
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        // Create integer and string arrays
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        
        // Pass both arrays to the same generic method
        printArray(intArray);
        printArray(stringArray);
    }
}
