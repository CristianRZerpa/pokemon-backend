package ar.com.zsoft.pokemon.controller;

import ar.com.zsoft.pokemon.strategy.StrategyFactory;
import ar.com.zsoft.pokemon.strategy.type.StrategyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/")
public class PokemonController {

    @Autowired
    private StrategyFactory strategyFactory;

    @GetMapping(path = "/pokemon/attack/{type}")
    public ResponseEntity<String> listTrainer(
            @PathVariable("type") String type) {

        //TODO: added real pokemon type
        // and call like: StrategyType.findPokemonActionStrategy(pokemon.getType).attack()
        // instead of pokemon.getType you cloud be use a US like GetStrategyTypeByPokemon
        if (type.equalsIgnoreCase("fire")) {
            strategyFactory.findPokemonActionStrategy(StrategyType.FIRE).attack();
        } else if (type.equalsIgnoreCase("water")) {
            strategyFactory.findPokemonActionStrategy(StrategyType.WATER).attack();
        } else if (type.equalsIgnoreCase("grass")) {
            strategyFactory.findPokemonActionStrategy(StrategyType.GRASS).attack();
        } else {
            strategyFactory.findPokemonActionStrategy(StrategyType.NORMAL).attack();
        }
        return new ResponseEntity<>("Attack DONE", OK);
    }


}
