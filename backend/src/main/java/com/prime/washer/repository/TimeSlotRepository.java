package com.prime.washer.repository;

import com.prime.washer.model.TimeSlots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlots, Long> {
}
