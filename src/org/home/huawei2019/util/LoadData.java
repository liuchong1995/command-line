package org.home.huawei2019.util;

import java.util.*;

public class LoadData {
	
	/**
	 * 根据 字符数组 加载数据集
	 * @param content
	 * @return
	 */
	public static List<List<Integer>> loadData(String[] content){
		List<List<Integer>> dataset = new ArrayList<>();
		for (int i = 0; i < content.length; i++) {
			if (content[i].contains(" ")) {
				ArrayList<Integer> online = new ArrayList<>();
				content[i] = content[i].substring(1,content[i].length() - 1);
				content[i] = content[i].replaceAll(",","");
				String[] array = content[i].split("\\s+");
				for (int j = 2; j < array.length; j++) {
					online.add(Integer.parseInt(array[j]));
				}
				dataset.add(online);
			}
		}
		return dataset;
	}

	public static Map<Integer, Integer> countUse(List<List<Integer>> dataset) {
		TreeMap<Integer, Integer> res = new TreeMap<>();
		dataset.forEach(list -> list.forEach(roadId -> res.put(roadId,res.getOrDefault(roadId,0) + 1)));
		return res;
	}
}
