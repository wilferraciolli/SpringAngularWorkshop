package com.wiltech.controller;

import com.wiltech.model.Oportunity;
import com.wiltech.repository.OportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Oportunity controller.
 */
@RestController
@RequestMapping("/oportunities")
public class OportunityController {

    @Autowired
    private OportunityRepository oportunityRepository;

    /**
     * Get all oportunities list.
     *
     * @return the list
     */
    @GetMapping
    public List<Oportunity> getAll() {

        return oportunityRepository.findAll();
    }
}
