package com.fatshaw.dddtemplate.infrastructure

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan
@EnableJpaRepositories
@EnableJpaAuditing
class InfrastructureConfig
