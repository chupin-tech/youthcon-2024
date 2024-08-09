package com.chupintech.youthcon2024.configuration;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class AsyncConfiguration {

	@Bean
	public Executor defaultExecutor() {
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(5);
		executor.setQueueCapacity(10);
		executor.setThreadGroupName("YouthGroup");
		executor.setThreadNamePrefix("Youth-");
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.initialize();

		return executor;
	}
}
