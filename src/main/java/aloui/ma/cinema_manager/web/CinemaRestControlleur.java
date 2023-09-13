package aloui.ma.cinema_manager.web;

import aloui.ma.cinema_manager.Dao.FilmRepo;
import aloui.ma.cinema_manager.Dao.TicketRepo;
import aloui.ma.cinema_manager.entities.Film;
import aloui.ma.cinema_manager.entities.Ticket;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CinemaRestControlleur {
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private TicketRepo ticketRepo;

    @GetMapping(path = "/imageFilms/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte [] images(@PathVariable("id") Long id)throws Exception{
        Film f=filmRepo.findById(id).get();
        String photoName=f.getPhoto();
        File file=new File(System.getProperty("user.home")+"/cinema/image/"+photoName);
        Path path= Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
    @PostMapping("/payerTicket")
    @Transactional
    public List<Ticket> tickets(@RequestBody TicketForm ticketForm){
        System.err.println("id de ticket");
        List<Ticket>ticketPayer=new ArrayList<>();
        ticketForm.getTickets().forEach(id->{
            System.out.println("id de ticket"+ticketRepo.findById(id).get());
            Ticket ticket=ticketRepo.findById(id).get();
            ticket.setNameClient(ticketForm.nomClient);
            ticket.setCodePayement(ticketForm.getCodePayement());
            ticket.setReserver(true);
            ticketRepo.save(ticket);
            ticketPayer.add(ticket);
        });
        return ticketPayer;
    }
    @Data

    public class TicketForm{
        String nomClient;
        private Integer codePayement;
        List<Long> tickets=new ArrayList<>();
    }
}
