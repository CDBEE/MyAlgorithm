# ReverseInteger

## 풀이법
1. 맨 앞의 -, 맨 뒤의 0은 예외 케이스로 빼준다.
2. 문자열화 한 String의 뒤부터 앞까지 StringBuilder로 결합
3. 바꾼 값이 Integer의 값을 벗어날 수 있으므로 Long형으로 변환 후 값의 범위를 측정하고 넘어갈 경우 0을 반환한다.


```java
public class ReverseInteger {
    public int reverse(int x) {
        String s = String.valueOf(x);
        int len = s.length() - 1;
        StringBuilder sb=  new StringBuilder();
        int startIdx = 0, endIdx = len;
        if(s.charAt(0) == '-'){
            sb.append('-');
            startIdx++;
        }

        if(s.charAt(len) == '0'){
            len--;
        }

        for(int i = endIdx; i >= startIdx; i--){
            sb.append(s.charAt(i));
        }

        Long l = Long.valueOf(sb.toString());

        int answer = l < (long)Integer.MIN_VALUE || l > (long)Integer.MAX_VALUE ? 0 : l.intValue();

        return answer;
    }
}

```