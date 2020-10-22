package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestItem {
    Item item;

    @BeforeEach
    public void setUp() {
        item = new Item();
    }

    @Test
    public void testDefaultItem() {
        assertEquals("None", item.getItemName());
    }

    @Test
    public void testSetItem() {
        item.setItemName("Pen");
        assertEquals("Pen", item.getItemName());
    }
}
