package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import static org.testng.Assert.*;

@SpringBootTest
public class TranslatorFileServiceTest {
    @Autowired
    private  TranslatorFileService translatorFileService;

    @Test
    public void testInvertFile() throws IOException {
        boolean b = false;
        b = translatorFileService.esInvertido();
        assertTrue(b);
    }
}