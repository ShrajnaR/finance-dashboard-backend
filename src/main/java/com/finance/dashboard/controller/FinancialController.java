package com.finance.dashboard.controller;

import com.finance.dashboard.dto.FinancialRecordDTO;
import com.finance.dashboard.entity.FinancialRecord;
import com.finance.dashboard.enums.RecordType;
import com.finance.dashboard.service.FinancialService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/records")
public class FinancialController {

	private final FinancialService service;

	public FinancialController(FinancialService service) {
		this.service = service;
	}

	@PostMapping
	public FinancialRecord create(@Valid @RequestBody FinancialRecordDTO dto) {

		FinancialRecord record = new FinancialRecord();
		record.setAmount(dto.getAmount());
		record.setType(dto.getType());
		record.setCategory(dto.getCategory());
		record.setDate(dto.getDate());
		record.setNotes(dto.getNotes());

		return service.create(record);
	}

	@GetMapping
	public Page<FinancialRecord> getAll(@RequestParam int page, @RequestParam int size) {
		return service.getAll(page, size);
	}

	// ⭐ FILTER API
	@GetMapping("/filter")
	public List<FinancialRecord> filter(@RequestParam(required = false) String category,
			@RequestParam(required = false) RecordType type, @RequestParam(required = false) LocalDate start,
			@RequestParam(required = false) LocalDate end) {

		return service.filter(category, type, start, end);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "Record soft deleted";
	}
}