package Java.Java_Final.JavaCompiler;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;

/**
 * @Description: A file object used to represent source coming from a string
 * @author: Anhlaidh
 * @date: 2020-08-04 14:57
 */
public class JavaSourceFromString extends SimpleJavaFileObject {
    private String code;
    public JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension),Kind.SOURCE);
        this.code = code;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return code;
    }

    public String getCode() {
        return code;
    }
}
