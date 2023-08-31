package ar.com.zsoft.pokemon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table
@Data
@Builder
public class Pokemon {
    @Id
    @Column
    private Integer id;
    @Column
    private String number;
    @Column
    private String name;
    @Column
    private Integer hp_max;
    @Column
    private Integer hp;
    @ManyToOne
    @JoinColumn(name = "id_trainer", nullable = false, updatable = false)
    private Trainer trainer;

    public Pokemon() {
    }

    public Pokemon(Integer id, String number, String name, Integer hp_max, Integer hp, Trainer trainer) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.hp_max = hp_max;
        this.hp = hp;
        this.trainer = trainer;
    }
}
