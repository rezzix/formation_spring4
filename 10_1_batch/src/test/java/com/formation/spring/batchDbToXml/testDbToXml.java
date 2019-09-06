package com.formation.spring.batchDbToXml;

import static org.junit.Assert.*;

import java.util.Date;

import javax.security.auth.login.AppConfigurationEntry;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml")
@ActiveProfiles(profiles = "dev")
public class testDbToXml {
	
	@Autowired 
	DataSource datasource;
	@Autowired
	JobLauncher jobLauncher;
	@Autowired
	Job dbToCsv;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(datasource.toString());
		
        System.out.println("Starting the batch job");
        try {
        	JobParameters jobParameters = new JobParametersBuilder().addDate("launch_time",new Date()).toJobParameters();
            
            JobExecution execution = jobLauncher.run(dbToCsv, jobParameters);
            System.out.println("Job Status : " + execution.getStatus());
            System.out.println("Job completed");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Job failed");
        }
	}

}
