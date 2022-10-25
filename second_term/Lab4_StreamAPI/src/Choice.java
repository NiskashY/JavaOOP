import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Choice {
    static public int InputOptional(String[] menu) {
        for (var item : menu) {
            System.out.println(item);
        }
        System.out.println("Your Choice: ");
        // menu - last element should be 'else - exit'

        int choice = 0;
        boolean isInputOk = false;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return choice;
    }
}
