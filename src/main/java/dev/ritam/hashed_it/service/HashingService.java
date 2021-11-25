package dev.ritam.hashed_it.service;

import dev.ritam.hashed_it.exception.UnknownHashTypeException;
import dev.ritam.hashed_it.model.ConversionRequest;
import dev.ritam.hashed_it.model.HashedOutput;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Set;
import java.util.TreeSet;

@Service
public class HashingService {
    private String getHash(String hashType, String input) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(hashType);
        byte[] bytes = messageDigest.digest(input.getBytes());
        BigInteger bigInteger = new BigInteger(1, bytes);

        return bigInteger.toString(16);
    }

    public String getHashFromConversionRequest(ConversionRequest conversionRequest) throws NoSuchAlgorithmException {
        return getHash(conversionRequest.getHashType(), conversionRequest.getInput());
    }

    public Set<String> getAllHashTypes() {
        return new TreeSet<>(Security.getAlgorithms("MessageDigest"));
    }

    public HashedOutput getHashedOutput(String hashType, String input) {
        String output;

        try {
            output = getHash(hashType, input);
        } catch (NoSuchAlgorithmException ignore) {
            throw new UnknownHashTypeException("Hash Type %s is unrecognized. Please visit '/api/v1/types' for see all the available types");
        }

        HashedOutput hashedOutput = new HashedOutput();
        hashedOutput.setInput(input);
        hashedOutput.setOutput(output);
        hashedOutput.setHashType(hashType);

        return hashedOutput;
    }
}
