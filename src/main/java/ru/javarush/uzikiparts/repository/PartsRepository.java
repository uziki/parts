package ru.javarush.uzikiparts.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.javarush.uzikiparts.model.Part;

import java.util.List;

@Repository
public interface PartsRepository extends JpaRepository<Part, Integer> {
    List<Part> findAllByNecessaryIsTrueOrderByAmount();
    Page<Part> findAllByOrderByName(Pageable pageable);
    Page<Part> findAllByNecessaryIsFalseOrderByName(Pageable pageable);
    Page<Part> findAllByNecessaryIsTrueOrderByName(Pageable pageable);
    Page<Part> findPartsByNameContains(Pageable pageable, String name);

}
