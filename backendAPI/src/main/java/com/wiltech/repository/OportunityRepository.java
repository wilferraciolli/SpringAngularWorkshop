package com.wiltech.repository;

import com.wiltech.model.Oportunity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Oportunity repository.
 */
public interface OportunityRepository extends JpaRepository<Oportunity, Long> {
}
