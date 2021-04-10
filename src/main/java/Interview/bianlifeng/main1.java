package Interview.bianlifeng;

import java.util.Scanner;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2021-04-09 17:13
 */
public class main1 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String s = reader.nextLine();
        System.out.println(process(s));;

    }

    private static String process(String s) {
        StringBuilder sb = new StringBuilder();
        String next = "";
        String cur_pre = "";
        String cur_after = "";
        String process = "";
        if (s.indexOf('{') != -1) {
            next = s.substring(s.indexOf('{') + 1, s.lastIndexOf('}'));
            cur_pre = s.substring(0, s.indexOf('{'));
            cur_after = s.substring(s.lastIndexOf('}') + 1, s.length());
            process = process(next);
        } else {
            cur_pre = s;
        }


        String[] pre = cur_pre.split("[0-9]");
        String[] after = cur_after.split("[0-9]");
        String[] pre_number = cur_pre.split("[A-Z]");
        String[] after_number = cur_after.split("[A-Z]");

        //pre
        for (int i = 0; i < pre.length; i++) {
            if (pre_number.length==1) {
                for (int j = 0; j < Integer.parseInt(pre_number[0]); j++) {
                    sb.append(pre[0]);
                }
                break;
            }
            if (pre_number.length == 0) {
                sb.append(pre[i]);
                break;
            }
            if ("".equals(pre_number[i])) {
                sb.append(pre[i]);
            } else {
                for (int j = 0; j < Integer.parseInt(pre_number[i]); j++) {
                    sb.append(pre[i]);
                }
            }
        }
        //mid
        if (pre_number.length == pre.length + 1) {
            for (int i = 0; i < Integer.parseInt(pre_number[pre_number.length - 1]); i++) {
                sb.append(process);
            }
        } else {
            sb.append(process);
        }
        //after
        for (int i = 0; i < after.length; i++) {
            if (after_number.length==1) {
                for (int j = 0; j < Integer.parseInt(after_number[0]); j++) {
                    sb.append(after[0]);
                }
                break;
            }
            if (after_number.length == 0) {
                sb.append(after[i]);
                break;
            }
            if ("".equals(after_number[i])) {
                sb.append(after[i]);
            } else {
                for (int j = 0; j < Integer.parseInt(after_number[i]); j++) {
                    sb.append(after[i]);
                }
            }
        }


        return sb.toString();

    }


}
