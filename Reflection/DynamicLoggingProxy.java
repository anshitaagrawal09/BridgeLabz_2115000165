import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define an interface
interface Greeting {
    void sayHello(String name);
}

// Step 2: Create a real implementation of Greeting
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Step 3: Create a Logging Proxy using Reflection
class LoggingProxy implements InvocationHandler {
    private final Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Executing method: " + method.getName());
        return method.invoke(target, args); // Call the original method
    }

    // Utility method to create a proxy instance
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[]{interfaceType},
            new LoggingProxy(target)
        );
    }
}

// Step 4: Test the proxy in main()
public class DynamicLoggingProxy {
    public static void main(String[] args) {
        // Create the original object
        Greeting greeting = new GreetingImpl();

        // Create a proxy for the Greeting interface
        Greeting proxyInstance = LoggingProxy.createProxy(greeting, Greeting.class);

        // Call method on the proxy, which logs the method call
        proxyInstance.sayHello("Alice");
    }
}
