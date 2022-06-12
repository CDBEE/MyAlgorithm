# FirstBadVersion

## 풀이법
1. 간단한 이진 탐색 문제이지만 low와 high를 더했을 때 int의 범위를 넘는 경우가 있기 때문에 조심


```java
public class FirstBadVersion {
    public int firstBadVersion(int n){
        long low = 0, high = n;
        int mid = 0;

        while(low <= high){
            mid = (int)((low + high) / 2);
            if(!isBadVersion(mid) && isBadVersion(mid + 1)){
                return mid+1;
            }else if(!isBadVersion(mid)){
                low = mid + 1;
            }else if(isBadVersion(mid)){
                high = mid - 1;
            }
        }
        return mid;
    }
    
}
```