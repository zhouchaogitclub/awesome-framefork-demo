package com.zc;

/**
 * @author yeyu
 * @since 2022/7/13 14:01
 */
public interface Lock {
    void lock();

    void unlock();

    default boolean tryLock() {
        throw new UnsupportedOperationException();
    }
}
