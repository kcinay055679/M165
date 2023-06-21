package ch.gibb.m165.backend.repositories;

import ch.gibb.m165.backend.models.ShopChain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShopChainRepository extends MongoRepository<ShopChain, String> {
}
