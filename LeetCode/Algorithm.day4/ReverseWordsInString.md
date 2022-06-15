# Reverse Words In String

## 풀이법
1. String.split(" ")을 통해 단어를 낱말로 흩어놓는다
2. 흩어놓은 단어들을 거꾸로 뒤집는다.
3. 뒤집은 단어를 StringBuilder로 붙여넣는다.
4. 맨 마지막에 스페이스바가 하나 더 붙는것을 대비해 setLength를 통해 없애준다.

```java
public class ReverseWordsInString {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < ss.length; i++){
            String sss = ss[i];
            for(int j=sss.length() - 1; j >= 0; j--){
                sb.append(sss.charAt(j));
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);

        return sb.toString();
    }
}

```