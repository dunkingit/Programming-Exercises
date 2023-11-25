package com.techelevator.items.filereader;

import com.techelevator.items.Item;


import java.util.HashMap;
import java.util.Map;


public class InventoryBuilder {

    private final String filePath;

    public InventoryBuilder(String inventoryFilePath){
        this.filePath = inventoryFilePath;
    }

    public Map<String, Item> getInventory(){
        Map<String, Item> items = new HashMap<>();
        items.put("test", new Item("test"));
        items.put("test1", new Item("test1"));
        return items;
    }
}
