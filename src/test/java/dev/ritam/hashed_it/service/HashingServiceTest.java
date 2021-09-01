package dev.ritam.hashed_it.service;

import dev.ritam.hashed_it.model.HashedOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class HashingServiceTest {
    private HashingService hashingService;

    @Autowired
    public void setHashingService(HashingService hashingService) {
        this.hashingService = hashingService;
    }

    @Test
    void getAllHashTypes_test() {
        Set<String> algorithms = hashingService.getAllHashTypes();
        System.out.println(algorithms);
        Assertions.assertTrue(algorithms.contains("MD5"));
    }

    @Test
    void getHashedOutput_correct_input_test() throws NoSuchAlgorithmException {
        HashedOutput expectedOutput = new HashedOutput();
        expectedOutput.setInput("something");
        expectedOutput.setOutput("437b930db84b8079c2dd804a71936b5f");
        expectedOutput.setHashType("MD5");

        HashedOutput actualOutput = hashingService.getHashedOutput("MD5", "something");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void getHashedOutput_incorrect_hashType_test() {
        Assertions.assertThrows(
                NoSuchAlgorithmException.class,
                () -> hashingService.getHashedOutput("md", "something")
        );
    }
}