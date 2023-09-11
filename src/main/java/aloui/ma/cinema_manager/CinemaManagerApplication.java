package aloui.ma.cinema_manager;

import aloui.ma.cinema_manager.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaManagerApplication implements CommandLineRunner {
    @Autowired
    private ICinemaService iCinemaService;

    public static void main(String[] args) {
        SpringApplication.run(CinemaManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        iCinemaService.UnitVilles();
        iCinemaService.UnitCinemas();
        iCinemaService.UnitSalles();
        iCinemaService.UnitPlaces();
        iCinemaService.UnitSeance();
        iCinemaService.UnitCategorie();
        iCinemaService.UnitFilm();
        iCinemaService.UnitFilmProjection();
        iCinemaService.UnitTicket();
    }
}
