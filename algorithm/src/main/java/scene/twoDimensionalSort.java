package scene;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:Gpw
 * @Date:2020/3/11
 * @Description:
 *  二维排序，在一定的排序基础上再加一轮排序
 * @Version:1.0
 */
public class twoDimensionalSort {

    public static String sortBySessionOffset(String slots) {

        JSONArray slotArr = JSONArray.parseArray(slots);
        JSONArray sortedSlotArr = new JSONArray();

        List<JSONObject> slotList = new ArrayList<>();
        for (int i = 0;i < slotArr.size();i++) {
            slotList.add(slotArr.getJSONObject(i));
        }

        Collections.sort(slotList, new Comparator<JSONObject>() {

            @Override
            public int compare(JSONObject o1, JSONObject o2) {

                int dif = 0;
                int a = o2.getIntValue("session_offset") - o1.getIntValue("session_offset");
                if (a != 0) {
                    dif = (a > 0) ? -1 : 3;
                } else {
                    a = o2.getIntValue("begin") - o1.getIntValue("begin");
                    if (a != 0) {
                        dif = (a > 0) ? -2 : 2;
                    }
                }
                return dif;
            }
        });

        for (int i = 0;i < slotList.size();i++) {
            sortedSlotArr.add(slotList.get(i));
        }

        return sortedSlotArr.toString();
    }

    public static void main(String[] args) {

        String slots = "[\n" +
                "                        {\n" +
                "                            \"word_type\": \"\",\n" +
                "                            \"confidence\": 100.0,\n" +
                "                            \"length\": 2,\n" +
                "                            \"name\": \"user_action\",\n" +
                "                            \"original_word\": \"打开\",\n" +
                "                            \"sub_slots\": [],\n" +
                "                            \"session_offset\": 4,\n" +
                "                            \"begin\": 5,\n" +
                "                            \"normalized_word\": \"ON\",\n" +
                "                            \"merge_method\": \"updated\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"word_type\": \"\",\n" +
                "                            \"confidence\": 100.0,\n" +
                "                            \"length\": 2,\n" +
                "                            \"name\": \"user_action\",\n" +
                "                            \"original_word\": \"关闭\",\n" +
                "                            \"sub_slots\": [],\n" +
                "                            \"session_offset\": 4,\n" +
                "                            \"begin\": 2,\n" +
                "                            \"normalized_word\": \"OFF\",\n" +
                "                            \"merge_method\": \"updated\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"word_type\": \"\",\n" +
                "                            \"confidence\": 100.0,\n" +
                "                            \"length\": 2,\n" +
                "                            \"name\": \"user_area\",\n" +
                "                            \"original_word\": \"客厅\",\n" +
                "                            \"sub_slots\": [],\n" +
                "                            \"session_offset\": 4,\n" +
                "                            \"begin\": 0,\n" +
                "                            \"normalized_word\": \"LIVING_ROOM\",\n" +
                "                            \"merge_method\": \"updated\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"word_type\": \"\",\n" +
                "                            \"confidence\": 100.0,\n" +
                "                            \"length\": 2,\n" +
                "                            \"name\": \"user_device\",\n" +
                "                            \"original_word\": \"电视\",\n" +
                "                            \"sub_slots\": [],\n" +
                "                            \"session_offset\": 8,\n" +
                "                            \"begin\": 9,\n" +
                "                            \"normalized_word\": \"TV_SET\",\n" +
                "                            \"merge_method\": \"updated\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"word_type\": \"\",\n" +
                "                            \"confidence\": 100.0,\n" +
                "                            \"length\": 1,\n" +
                "                            \"name\": \"user_device\",\n" +
                "                            \"original_word\": \"灯\",\n" +
                "                            \"sub_slots\": [],\n" +
                "                            \"session_offset\": 1,\n" +
                "                            \"begin\": 1,\n" +
                "                            \"normalized_word\": \"LIGHT\",\n" +
                "                            \"merge_method\": \"updated\"\n" +
                "                        }\n" +
                "]";

        String sortStr = sortBySessionOffset(slots);
        System.out.println("排序后：" + sortStr);
    }
}
