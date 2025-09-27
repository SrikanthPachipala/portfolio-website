package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Skill;
import com.example.repository.SkillRepository;

@Service
public class SkillServiceImpl implements  SkillService{
	@Autowired
	private final SkillRepository skillRepo;

    public SkillServiceImpl(SkillRepository skillRepo) {
        this.skillRepo = skillRepo;
    }

    @Override
    public List<Skill> getAllSkills() {
        return skillRepo.findAll();
    }

    @Override
    public Skill saveSkill(Skill skill) {
        return skillRepo.save(skill);
    }
}
