package ch.gibb.m165.backend.dtos;

import java.util.List;

public record ShopChainDTO(String name, List<String> shops, String owner) {
}
