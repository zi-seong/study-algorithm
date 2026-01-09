import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();

        // 시작 위치 찾기 (S)
        int r = 0, c = 0;
        for (int i = 0; i < H; i++) {
            int idx = park[i].indexOf('S');
            if (idx != -1) {
                r = i;
                c = idx;
                break;
            }
        }

        // 방향 벡터
        Map<Character, int[]> dir = new HashMap<>();
        dir.put('N', new int[]{-1, 0});
        dir.put('S', new int[]{1, 0});
        dir.put('W', new int[]{0, -1});
        dir.put('E', new int[]{0, 1});

        for (String route : routes) {
            String[] parts = route.split(" ");
            char op = parts[0].charAt(0);
            int n = Integer.parseInt(parts[1]);

            int[] d = dir.get(op);

            // 이 명령을 적용해볼 임시 위치
            int nr = r;
            int nc = c;

            boolean ok = true;

            // 한 칸씩 이동하며 범위/장애물 체크
            for (int step = 1; step <= n; step++) {
                nr += d[0];
                nc += d[1];

                // 공원 밖이면 실패
                if (nr < 0 || nr >= H || nc < 0 || nc >= W) {
                    ok = false;
                    break;
                }

                // 장애물 만나면 실패
                if (park[nr].charAt(nc) == 'X') {
                    ok = false;
                    break;
                }
            }

            // 성공한 명령만 반영
            if (ok) {
                r = nr;
                c = nc;
            }
        }

        return new int[]{r, c};
    }
}