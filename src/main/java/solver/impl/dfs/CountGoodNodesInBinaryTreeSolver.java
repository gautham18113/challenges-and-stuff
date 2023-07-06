package solver.impl.dfs;

import com.google.common.reflect.TypeToken;
import core.datastructure.BST;
import model.TestCases;
import module.SolverType;
import parser.Parser;
import problem.compare.Compare;
import problem.input.impl.GenericInput;
import problem.output.impl.GenericOutput;
import solver.BaseSolver;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree
 */
@SolverType
public class CountGoodNodesInBinaryTreeSolver
        extends BaseSolver<GenericInput<List<Integer>>, GenericOutput<Integer>> {

    @Inject
    public CountGoodNodesInBinaryTreeSolver(
            @Named("jsonParser")
            Parser parser,
            @Named("countGoodNodesInBinaryTreeProblem")
            String fileName,
            Map<String, Compare> compareMap) {
        super(parser, fileName, compareMap);
    }

    @Override
    protected TestCases<GenericInput<List<Integer>>, GenericOutput<Integer>> getTestCases() {
        return parser.parse(getConfigFile(), new TypeToken<>() {
        });
    }

    @Override
    public GenericOutput<Integer> solveProblem(GenericInput<List<Integer>> input) {
        List<Integer> nodes = input.getValue();
        BST root = BST.toBinaryTree(nodes);

        int result = dfs(root, Integer.MIN_VALUE);

        GenericOutput<Integer> output = new GenericOutput<>();
        output.setValue(result);
        return output;
    }

    private boolean goodNode(BST node, int maxSoFar) {
        return node.value >= maxSoFar;
    }

    private int dfs(BST current, int maxSoFar) {

        if (Objects.isNull(current)) {
            return 0;
        }

        boolean isGoodNode = goodNode(current, maxSoFar);

        maxSoFar = Math.max(maxSoFar, current.value);

        int validChildNodes = dfs(current.left, maxSoFar) + dfs(current.right, maxSoFar);

        if (isGoodNode) {
            return validChildNodes + 1;
        }

        return validChildNodes;
    }
}
