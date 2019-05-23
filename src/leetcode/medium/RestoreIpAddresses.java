package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * author：jutao
 * time：2019/5/23
 * description：93. 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 */
public class RestoreIpAddresses {
    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("12345") + "");
    }

    List<String> list;

    public List<String> restoreIpAddresses(String ip) {
        list = new ArrayList<>();
        if (ip.length() < 4) {
            return list;
        }
        if (ip.length() > 12) {
            return list;
        }
        if (ip.length() > 4 && Long.valueOf(ip) == 0) {
            return list;
        }
        restoreIpAddresses(ip, "", 1);
        return list;
    }

    private void restoreIpAddresses(String ip, String s, int count) {
        if (count == 4) {
            if (ip.length() <= 3) {
                if (ip.length() > 1 && ip.substring(0, 1).equals("0")) {
                    return;
                }
                if (Integer.valueOf(ip) > 255) {
                    return;
                }
                list.add(s.substring(1) + "." + ip);
            }
            return;
        }
        for (int i = 1; i < Math.min(4, ip.length()); i++) {
            String temp = ip.substring(0, i);
            if (temp.length() > 1 && temp.substring(0, 1).equals("0")) {
                break;
            }
            int number = Integer.valueOf(temp);
            if (number > 255) {
                continue;
            }
            restoreIpAddresses(ip.substring(i), s + "." + number, count + 1);
        }
    }
}
