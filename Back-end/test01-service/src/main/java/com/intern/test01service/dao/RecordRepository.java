package com.intern.test01service.dao;

import com.intern.test01service.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Bugott
 */
@Transactional
public interface RecordRepository extends JpaRepository<Record, Integer> {
    @Modifying
    @Query(value = "update record set message = :message where id = :id", nativeQuery = true)
    void updateMessageById(@Param("id") Integer id, @Param("message") String message);
}
