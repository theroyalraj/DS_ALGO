
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CompareTwoTextFiles {

    public static void main(String[] args) throws IOException {

        File f1 = new File("out0.txt");
        File f2 = new File("test0.txt");
        boolean result = FileUtils.contentEqualsIgnoreEOL(f1, f2, "utf-8");
        if (!result) {
            System.out.println("Files content are not equal.");
        } else {
            System.out.println("Files content are equal.");
        }

    }

}