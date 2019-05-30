package com.xujiang.xujiang.event;

import org.springframework.context.ApplicationEvent;

public class DictEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DictEvent(Object source) {
        super(source);
    }
}
