package ru.javarush.uzikiparts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.javarush.uzikiparts.model.Part;
import ru.javarush.uzikiparts.repository.PartsRepository;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {
    @Autowired
    private PartsRepository repository;


    @Override
    public Part getPartById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public void savePart(Part part) {
        repository.save(part);
    }

    @Override
    public void updatePart(Integer id, String name, Integer amount, boolean isNecessary) {
        Part updatedPart = repository.getOne(id);
        updatedPart.setName(name);
        updatedPart.setAmount(amount);
        updatedPart.setNecessary(isNecessary);
        repository.save(updatedPart);
    }

    @Override
    public void deletePart(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Part> findAllByOrderByName(Pageable pageable) {
        return repository.findAllByOrderByName(pageable);
    }

    @Override
    public Page<Part> findAllByNecessaryIsFalse(Pageable pageable) {
        return repository.findAllByNecessaryIsFalseOrderByName(pageable);
    }

    @Override
    public Page<Part> findAllByNecessaryIsTrue(Pageable pageable) {
        return repository.findAllByNecessaryIsTrueOrderByName(pageable);
    }

    @Override
    public Page<Part> findPartByName(Pageable pageable, String name) {
        return repository.findPartsByNameContains(pageable, name);
    }

    @Override
    public List<Part> findAllByNecessaryIsTrueOrderByAmount() {
        return repository.findAllByNecessaryIsTrueOrderByAmount();
    }
}
