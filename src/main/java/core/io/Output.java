package core.io;

public class Output<T> {
    private T output;

    public Output(T op) {
       this.output=op;
    }

    public T getOutput() {
        return this.output;
    }
}
