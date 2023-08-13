package ar.com.zsoft.pokemon.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DummyPokemon {
    private Integer id;
    private String name;
}
