# Move Zeros

## 풀이법
1. 0이 아닌 숫자만 queue에 넣는다
2. 루프를 돌면서 queue의 size만큼 숫자를 채우고 남은 공간은 0으로 채운다

### 코멘트
1. 원래는 새로운 배열을 만들어서 index를 따로 움직이면서 0이 아닌 숫자를 먼저 채우려고했다.



```java
import java.util.LinkedList;
import java.util.Queue;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        Queue<Integer> nonzero = new LinkedList<>();
        for(int i : nums){
            if(i != 0)
                nonzero.offer(i);
        }
        for(int i=0, len = nums.length, k = nonzero.size(); i < len; i++){
            if(i < k){
                nums[i] = nonzero.poll();
            }else {
                nums[i] = 0;
            }
        }
    }
}

```