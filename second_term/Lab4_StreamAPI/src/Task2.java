import com.sun.source.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeMap;

import static java.lang.Math.abs;

class Storage extends TreeMap {
    private TreeMap<Integer, Integer> count;

    public Storage() {
        count = new TreeMap<>();
    }

    public void Add(Integer number) {
//        count.put(number, count.get(number) + 1);
        int x = 0; // current value of number in map
        if (count.containsKey(number)) {
            x = count.get(number);
        }

        count.put(number, x + 1);
    }

    public void Remove(Integer number) {
        if (!count.containsKey(number)) {
            String msg_not_found = "No such element in map";
            System.out.println(msg_not_found);
        } else {
            count.put(number, count.get(number) - 1);
            if (count.get(number) == 0) {
                count.remove(number);
            }
        }
    }

    public Integer FindNearest(Integer number) {
        Integer nearest = null;
        Integer first = count.floorKey(number);       // lower_bound
        Integer second = count.higherKey(number);     // upper_bound

        if (first != null && second != null) {
            var first_abs = abs(number - first);
            var second_abs = abs(number - second);
            nearest = (first_abs <= second_abs ? first : second);
        } else {
            nearest = (first == null ? second : first);
        }

        return nearest;
    }
}

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
        Storage storage = new Storage();
        String[] menu = {"1 - add Integer",
                "2 - remove Integer",
                "3 - find nearest Element",
                "else - exit"};


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;

        while (true) {
            int choice = Choice.InputOptional(menu);
            try {
                final String input_msg = "Input integer: ";
                System.out.print(input_msg);
                number = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong data type!");
                continue;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            switch (choice) {
                case 1 -> {
                    // add
                    storage.Add(number);
                }
                case 2 -> {
                    // remove
                    storage.Remove(number);
                }
                case 3 -> {
                    // find
                    Integer nearest = storage.FindNearest(number);
                    if (nearest == null) {
                        System.out.println("Storage is Empty");
                    } else {
                        System.out.println("Nearest element = " + nearest);
                    }
                }
                default -> {
                    return;
                }
            }
        }
    }
}
