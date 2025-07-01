package rin.k_craft_beer.controller;

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

  @GetMapping
  public List<Brewery> findAll() {
    return breweryService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Brewery> findById(@PathVariable String id) {
    return breweryService.findById(id);
  }

  @GetMapping("/name/{name}")
  public Optional<Brewery> findByName(@PathVariable String name) {
    return breweryService.findByName(name);
  }

  @PostMapping
  public Brewery create(@RequestBody Brewery brewery) {
    return breweryService.create(brewery);
  }

  @PutMapping("/{id}")
  public Brewery update(@PathVariable String id, @RequestBody Brewery brewery) {
    return breweryService.update(id, brewery);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable String id) {
    breweryService.deleteById(id);
  }

  @GetMapping("/api")
  public List<Brewery> findForMap() {
    return findAll();
  }
}