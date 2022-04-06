import com.bjpowernode.utils.FileNameUtil;

import java.io.File;

/**
 * @author wjs
 * @create 2022-03-16 20:20
 */
public class TestFileNameUtil {
    public static void main(String[] args) {
        System.out.println(FileNameUtil.getRealFileName("wei.jpg"));
        System.out.println(FileNameUtil.getFileType("wei.jpg"));
        String uploadName=FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType("wei.jpg");
        System.out.println(uploadName);
        System.out.println(File.separator);
    }
}
