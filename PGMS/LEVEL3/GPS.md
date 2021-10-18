# GPS

## 풀이법
1. 인접리스트를 통해 길을 연결해준다.
2. dp를 Integer.MAX_VALUE로 초기화해준다.
3. gps_log의 index만큼 돌면서
4. 노드 갯수만큼 돌면서
5. 연결되어 있는 도로로 갈 때 gps와 같지 않으면 값을 갱신해주고
6. 원래 dp값과 비교하며 min값을 갱신해준다.
7. 마지막 노드와 연결된 길에서 값을 가져와 값이 Integer.MAX_VALUE면 -1을, 아니면 dp값을 반환한다.

### 코멘트
- 처음 방향성을 못잡아 dp를 써야한다는 힌트를 얻었다.
- 중요한점은 gps_log의 길이가 그렇게 길지 않아서 인접행렬을 써도 될 정도였다는 점?

```java
import java.util.*;

public class GPS {

    static public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;
        int[][] dp = new int[k][n+1];
        ArrayList<Integer>[] road = new ArrayList[n+1];
        for(int i=0; i < dp.length; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int i=0; i < road.length; i++){
            road[i] = new ArrayList<>();
        }

        for(int i=0; i < edge_list.length; i++){
            road[edge_list[i][0]].add(edge_list[i][1]);
            road[edge_list[i][1]].add(edge_list[i][0]);
        }

        int start = gps_log[0];
        int end = gps_log[gps_log.length - 1];
        dp[0][start] = 0;

        for(int i = 0; i < k-1; i++){
            for(int j=1; j <= n; j++){
                if(dp[i][j] == Integer.MAX_VALUE) continue;
                ArrayList<Integer> list = road[j];
                for(int node=0; node < list.size(); node++){
                    int v = dp[i][j];
                    if(list.get(node) != gps_log[i + 1]){
                        v++;
                    }

                    dp[i+1][list.get(node)] = Math.min(dp[i+1][list.get(node)], v);
                }
            }
        }
        return dp[k-1][end] == Integer.MAX_VALUE ? -1 : dp[k-1][end];
    }
}

```


출처 [코딩테스트 연습>2017 카카오코드 본선>GPS](https://programmers.co.kr/learn/courses/30/lessons/1837)