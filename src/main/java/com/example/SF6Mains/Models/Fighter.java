package com.example.SF6Mains.Models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Fighter {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String type;

    private String effectiveRange;

    private String easeOfUse;

    private Integer height;

    private Integer weight;



    public void fighterFillForm(Fighter fighter){
        if(ObjectUtils.isEmpty(fighter.name)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name not filled out");
            }

        if(ObjectUtils.isEmpty(fighter.type)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type not filled out");
            }

        if(ObjectUtils.isEmpty(fighter.effectiveRange)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Effective Range not filled out");
            }

        if(ObjectUtils.isEmpty(fighter.easeOfUse)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ease Of Use not filled out");
            }

        if(ObjectUtils.isEmpty(fighter.height)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Height not filled out");
            }

        if(ObjectUtils.isEmpty(fighter.weight)){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Weight not filled out");
            }
    }

    public void fighterAdjustmentForm(Fighter fighter){
        if(!ObjectUtils.isEmpty(fighter.name)){
            fighter.setName(fighter.getName());
        }

        if(!ObjectUtils.isEmpty(fighter.type)){
            fighter.setType(fighter.getType());
        }

        if(!ObjectUtils.isEmpty(fighter.effectiveRange)){
            fighter.setEffectiveRange(fighter.getEffectiveRange());
        }

        if(!ObjectUtils.isEmpty(fighter.easeOfUse)){
            fighter.setEaseOfUse(fighter.getEaseOfUse());
        }

        if(!ObjectUtils.isEmpty(fighter.height)){
            fighter.setHeight(fighter.getHeight());
        }

        if(!ObjectUtils.isEmpty(fighter.weight)){
            fighter.setWeight(fighter.getWeight());
        }
    }
}
