package sk.fei.stuba.oop.zadanie3.mvcupdate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.fei.stuba.oop.zadanie3.mvcupdate.user.User;

import java.util.HashMap;
import java.util.Map;

@Controller
@SpringBootApplication
public class MvcUpdateApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(MvcUpdateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

}
