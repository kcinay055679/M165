package ch.gibb.m165.backend.dtos;

import java.util.List;

public record ShopDTO(String name, List<String> items, List<String> employees) {
}
