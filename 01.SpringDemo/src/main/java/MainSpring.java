import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.Property;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class MainSpring {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        SignUpService signUpService = context.getBean(SignUpService.class);
        signUpService.singUp("obsharova@gmail.com", "qwerty007");
/*
        Properties properties = new Properties();
        properties.load(new FileReader("src//main//resources//application.properties"));*/


     /*   HikariConfig config = new HikariConfig();
        config.setDriverClassName(properties.getProperty("db.driver"));
        config.setJdbcUrl(properties.getProperty("db.url"));
        config.setUsername(properties.getProperty("db.user"));
        config.setPassword(properties.getProperty("db.password"));

        DataSource dataSource = new HikariDataSource(config);
        PasswordBlackList passwordBlackLis = new PasswordBlackListJDBCImpl(dataSource);*/
    }
}
