## Prefix Sum

```java
// arr is some integer array
int[] prefixSum = new int[arr.size() + 1];
for(int i = 1; i <= arr.size(); i++) {
    prefixSum[i] = prefixSum[i - 1] + arr.get(i - 1);
}

// sub array sum till i to j, where 0 <= i < j < arr.size()
int subArraySum = prefixSum[j + 1] - prefixSum[i - 1]
```