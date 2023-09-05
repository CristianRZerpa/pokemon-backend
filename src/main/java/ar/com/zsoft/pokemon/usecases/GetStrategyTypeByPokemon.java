package ar.com.zsoft.pokemon.usecases;


import ar.com.zsoft.pokemon.entity.Pokemon;
import ar.com.zsoft.pokemon.strategy.type.StrategyType;

import java.util.function.Function;

public interface GetStrategyTypeByPokemon extends Function<Pokemon, StrategyType> {
}
