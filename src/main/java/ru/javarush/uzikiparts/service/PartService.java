package ru.javarush.uzikiparts.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.javarush.uzikiparts.model.Part;

import java.util.List;

public interface PartService {
    Page<Part> findAllByOrderByName(Pageable pageable);
    Page<Part> findPartByName(Pageable pageable, String name);
    List<Part> findAllByNecessaryIsTrueOrderByAmount();
    Page<Part> findAllByNecessaryIsFalse(Pageable pageable);
    Page<Part> findAllByNecessaryIsTrue(Pageable pageable);
    void updatePart(Integer id, String name, Integer amount, boolean isNecessary);
    void deletePart(Integer id);
    void savePart(Part part);
    Part getPartById(Integer id);
}