package leetcode.medium;

/**
 * author：jutao
 * time：2019/6/26
 * description：739. 每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        new DailyTemperatures().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        int[] temp = new int[71];
        temp[T[T.length-1] - 30]=T.length-1;
        int max=T[T.length-1];
        for (int i = T.length - 2; i >= 0; i--) {
            if(T[i]==100){
                max=T[i];
                temp[T[i] - 30] = i;
                res[i]=0;
                continue;
            }
            if(max<=T[i]){
                max=T[i];
                temp[T[i] - 30] = i;
                res[i]=0;
                continue;
            }
            int p = T[i] + 1;
            while (p <= 100) {
                if (temp[p - 30] != 0) {
                    res[i] = res[i]==0?temp[p - 30] - i:Math.min(temp[p - 30] - i,res[i]);
                }
                p++;
            }
            temp[T[i] - 30] = i;
        }
        return res;
    }

    public int[] dailyTemperatures1(int[] T) {
        int[] res = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < T.length) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
                j += res[j];
            }
        }
        return res;
    }
}
