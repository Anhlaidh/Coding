package test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description:
 * @author: Anhlaidh
 * @date: 2021-03-30 18:44
 */

public class testFastJson {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("aaa", 1);
        map.put("bbb", 2);
        map.put("ccc", 3);
        List<entry> list = new ArrayList<>();
        list.add(new entry("aaa", 1));
        list.add(new entry("bbb", 2));
        list.add(new entry("ccc", 3));
        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(map));
    }

    static class entry {
        @JSONField(name = "name")
        String name;
        @JSONField(name = "value")
        int value;

        public entry(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
}
