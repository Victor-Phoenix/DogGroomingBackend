package com.victor.project.models;

import java.time.DayOfWeek;
import java.time.LocalTime;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class DailyShiftLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private DayOfWeek dayOfWeek;

	@NotNull
	private LocalTime actualStartTime;
	
	@NotNull
	private LocalTime actualLunchStart;
	
	@NotNull
	private LocalTime actualLunchEnd;
	
	@NotNull
	private LocalTime actualEndTime;
}
