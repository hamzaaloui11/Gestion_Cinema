package aloui.ma.cinema_manager.service;

import aloui.ma.cinema_manager.Dao.*;
import aloui.ma.cinema_manager.entities.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class CinemaServiceImpl implements ICinemaService{
    @Autowired
    private VilleRepo villeRepo;
    @Autowired
    private CinemaRepo cinemaRepo;
    @Autowired
    private SalleRepo salleRepo;
    @Autowired
    private PlaceRepo placeRepo;
    @Autowired
    private SeanceRepo seanceRepo;
    @Autowired
    private CategorieRepo categorieRepo;
    @Autowired
    private FilmRepo filmRepo;
    @Autowired
    private FilmProjectionRepo filmProjectionRepo;
    @Autowired
    private TicketRepo ticketRepo;
    @Override
    public void UnitVilles() {
        Stream.of("casablanca","Beni Mellal","Azilal","Marrakech").forEach(v->{
            Ville ville = new Ville();
            ville.setName(v);
            villeRepo.save(ville);
        });
    }

    @Override
    public void UnitCinemas() {
        villeRepo.findAll().forEach(v->{
            Stream.of("Miga Rama","Founoun","Chahrazad","Imax").forEach(c->{
                Cinema cinema=new Cinema();
                cinema.setName(c);
                cinema.setVille(v);
                cinema.setNbrSalle((int) (3+ Math.random()*7));
                cinemaRepo.save(cinema);
            });
        });
    }

    @Override
    public void UnitSalles() {
        cinemaRepo.findAll().forEach(c->{
            for(int i=0;i<c.getNbrSalle();i++){
                Salle salle =new Salle();
                salle.setName("salle"+(i+1));
                salle.setCinema(c);
                salle.setNbrPlace((int) (20+Math.random()*10));
                salleRepo.save(salle);
            }
        });

    }

    @Override
    public void UnitPlaces() {
        salleRepo.findAll().forEach(p->{
            for (int i=0;i<p.getNbrPlace();i++){
                Place place=new Place();
                place.setNumPlace(i+1);
                place.setSalle(p);
                placeRepo.save(place);
            }
        });

    }

    @Override
    public void UnitSeance() {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");
        Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s->{
            Seance seance=new Seance();
            try {
                seance.setHeureDebut(dateFormat.parse(s));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            seanceRepo.save(seance);
        });
    }

    @Override
    public void UnitCategorie() {
        Stream.of("Action","Fection","Drama","Historique").forEach(c->{
            Categorie categorie=new Categorie();
            categorie.setName(c);
            categorieRepo.save(categorie);
        });
    }

    @Override
    public void UnitFilm() {
        double [] duree=new double[]{1.5,2,2.5,3};
        List<Categorie>categorieList=categorieRepo.findAll();
            Stream.of("Game of throns","spider man","hary puter","batman" ).forEach(f->{
                Film film=new Film();
                film.setTitre(f);
                film.setDuree(duree[new Random().nextInt(duree.length)]);
                film.setPhoto(f.replace(" ","")+".jpg");
                film.setCategorie(categorieList.get(new Random().nextInt(categorieList.size())));
                filmRepo.save(film);
        });
    }

    @Override
    public void UnitFilmProjection() {
        double [] prices=new double[] {30,50,60,70,90, 100};
        villeRepo.findAll().forEach(ville -> {
            ville.getCinemas().forEach(cinema -> {
                cinema.getSalles().forEach(salle -> {
                    filmRepo.findAll().forEach(film -> {
                        seanceRepo.findAll().forEach(seance -> {
                            FilmProjection filmProjection=new FilmProjection();
                            filmProjection.setDateProjection(new Date());
                            filmProjection.setFilm(film);
                            filmProjection.setPrix (prices [new Random() .nextInt (prices.length)]);
                            filmProjection.setSalle(salle);
                            filmProjection.setSeance(seance);
                            filmProjectionRepo.save(filmProjection);
                        });
                    });
                });
            });
        });
    }

    @Override
    public void UnitTicket() {
        filmProjectionRepo.findAll().forEach(p->{
            p.getSalle().getPlaces().forEach(place -> {
                Ticket ticket=new Ticket();
                ticket.setProjection(p);
                ticket.setPlace(place);
                ticket.setPrix(p.getPrix());
                ticket.setReserver(false);
                ticketRepo.save(ticket);
            });
        });
    }
}
