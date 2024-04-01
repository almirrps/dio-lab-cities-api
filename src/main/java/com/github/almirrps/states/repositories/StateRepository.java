package com.github.almirrps.states.repositories;

import com.github.almirrps.states.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
