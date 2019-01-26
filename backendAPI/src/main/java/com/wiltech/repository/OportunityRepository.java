package com.wiltech.repository;

import com.wiltech.model.Oportunity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Oportunity repository.
 */
public interface OportunityRepository extends JpaRepository<Oportunity, Long> {

    /**
     * Find by description and prospect name optional.
     * Spring will understand that the query is to find by Description and ProspectName as theses are the actual bean name.
     * Therefore no query is needed to be created.
     *
     * @param description  the description
     * @param prospectName the prospect name
     * @return the optional
     */
    Optional<Oportunity> findByDescriptionAndProspectName(String description, String prospectName);
}
