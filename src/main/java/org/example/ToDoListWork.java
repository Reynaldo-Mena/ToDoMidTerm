package org.example;

import java.util.ArrayList;
import java.util.List;

public class ToDoListWork {
    private List<Items> items;

    public ToDoListWork() {
        items = new ArrayList<>();
    }

    public void addItem(String description) {
        items.add(new Items(description));
    }

    public void deleteItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    public List<Items> getItems() {
        return items;
    }
}
