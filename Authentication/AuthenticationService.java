package Authentication;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationService {
    private static final String USERS_FILE = "users.dat";
    private Map<String, User> users = new HashMap<>();

    public AuthenticationService() {
        loadUsers();
    }

    public void register(String username, String password) {
        if (username == null || password == null || users.containsKey(username)) {
            throw new IllegalArgumentException("Invalid username or password, or user already exists.");
        }
        users.put(username, new User(username, password));
        saveUsers();
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user == null || !user.getPassword().equals(password)) {
            return false; // User not found or password does not match
        }
        return true;
    }

    private void loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERS_FILE))) {
            users = (Map<String, User>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Users file not found. A new one will be created.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading users file: " + e.getMessage());
        }
    }

    private void saveUsers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE))) {
            oos.writeObject(users);
        } catch (IOException e) {
            System.err.println("Error writing to users file: " + e.getMessage());
        }
    }
}
