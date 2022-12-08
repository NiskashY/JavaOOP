public class Main {
    public static void main(String[] args) {
        Room room = new Room();

        boolean isNotExit = true;
        while (isNotExit) {
            isNotExit = room.PrintMenu();
            if (!isNotExit) {
                System.out.println("\n\tBye!");
            }
        }

        Writer writer = new Writer(room.getDevicesList());
        writer.run();
    }
}