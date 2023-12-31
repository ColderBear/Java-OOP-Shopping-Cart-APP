package Authentication;
import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;

    public User(String username, String hashedPassword) {
        this.username = username;
        this.password = hashedPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
