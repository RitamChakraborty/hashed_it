package dev.ritam.hashed_it.service;

import dev.ritam.hashed_it.model.HashedOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashingServiceTest {
    private final HashingService hashingService = new HashingService();

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