package dev.ritam.hashed_it.controller;

import dev.ritam.hashed_it.model.HashedOutput;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class V1Controller {
    @GetMapping("/{hashType}")
    public HashedOutput getHashedOutput(
            @PathVariable("hashType") String hashType,
            @RequestParam("input") String input
    ) {
        HashedOutput hashedOutput = new HashedOutput();
        hashedOutput.setInput(input);
        hashedOutput.setOutput("hash(" + input + ")");
        hashedOutput.setHashType(hashType);

        return hashedOutput;
    }
}
