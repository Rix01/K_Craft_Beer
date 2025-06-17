package rin.k_craft_beer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rin.k_craft_beer.domain.Brewery;
import rin.k_craft_beer.service.BreweryService;

import java.util.List;

@RestController
@RequestMapping("/brewery")
@CrossOrigin(origins = "*") // React에서 호출할 수 있도록 CORS 허용
public class BreweryController {
    private final BreweryService breweryService;

    public BreweryController(BreweryService breweryService) {
        this.breweryService = breweryService;
    }

    @GetMapping
    public List<Brewery> findAll(){
        return breweryService.findAll();
    }

    // 지도 마커용 API
    @GetMapping("/api")
    public List<Brewery> findForMap(){
        return findAll();
    }

}
