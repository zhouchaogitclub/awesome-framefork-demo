package com.zc;

import java.lang.reflect.Proxy;

/**
 * @author 周超
 * @since 2022/3/17 21:38
 */
public class APhone implements Phone {
    @Override
    public void call() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        APhone aPhone = new APhone();
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Phone phone = (Phone) Proxy.newProxyInstance(aPhone.getClass().getClassLoader(),
                aPhone.getClass().getInterfaces(), (proxy, method, args1) -> {
                    if (method.getName().contains("call")) {
                        System.out.println("proxy");
                    }
                    return method.invoke(aPhone, args1);
                });
        phone.call();
        System.out.println(phone.hashCode());
    }
}
