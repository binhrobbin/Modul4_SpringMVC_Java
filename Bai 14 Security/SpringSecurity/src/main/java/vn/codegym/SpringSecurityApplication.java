package vn.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        bc.encode("123");
        System.out.println(bc.encode("123"));
    }

}
