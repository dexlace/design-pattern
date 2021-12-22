package com.dexlace.pattern.util;

import java.util.*;

public class TopicRandomUtil {

    /**
     * 乱序Map元素，记录对应答案key
     * 乱序的选项  仍然能对应正确的答案
     * 整个过程十分耗时
     * @param option 题目
     * @param key    答案
     * @return Topic 乱序后 {A=c., B=d., C=a., D=b.}
     */
    static public Topic random(Map<String, String> option, String key) {
        Set<String> keySet = option.keySet();
        ArrayList<String> keyList = new ArrayList<String>(keySet);
        // 将题目打乱 包含了若干选项的题目
        Collections.shuffle(keyList);
        HashMap<String, String> optionNew = new HashMap<String, String>();
        int idx = 0;
        String keyNew = "";
        // 0.按照原来的顺序遍历题目即A,B,C,D
        for (String next : keySet) {
            // 1.按照打乱的顺序取出打乱的题目即非A,B,C,D的其他组合
            String randomKey = keyList.get(idx++);
            // 2.以原来的顺序遍历得到答案，比如A 虽然打乱了顺序 还是要记住正确答案
            if (key.equals(next)) {
                keyNew = randomKey;
            }
            // 3. 生成新的对应关系 即对打乱的key进行赋值
            // 如果获取了正确的key，即答案，那么就让对应的打乱的顺序来对应于正确的答案
            optionNew.put(randomKey, option.get(next));
        }
        return new Topic(optionNew, keyNew);
    }

}
