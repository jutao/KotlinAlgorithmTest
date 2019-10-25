package leetcode;

import sun.net.www.http.HttpClient;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * author：jutao
 * time：2019/7/24
 * description：分析gp链接是否下线
 */
public class InspectionGp {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curDate = simpleDateFormat.format(System.currentTimeMillis());  //当前日期
        System.out.println(curDate);
        System.getProperties().setProperty("http.proxyHost", "127.0.0.1");
        System.getProperties().setProperty("http.proxyPort", "49502");
        System.setProperty("https.proxyHost", "127.0.0.1");
        System.setProperty("https.proxyPort", "49502");
        String[] urls = {
                "2028 https://play.google.com/store/apps/details?id=com.qwxawq.jax",
                "2028马甲包(备案) https://play.google.com/store/apps/details?id=com.chons.bance",
                "2063绿包(备案) https://play.google.com/store/apps/details?id=com.sadhllas.vaynhe",
                "2064(备案) https://play.google.com/store/apps/details?id=com.heycok.amidnes",
                "2065V11 https://play.google.com/store/apps/details?id=com.lppdoc.lmlcopx",
                "2066V11(备案) https://play.google.com/store/apps/details?id=com.mklopx.tyux",
                "2068 https://play.google.com/store/apps/details?id=com.skongs.ldonglon",
                "2069V11(备案) https://play.google.com/store/apps/details?id=com.novhey.vblmop",
                "2070(备案) https://play.google.com/store/apps/details?id=umliop.lkhj.daslp",
                "2071V11 https://play.google.com/store/apps/details?id=com.olinm.mnvcf",
                "2072暂时不上 https://play.google.com/store/apps/details?id=ksdlop.lomsak.uidso",
                "2074(备案) https://play.google.com/store/apps/details?id=com.vayvang.com",
                "2075 https://play.google.com/store/apps/details?id=com.tuigaotin.xinyongmidai",
                "2076暂时不上 https://play.google.com/store/apps/details?id=com.yccash.vn",
                "2083(备案) https://play.google.com/store/apps/details?id=com.saigoncash.sikuo",
                "2085V4 https://play.google.com/store/apps/details?id=com.ms.easydong",
                "2094V4 https://play.google.com/store/apps/details?id=com.molibiao.sadamn",
                "2096V12 https://play.google.com/store/apps/details?id=com.mlonhp.mlnjvf"
        };
        inspection(urls);
    }

    private static void inspection(String[] urls) {
        for (String url : urls) {
            String[] s = url.split(" ");
            sendGet(s[0],s[1]);
        }
    }

    private static String sendGet(String name,String url) {
        // 定义一个字符串用来存储网页内容
        String result = "";
        // 定义一个缓冲字符输入流
        BufferedReader in = null;
        try {
            // 将string转成url对象
            URL realUrl = new URL(url);
            // 初始化一个链接到那个url的连接
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
            // 开始实际的连接
            connection.connect();
            // 初始化 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            // 用来临时存储抓取到的每一行的数据
            String line;
            while ((line = in.readLine()) != null) {
                // 遍历抓取到的每一行并将其存储到result里面
                result += line;
            }
        } catch (Exception e) {
            System.out.println(name+"不在线上,地址为:"+url);
        }
        // 使用finally来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
