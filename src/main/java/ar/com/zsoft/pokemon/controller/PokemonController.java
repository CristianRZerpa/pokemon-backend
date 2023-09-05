package ar.com.zsoft.pokemon.controller;

import ar.com.zsoft.pokemon.entity.Pokemon;
import ar.com.zsoft.pokemon.strategy.StrategyFactory;
import ar.com.zsoft.pokemon.strategy.type.StrategyType;
import ar.com.zsoft.pokemon.usecases.GetStrategyTypeByPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/")
public class PokemonController {

    @Autowired
    private StrategyFactory strategyFactory;

    @Autowired
    private GetStrategyTypeByPokemon getStrategyTypeByPokemon;

    @GetMapping(path = "/pokemon/{id}")
    public ResponseEntity<String> getPokemon(
            @PathVariable("id") Integer id) {
        String uri = "https://pokeapi.co/api/v2/pokemon/" + id;
        RestTemplate restTemplate = new RestTemplate();
        return new ResponseEntity<>(restTemplate.getForObject(uri, String.class), OK);
    }

    @GetMapping(path = "/pokemon/attack/{type}")
    public ResponseEntity<String> listTrainer(
            @PathVariable("type") String type) {
        Pokemon pokemon = Pokemon.builder().type(type).build();
        StrategyType strategyType = getStrategyTypeByPokemon.apply(pokemon);
        strategyFactory.findPokemonActionStrategy(strategyType).attack();
        return new ResponseEntity<>("Attack DONE", OK);
    }


}
