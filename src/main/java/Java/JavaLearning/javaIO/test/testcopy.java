package Java.JavaLearning.javaIO.test;

import java.io.*;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020-09-24 20:32
 */
public class testcopy {
    public static void main(String[] args) throws IOException {
        copy2("G:\\Coding\\a.txt", "G:\\Coding\\b.txt");

    }

    private static void copy(String filename, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copy2(String filename, String path) throws IOException {
        InputStream in = new FileInputStream(filename);
        OutputStream out = new FileOutputStream(path);
        byte[] bytes = in.readAllBytes();
        out.write(bytes, 0, bytes.length);
        RandomAccessFile a = new RandomAccessFile(filename, "r");
        a.readByte();


    }

}
