package dev.ritam.hashed_it;

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
    public String toString() {
        return "HashedOutput{" +
                "input='" + input + '\'' +
                ", output='" + output + '\'' +
                ", hashType='" + hashType + '\'' +
                '}';
    }
}
