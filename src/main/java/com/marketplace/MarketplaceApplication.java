package com.marketplace;

//import com.marketplace.Util.JjwtRuntimeHints;
import com.marketplace.Config.AwtHints;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportRuntimeHints;
import org.springframework.context.annotation.ReflectiveScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ImportRuntimeHints(AwtHints.class)
@ReflectiveScan
public class MarketplaceApplication {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(MarketplaceApplication.class, args);
    }

}
