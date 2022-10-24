import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task2 {
    static public void Solve() {
        System.out.println("Task 2.");
        SubTask1();
        System.out.println();
        SubTask2();
    }

    static private void SubTask1() {
        System.out.println("SubTask 1.");
        int array_length = 10;
        int left_boarder = 0, right_boarder = 31;
        ArrayList<Integer> arrayList = Task1.CreateRandomArray(array_length, left_boarder, right_boarder);

        Random rand = new Random();
        final int X = rand.nextInt((right_boarder + 1) / 2);
        System.out.println("Random pivot number X: " + X);

        final String msg_before = "Init Array:   ", msg_after = "After divide: ";
        System.out.println(msg_before + arrayList);

        int pivot_index = 0;
        for (int i = 0; i < array_length; ++i) {
            if (arrayList.get(i) <= X) {
                Collections.swap(arrayList, i, pivot_index++);
            }
        }

        System.out.println(msg_after + arrayList);
        System.out.println("Pivot index = " + pivot_index);
    }

    static private void SubTask2() {

    }
}
