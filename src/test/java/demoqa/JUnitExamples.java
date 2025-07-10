package demoqa;

import org.junit.jupiter.api.*;

public class JUnitExamples {

    @BeforeAll
    static void BeforeAll() {
        System.out.println("This is BeforeAll");
    }

    @BeforeEach
    void BeforeEach() {
        System.out.println("    This is BeforeEach");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("This is AfterAll");
    }

    @AfterEach
    void AfterEach() {
        System.out.println("    This is AfterEach ");
    }

    @Test
    void firstTest() {
        System.out.println("        This is firstTest");
    }

    @Test
    void secondTest() {
        System.out.println("        This is secondTest");
    }

}