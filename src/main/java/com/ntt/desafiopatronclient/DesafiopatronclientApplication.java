package com.ntt.desafiopatronclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DesafiopatronclientApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesafiopatronclientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Service service = new Service();

        String open = "open";
        String halfOpen = "half-open";
        String close = "close";

        Coche coche = new Coche(open, "Renault", "Megane");

        for (int i = 0; i < 5; i++) {
            if (coche.getEstado().equals(open)) {
                coche.setEstado(halfOpen);
                service.setToHalfOpen();
                Thread.sleep(5000);

                if (i >= 3) {
                    coche.setEstado(close);
                    service.setToClose();
                    Thread.sleep(5000);
                } else {
                    coche.setEstado(open);
                    service.setToOpen();
                    Thread.sleep(5000);
                }
            }
        }
    }

}
