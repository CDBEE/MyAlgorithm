# LongestPalindromicSubstring

## 풀이법
1. 우선 홀수일 때, 짝수일 때가 나눠져야 한다.
2. 홀수일 경우 중앙의 한 점으로부터 왼쪽과 오른쪽이 같은 문자열을 갖는 동안 양 옆으로 퍼져나간다.
3. 짝수일 경우도 같지만 left와 right이 같은 경우에만 퍼져나간다.

### 코멘트
1. left, right를 주고 함수를 사용해서 체크를 했다면 좀 더 깔끔하게 풀 수 있지 않을까 싶다.

```java
public class LongestPalindromicSubstring {

    class Solution {
        public String longestPalindrome(String s) {
            int left = 0, right = 0;
            String max = "";
            for(int i=0, len = s.length(); i < len; i++){
                left = right = i;
                while(left - 1 >= 0 && right +1 < len && s.charAt(left-1) == s.charAt(right+1)){
                    left--;
                    right++;
                }
                if(max.length() < right - left + 1){
                    max = s.substring(left, right + 1);
                }
            }

            for(int i=0, len = s.length(); i < len - 1; i++){
                if(s.charAt(i) == s.charAt(i+1)){
                    left = i;
                    right = i+1;
                    while(left - 1 >= 0 && right + 1 < len && s.charAt(left-1) == s.charAt(right+1)){
                        left--;
                        right++;
                    }
                    if(max.length() < right - left + 1){
                        max = s.substring(left, right + 1);
                    }
                }
            }

            return max;
        }
    }
}
```