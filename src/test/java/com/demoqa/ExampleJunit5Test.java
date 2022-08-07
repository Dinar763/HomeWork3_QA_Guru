package com.demoqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class ExampleJunit5Test {

    @BeforeAll
    static void configure() {
        System.out.println("sddff");
    }


    @Test
    void firstTest() {
        Assertions.assertTrue(3>2);
    }
}
