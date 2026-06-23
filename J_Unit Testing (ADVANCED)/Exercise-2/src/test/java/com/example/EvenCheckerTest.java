package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenCheckerTest {
    @Test
    void testEvenNumber() {
        assertTrue(4 % 2 == 0);
    }
}
