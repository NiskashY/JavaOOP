import javax.sound.midi.Soundbank;
import java.io.File;
import java.util.*;
import java.util.stream.Stream;

class Task1 {
    private static ArrayList<Integer> CreateRandomArray(final int array_length,
                                                        final int left_boarder,
                                                        final int right_boarder) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < array_length; ++i) {
            arrayList.add(random.nextInt(left_boarder, right_boarder) - right_boarder / 2);
        }

        return arrayList;
    }

    static public void Solve() {
        System.out.println("Task 1.");
        // a = 10; b = Descending; c = even numbers and zeroes
        int array_length = 10;
        int left_boarder = 0, right_boarder = 31;
        boolean isAscending = false;

        ArrayList<Integer> arrayList =
                CreateRandomArray(array_length, left_boarder, right_boarder);

        Stream<Integer> stream_array = arrayList.stream();

        if (isAscending) { // sort stream
            stream_array = stream_array.sorted();
        } else {
            stream_array = stream_array.sorted(Comparator.reverseOrder());
        }

        // filter array: remain only odd elements without zeroes
        stream_array = stream_array.filter(item -> item % 2 != 0);
        // convert from Integer to String
        Stream<String> mapped_stream_array = stream_array.map(Object::toString); // (Object::toString) ~ (item -> item.toString();)

        // Output initial state of array
        final String msg_after = "Sorted, mapped, filtered array: ", msg_init = "Initial array: ";
        System.out.println(msg_init + arrayList);

        // Output final state of array
        System.out.print(msg_after + "[");
        mapped_stream_array.forEach((item) -> System.out.print(item.toString() + ", "));
        System.out.println("\b\b]"); // for deleting ', ' in the end of line above
    }
}

class Task2 {
    static public void Solve() {

    }
}

public class Main {

    // Variant = 20
    public static void main(String[] args) {
        Task1.Solve();
    }
}