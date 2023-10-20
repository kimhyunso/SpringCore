package hello.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;




// 스프링에서 자동으로 빈을 등록해줌

//@Configuration
@Slf4j
public class DbConfig {


    @Bean
    public DataSource dataSource(){
        log.info("dataSource 빈 등록");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setJdbcUrl("jdbc:h2:mem:test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
    // DataSourceTransactionManager 와 같음
    @Bean
    public TransactionManager transactionManager(){
        log.info("transactionManager 빈 등록");
        return new JdbcTransactionManager(dataSource());
    }

    // 회원 데이터를 DB에 보관하고 관리하는 기능
    @Bean
    public JdbcTemplate jdbcTemplate(){
        log.info("jdbcTemplate 빈 등록");
        return new JdbcTemplate(dataSource());
    }
}
