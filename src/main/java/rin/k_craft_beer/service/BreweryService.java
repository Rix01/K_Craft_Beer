package rin.k_craft_beer.service;

import org.springframework.stereotype.Service;
import rin.k_craft_beer.domain.Brewery;
import rin.k_craft_beer.repository.BreweryRepository;

import java.util.List;

@Service
public class BreweryService {
    private final BreweryRepository breweryRepository;

    public BreweryService(BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    public List<Brewery> findAll() {
        return breweryRepository.findAll();
    }

}
