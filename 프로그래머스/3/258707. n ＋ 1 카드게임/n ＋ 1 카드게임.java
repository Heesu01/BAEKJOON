import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int target = n + 1;

        int idx = n / 3;

        Set<Integer> hand = new HashSet<>();
        for (int i = 0; i < idx; i++) hand.add(cards[i]);

        Set<Integer> extra = new HashSet<>();

        int round = 0;

        while (true) {
            round++;

            if (idx >= n) break;

            extra.add(cards[idx++]);
            extra.add(cards[idx++]);

            boolean ok = false;

            if (useFromHand(hand, target)) {
                ok = true;
            } else if (coin >= 1 && useFromHandExtra(hand, extra, target)) {
                coin--;
                ok = true;
            } else if (coin >= 2 && useFromExtra(extra, target)) {
                coin -= 2;
                ok = true;
            }

            if (!ok) break;
        }

        return round;
    }

    private boolean useFromHand(Set<Integer> hand, int target) {
        List<Integer> list = new ArrayList<>(hand);
        for (int x : list) {
            int y = target - x;
            if (x == y) continue;
            if (hand.contains(y)) {
                hand.remove(x);
                hand.remove(y);
                return true;
            }
        }
        return false;
    }

    private boolean useFromHandExtra(Set<Integer> hand, Set<Integer> extra, int target) {
        List<Integer> list = new ArrayList<>(hand);
        for (int x : list) {
            int y = target - x;
            if (extra.contains(y)) {
                hand.remove(x);
                extra.remove(y);
                return true;
            }
        }
        return false;
    }

    private boolean useFromExtra(Set<Integer> extra, int target) {
        List<Integer> list = new ArrayList<>(extra);
        for (int x : list) {
            int y = target - x;
            if (x == y) continue;
            if (extra.contains(y)) {
                extra.remove(x);
                extra.remove(y);
                return true;
            }
        }
        return false;
    }
}
