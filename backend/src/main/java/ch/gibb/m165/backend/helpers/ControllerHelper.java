package ch.gibb.m165.backend.helpers;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Objects;

public class ControllerHelper {
    private  ControllerHelper(){
    }
    public static <T> List<T> getItemsFromIds(MongoRepository<T, String> repo, List<String> ids) {
        return ids.stream()
                .map(itemID -> repo.findById(itemID).orElse(null))
                .filter(Objects::nonNull)
                .toList();
    }
}
