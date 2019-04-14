package org.home.wy.new2;

import java.util.*;

/**
 * @Author: LiuChong
 * @Date: 2019-04-02 20:32
 * @Description:
 */
public class Main {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Map<Integer, List<Integer>> integerListMap = allPri(nums);
        int res = 0;
        for (Map.Entry<Integer, List<Integer>> entry : integerListMap.entrySet()) {
            for (Integer integer : entry.getValue()) {
                List<Integer> list = integerListMap.getOrDefault(integer, Collections.emptyList());
                res += list.size();
                if (list.contains(entry.getKey())) {
                    res--;
                }
            }
        }
        System.out.println(res);
    }


    static boolean isPri(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int c;
        while ((c = a % b) != 0) {
            a = b;
            b = c;
        }
        return b == 1;//b == 1 表示互质
    }

    static Map<Integer, List<Integer>> allPri(int[] allNum) {
        HashMap<Integer, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < allNum.length; i++) {
            for (int j = 0; j < allNum.length; j++) {
                if (i != j && isPri(allNum[i], allNum[j])) {
                    List<Integer> list = res.getOrDefault(i, new ArrayList<>());
                    list.add(j);
                    res.put(i, list);
                }
            }
        }
        return res;
    }

    class IJK {

        private Set<Integer> ijk;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            IJK ijk1 = (IJK) o;
            return ijk.equals(ijk1.ijk);
        }

        @Override
        public int hashCode() {
            return Objects.hash(ijk);
        }

        public IJK(Set<Integer> ijk) {
            this.ijk = ijk;
        }
    }

}
