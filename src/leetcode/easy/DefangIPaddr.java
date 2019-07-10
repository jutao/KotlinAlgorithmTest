package leetcode.easy;

/**
 * author：jutao
 * time：2019/7/10
 * description：1108. IP 地址无效化
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 */
public class DefangIPaddr {
    public String defangIPaddr(String address) {
        char[] ch=new char[address.length()+6];
        int index=0;
        for (int i = 0; i < address.length(); i++) {
            if(address.charAt(i)=='.'){
                ch[index++]='[';
                ch[index++]='.';
                ch[index++]=']';
            }else {
                ch[index++]=address.charAt(i);
            }
        }
        return new String(ch);
    }
}
