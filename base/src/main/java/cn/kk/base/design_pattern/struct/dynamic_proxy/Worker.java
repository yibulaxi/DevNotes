package cn.kk.base.design_pattern.struct.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Worker {

    /**
     * 动态代理
     * @param project
     * @param <T>
     * @return
     */
    public <T> T create(final Class<T> project){

       return  (T) Proxy.newProxyInstance(project.getClassLoader(), new Class[]{project}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                   return method.invoke(this, args);
                }
                return null;
            }
        });
    }
}
