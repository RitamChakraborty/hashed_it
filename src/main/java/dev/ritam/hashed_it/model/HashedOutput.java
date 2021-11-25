package dev.ritam.hashed_it.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HashedOutput {
    private String input;
    private String output;
    private String hashType;
}
