package ar.com.zsoft.pokemon.strategy;

import ar.com.zsoft.pokemon.strategy.type.StrategyType;

public interface PokemonActionStrategy {
    void attack();
    StrategyType getStrategyType();
}
