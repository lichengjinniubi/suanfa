package com.example.demo.contribute;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnClassNameConditional implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String className = (String) metadata.getAnnotationAttributes(ConditionalOnClassName.class.getName()).get("value");
        System.out.println(className);
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return false;
        }
    }
}
