package com.finance.dashboard.service;

import com.finance.dashboard.enums.RecordType;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardService {

	private final FinancialService service;

	public DashboardService(FinancialService service) {
		this.service = service;
	}

	public Map<String, Object> getSummary() {
		double income = service.totalByType(RecordType.INCOME);
		double expense = service.totalByType(RecordType.EXPENSE);

		Map<String, Object> map = new HashMap<>();
		map.put("totalIncome", income);
		map.put("totalExpense", expense);
		map.put("netBalance", income - expense);

		return map;
	}
}