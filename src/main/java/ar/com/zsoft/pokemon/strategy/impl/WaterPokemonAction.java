package ar.com.zsoft.pokemon.strategy.impl;

import ar.com.zsoft.pokemon.strategy.PokemonActionStrategy;
import ar.com.zsoft.pokemon.strategy.type.StrategyType;
import org.springframework.stereotype.Component;

@Component
public class WaterPokemonAction implements PokemonActionStrategy {
    @Override
    public void attack() {
        System.out.println("Attack WATER");
    }
    @Override
    public StrategyType getStrategyType() {
        return StrategyType.WATER;
    }
}
