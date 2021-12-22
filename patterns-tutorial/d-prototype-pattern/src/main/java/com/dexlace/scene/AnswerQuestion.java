package com.dexlace.scene;

import lombok.Data;

/**
 * 解答题 创建的重复对象
 */
@Data
public class AnswerQuestion {

    private String name;  // 问题
    private String key;   // 答案

    public AnswerQuestion() {
    }

    public AnswerQuestion(String name, String key) {
        this.name = name;
        this.key = key;
    }

}
