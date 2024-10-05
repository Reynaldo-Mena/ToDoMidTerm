import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ToDoListWorkTest {
    private ToDoListWork todoList;

    @BeforeEach
    public void setUp() {
        todoList = new ToDoListWork();
    }

    @Test
    public void testAddItem() {
        todoList.addItem("wash car");
        assertEquals(1, todoList.getItems().size());
        assertEquals("wash car", todoList.getItems().get(0).getDescription());
    }

    @Test
    public void testDeleteItem() {
        todoList.addItem("wash car");
        todoList.deleteItem(0);
        assertEquals(0, todoList.getItems().size());
    }



}