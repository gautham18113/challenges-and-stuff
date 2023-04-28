# Dynamic Programming

Dynamic Programming is an **optimization** technique that solves problems with the following characteristics

1. The problem can be divided into sub-problems, and its optimal solution can be constructed from optimal solutions of
   the sub-problems. In academic terms, this is called optimal substructure.
2. The sub-problems from 1) overlap.

Dynamic programming amounts to breaking down an optimization problem into simpler sub-problems, and storing the solution
to each sub-problem so that each sub-problem is only solved once.

Dynamic programming is basically DFS + pruning + memoization.

## How to solve Dynamic programming problems

Top-down: this is basically DFS + memoization. We split large problems and recursively solve smaller sub-problems.

Bottom-up: we try to solve sub-problems and then use their solutions to find the solutions to bigger sub-problems. This
is usually done in a tabular form.

## Steps to work through a DP problem

We can see from this example the top-down and bottom-up are essentially equivalent.

Remember: DP = DFS + pruning + memoization.

Steps to solve a DP problem:

- brute force
- draw the state-space tree
- dfs on the state-space tree
- prune if possible
- memo
    - find the duplicate subtrees
- bottom-up (if you want to)
    - optional space optimization

## Examples

- Knapsack problems
  - [weight only knapsack](https://github.com/gautham18113/AlgorithmsJava/blob/df9f79a56f9a8eda25d97d75bdc4830872ac75e4/src/main/java/solver/impl/dp/KnapsackWeightOnlyBottomUpSolver.java#L18-L18)
  - [partition to equal subset sum]()