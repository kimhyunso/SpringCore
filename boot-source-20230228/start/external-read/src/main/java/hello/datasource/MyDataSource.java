package hello.datasource;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;

@Slf4j
public class MyDataSource {

    private String url;
    private String username;
    private String password;
    private int maxConnection;
    private Duration timeout;

    private List<String> options;

    public MyDataSource(String url, String username, String password, int maxConnection, Duration timeout, List<String> options) {
        this.url = url;
        this.username = username;
        this.timeout = timeout;
        this.maxConnection = maxConnection;
        this.password = password;
        this.options = options;
    }

    @PostConstruct
    public void init(){
        log.info("url={}", url);
        log.info("username={}", username);
        log.info("timeout={}", timeout);
        log.info("maxConnection={}", maxConnection);
        log.info("password={}", password);
        log.info("options={}", options);
    }





}
