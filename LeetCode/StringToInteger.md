# StringToInteger

## 풀이법
1. 일단 atoi에 대한 단계가 이미 문제에 명시가 되어있기 때문에 그대로 따라하면 된다.
2. 따라하는 와중 예외적인 몇 단계가 있는데 예외는 이렇다
   1. 숫자 맨 앞에 0이 붙는 문제
   2. Long값 이상의 범위(String의 길이가 200까지라서..)가 들어오는 문제
   3. int값 이상의 값이 주어진다면 int의 최소/최대 값으로 치환해서 return


```java
public class StringToInteger {
    public int myAtoi(String s) {
        int idx = 0, len = s.length();
        boolean flag = true;
        while(idx < len && s.charAt(idx) == ' '){
            idx++;
        }

        StringBuilder sb = new StringBuilder();

        if(idx < len && (s.charAt(idx) == '-' || s.charAt(idx) == '+')){
            sb.append(s.charAt(idx));
            idx++;
        }

        while(idx < len && (s.charAt(idx) >= '0' && s.charAt(idx) <= '9')){
            if(flag && s.charAt(idx) == '0'){
                idx++;
                continue;
            }
            sb.append(s.charAt(idx++));
            flag = false;
        }


        if(sb.length() == 0) return 0;

        if(sb.length() == 1 && (sb.charAt(0) == '+' || sb.charAt(0) == '-'))
            return 0;

        if(sb.charAt(0) == '-' && sb.length() >= 12)
            return Integer.MIN_VALUE;
        if(sb.charAt(0) == '+' && sb.length() >= 12)
            return Integer.MAX_VALUE;
        if(sb.length() > 11)
            return Integer.MAX_VALUE;

        Long l = Long.valueOf(sb.toString());

        int answer = l < (long)Integer.MIN_VALUE ? Integer.MIN_VALUE : l > (long)Integer.MAX_VALUE ? Integer.MAX_VALUE : l.intValue();

        return answer;
    }
}
```