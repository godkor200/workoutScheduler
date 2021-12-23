package com.example.exercise.repository;

import com.example.exercise.ExerciseApplicationTests;
import com.example.exercise.model.entity.PlanDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PlanDetailRepositoryTest extends ExerciseApplicationTests {
    @Autowired
    private PlanDetailRepository planDetailRepository;

    @Test
    public void create(){
        PlanDetail planDetail = new PlanDetail();
        planDetail.setPlanningAt(LocalDateTime.now());
        planDetail.setPlanId(1L);
        planDetail.setUserId(1L);

        PlanDetail newPlanDetail = planDetailRepository.save(planDetail);
        System.out.println(newPlanDetail);
    }
}
