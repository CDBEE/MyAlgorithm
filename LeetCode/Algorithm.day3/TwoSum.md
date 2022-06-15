# Two Sum

## 풀이법
1. 왼쪽 끝은 가장 작은 수, 오른쪽 끝은 가장 큰 수이다.
2. 두 수의 합이 target보다 더 크다면 오른쪽을 index를 한 칸 당긴다.(작아지는 방향)
3. 두 수의 합이 target보다 더 작다면 왼쪽 끝을 index를 한 칸 민다.(커지는 방향)
4. 두 수의 합이 target까지 반복한다.

```java
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length - 1;

        while((numbers[a] + numbers[b]) != target){
            if(numbers[a] + numbers[b] > target){
                b--;
            }else if(numbers[a] + numbers[b] < target){
                a++;
            }
        }

        return new int[]{a, b};
    }
}

```