# SquaresOfSortedArray

## 풀이법
1. 루프 돌면서 제곱 후 정렬, 끝!

```java
import java.util.Arrays;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0, len = nums.length;i < len; i++){
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
```