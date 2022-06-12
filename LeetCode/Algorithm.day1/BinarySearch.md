# BinarySearch

## 풀이법
1. 간단한 이진 탐색 문제이다.

```java
public class BinarySearch {
    public int search(int[] nums, int target){
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }
        }

        return -1;
    }
}
```