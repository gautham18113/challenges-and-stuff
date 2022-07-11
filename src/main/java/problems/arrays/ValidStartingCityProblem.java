package problems.arrays;

import core.Problem;
import core.ProblemInterface;
import core.TestCase;

public class ValidStartingCityProblem implements ProblemInterface {

    /**
     * <div class="html">
     * <p>
     *   Imagine you have a set of cities that are laid out in a circle, connected by a
     *   circular road that runs clockwise. Each city has a gas station that provides
     *   gallons of fuel, and each city is some distance away from the next city.
     * </p>
     * <p>
     *   You have a car that can drive some number of miles per gallon of fuel, and
     *   your goal is to pick a starting city such that you can fill up your car with
     *   that city's fuel, drive to the next city, refill up your car with that city's
     *   fuel, drive to the next city, and so on and so forth until you return back to
     *   the starting city with 0 or more gallons of fuel left.
     * </p>
     * <p>
     *   This city is called a valid starting city, and it's guaranteed that there will
     *   always be exactly one valid starting city.
     * </p>
     * <p>
     *   For the actual problem, you'll be given an array of distances such that city
     *   <span>i</span> is <span>distances[i]</span> away from city <span>i + 1</span>.
     *   Since the cities are connected via a circular road, the last city is connected
     *   to the first city. In other words, the last distance in the
     *   <span>distances</span> array is equal to the distance from the last city to
     *   the first city. You'll also be given an array of fuel available at each city,
     *   where <span>fuel[i]</span> is equal to the fuel available at city
     *   <span>i</span>. The total amount of fuel available (from all cities combined)
     *   is exactly enough to travel to all cities. Your fuel tank always starts out
     *   empty, and you're given a positive integer value for the number of miles that
     *   your car can travel per gallon of fuel (miles per gallon, or MPG). You can
     *   assume that you will always be given at least two cities.
     * </p>
     * <p>Write a function that returns the index of the valid starting city.</p>
     * <h3>Sample Input</h3>
     * <pre><span class="">distances</span> = [5, 25, 15, 10, 15]
     * <span class="">fuel</span> = [1, 2, 1, 0, 3]
     * <span class="">mpg</span> = 10
     * </pre>
     * <h3>Sample Output</h3>
     * <pre>4
     * </pre>
     * </div>
     */
    @Override
    public Problem getProblem() {
        return Problem.builder()
        .withTestCase(
            TestCase.builder()
            .withInput(new int[]{5, 25, 15, 10, 15})
            .withInput(new int[]{1, 2, 1, 0, 3})
            .withInput(10)
            .withOutput(4)
            .build()
        )
        .build();
    }

}
