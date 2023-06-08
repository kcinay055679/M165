package ch.gibb.m165.backend.controller;

import ch.gibb.m165.backend.models.GroceryItem;
import ch.gibb.m165.backend.repositories.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class ItemCroceryController {
    private final ItemRepository itemRepository;
    private final Random random = new Random();

    public ItemCroceryController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    @GetMapping("/items")
    List<GroceryItem> all() {
        return itemRepository.findAll();
    }
    @GetMapping("/items/{name}")
    GroceryItem newItem(@PathVariable String name) {
        GroceryItem test = new GroceryItem(random.nextInt(0,999999999), name, 1, "test");
        GroceryItem save = itemRepository.save(test);
        return save;
    }
}
