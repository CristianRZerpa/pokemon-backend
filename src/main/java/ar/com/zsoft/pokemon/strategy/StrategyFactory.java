package ar.com.zsoft.pokemon.strategy;

import ar.com.zsoft.pokemon.strategy.type.StrategyType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class StrategyFactory {
    private Map<StrategyType, PokemonActionStrategy> strategies = new HashMap();

    public StrategyFactory(Set<PokemonActionStrategy> pokemonStrategy) {
        System.out.println("StrategyFactory - Constructor: " + pokemonStrategy.size());
        createStrategy(pokemonStrategy);
    }

    public PokemonActionStrategy findPokemonActionStrategy(StrategyType strategyType) {
        return strategies.get(strategyType);
    }
    private void createStrategy(Set<PokemonActionStrategy> animalStrategy) {
        animalStrategy.forEach(
                strategy ->strategies.put(strategy.getStrategyType(), strategy));
    }
}

