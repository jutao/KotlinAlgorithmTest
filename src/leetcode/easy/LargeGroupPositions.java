package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/26
 * description：830. 较大分组的位置
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * <p>
 * 最终结果按照字典顺序输出。
 * ****************************************
 */
public class LargeGroupPositions {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> lists = new ArrayList<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int j = i;
            while (j + 1 < chars.length && chars[j+1] == chars[i]) {
                j++;
            }
            if (j - i >= 2) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                lists.add(list);
                i=j;
            }
        }
        return lists;
    }
}
