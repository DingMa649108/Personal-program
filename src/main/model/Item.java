package model;

import org.json.JSONObject;
import persistence.Writable;

public class Item implements Writable {
    protected String itemName;

    public Item() {
        itemName = "None";
    }

    public Item(String item) {
        itemName = item;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Item name", itemName);
        return json;
    }
}
