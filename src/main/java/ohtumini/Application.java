
package ohtumini;

import ohtumini.profiles.DevProfile;
import ohtumini.profiles.ProdProfile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

 
@Configuration
@EnableAutoConfiguration
@ComponentScan
@Import({DevProfile.class, ProdProfile.class})
public class Application {
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
