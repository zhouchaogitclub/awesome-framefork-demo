package com.zc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author yeyu
 * @since 2021/7/13 5:36 下午
 */
public final class WebClientUtils {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(A.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> {
            if (method.getName().contains("hello")) {
                System.out.println("toString");
            }
            return proxy.invokeSuper(obj, args1);
        });
        A x = ((A) enhancer.create());
        x.hello();
        System.out.println(x);
    }

    public static class A {
        public void hello() {
            System.out.println("hello A");
        }
    }

}
