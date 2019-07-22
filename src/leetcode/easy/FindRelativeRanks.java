package leetcode.easy;

/**
 * author：jutao
 * time：2019/7/18
 * description：506. 相对名次
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * <p>
 * (注：分数越高的选手，排名越靠前。)
 */
public class FindRelativeRanks {
    public static void main(String[] args) {
        new FindRelativeRanks().findRelativeRanks(new int[]{6, 7, 4, 3, 2});
    }

    public String[] findRelativeRanks(int[] nums) {
        String[] ranks = new String[nums.length];

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] rank = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            rank[nums[i]] = i+1;
        }
        int count = 1;
        for (int i = max; i >=0; i--) {
            if (rank[i] > 0) {
                switch (count) {
                    case 1:
                        ranks[rank[i]-1] = "Gold Medal";
                        break;
                    case 2:
                        ranks[rank[i]-1] = "Silver Medal";
                        break;
                    case 3:
                        ranks[rank[i]-1] = "Bronze Medal";
                        break;
                    default:
                        ranks[rank[i]-1] = Integer.toString(count);
                        break;
                }
                count++;
            }
        }
        return ranks;
    }
}
