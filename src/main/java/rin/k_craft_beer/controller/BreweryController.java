package rin.k_craft_beer.controller;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import rin.k_craft_beer.domain.Brewery;
import rin.k_craft_beer.service.BreweryService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/brewery")
@CrossOrigin(origins = "*") // React에서 호출할 수 있도록 CORS 허용
public class BreweryController {

  private final BreweryService breweryService;

  public BreweryController(BreweryService breweryService) {
    this.breweryService = breweryService;
  }

  // ResponseEntity는 좀 더 나중에...

  @GetMapping
  public List<Brewery> findAll() {
    return breweryService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Brewery> findById(@PathVariable String id) {
    return breweryService.findById(id);
  }

  // 이름으로 양조장 찾기. 찾는 값 없을 때 null 반환하기에 이를 위해 Optional 사용.
  @GetMapping("/name/{name}")
  public Optional<Brewery> findByName(@PathVariable String name) {
    return breweryService.findByName(name);
  }

  // 양조장 추가하기
  @PostMapping
  public Brewery create(@RequestBody Brewery brewery) {
    return breweryService.create(brewery);
  }

  // 양조장 수정하기
  @PutMapping("/{id}")
  public Brewery update(@PathVariable String id, @RequestBody Brewery brewery) {
    return breweryService.update(id, brewery);
  }

  // 양조장 삭제
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable String id) {
    breweryService.deleteById(id);
  }

  // 지도 마커용 API
  @GetMapping("/api")
  public List<Brewery> findForMap() {
    return findAll();
  }

}
