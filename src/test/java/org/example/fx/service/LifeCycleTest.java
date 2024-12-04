package org.example.fx.service;

import org.example.fx.data.Account;
import org.example.fx.data.User;
import org.example.fx.exceptiion.NotARegularUserException;
import org.junit.jupiter.api.*;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LifeCycleTest {

    User user;
    Account account;
    AccountService accountService;
    boolean isUserLoggedIn = false;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
    }

    @Order(1)
    @Test
    void testCreateAccount()  {

        account = new Account();
        account.setAccountNumber("2134365577");
        account.setPin(1234);

        user = new User();
        user.setUserId(UUID.randomUUID().toString());
        user.setAccount(account);
        user.setAge(25);
        user.setFullname("John Doe");

        assertNotNull(user, "User is not created!");
    }

    @Order(2)
    @Test
    void testLoginAccount() {

        isUserLoggedIn  = accountService.login(user, "2134365577", 1234);

        assertTrue(isUserLoggedIn, "User provided credentials are not correct!");
    }

    @Order(3)
    @Test
    void testDeposit_Success() {

        boolean deposited = accountService.deposit(user, 100000.00, isUserLoggedIn);

        assertTrue(deposited, "You have deposited is not successful or try to login!");
    }

    @Order(3)
    @Test
    void testDeposit_NotLoggedIn() {

        isUserLoggedIn = false;

        boolean deposited = accountService.deposit(user, 100000.00, isUserLoggedIn);

        isUserLoggedIn = true;

        assertFalse(deposited, "User faild to log in!");
    }

    @Order(3)
    @Test
    void testDeposit_UnableToDeposit() {

        user.setAge(15);

        assertThrows(NotARegularUserException.class, () -> {

            accountService.deposit(user, 5000000.00, isUserLoggedIn);

        }, "");
    }

}
