import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class CousinOfCollatz {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long startTime, endTime, executionTime;
        String inputLine = in.nextLine();
        String[] inputs = inputLine.split(" ");

        for (int i = 0; i < inputs.length; i++) {
            long n = Long.parseLong(inputs[i]);
            if (n==0){
                break;
            }
            startTime = System.currentTimeMillis();
            long[] output = longestSequence(n);
            long longestSequenceNumber = output[0];
            long longestSequenceLength = output[1];
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            System.out.println(n + " " + longestSequenceNumber + "  " + longestSequenceLength + "  " + executionTime);
        }
    }

    public static long sequenceLength(long n) {
        long count = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                count++;
            } else {
                if (n % 4 == 1) {
                    n = n * 7 + 1;
                    count++;
                } else if (n % 4 == 3) {
                    n = n * 7 - 1;
                    count++;
                }
            }
        }
        //the number 1 is the last in every collatz sequence so we add 1 to count
        count++;
        return count;
    }

    public static long[] longestSequence(long n){
        long longestNumber = 1;
        long longestSequence = 1;

        //call sequenceLength method to add
        for (int i = (int)n; i > 0; i--) {
            if (sequenceLength(i) > longestSequence) {
                longestSequence = sequenceLength(i);
                longestNumber = i;
            }
        }
        long[] output = {longestNumber, longestSequence};
        return output;
    }
}

//}