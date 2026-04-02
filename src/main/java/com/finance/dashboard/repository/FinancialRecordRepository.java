package com.finance.dashboard.repository;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.enums.RecordType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FinancialRecordRepository extends JpaRepository<FinancialRecord, Long> {

	List<FinancialRecord> findByDeletedFalse();

	List<FinancialRecord> findByCategoryAndDeletedFalse(String category);

	List<FinancialRecord> findByTypeAndDeletedFalse(RecordType type);

	List<FinancialRecord> findByDateBetweenAndDeletedFalse(LocalDate start, LocalDate end);
}