package dev.ritam.hashed_it.controller.api;

import dev.ritam.hashed_it.model.HashedOutput;
import dev.ritam.hashed_it.service.HashingService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1")
@RateLimiter(name = "API_RATE_LIMITER")
public class V1Controller {
    private final HashingService hashingService;

    public V1Controller(HashingService hashingService) {
        this.hashingService = hashingService;
    }

    @GetMapping("/types")
    public ResponseEntity<Set<String>> getAllHashTypes() {
        return ResponseEntity.ok(hashingService.getAllHashTypes());
    }

    @GetMapping("/{hashType}")
    public HashedOutput getHashedOutput(
            @PathVariable("hashType") String hashType,
            @RequestParam("input") String input
    ) {
        return hashingService.getHashedOutput(hashType, input);
    }
}
