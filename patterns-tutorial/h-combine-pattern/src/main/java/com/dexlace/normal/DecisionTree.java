package com.dexlace.normal;


import lombok.extern.slf4j.Slf4j;

/**
 * 以if else的决策树为例
 */
@Slf4j
public class DecisionTree {



    public String process(final String userId, final String userSex, final int userAge) {

        log.info("ifelse实现方式判断用户结果。userId：{} userSex：{} userAge：{}", userId, userSex, userAge);

        if ("man".equals(userSex)) {
            if (userAge < 25) {
                return "果实A";
            }

            if (userAge >= 25) {
                return "果实B";
            }
        }

        if ("woman".equals(userSex)) {
            if (userAge < 25) {
                return "果实C";
            }

            if (userAge >= 25) {
                return "果实D";
            }
        }

        return null;

    }


}
