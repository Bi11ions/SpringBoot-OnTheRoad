package com.atguigu.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author wangsen@qgutech.com
 * @since 2018/12/18 16:28
 */
public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();

        String osName = environment.getProperty("os.name");
        if (osName.contains("linux")) {
            return true;
        }

        return false;
    }
}
