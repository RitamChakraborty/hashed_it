package dev.ritam.hashed_it.controller;

import dev.ritam.hashed_it.model.ConversionRequest;
import dev.ritam.hashed_it.service.HashingService;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RateLimiter(name = "RATE_LIMITER")
public class HomeController {
    private final HashingService hashingService;

    @GetMapping("/")
    public String getIndex(@ModelAttribute("conversionRequest") ConversionRequest conversionRequest) {
        return "index";
    }

    @PostMapping("/")
    public String postIndex(@ModelAttribute("conversionRequest") ConversionRequest conversionRequest, Model model) {
        try {
            log.info(conversionRequest.toString());
            String output = hashingService.getHashFromConversionRequest(conversionRequest);
            model.addAttribute("output", output);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }

        return "index";
    }

    @ModelAttribute("hashTypes")
    public List<String> hashTypes() {
        return new ArrayList<>(hashingService.getAllHashTypes());
    }
}
