package com.dexlace.pattern;

import com.dexlace.pattern.util.Topic;
import com.dexlace.pattern.util.TopicRandomUtil;
import com.dexlace.scene.AnswerQuestion;
import com.dexlace.scene.ChoiceQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 * 原型模式一定要实现cloneable接口
 */
public class QuestionBank implements Cloneable {

    private String candidate; // 考生
    private String number;    // 考号

    private ArrayList<ChoiceQuestion> choiceQuestionList = new ArrayList<>();
    private ArrayList<AnswerQuestion> answerQuestionList = new ArrayList<>();

    /**
     * 这两种添加操作是创建者模式
     * @param choiceQuestion 添加选择题
     * @return 结果
     */
    public QuestionBank append(ChoiceQuestion choiceQuestion) {
        choiceQuestionList.add(choiceQuestion);
        return this;
    }

    /**
     * 这两种添加操作是创建者模式
     * @param answerQuestion 添加问答题
     * @return 结果
     */
    public QuestionBank append(AnswerQuestion answerQuestion) {
        answerQuestionList.add(answerQuestion);
        return this;
    }

    /**
     * 这里的核心操作就是对对象的复制，这里的复制不只是包括了本身，同时对两个集合也做了复制。
     * 只有这样的拷贝才能确保在操作克隆对象的时候不影响原对象。
     * @return object
     * @throws CloneNotSupportedException 不支持
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        // 1. 克隆一个乱序的习题集
        QuestionBank questionBank = (QuestionBank) super.clone();
        questionBank.choiceQuestionList = (ArrayList<ChoiceQuestion>) choiceQuestionList.clone();
        questionBank.answerQuestionList = (ArrayList<AnswerQuestion>) answerQuestionList.clone();

        // 2.1 对习题集的选择题进行乱序
        Collections.shuffle(questionBank.choiceQuestionList);
        // 2.2 对习题集的简答题进行乱序
        Collections.shuffle(questionBank.answerQuestionList);
        // 得到乱序后的选择题
        ArrayList<ChoiceQuestion> choiceQuestionList = questionBank.choiceQuestionList;
        // 3.1 对选择题的答案进行打乱并重新生成选择题
        for (ChoiceQuestion question : choiceQuestionList) {
            Topic random = TopicRandomUtil.random(question.getOption(), question.getKey());
            question.setOption(random.getOption());
            question.setKey(random.getKey());
        }
        return questionBank;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {

        StringBuilder detail = new StringBuilder("考生：" + candidate + "\r\n" +
                "考号：" + number + "\r\n" +
                "--------------------------------------------\r\n" +
                "一、选择题" + "\r\n\n");

        for (int idx = 0; idx < choiceQuestionList.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(choiceQuestionList.get(idx).getName()).append("\r\n");
            Map<String, String> option = choiceQuestionList.get(idx).getOption();
            for (String key : option.keySet()) {
                detail.append(key).append("：").append(option.get(key)).append("\r\n");;
            }
            detail.append("答案：").append(choiceQuestionList.get(idx).getKey()).append("\r\n\n");
        }

        detail.append("二、问答题" + "\r\n\n");

        for (int idx = 0; idx < answerQuestionList.size(); idx++) {
            detail.append("第").append(idx + 1).append("题：").append(answerQuestionList.get(idx).getName()).append("\r\n");
            detail.append("答案：").append(answerQuestionList.get(idx).getKey()).append("\r\n\n");
        }

        return detail.toString();
    }

}
