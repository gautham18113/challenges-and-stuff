package problems.arrays;

import core.io.Input;
import core.io.Output;
import core.Problem;
import core.TestCase;

import java.util.Arrays;
import java.util.Collections;

public class TandemBicycleProblem {
    public Problem problem;
    /**
     *
     * A tandem bicycle is a bicycle that's operated by two people: person A and
     * person B. Both people pedal the bicycle, but the person that pedals faster
     * dictates the speed of the bicycle. So if person A pedals at a speed of
     * 5, and person B pedals at a speed of 4, the tandem
     * bicycle moves at a speed of 5 (i.e.,
     * tandemSpeed = max(speedA, speedB)).
     *
     * You're given two lists of positive integers: one that contains the speeds of
     * riders wearing red shirts and one that contains the speeds of riders wearing
     * blue shirts. Each rider is represented by a single positive integer, which is
     * the speed that they pedal a tandem bicycle at. Both lists have the same
     * length, meaning that there are as many red-shirt riders as there are
     * blue-shirt riders. Your goal is to pair every rider wearing a red shirt with a
     * rider wearing a blue shirt to operate a tandem bicycle.
     *
     * Write a function that returns the maximum possible total speed or the minimum
     * possible total speed of all of the tandem bicycles being ridden based on an
     * input parameter, <em>fastest</em>. If <em>fastest = true</em>, your
     * function should return the maximum possible total speed; otherwise it should
     * return the minimum total speed.
     *
     * "Total speed" is defined as the sum of the speeds of all the tandem bicycles
     * being ridden. For example, if there are 4 riders (2 red-shirt riders and 2
     * blue-shirt riders) who have speeds of <em>1, 3, 4, 5</em>, and if they're
     * paired on tandem bicycles as follows: <em>[1, 4], [5, 3]</em>, then the
     * total speed of these tandem bicycles is <em>4 + 5 = 9</em>.
     *
     * redShirtSpeeds = [5, 5, 3, 9, 2]
     * blueShirtSpeeds = [3, 6, 7, 2, 1]
     * fastest = true
     *
     * output = 32
     *
     */

    public TandemBicycleProblem() {
        problem = Problem.builder()
            .withTestCaseList(Collections.singletonList(
                TestCase.builder()
                    .withInputParameters(Arrays.asList(
                        new Input<>(new int[]{5, 5, 3, 9, 2}),
                        new Input<>(new int[]{3, 6, 7, 2, 1}),
                        new Input<>(true)
                    ))
                    .withOutput(new Output<>(32))
                    .build()
            ))
            .build();
    }
}
