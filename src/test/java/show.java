import org.apache.tools.ant.util.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @description:测试
 * @author: Cherry
 * @time: 2020/6/14 8:00
 */
public class show {
    @Test
    public void show1(){
        String d = DateUtils.format(new Date(),"yyyy-MM-dd");
        String d2 = DateUtils.format(System.currentTimeMillis(),"yyyy-MM-dd hh:mm:ss");
        System.out.println(d+"\n"+d2);
    }
}
