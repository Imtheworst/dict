package com.xujiang.xujiang.listen;


import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent extends ApplicationEvent {
    @Getter
    private String message;

    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

}