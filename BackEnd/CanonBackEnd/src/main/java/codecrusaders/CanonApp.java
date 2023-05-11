package codecrusaders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "codecrusaders")
public class CanonApp {
    public static void main(String[] args)
    {
        SpringApplication.run(CanonApp.class, args);
    }
}