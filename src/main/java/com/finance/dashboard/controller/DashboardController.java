package com.finance.dashboard.controller;

import com.finance.dashboard.service.DashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	private final DashboardService service;

	public DashboardController(DashboardService service) {
		this.service = service;
	}

	@GetMapping
	public Map<String, Object> getSummary() {
		return service.getSummary();
	}
}