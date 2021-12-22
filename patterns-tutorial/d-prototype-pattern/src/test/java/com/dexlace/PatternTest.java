package com.dexlace;

import com.dexlace.pattern.QuestionBankService;
import org.junit.Test;

public class PatternTest {
    @Test
    public void testQuestionBank() throws CloneNotSupportedException {
        QuestionBankService questionBankController = new QuestionBankService();
        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper("豆豆", "1000001921051"));
        System.out.println(questionBankController.createPaper("大宝", "1000001921987"));
    }


}
