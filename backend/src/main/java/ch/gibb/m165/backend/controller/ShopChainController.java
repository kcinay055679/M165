package ch.gibb.m165.backend.controller;

import ch.gibb.m165.backend.dtos.ShopChainDTO;
import ch.gibb.m165.backend.helpers.ControllerHelper;
import ch.gibb.m165.backend.models.Person;
import ch.gibb.m165.backend.models.Shop;
import ch.gibb.m165.backend.models.ShopChain;
import ch.gibb.m165.backend.repositories.PersonRepository;
import ch.gibb.m165.backend.repositories.ShopChainRepository;
import ch.gibb.m165.backend.repositories.ShopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/chains")
public class ShopChainController {
    private final ShopChainRepository shopChainRepository;
    private final PersonRepository personRepository;
    private final ShopRepository shopRepository;

    public ShopChainController(ShopChainRepository shopChainRepository,
                               PersonRepository personRepository,
                               ShopRepository shopRepository) {
        this.shopChainRepository = shopChainRepository;
        this.personRepository = personRepository;
        this.shopRepository = shopRepository;
    }

    @GetMapping()
    List<ShopChain> list() {
        return shopChainRepository.findAll();
    }

    @GetMapping("/{id}")
    ShopChain get(@PathVariable String id) {
        return shopChainRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    ShopChain newItem(@RequestBody ShopChainDTO shopChainDTO) {
        Person owner = personRepository.findById(shopChainDTO.owner()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Shop> shops = ControllerHelper.getItemsFromIds(shopRepository, shopChainDTO.shops());
        ShopChain shopChain = new ShopChain(UUID.randomUUID().toString(), shopChainDTO.name(), shops, owner);
        return shopChainRepository.save(shopChain);
    }

    @PutMapping("/{id}")
    ShopChain updateItem(@PathVariable String id, @RequestBody ShopChainDTO shopChainDTO) {
        ShopChain shopChain = shopChainRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Person owner = personRepository.findById(shopChainDTO.owner()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<Shop> shops = ControllerHelper.getItemsFromIds(shopRepository, shopChainDTO.shops());
        shopChain.setName(shopChainDTO.name());
        shopChain.setShops(shops);
        shopChain.setOwner(owner);
        return shopChainRepository.save(shopChain);
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable String id) {
        ShopChain shopChain = shopChainRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        shopChainRepository.delete(shopChain);
    }
}