import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class GuessFileCharsetTest {
    @Test
    public void guessTest(){
        try {
            File u8f = new File("./src/test/resources/utf-8.csv");
            File gbkf = new File("./src/test/resources/gbk.csv");
            Charset uc = GuessFileCharset.guess(u8f);
            if (!"UTF-8".equals(uc.name())){
                System.out.printf("error: expect UTF-8, but get %s%n", uc);
                return;
            }
            Charset gc = GuessFileCharset.guess(gbkf);
            if (!"UTF-16LE".equals(gc.name())){
                System.out.printf("error: expect GBK, but get %s%n", gc);
                return;
            }
            System.out.println("success");
        }catch (IOException e){
            System.out.printf("error: %s%n", e.getMessage());
        }
    }
}
