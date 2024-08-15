package com.chupintech.youthcon2024.event;

public interface EventListener<E> {
    void onEvent(E event);
}
