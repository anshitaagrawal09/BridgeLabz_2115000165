import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Step 1: Define @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

// Step 2: Create a Cache Manager
class CacheManager {
    private static final Map<String, Object> cache = new HashMap<>();

    public static Object invokeWithCache(Object obj, String methodName, Object... args) {
        try {
            Method method = obj.getClass().getMethod(methodName, getParameterTypes(args));
            if (method.isAnnotationPresent(CacheResult.class)) {
                String key = generateCacheKey(methodName, args);
                if (cache.containsKey(key)) {
                    System.out.println("Returning cached result for: " + key);
                    return cache.get(key);
                }

                Object result = method.invoke(obj, args);
                cache.put(key, result);
                return result;
            }
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new RuntimeException("Error invoking method", e);
        }
    }

    private static String generateCacheKey(String methodName, Object[] args) {
        StringBuilder key = new StringBuilder(methodName);
        for (Object arg : args) {
            key.append("_").append(arg.toString());
        }
        return key.toString();
    }

    private static Class<?>[] getParameterTypes(Object[] args) {
        Class<?>[] types = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            types[i] = args[i].getClass();
        }
        return types;
    }
}

// Step 3: Create a Computationally Expensive Service
class ExpensiveService {
    @CacheResult
    public int computeFactorial(int n) {
        System.out.println("Computing factorial of " + n + "...");
        return (n <= 1) ? 1 : n * computeFactorial(n - 1);
    }
}

// Step 4: Test the Caching System
public class CacheTest {
    public static void main(String[] args) {
        ExpensiveService service = new ExpensiveService();

        // First call: Computes and stores in cache
        System.out.println("Result: " + CacheManager.invokeWithCache(service, "computeFactorial", 5));

        // Second call with same input: Returns cached result
        System.out.println("Result: " + CacheManager.invokeWithCache(service, "computeFactorial", 5));

        // Call with a different input: Computes again
        System.out.println("Result: " + CacheManager.invokeWithCache(service, "computeFactorial", 6));
    }
}
