# MiddleOfLinkedList

## 풀이법
1. 전체 길이를 먼저 찾는다
2. 그 절반만큼 간 다음 절반을 return한다

### 코멘트
1. 이 방법보다는 Two pointer에서 하나는 한 칸, 하나는 두 칸씩 가는 방법을 쓰면
자연스레 중간을 찾을 수 있다.


```java
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode tmp = head;
        int i = 0;
        while(tmp.next != null){
            i++;
            tmp = tmp.next;
        }
        i = i / 2;
        int j = 0;
        while(j++ < i){
            head = head.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
```