package dev.ritam.hashed_it.model;

import java.util.Objects;

public class HashedOutput {
    private String input;
    private String output;
    private String hashType;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getHashType() {
        return hashType;
    }

    public void setHashType(String hashType) {
        this.hashType = hashType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashedOutput)) return false;
        HashedOutput that = (HashedOutput) o;
        return getInput().equals(that.getInput()) &&
                getOutput().equals(that.getOutput()) &&
                getHashType().equals(that.getHashType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInput(), getOutput(), getHashType());
    }

    @Override
    public String toString() {
        return "HashedOutput{" +
                "input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", hashType='" + hashType + '\'' +
                '}';
    }
}
