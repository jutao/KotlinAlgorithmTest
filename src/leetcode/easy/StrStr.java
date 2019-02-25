package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/2/25
 * description：28. 实现strStr()
 * 即实现Java 的 indexOf() 方法
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * ****************************************
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("dasdasdssadasds", "sds"));
    }
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        for (int i = 0; i < haystackChar.length; i++) {
            if (i + needleChar.length > haystackChar.length) {
                return -1;
            }
            if (haystackChar[i] == needleChar[0]) {
                boolean flag = true;
                for (int j = 1; j < needleChar.length; j++) {
                    if (needleChar[j] != haystackChar[i + j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        "ss".indexOf("dasd");
        return -1;
    }
}
