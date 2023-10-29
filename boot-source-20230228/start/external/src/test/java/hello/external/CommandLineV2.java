package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

@Slf4j
public class CommandLineV2 {
    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg {}", arg);
        }


        ApplicationArguments appArguments = new DefaultApplicationArguments(args);

        log.info("SourceArgs={}", List.of(appArguments.getSourceArgs()));
        log.info("NonOptionArgs = {}", appArguments.getNonOptionArgs());
        log.info("OptionsNames = {}", appArguments.getOptionNames());

        Set<String> optionNames = appArguments.getOptionNames();

        for (String optionName : optionNames) {
            log.info("option arg {}={}", optionName, appArguments.getOptionValues(optionName));

        }

        // 옵션인수는 하나의 키에 여러 값을 포함 할 수 있음 command-line-option-info
        List<String> url = appArguments.getOptionValues("url");
        List<String> username = appArguments.getOptionValues( "username");
        List<String> password = appArguments.getOptionValues("password");

        List<String> mode = appArguments.getOptionValues("mode");

        log.info("url {}",url);
        log.info("username {}",username);
        log.info("password {}",password);
        log.info("mode {}",mode);


    }
}
