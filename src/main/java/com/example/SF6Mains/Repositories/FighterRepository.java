package com.example.SF6Mains.Repositories;

import com.example.SF6Mains.Models.Fighter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FighterRepository extends CrudRepository <Fighter, Long> {
    List<Fighter> findByName(String name);
    List<Fighter> findByTypeOrderByNameDesc(String type);
    List<Fighter> findByEffectiveRangeOrderByNameDesc(String range);
    List<Fighter> findByEaseOfUseOrderByNameDesc(String ease);
}
