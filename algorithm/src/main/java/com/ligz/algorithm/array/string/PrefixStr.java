package com.ligz.algorithm.array.string;

/**
 * 查找字符串数组中的最长公共前缀
 * author:ligz
 */
public class PrefixStr {
	public String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0){//如果长度为0则这返回""
			return "";
		}
		int minLen = strs[0].length();
		for(String s : strs){//得到最短的长度，防止越界
			if(minLen > s.length()){
				minLen = s.length();
			}
		}
		char[] first = strs[0].toCharArray();
		StringBuilder pre = new StringBuilder("");
		for(int i = 0; i < minLen; i++){//以最短的字符为遍历的最大值，一个一个对比，直到不一样break
			boolean flag = true;
			for(String s : strs){
				char[] str = s.toCharArray();
				if(first[i] != str[i]){
					flag = false;
				}
			}
			if(flag == true){
				pre.append(first[i]);
			}else{
				break;
			}
		}
		return pre.toString();
	}

	/**
	 * 官方
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {//当前缀不为索引0时，就将长度-1.
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) return "";
			}
		return prefix;
	}
	/**
	 * 官方2
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix3(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		for (int i = 0; i < strs[0].length() ; i++){
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j ++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
}