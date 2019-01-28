package easy;

/**
 * ****************************************
 * author：琚涛
 * time：2019/1/28
 * description：9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * ****************************************
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        for (int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
//        if(x<0){
//            return false;
//        }
//        int temp=x;
//        int result=0;
//        while (temp!=0){
//            result=result*10+temp%10;
//            temp/=10;
//        }
//        return result==x;
    }
}
