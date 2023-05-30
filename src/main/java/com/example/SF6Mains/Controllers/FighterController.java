package com.example.SF6Mains.Controllers;

import com.example.SF6Mains.Models.Fighter;
import com.example.SF6Mains.Repositories.FighterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/fighters")
public class FighterController {

    @Autowired
    private final FighterRepository fighterRepository;
    FighterController(final FighterRepository fighterRepo){
        this.fighterRepository = fighterRepo;
    }

    @GetMapping()
    public Iterable<Fighter> allFighters(){return this.fighterRepository.findAll();}

    @GetMapping("/{id}")
    public Fighter specificFighter(@PathVariable Long id){
        Optional<Fighter> optionalFighter = this.fighterRepository.findById(id);

        if(optionalFighter.isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Fighter fighter = optionalFighter.get();

        return fighter;
    }

    @PostMapping()
    public Fighter addNewFighter(@RequestBody Fighter fighter){
        this.fighterRepository.save(fighter);

        Fighter utilFighter = fighter;

        utilFighter.fighterFillForm(fighter);

        return fighter;
    }

    @PutMapping("/{id}")
    public Fighter editFighterInfo(@PathVariable Long id, @RequestBody Fighter fighter){
        Optional<Fighter> optionalFighter = this.fighterRepository.findById(id);

        if(optionalFighter.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        Fighter adjFighter = optionalFighter.get();

        //todo create a form to edit property info on a fighter
        adjFighter.fighterAdjustmentForm(fighter);

        return fighter;
    }

    @DeleteMapping("/{id}")
    public Fighter removeFighter(@PathVariable Long id){
        Optional<Fighter> optionalFighter = this.fighterRepository.findById(id);

        if(optionalFighter.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This fighter does not exist.");
        }

        Fighter fighter = optionalFighter.get();

        this.fighterRepository.delete(fighter);

        return fighter;
    }


}
