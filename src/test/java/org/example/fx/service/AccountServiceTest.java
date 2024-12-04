//package org.example.fx.service;
//
//import org.example.fx.data.Account;
//import org.example.fx.data.User;
//import org.example.fx.exceptiion.NotARegularUserException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AccountServiceTest {
//
//    User user;
//    Account account;
//    AccountService accountService;
//
//    @BeforeEach
//    void setUpStubs() {
//
//        account = new Account();
//        account.setAccountNumber("2128736988");
//
//        user = new User();
//        user.setUserId(UUID.randomUUID().toString());
//        user.setAge(16);
//        user.setFullname("John Doe");
//        user.setAccount(account);
//
//        accountService = new AccountService();
//    }
//
//    @Test
//    void testCreateUser() {
//
//        assertNotNull(user, "User is null!");
//    }
//
//    @Test
//    void testDeposit_Success() {
//
//        boolean deposited = accountService.deposit(user, 40000);
//
//        assertTrue(deposited, "Your is not successful!!!");
//    }
//
//    @Test
//    void testDeposit_Fails() {
//
//        assertThrows(NotARegularUserException.class, () -> {
//
//            accountService.deposit(user, 60000);
//        });
//    }
//
//    @Test
//    void testDeposit_UserWithAgeAbove18() {
//
//        user.setAge(47);
//
//        boolean deposited = accountService.deposit(user, 100000000);
//
//        assertTrue(deposited);
//    }
//
//    @ParameterizedTest
//    //@CsvSource({"1, 2", "3, 4"})
//    //@CsvFileSource(resources = "/data.csv")
//    @ValueSource(ints = {3, 4})
//    void testMe(int x) {
//        System.out.println("x = " + x);
//
//    }
//
//}
