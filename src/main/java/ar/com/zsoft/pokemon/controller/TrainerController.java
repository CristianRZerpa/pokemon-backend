package ar.com.zsoft.pokemon.controller;

import ar.com.zsoft.pokemon.entity.Trainer;
import ar.com.zsoft.pokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/")
public class TrainerController {

    @Autowired
    private TrainerRepository repository;

    @GetMapping(path = "/trainer")
    public ResponseEntity<Iterable<Trainer>> listTrainer() {
        return new ResponseEntity<>(repository.findAll(), OK);
    }


}
