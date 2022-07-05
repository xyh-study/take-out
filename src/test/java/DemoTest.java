import org.junit.jupiter.api.Test;

/**
 * @author: xyh
 * @create: 2022/7/5 8:45
 */
public class DemoTest
{
    @Test
    public void test1(){
        long l = System.currentTimeMillis();
        String str = ".jpg";
        System.out.println(l+str);

        String substring = "123456.234.jpg".substring("123456.234.jpg".lastIndexOf("."));
        System.out.println(substring);
    }
}
