import java.util.*;

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagramsNaive(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = sortString(str);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(key, newList);
            }
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getSortKey(str);

            if(map.containsKey(key)){
                map.get(key).add(str);
            }else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(key, newList);
            }
        }

        return new ArrayList<>(map.values());
    }

    private String sortString(String str) {
        char[] charArr = str.toCharArray();

        Arrays.sort(charArr);

        return new String(charArr);
    }

    private static String getSortKey(String str) {
        int[] countArr = new int[26];
        int ch = 'a';

        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            countArr[c - 'a']++;
        }

        for (int i = 0; i < countArr.length; i++){
            if(countArr[i] != 0){
                String st = (char) ch + String.valueOf(countArr[i]); // Need this (char) otherwise a is append as 97
                sb.append(st);
            }
            ch++;
        }

        return new String(sb); //sb.toString();
    }

    public static void main(String[] args) {
        String str = "safsdf";
        System.out.println(getSortKey(str));
    }
}

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]



Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
