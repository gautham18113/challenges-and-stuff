package core.io;

import java.util.List;

public class Input<T extends Object>{
    private T input;

    public Input(T ip) {
        this.input = ip;
    }
    public void setInput(T input) {
        this.input= input;
    }
    public T getInput() {
        return this.input;
    }

    public Boolean toBoolean() {
        if(input instanceof Boolean) return (Boolean) input;
        return null;
    }

    public List<T> toList() {
        if(input instanceof List) return (List<T>) input;
        return null;
    }
}