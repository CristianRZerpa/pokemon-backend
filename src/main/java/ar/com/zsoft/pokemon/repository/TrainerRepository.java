package ar.com.zsoft.pokemon.repository;

import ar.com.zsoft.pokemon.entity.Trainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long> {
}
