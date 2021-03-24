package io.pivotal.pal.tracker;

import com.mysql.cj.jdbc.MysqlDataSource;
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
        MysqlDataSource mysqlDataSource =new MysqlDataSource();
        mysqlDataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
        return new JdbcTimeEntryRepository(mysqlDataSource);
    }
}
