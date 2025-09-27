package com.example.service;

import java.util.List;

import com.example.model.Skill;

public interface SkillService {
	List<Skill> getAllSkills();
    Skill saveSkill(Skill skill);
}
