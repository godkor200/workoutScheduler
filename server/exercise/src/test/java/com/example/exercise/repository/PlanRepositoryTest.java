package com.example.exercise.repository;

import com.example.exercise.ExerciseApplicationTests;
import com.example.exercise.model.entity.Plan;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class PlanRepositoryTest extends ExerciseApplicationTests {
    @Autowired
    private PlanRepository planRepository;

    @Test
    public void create(){
        Plan plan = new Plan();
        plan.setPlanName("윗몸이르키기");
        plan.setContent("열심히 하는게 좋다.");
        plan.setCreatedAt(LocalDateTime.now());
        Plan newPlan = planRepository.save(plan);
        System.out.println(newPlan);
    }
    @Test
    public void read(){
        Optional<Plan> plan = planRepository.findById(1L);
        plan.ifPresent(s->{
            System.out.println(s);
        });
    }
}
