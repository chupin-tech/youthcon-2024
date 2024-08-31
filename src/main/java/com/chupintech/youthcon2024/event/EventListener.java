package com.chupintech.youthcon2024.event;

public interface EventListener<T> {
    void onEvent(T event);

    boolean canListen(Class<?> clazz);
}
