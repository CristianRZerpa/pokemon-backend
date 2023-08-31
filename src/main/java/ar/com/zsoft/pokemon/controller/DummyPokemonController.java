package ar.com.zsoft.pokemon.controller;

import ar.com.zsoft.pokemon.entity.DummyPokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("dummy")
public class DummyPokemonController {

    private static final List<DummyPokemon> pokemonList =
            Arrays.asList(
                    DummyPokemon.builder().id(1).name("Bulbasaur").build(),
                    DummyPokemon.builder().id(2).name("Ivysaur").build(),
                    DummyPokemon.builder().id(3).name("Venusaur").build(),
                    DummyPokemon.builder().id(4).name("Charmander").build(),
                    DummyPokemon.builder().id(5).name("Charmeleon").build(),
                    DummyPokemon.builder().id(6).name("Charizard").build(),
                    DummyPokemon.builder().id(7).name("Squirtle").build(),
                    DummyPokemon.builder().id(8).name("Wartortle").build(),
                    DummyPokemon.builder().id(9).name("Blastoise").build()
            );

    @GetMapping(path = "/pokemon/{id}")
    public ResponseEntity<DummyPokemon> getPokemon(
            @PathVariable("id") Integer id) {
        return new ResponseEntity<>(pokemonList.get(id - 1), OK);
    }

    @GetMapping(path = "/pokemon")
    public ResponseEntity<List<DummyPokemon>> listPokemon() {
        return new ResponseEntity<>(pokemonList, OK);
    }

    @PostMapping(path = "/pokemon")
    public ResponseEntity<DummyPokemon> savePokemon(
            @RequestBody DummyPokemon pokemon) {
        pokemon.setId(10);
        return new ResponseEntity<>(pokemon, OK);
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<Void> updatePokemon(
            @PathVariable("id") String id,
            @RequestBody DummyPokemon pokemon) {
        return new ResponseEntity<>(OK);
    }

    @DeleteMapping(path = "/pokemon/{id}")
    public ResponseEntity<Void> deletePokemon(
            @PathVariable("id") String id) {
        return new ResponseEntity<>(OK);
    }

}
