package question009.starDynamic;

import java.lang.reflect.Proxy;

public class JdkProxyHandler {

    private Object realStar; // 真实的对象

    public JdkProxyHandler(IStar star) {
        super();
        this.realStar = star;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(realStar.getClass().getClassLoader(),
                realStar.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("before sing");
                    Object object = method.invoke(realStar, args);
                    System.out.println("after sing");
                    return object;
                });
    }
}
