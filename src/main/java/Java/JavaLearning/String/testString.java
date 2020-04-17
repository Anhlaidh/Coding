package Java.JavaLearning.String;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2020/3/13 0013 11:16
 */
public class testString {
    public static void main(String[] args) {
        String a = "123;456;789;123 ";
        System.out.println(a.charAt(0));//返回第0个元素
        System.out.println(a.indexOf(";"));//返回第一个；的位置
        System.out.println(a.concat(";000"));//连接一个新字符串并返回，a不变
        System.out.println(a.contains("000"));//判断a是否包含000
        System.out.println(a.endsWith("000"));//判断a结尾是否000
        System.out.println(a.equals("000"));//判断是否等于000
        System.out.println(a.equalsIgnoreCase("000"));//判断忽略大小写的情况下是否等于000
        System.out.println(a.length());//a的长度
        System.out.println(a.trim());//返回a去除前后空格后的字符串，a不变
        String[] b = a.split(";");//将a按照；分割成数组
        for (int i=0;i<b.length;i++) System.out.println(b[i]);
        System.out.println("==============");
        System.out.println(a.substring(2,5));//截取a的第二个到第五个字符，a不变
        System.out.println(a.replace("1","a"));//把1替换成a
        System.out.println(a.replaceAll("1","a"));//把1替换成a，正则表达式
    }
}
