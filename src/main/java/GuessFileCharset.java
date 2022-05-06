import info.monitorenter.cpdetector.io.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author hyqc
 */
public class GuessFileCharset {
    public static Charset guess(File file) throws IOException {
        CodepageDetectorProxy detectorProxy = CodepageDetectorProxy.getInstance();
        detectorProxy.add(new ParsingDetector(false));
        detectorProxy.add(JChardetFacade.getInstance());
        detectorProxy.add(ASCIIDetector.getInstance());
        detectorProxy.add(UnicodeDetector.getInstance());
        return detectorProxy.detectCodepage(file.toURI().toURL());
    }
}
