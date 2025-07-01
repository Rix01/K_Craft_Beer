package rin.k_craft_beer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rin.k_craft_beer.domain.Brewery;

import java.util.List;

public interface BreweryRepository extends MongoRepository<Brewery, String> {
    Brewery findByName(String name);
    // 특정 키워드가 포함된 브루어리 목록 조회
    List<Brewery> findByNameContaining(String keyword);
}
