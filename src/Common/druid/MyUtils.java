package Common.druid;

import java.nio.charset.StandardCharsets;

/**
 * @Author:The King Of the World
 * @Date:2020/12/6
 * @Description:Common.druid
 * @version：1.0
 */
public class MyUtils {
    public static String toChinese(String string) {
        String str;
        if (string == null) {
            str = "";
        } else {
            try {
                str = new String(string.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            } catch (Exception e) {
                str = "";
                System.out.println("Failed to solve the Decoding!");
                e.printStackTrace();
            }
        }
        return str;
    }
}
