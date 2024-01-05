package com.test;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ReverseTest {

    @Test
    public void should_read_and_write_content_in_reverse_order() {
        assertTrue(Reverse.reverseText("src\\main\\resources\\input.txt", "src\\main\\resources\\output.txt"));
        assertEquals("CBA",getTextFromFile());
    }
    @Test
    public void should_return_null_if_input_file_is_empty() {
        assertTrue(Reverse.reverseText("src\\main\\resources\\input_null.txt", "src\\main\\resources\\output.txt"));
        assertNull(getTextFromFile());
    }

    @Test
    public void should_return_false_if_output_file_is_not_found() {
        assertFalse(Reverse.reverseText("src\\main\\resources\\input.txt", ""));
    }

    private static String getTextFromFile() {
        File file = new File("src\\main\\resources\\output.txt");
        try {
            Scanner scanner = new Scanner(file);
            return scanner.nextLine();
        } catch(Exception e) {
            return null;
        }
    }
}