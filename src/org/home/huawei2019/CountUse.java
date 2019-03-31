package org.home.huawei2019;

import org.home.huawei2019.util.FileUtil;
import org.home.huawei2019.util.LoadData;

import java.util.List;
import java.util.Map;

/**
 * @Author: LiuChong
 * @Date: 2019-03-19 15:08
 * @Description:
 */
public class CountUse {

    public static void main(String[] args) {
        String[] strings = FileUtil.read("bin/demo/answer.txt", null);
        List<List<Integer>> lists = LoadData.loadData(strings);
        Map<Integer, Integer> use = LoadData.countUse(lists);
        System.out.println();
    }
}
