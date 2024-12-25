package JavaSE;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 异常示例代码
 */
public class Example_exception {
    public static void main(String[] args) {
        /**
         *  1.try-with-resources 使用示例
         * try-with-resources 会自动关闭 BufferedInputStream 和 BufferedOutputStream，且可用 ';' 分隔多个资源
        */
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File("test.txt")));
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("out.txt")))) {
            int b;
            while ((b = bin.read()) != -1) {
                bout.write(b);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
