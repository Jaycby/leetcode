package com.Jaycby.Bag.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version v1.0
 * @ClassName: ProxyFactory
 * @Description: 获取代理对象的工厂类
 *      代理类也实现了对应的接口
 * @Author: 黑马程序员
 */
public class ProxyFactory {

    //声明目标对象
    private TrainStation station = new TrainStation();

    //获取代理对象的方法
    public SellTickets getProxyObject() {
        //返回代理对象
        /*
            ClassLoader loader : 类加载器，用于加载代理类。可以通过目标对象获取类加载器
            Class<?>[] interfaces ： 代理类实现的接口的字节码对象
            InvocationHandler h ： 代理对象的调用处理程序
         */
        SellTickets proxyObject = (SellTickets)Proxy.newProxyInstance(
                station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                new InvocationHandler() {
                    /*
                        InvocationHandler中invoke方法参数说明：
                            proxy ： 代理对象
                            method ： 对应于在代理对象上调用的接口方法的 Method 实例
                            args ： 代理对象调用接口方法时传递的实际参数
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("代理点收取一些服务费用(JDK动态代理方式)");
                        //执行真实对象
                        Object result = method.invoke(station, args);
                        return result;
                    }
                });
        return proxyObject;
    }
}
