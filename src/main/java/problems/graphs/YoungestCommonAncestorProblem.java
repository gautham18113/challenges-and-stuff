package problems.graphs;

import java.util.Objects;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class YoungestCommonAncestorProblem implements ProblemInterface{
    /**
     *<div class="html">
     * <p>
     *   You're given three inputs, all of which are instances of an
     *   <span>AncestralTree</span> class that have an <span>ancestor</span> property
     *   pointing to their youngest ancestor. The first input is the top ancestor in an
     *   ancestral tree (i.e., the only instance that has no ancestor--its
     *   <span>ancestor</span> property points to <span>None</span> /
     *   <span>null</span>), and the other two inputs are descendants in the ancestral
     *   tree.
     * </p>
     * <p>
     *   Write a function that returns the youngest common ancestor to the two
     *   descendants.
     * </p>
     * <p>
     *   Note that a descendant is considered its own ancestor. So in the simple
     *   ancestral tree below, the youngest common ancestor to nodes A and B is node A.
     * </p>
     * <pre><span class="">// The youngest common ancestor to nodes A and B is node A.</span>
     *   A
     *  /
     * B
     * </pre>
     * <h3>Sample Input</h3>
     * <pre><span class="">// The nodes are from the ancestral tree below.</span>
     * <span class="">topAncestor</span> = node A
     * <span class="">descendantOne</span> = node E
     * <span class="">descendantTwo</span> = node I
     *           A
     *        /     \
     *       B       C
     *     /   \   /   \
     *    D     E F     G
     *  /   \
     * H     I
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>node B
     * </pre>
     * </div>
     */
    @Override
    public Problem getProblem() {
        AncestralTree I = new AncestralTree('I');
        AncestralTree H = new AncestralTree('H');
        AncestralTree D = new AncestralTree('D');
        D.addAsAncestor(new AncestralTree[]{H, I});;
        AncestralTree E = new AncestralTree('E');
        AncestralTree B = new AncestralTree('B');
        B.addAsAncestor(new AncestralTree[]{D, E});
        AncestralTree F = new AncestralTree('F');
        AncestralTree G = new AncestralTree('G');
        AncestralTree C = new AncestralTree('C');
        C.addAsAncestor(new AncestralTree[]{F, G});
        AncestralTree A = new AncestralTree('A');
        A.addAsAncestor(new AncestralTree[]{B, C});


        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(A)
            .withInput(E)
            .withInput(I)
            .withOutput(B)
            .build()
        )
        .withTestCase(
            TestCase.builder()
            .withInput(A)
            .withInput(H)
            .withInput(F)
            .withOutput(A)
            .build()
        )
        .build();
    }

    public static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
          this.name = name;
          this.ancestor = null;
        }

        public boolean equals(AncestralTree o) {
            if(
                o.name == this.name
                && (
                    (Objects.isNull(o.ancestor) && Objects.isNull(this.ancestor))
                    || (
                        (Objects.nonNull(o.ancestor) && Objects.nonNull(this.ancestor))
                        && (o.ancestor.name == this.ancestor.name)
            ))) return true;
            return false;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
          for (AncestralTree descendant : descendants) {
            descendant.ancestor = this;
          }
        }
    }



}
