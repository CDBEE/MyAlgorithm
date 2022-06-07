# Longest Substring Without Repeating Characters

## 풀이
1. 이 문제는 brute force로 풀면 문자열이 길어졌을 때 시간 초과의 우려가 있다.
2. 이런 앞 뒤 탐색류 문제에 많이 적용되는 것이 Sliding window이다.
3. 우선 앞 뒤 index를 두고 앞을 이동하면서
4. 만약 현재 앞에서 뒤까지 탐색했던 문자열(set에 존재하는)에 존재하는 문자가 나왔다면
5. 해당 문자의 앞 부분까지 뒤의 index를 땡긴다.
6. 문자열을 탐색할 때 마다 문자열의 길이를 갱신해준다.

### 
1. 지금 생각해봤는데 문자열의 위치를 기억하는 map이 더 좋았을 것 같다.

```java
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s){
        int head = 0;

        int max = 1;

        if(s.length() == 0) return 0;

        Set<Character> set = new HashSet<>();

        set.add(s.charAt(0));

        for(int i=1, len = s.length(); i < len; i++){
            char c = s.charAt(i);
            if(!set.add(c)){
                while(s.charAt(head) != c){
                    set.remove(s.charAt(head++));
                }
                head++;
            }
            max = Math.max(max, i - head + 1);
        }

        return max;
    }
}
```