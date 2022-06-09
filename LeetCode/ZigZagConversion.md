# ZigZagConversion

## 풀이법
1. 규칙을 찾으면 쉽다.
2. numOfRows = 1 이면 원본과 같으니 그냥 원본을 리턴한다.
3. numOfRows > 2 부터의 규칙은 이렇다
   1. 세로로 진행되는 줄은 numOfRows만큼 진행된다.
   2. 각 줄은 Start를 한번 더한 간격, end를 한 번 더한 간격을 띄우면서 문자열을 만들어간다.
   3. Start는 (numOfRows - 1) * 2로 시작, end는 0로 시작한다. 
   4. 줄이 진행하면서 start는 -2, end는 +2를 한다.
4. 이 규칙들을 진행하면서 모든 세로줄을 다 탐색하면 완성이다.

### 코멘트
1. 규칙만 찾으면 끝나는 문제

```java
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        int start = (numRows-1) * 2, end = 0, len = s.length();


        StringBuilder sb = new StringBuilder();
        for(int i=0; i < numRows; i++){
            int point = i;
            while(point < len){
                if(start != 0) sb.append(s.charAt(point));
                point += start;
                if(point >= len) break;
                if(end != 0)sb.append(s.charAt(point));
                point += end;
            }

            start -= 2;
            end += 2;
        }

        return sb.toString();
    }
}

```