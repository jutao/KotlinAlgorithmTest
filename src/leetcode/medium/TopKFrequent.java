package medium;

import java.util.*;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/2
 * description：347. 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * ****************************************
 */
public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(new TopKFrequent().topKFrequent(new int[]{5,5,5,5,5,5,5,1, 1, 1, 1, 5, 5, 6, 6, 6, 6, 6, 6, 7}, 2));
    }
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(
                new Comparator<Map.Entry<Integer,Integer>>(){ //编写一个按values降序维护的comparator
                    public int compare(Map.Entry<Integer,Integer> entry1, Map.Entry<Integer,Integer> entry2){
                        return entry2.getValue() - entry1.getValue();
                    }
                });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
        }
        List<Integer> list=new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            list.add(priorityQueue.poll().getKey());
        }
        return list;
    }
}
