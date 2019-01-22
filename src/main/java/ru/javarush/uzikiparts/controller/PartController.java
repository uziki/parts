package ru.javarush.uzikiparts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javarush.uzikiparts.model.Part;
import ru.javarush.uzikiparts.service.PartService;

import java.util.List;

@Controller
public class PartController {
    private PartService service;

    private int sort = 0;
    private boolean switcher = false;
    private String findString = "";


    @Autowired
    public void setPartService(PartService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String list(Model model, @PageableDefault(size = 10) Pageable pageable) {
        int PCamount = getPCAmount();
        Page<Part> pages = setPagesUp(pageable);

        model.addAttribute("sort", sort);
        model.addAttribute("PCamount", PCamount);
        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("parts", pages.getContent());

        return "index";
    }

    @PostMapping("/add")
    public String addPart(@RequestParam String name,
                          @RequestParam Integer amount,
                          @RequestParam(value = "necessary", required = false) boolean isNecessary) {
        Part part = new Part(name, isNecessary, amount);
        service.savePart(part);

        return "redirect:/";
    }

    @GetMapping("/sort")
    public String sortChoose() {
        switcher = true;
        return "redirect:/";
    }

    @GetMapping("/new")
    public String addPart() {
        return "operations/new";
    }


    @PostMapping("/find")
    public String findName(
            @RequestParam String name
    ) {
        sort = 3;
        findString = name;
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deletePart(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable Integer id,
            Model model
    ) {
        Part part = service.getPartById(id);
        model.addAttribute("part", part);
        return "operations/edit";
    }

    @PostMapping("/update")
    public String savePart(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam Integer amount,
            @RequestParam(value = "necessary", required = false) boolean isNecessary
    ) {
        service.updatePart(id, name, amount, isNecessary);
        return "redirect:/";
    }


    @GetMapping("/reload")
    public String reset() {
        sort = 0;
        switcher = false;
        return "redirect:/";
    }

    @GetMapping("/list")
    public String userList(Model model, Pageable pageable) {
        Page<Part> pages = service.findAllByOrderByName(pageable);
        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("size", pages.getSize());
        model.addAttribute("parts", pages.getContent());
        return "/user/list";
    }

    private int getPCAmount() {
        List<Part> parts = service.findAllByNecessaryIsTrueOrderByAmount();
        return parts.size() == 0 ? 0 : parts.get(0).getAmount();
    }

    private Page<Part> setPagesUp(Pageable pageable) {
        Page<Part> pages = null;

        if (switcher) {
            sort = sort < 2 ? ++sort : 0;
            switcher = false;
        }

        switch (sort) {
            case 0:
                pages = service.findAllByOrderByName(pageable);
                break;
            case 1:
                pages = service.findAllByNecessaryIsTrue(pageable);
                break;
            case 2:
                pages = service.findAllByNecessaryIsFalse(pageable);
                break;
            case 3:
                pages = service.findPartByName(pageable, findString);
                break;
        }
        return pages;
    }


}
