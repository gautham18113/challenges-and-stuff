package core;

import core.io.Input;
import core.io.Output;

import java.util.ArrayList;
import java.util.List;

public class TestCase {

    private final List<Input<?>> inputs;
    private final Output<?> output;

    private TestCase(List<Input<?>> inputs, Output<?> output) {
        this.inputs = inputs;
        this.output = output;
    }

    public List<Input<?>> getInputs() {
        return inputs;
    }

    public Output<?> getOutput() {
        return output;
    }

    public static class Builder {

        private List<Input<?>> inputParameters;

        private Output<?> output;

        protected static Builder newInstance() {
            return new Builder();
        }
        public Builder withInputParameters(List<Input<?>> params) {
            inputParameters = params;
            return this;
        }

        public Builder withInput(Input<?> param) {
            if(inputParameters == null)  inputParameters=new ArrayList<>();

            inputParameters.add(param);
            return this;
        }

        public Builder withInput(Object param) {
            if(inputParameters == null)  inputParameters=new ArrayList<>();

            inputParameters.add(new Input<>(param));
            return this;
        }

        public Builder withOutput(Output<?> op) {
            output = op;
            return this;
        }

        public Builder withOutput(Object op) {
            output = new Output<>(op);
            return this;
        }

        public TestCase build() {
            return new TestCase(
                this.inputParameters,
                this.output
            );
        }
    }

    public static Builder builder() {
        return Builder.newInstance();
    }
}

