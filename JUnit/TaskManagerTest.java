import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import java.util.concurrent.TimeUnit;

class TaskManagerTest {

    private final TaskManager taskManager = new TaskManager();

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS) // Test fails if it takes more than 2 seconds
    void testLongRunningTask() {
        assertEquals("Task Completed", taskManager.longRunningTask());
    }
}
