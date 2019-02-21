package medium;

import java.util.*;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/21
 * description：451. 根据字符出现频率排序
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * ****************************************
 */
public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(new FrequencySort().frequencySort2("abbddeeeeeccc"));
    }

    /**
     * 解法1
     * @param s
     * @return
     */
    public String frequencySort1(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : entries) {
            Integer value = entry.getValue();
            while (value-- > 0) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }



    /**
     * 解法2
     * @param s
     * @return
     */
    public String frequencySort2(String s) {
        if(s.length()<=2){
            return s;
        }
        int[] count = new int[256];
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        List<Node> list = new LinkedList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                list.add(new Node(count[i], (char) i));
            }
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.count-o1.count;
            }
        });
        int j=0;
        for (Node node : list) {
            for (int i = node.count; i > 0; i--) {
                result[j++]=node.word;
            }
        }
        return new String(result);
    }
    private class Node {
        int count;
        char word;

        public Node(int count, char word) {
            this.count = count;
            this.word = word;
        }
    }
}
