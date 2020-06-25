package com.lchtest.pattern.singleton.lazy;

/**
 * 单例模式最基本条件
 * 1.构造方法私有化
 * 2.提供全局访问点
 */
public class LazySimpleSingleton {

    public static LazySimpleSingleton lazy;

    private LazySimpleSingleton() {
    }

    public static LazySimpleSingleton getInstance() {
        if (null == lazy) {  //在这里加断点调试
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }

}
