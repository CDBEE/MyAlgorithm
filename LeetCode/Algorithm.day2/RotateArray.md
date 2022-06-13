# RotateArray

## 풀이법
1. 무언가를 돌릴 때 공간적 제약이 없다면 두 개를 이어붙이는 것이 간단한 해법이다.


```java
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(k > nums.length) k %= nums.length;
        int[] rotate = new int[nums.length * 2];

        for(int i=0, j = nums.length, len = nums.length; i < len; i++, j++){
            rotate[i] = nums[i];
            rotate[j] = nums[i];
        }


        for(int i = nums.length - k, cnt = 0, len = nums.length; cnt < len;i++, cnt++){
            nums[cnt] = rotate[i];
        }
    }
}


```