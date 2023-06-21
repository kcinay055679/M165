package ch.gibb.m165.backend.controller;

import ch.gibb.m165.backend.dtos.ShopDTO;
import ch.gibb.m165.backend.models.GroceryItem;
import ch.gibb.m165.backend.models.Person;
import ch.gibb.m165.backend.models.Shop;
import ch.gibb.m165.backend.repositories.ItemRepository;
import ch.gibb.m165.backend.repositories.PersonRepository;
import ch.gibb.m165.backend.repositories.ShopRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController()
@RequestMapping("/shops")
public class ShopController {
    private final ShopRepository shopRepository;
    private final ItemRepository itemRepository;
    private final PersonRepository personRepository;

    public ShopController(ShopRepository shopRepository, ItemRepository itemRepository,
                          PersonRepository personRepository) {
        this.shopRepository = shopRepository;
        this.itemRepository = itemRepository;
        this.personRepository = personRepository;
    }

    @GetMapping()
    List<Shop> list() {
        return shopRepository.findAll();
    }

    @GetMapping("/{id}")
    Shop get(@PathVariable String id) {
        return shopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    Shop newItem(@RequestBody ShopDTO shopDTO) {
        List<GroceryItem> items = getItemsFromIds(itemRepository, shopDTO.items());
        List<Person> employees = getItemsFromIds(personRepository, shopDTO.items());
        return shopRepository.save(new Shop(UUID.randomUUID().toString(), shopDTO.name(), items, employees));
    }

    @PutMapping("/{id}")
    Shop updateItem(@PathVariable String id, @RequestBody ShopDTO shopDTO) {
        Shop shop = shopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        shop.setName(shopDTO.name());
        shop.setGroceryItems(getItemsFromIds(itemRepository,shopDTO.items()));
        shop.setEmployees(getItemsFromIds(personRepository,shopDTO.employees()));
        return shopRepository.save(shop);
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable String id) {
        Shop groceryItem = shopRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        shopRepository.delete(groceryItem);
    }

    <T> List<T> getItemsFromIds(MongoRepository<T, String> repo, List<String> ids) {
        return ids.stream()
                .map(itemID -> repo.findById(itemID).orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }
}
