package ch.gibb.m165.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document
public class Shop {
    @Id
    @MongoId
    private String id;
    private String name;
    private List<GroceryItem> groceryItems = new ArrayList<>();
    private List<Person> employees = new ArrayList<>();

    public Shop(String id, String name, List<GroceryItem> groceryItems, List<Person> employees) {
        this.id = id;
        this.name = name;
        this.groceryItems = groceryItems;
        this.employees = employees;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GroceryItem> getGroceryItems() {
        return groceryItems;
    }

    public void setGroceryItems(List<GroceryItem> groceryItems) {
        this.groceryItems = groceryItems;
    }
}
