package dev.ritam.hashed_it.service;

import dev.ritam.hashed_it.model.HashedOutput;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class HashingService {
    private String getHash(String hashType, String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(hashType);
        byte[] bytes = messageDigest.digest(input.getBytes());
        BigInteger bigInteger = new BigInteger(1, bytes);

        return bigInteger.toString(16);
    }

    public HashedOutput getHashedOutput(String hashType, String input) throws NoSuchAlgorithmException {
        String output = getHash(hashType, input);

        HashedOutput hashedOutput = new HashedOutput();
        hashedOutput.setInput(input);
        hashedOutput.setOutput(output);
        hashedOutput.setHashType(hashType);

        return hashedOutput;
    }
}
