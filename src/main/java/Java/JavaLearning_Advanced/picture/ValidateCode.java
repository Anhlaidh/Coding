package Java.JavaLearning_Advanced.picture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/28 0028 19:56
 */
public class ValidateCode {
    static char[] codeSequence= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','2','3','4','5','6','7','8','9'};
    static int charNum = codeSequence.length;
    public static void main(String[] args) throws IOException {
        generateCode("./temp/validateCode/code.jpg");
    }

    private static void generateCode(String filePath) throws IOException {
        //首先定义验证码图片库
        int width = 140;//验证码图片的宽度
        int height = 40;//验证码图片的高度
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //定义图片上的图形和干扰线
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(Color.GRAY);//将图像填充为浅灰色
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setColor(Color.BLACK);//画边框
        graphics2D.drawRect(0, 0, width - 1, height - 1);
        //随机产生16条灰色干扰线
        graphics2D.setColor(Color.darkGray);
        //创建一个随机数生成器类，用于随机产生干扰线
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int x1 = random.nextInt(50);
            int y1 = random.nextInt(50);
            graphics2D.drawLine(x, y, x1, y1);

        }
        //计算字的位置坐标
        int codeCount = 4;//字的个数
        int fontHeight ;//字体高度
        int codeX;//第一个字符的x坐标，因为后面的字符坐标依次递增，所以他们的x轴值是codeX+i的值
        int codeY;//验证字符的y坐标，因为并排所以值一样
        //width-4除去左右多余的位置，使验证码更加集中显示，减的越多越集中
        //codeCount+1//等比分配显示的宽度，包括左右两边的空格
        codeX = (width - 4) / (codeCount + 1);//第一个字母的起始位置
        fontHeight = height - 10;//height-10高度中间区域显示验证码
        codeY = height - 7;
        //创建字体，字体的大小应该根据图片的高度来定
        Font font = new Font("Fixedsys", Font.PLAIN, fontHeight);
        graphics2D.setFont(font);
        //随机产生codeCount数字的验证码
        for (int i = 0; i < codeCount; i++) {
            //每次随机拿一个字母，赋予随机的颜色
            String strRand = String.valueOf(codeSequence[random.nextInt(charNum)]);
            int red = random.nextInt(255);
            int blue = random.nextInt(255);
            int green = random.nextInt(255);
            graphics2D.setColor(new Color(red, green, blue));
            //把字放到图片上
            graphics2D.drawString(strRand, (i + 1) * codeX, codeY);
        }
        ImageIO.write(bufferedImage, "jpg", new File(filePath));

    }
}
