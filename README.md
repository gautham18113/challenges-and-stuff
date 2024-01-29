[![Java CI with Gradle](https://github.com/gautham18113/challenges-and-stuff/actions/workflows/gradle.yml/badge.svg?event=push)](https://github.com/gautham18113/AlgorithmsJava/actions/workflows/gradle.yml)

# Description

This package provides an infrastructure to solve Leetcode style problems.

## How To

### Define the problem

We should first start with the test case / problem definition which is provided as a JSON input.

The test case definition will vary depending on the number of parameters, if your problem
has only one input then the format below can be used.

```json
{
  "testCases": [
    {
      "input": {
        "value": [
          "foo",
          "bar"
        ]
      },
      "output": {
        "value": 2
      }
    },
    {
      "input": {
        "value": [
          "baz"
        ]
      },
      "output": {
        "value": 1
      }
    }
  ]
}
```

If there are several input parameters, then the test case input needs an identifier
for each input. For example see below.

```json
{
  "testCases": {
    "input": {
      "matrix": [
        [
          1,
          5,
          9
        ],
        [
          10,
          11,
          13
        ],
        [
          12,
          13,
          15
        ]
      ],
      "k": 8
    },
    "output": {
      "value": 13
    }
  }
}
```

### Define the input

For cases where only a single input parameter is needed, this step is not required. It is only required if there
are mulitiple input parameters required for the problem.

A corresponding [ProblemInput](./src/main/java/model/io/ProblemInput.java) type needs to
be specified that matches the input schema. See [this](./src/main/java/solver/impl/graph/FloodFillInput.java) for
example.

Note that the first case uses a generic `{input: value}` object to encapsulate the input and the multiple
parameter case uses a custom `{input: <custom bean definition>}` to encapsulate the custom parameters needed
for the input.

The types within the encapsulated input are inferred by the JSON schema parser for both the generic and custom inputs.

### Define the solver

The solver is where the chunk of work happens, and is a kind of manager that "knows" how to solve the problem.

It is given the expected input type, expected output type and test cases. It is given a `solve` method which knows how
to process the input provided by the test case, and compares this result with the expected output defined by the test
case. The solver returns a `SolverOutput` which is an object that encapsulates details about the passed and failed test
cases.

The solver should be defined in the following format

```java
import com.google.common.reflect.TypeToken;
import model.testcase.TestCases;
import parser.Parser;
import compare.Compare;
import solver.output.GenericOutput;
import model.solver.SolverType;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

// The @SolverType annotation is required for the application to recognize this class as a solver
@SolverType
public class ExampleSolver extends BaseSolver<
        // This can be replaced with a custom input type that matches the problem's input schema
        GenericInput<int[]>,
        // A generic output that can encapsulate any kind of output. Note that if you need
        // a custom output, a corresponding output type needs to be created/
        GenericOutput<int>
        > {
    @Inject
    public ExampleSolver(
            // This allows to inject a parser of your own preference, if you don't prefer working
            // with JSON. Note that a corresponding parser implementation needs to be added.
            @Named("jsonParser")
            Parser parser,
            // The "exampleProblem" is the mapping between the solver and the json problem file
            @Named("exampleProblem")
            String fileName,
            // A map of comparators to compare non-conventional outputs from the solver, like 
            // the expected and actual values of graph, tree, linked list etc.
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    // This should be added to make sure that type inference happens properly
    @Override
    protected TestCases<GenericInput<int[]>, GenericOutput<int>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    // Must be overriden and contains instructions on solving the problem.
    @Override
    public GenericOutput<int[]> solveProblem(MergeSortedArrayInput input) {
        int[] arr = (int[]) input.getValue();
        int result = someFunctionThatSolvesThisProblem(arr);
        GenericOutput<int[]> op = new GenericOutput<>();
        op.setValue(result);
        return op;
    }

}
```

### Add solver to problem mapping

Finally, the name defined in `fileName` parameter above needs to be mapped to an actual file which
contains the problem details like test cases and comparator.

This should be done in the [problemList.json](src/main/resources/problems/problemList.json).

Once the above steps are complete, the application will run the solver against the testcases defined in the problem
definition file and produce an output similar to what is shown below:

```bash
Begin test cases for ReconstructingSequenceSolver
Executing test case: TestCase(input=ReconstructingSequenceInput(original=[1, 2, 3], seqs=[[1, 2], [1, 3]]), output=GenericOutput{value=false})
Execution time is 301084.00000 seconds
Executing test case: TestCase(input=ReconstructingSequenceInput(original=[1, 2, 3], seqs=[[1, 2]]), output=GenericOutput{value=false})
Execution time is 10666.00000 seconds
Executing test case: TestCase(input=ReconstructingSequenceInput(original=[1, 2, 3], seqs=[[1, 2], [1, 3], [2, 3]]), output=GenericOutput{value=true})
Execution time is 9792.00000 seconds
Executing test case: TestCase(input=ReconstructingSequenceInput(original=[4, 1, 5, 2, 6, 3], seqs=[[5, 2, 6, 3], [4, 1, 5, 2]]), output=GenericOutput{value=true})
Execution time is 17125.00000 seconds
Executing test case: TestCase(input=ReconstructingSequenceInput(original=[3, 1, 4, 2], seqs=[[3, 1], [3, 4], [4, 2]]), output=GenericOutput{value=false})
Execution time is 8875.00000 seconds
Executing test case: TestCase(input=ReconstructingSequenceInput(original=[1, 3, 2, 5, 4], seqs=[[4], [1, 1, 3], [3, 2], [2, 5], [5, 4]]), output=GenericOutput{value=false})
Execution time is 9042.00000 seconds
Executing test case: TestCase(input=ReconstructingSequenceInput(original=[7, 4, 2, 5, 1, 3, 6], seqs=[[7, 4, 5, 3], [2, 1, 3, 6]]), output=GenericOutput{value=false})
Execution time is 11292.00000 seconds
Executing test case: TestCase(input=ReconstructingSequenceInput(original=[4, 6, 1, 5, 8, 7, 2, 3], seqs=[[3], [4, 6, 1, 7], [1, 5, 8, 2], [8, 7, 2, 3]]), output=GenericOutput{value=true})
Execution time is 18542.00000 seconds
End test cases for ReconstructingSequenceSolver
```

## Conclusion

This is a module I built to make learning DSA and consolidating my learning a bit easier, please feel free to use the infrastructure defined here
for your own projects.

Enhancements and suggestions welcome!

## License

MIT
