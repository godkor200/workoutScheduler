package com.example.exercise.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Exercise {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String exerciseName;

	private int exerciseSet;

	private int exerciseWeight;

	private LocalDateTime exerciseTime;

	private String exerciseCategory;

	private String exerciseDesc;

	private LocalDateTime createdAt;

	private LocalDateTime updateAt;

	@OneToMany(mappedBy = "exercise")
	private List<RoutineExercise> routineExerciseList;
}
