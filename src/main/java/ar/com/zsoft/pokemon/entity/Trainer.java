package ar.com.zsoft.pokemon.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
@Builder
public class Trainer {
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer exp;
    @Column
    private Integer money;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="id_trainer")
    private List<Pokemon> pokemonList;

    public Trainer() {
    }

    public Trainer(Integer id, String name, Integer exp, Integer money, List<Pokemon> pokemonList) {
        this.id = id;
        this.name = name;
        this.exp = exp;
        this.money = money;
        this.pokemonList = pokemonList;
    }
}
