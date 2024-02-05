package com.example.bomo.controller;

import com.example.bomo.service.TerritorialManagerService;
import com.example.bomo.model.TerritorialManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/territorialManagers")
public class TerritorialManagerController {

    private final TerritorialManagerService territorialManagerService;


    public TerritorialManagerController(TerritorialManagerService territorialManagerService) {
        this.territorialManagerService = territorialManagerService;
    }

    @GetMapping("/list")
    public String showTerritorialManagers(Model model) {
        List<TerritorialManager> territorialManagers = territorialManagerService.getAllTerritorialManagers();
        model.addAttribute("territorialManagers", territorialManagers);
        return "territorial_manager/list_manager";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("territorialManager", new TerritorialManager());
        return "territorial_manager/create_manager";
    }

    @PostMapping("/create")
    public String createTerritorialManager(@ModelAttribute TerritorialManager territorialManager) {
        territorialManagerService.saveTerritorialManager(territorialManager);
        return "redirect:/territorialManagers/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<TerritorialManager> territorialManager = territorialManagerService.getTerritorialManagerById(id);
        model.addAttribute("territorialManager", territorialManager.orElse(null));
        return "territorial_manager/edit_manager";
    }

    @PostMapping("/edit/{id}")
    public String editTerritorialManager(@PathVariable Long id, @ModelAttribute TerritorialManager updatedTerritorialManager) {
        territorialManagerService.saveTerritorialManager(updatedTerritorialManager);
        return "redirect:/territorialManagers/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTerritorialManager(@PathVariable Long id) {
        territorialManagerService.deleteTerritorialManagerById(id);
        return "redirect:/territorialManagers/list";
    }
}
