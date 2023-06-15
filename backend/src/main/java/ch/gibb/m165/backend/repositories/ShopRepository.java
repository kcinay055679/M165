package ch.gibb.m165.backend.repositories;

import ch.gibb.m165.backend.models.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopRepository extends MongoRepository<Shop, String> {
}
