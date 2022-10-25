import jdk.jshell.spi.ExecutionControlProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeMap;

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
        TreeMap<Integer, Integer> count = new TreeMap<>();
        String[] menu = {"1 - add Integer",
                "2 - remove Integer",
                "3 - find nearest Element",
                "else - exit"};


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int choice = Choice.InputOptional(menu);
            try {
                switch (choice) {
                    case 1 -> {
                        // add
                        final String input_msg = "Input integer: ";
                        System.out.print(input_msg);
                        int number = Integer.parseInt(reader.readLine());
                        count.put(number, count.get(number) + 1);
                    }
                    case 2 -> {
                        // remove
                        final String input_msg = "Input integer: ";
                        System.out.print(input_msg);
                        int number = Integer.parseInt(reader.readLine());

                        if (count.get(number) == 0) {
                            String msg_not_found = "No such element in map";
                            System.out.println(msg_not_found);
                        } else {
                            count.put(number, count.get(number) - 1);
                            if (count.get(number) == 0) {

                            }
                        }
                    }
                    case 3 -> {
                        // find
                    }
                    default -> {
                        return;
                    }
                }
            } catch (NumberFormatException e){
                System.out.println("Wrong data type!");
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
