package main;

import main.data.Region;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author rabbit
 * @create 2021-08-05 19:52
 */
@SpringBootApplication
@EnableCaching
@MapperScan("main.mapper")
@MappedTypes(Region.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
