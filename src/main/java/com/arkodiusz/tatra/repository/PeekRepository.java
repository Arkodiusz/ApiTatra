package com.arkodiusz.tatra.repository;

import com.arkodiusz.tatra.domain.Peek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface PeekRepository extends JpaRepository<Peek, Long> {
}
