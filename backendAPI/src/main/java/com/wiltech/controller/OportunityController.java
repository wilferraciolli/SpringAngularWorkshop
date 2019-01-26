package com.wiltech.controller;

import com.wiltech.exceptions.ResourceNotFoundException;
import com.wiltech.model.Oportunity;
import com.wiltech.repository.OportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    /**
     * Create oportunity oportunity.
     *
     * @param payload the payload
     * @return the oportunity
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Oportunity createOportunity(@Valid @RequestBody final Oportunity payload) {

        final Optional<Oportunity> existentOportunity = oportunityRepository.findByDescriptionAndProspectName(payload.getDescription(), payload.getProspectName());

        if (existentOportunity.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Oportunities with this description and prospect name already exists.");
        }

        return oportunityRepository.save(payload);
    }

    /**
     * Find oportunity.
     *
     * @param id the id
     * @return the oportunity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Oportunity> find(@PathVariable("id") final Long id) {

        final Optional<Oportunity> oportunity = oportunityRepository.findById(id);

        if (oportunity.isPresent()) {
            return ResponseEntity.ok(oportunity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Update response entity.
     *
     * @param id      the id
     * @param payload the payload
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Oportunity> update(@PathVariable("id") final Long id, @Valid @RequestBody final Oportunity payload) {

        final Oportunity oportunity = oportunityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Oportunity.class.getName(), "id", id));

        oportunity.update(payload);

        return ResponseEntity.ok(oportunityRepository.save(oportunity));
    }

    /**
     * Delete response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") final Long id) {

        final Oportunity oportunity = oportunityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Oportunity.class.getName(), "id", id));
        oportunityRepository.delete(oportunity);

        return ResponseEntity.noContent().build();
    }
}
