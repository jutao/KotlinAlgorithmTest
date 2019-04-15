package medium;

/**
 * ****************************************
 * author：琚涛
 * time：2019/4/15
 * description：274. H指数
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的
 * （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）”
 * ****************************************
 */
public class HIndex {
    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{3, 0, 6, 1, 5}));
    }
    public int hIndex(int[] citations) {
        int n=citations.length;
        int[] buckets=new int[n+1];
        for (int citation : citations) {
            if(citation>=n){
                buckets[n]++;
            }else {
                buckets[citation]++;
            }
        }
        int count=0;
        for (int i = n; i >=0 ; i--) {
            count+=buckets[i];
            if(count>=i){
                return i;
            }
        }
        return 0;
    }
}
