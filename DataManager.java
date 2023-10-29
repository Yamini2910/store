import java.io.*;

public class DataManager {
    private static final String FILENAME = "data.ser";

    public static void saveData(Object data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            oos.writeObject(data);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILENAME))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved data found. Starting with fresh data.");
        }
        return null;
    }
}

