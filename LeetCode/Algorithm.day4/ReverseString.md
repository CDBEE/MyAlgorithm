# ReverseString

## 풀이법
1. head와 tail을 정한다.
2. head++, tail--를 하면서 head와 tail을 바꿔준다.

```java
public class ReverseString {
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        while(head <= tail){
            char temp = s[head];
            s[head++] = s[tail];
            s[tail--] = temp;
        }
    }
}
```