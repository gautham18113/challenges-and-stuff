package core;

import core.io.Input;
import core.io.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestCase {

    private final List<Input<?>> inputs;
    private final Output<?> output;
    private final Optional<BiFunction<?, ?, Boolean>> compare;

    private TestCase(List<Input<?>> inputs, Output<?> output, Optional<BiFunction<?, ?, Boolean>> compare) {
        this.inputs = inputs;
        this.output = output;
        this.compare = compare;
    }

    public Optional<BiFunction<?, ?, Boolean>> getCompare() {
        return compare == null ? Optional.empty() : compare;
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
        private Optional<BiFunction<?, ?, Boolean>> compare;

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

        public Builder withComparator(BiFunction<?, ?, Boolean> fn) {
            compare = Optional.ofNullable(fn);
            return this;
        }

        public TestCase build() {
            return new TestCase(
                this.inputParameters,
                this.output,
                this.compare
            );
        }
    }

    public static Builder builder() {
        return Builder.newInstance();
    }
}

