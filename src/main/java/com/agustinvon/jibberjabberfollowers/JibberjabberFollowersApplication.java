package com.agustinvon.jibberjabberfollowers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.metrics.export.datadog.EnableDatadogMetrics;

@SpringBootApplication
@EnableDatadogMetrics
public class JibberjabberFollowersApplication {

	public static void main(String[] args) {
		SpringApplication.run(JibberjabberFollowersApplication.class, args);
	}

}
