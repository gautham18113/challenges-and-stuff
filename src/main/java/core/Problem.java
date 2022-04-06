package core;

import java.util.ArrayList;
import java.util.List;

public class Problem {

    /**
     *
     * Problem will be a wrapper class that will
     * have the problem statement in the documentation.
     *
     * It will also have methods that will build test cases
     * given inputs.
     */

    private List<TestCase> testCases;

    private Problem(List<TestCase> testCases ) {
        this.testCases = testCases;
    }

    public List<TestCase> getTestCases() {
        return this.testCases;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private List<TestCase> testCaseList;

        public Builder withTestCaseList(List<TestCase> testCaseList) {
            this.testCaseList = testCaseList;
            return this;
        }

        public Builder withTestCase(TestCase testCase) {
            if(this.testCaseList == null) this.testCaseList = new ArrayList<>();
            this.testCaseList.add(testCase);
            return this;
        }

        public Problem build() {
            return new Problem(this.testCaseList);
        }
    }

}
