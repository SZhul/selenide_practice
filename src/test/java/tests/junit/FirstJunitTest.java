package tests.junit;

import org.junit.jupiter.api.*;

public class FirstJunitTest {

    @BeforeEach
    void beforeEach(){
        System.out.println("Это метод перед тестом ");
    }

    @AfterEach
    void afterEach(){
        System.out.println("Это метод после теста ");
    }

    @Test
    void firstTest(){
        System.out.println(" Это тест");
        Assertions.assertTrue(3>2);
    }
}
