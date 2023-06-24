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
@CrossOrigin
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
    ShopChain newItem(@RequestBody ShopChain shopChain) {
        return shopChainRepository.save(shopChain);
    }

    @PutMapping("/{id}")
    ShopChain updateItem(@PathVariable String id, @RequestBody ShopChain shopChain) {
        ShopChain dbShopChain = shopChainRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        dbShopChain.setShops(shopChain.getShops());
        dbShopChain.setOwner(shopChain.getOwner());
        dbShopChain.setName(shopChain.getName());
        return shopChainRepository.save(shopChain);
    }

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable String id) {
        ShopChain shopChain = shopChainRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        shopChainRepository.delete(shopChain);
    }
}
