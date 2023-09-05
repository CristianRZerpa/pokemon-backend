package ar.com.zsoft.pokemon.usecases.impl;

import ar.com.zsoft.pokemon.entity.Pokemon;
import ar.com.zsoft.pokemon.strategy.type.StrategyType;
import ar.com.zsoft.pokemon.usecases.GetStrategyTypeByPokemon;
import org.springframework.stereotype.Component;

@Component
public class DefaultGetStrategyTypeByPokemon implements GetStrategyTypeByPokemon {

    @Override
    public StrategyType apply(Pokemon pokemon) {
        if ("fire".equalsIgnoreCase(pokemon.getType())) {
            return StrategyType.FIRE;
        } else if ("water".equalsIgnoreCase(pokemon.getType())) {
            return StrategyType.WATER;
        } else if ("grass".equalsIgnoreCase(pokemon.getType())) {
            return StrategyType.GRASS;
        }
        return StrategyType.NORMAL;
    }
}
