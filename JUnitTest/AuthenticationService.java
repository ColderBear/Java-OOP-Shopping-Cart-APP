package JUnitTest;
import Authentication.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {

    private AuthenticationService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthenticationService();
    }

    @Test
    void registerAndLoginUser() {
        authService.register("user1", "pass1");
        assertTrue(authService.login("user1", "pass1"));
    }

    @Test
    void loginWithInvalidCredentials() {
        authService.register("user2", "pass2");
        assertFalse(authService.login("user2", "wrongpass"));
    }
}
