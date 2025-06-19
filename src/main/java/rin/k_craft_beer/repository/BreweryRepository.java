package rin.k_craft_beer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rin.k_craft_beer.domain.Brewery;

import java.util.List;
import java.util.Optional;

public interface BreweryRepository extends MongoRepository<Brewery, String> {
    // 이름으로 양조장 찾기
    Optional<Brewery> findByName(String name);

    // 특정 키워드가 포함된 양조장 목록 조회
    List<Brewery> findByNameContaining(String keyword);
}
