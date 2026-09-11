class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();

        for (char ch : t.toCharArray()) {
            mp1.put(ch, mp1.getOrDefault(ch, 0) + 1);
        }

        int hv = 0, nd = mp1.size();
        int[] res = {-1, -1};
        int rl = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            mp2.put(c, mp2.getOrDefault(c, 0) + 1);

            if (mp1.containsKey(c) && mp2.get(c).equals(mp1.get(c))) {
                hv++;
            }

            while (hv == nd) {
                if (r - l + 1 < rl) {
                    rl = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char lc = s.charAt(l);
                mp2.put(lc, mp2.get(lc) - 1);

                if (mp1.containsKey(lc) && mp2.get(lc) < mp1.get(lc)) {
                    hv--;
                }

                l++;
            }
        }

        return rl == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}