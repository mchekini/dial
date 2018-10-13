package com.workshop.back.persistence;

import com.workshop.back.persistence.entity.Member;
import com.workshop.back.persistence.repository.MemberRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackageClasses = Member.class)
@EnableJpaRepositories(basePackageClasses = MemberRepository.class)
public class DatabaseConfig {
}

