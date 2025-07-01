package rin.k_craft_beer.service;


import org.springframework.stereotype.Service;
import rin.k_craft_beer.domain.Brewery;
import rin.k_craft_beer.repository.BreweryRepository;

import java.util.List;

import java.util.Optional;

@Service
public class BreweryService {

  private final BreweryRepository breweryRepository;

  public BreweryService(BreweryRepository breweryRepository) {
    this.breweryRepository = breweryRepository;
  }

  // 모든 양조장 목록 가져오기
  public List<Brewery> findAll() {
    return breweryRepository.findAll();
  }

  // id로 양조장 찾기
  public Optional<Brewery> findById(String id) {
    return breweryRepository.findById(id);
  }

  // 이름으로 양조장 찾기. 찾는 값 없을 때 null 반환하기에 이를 위해 Optional 사용.
  public Optional<Brewery> findByName(String name) {
    return breweryRepository.findByName(name);
  }

  // 양조장 추가하기
  public Brewery create(Brewery brewery) {
    return breweryRepository.save(brewery);
  }

  // 양조장 수정하기
  public Brewery update(String id, Brewery brewery) {
    Brewery existing = findById(id).orElseThrow(
        () -> new IllegalArgumentException("해당 ID의 양조장이 존재하지 않습니다.: " + id));
    existing.setName(brewery.getName());
    existing.setLocation(brewery.getLocation());
    existing.setImage(brewery.getImage());
    existing.setHomepage(brewery.getHomepage());

    return breweryRepository.save(existing);
  }

  // 양조장 id를 통해 삭제
  public void deleteById(String id) {
    // 양조장 있는지 확인 후,
    if (!breweryRepository.existsById(id)) {
      throw new IllegalArgumentException("해당 양조장이 존재하지 않습니다.");
    }
    breweryRepository.deleteById(id);
  }
}
