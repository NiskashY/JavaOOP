package validation_and_output;

public class validation {
    public static boolean isPositionCorrect(final int pos, final int lowest_pos, final int highest_pos) {
        // [lowest_pos; highest_pos);
        return (pos >= lowest_pos && pos < highest_pos);
    }

    public static String GetNumberFormatMessage() {
        return "Please enter an integer!";
    }

}
