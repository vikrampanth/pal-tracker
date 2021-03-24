package io.pivotal.pal.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {
    public static void main(String[] a){
        SpringApplication.run(PalTrackerApplication.class);
    }
    @Bean
    public TimeEntryRepository timeEntryRepository(){
        return new InMemoryTimeEntryRepository();
    }
}
