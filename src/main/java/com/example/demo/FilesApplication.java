package com.example.demo;

import com.example.demo.service.TranslatorFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FilesApplication implements CommandLineRunner {

    private static Logger LOG = LoggerFactory.getLogger(FilesApplication.class);
    public static void main(String[] args) {
        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(FilesApplication.class, args);
        LOG.info("APPLICATION FINISHED");
    }
    @Override
    public void run(String... args) throws Exception{
        LOG.info("EXECUTING : command line runner");
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
    }

}
