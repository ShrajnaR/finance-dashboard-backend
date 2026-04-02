package com.finance.dashboard.service;

import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.enums.RecordType;
import com.finance.dashboard.repository.FinancialRecordRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FinancialService {

    private final FinancialRecordRepository repo;

    public FinancialService(FinancialRecordRepository repo) {
        this.repo = repo;
    }

    public FinancialRecord create(FinancialRecord record) {
        return repo.save(record);
    }

    public Page<FinancialRecord> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return repo.findAll(pageable);
    }

    public void delete(Long id) {
        FinancialRecord record = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
        record.setDeleted(true);
        repo.save(record);
    }

    public List<FinancialRecord> filter(String category, RecordType type,
                                        LocalDate start, LocalDate end) {

        if (category != null)
            return repo.findByCategoryAndDeletedFalse(category);

        if (type != null)
            return repo.findByTypeAndDeletedFalse(type);

        if (start != null && end != null)
            return repo.findByDateBetweenAndDeletedFalse(start, end);

        return repo.findByDeletedFalse();
    }

    public double totalByType(RecordType type) {
        return repo.findByTypeAndDeletedFalse(type)
                .stream()
                .mapToDouble(FinancialRecord::getAmount)
                .sum();
    }
}