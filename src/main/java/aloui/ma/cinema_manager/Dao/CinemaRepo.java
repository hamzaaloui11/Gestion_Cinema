package aloui.ma.cinema_manager.Dao;

import aloui.ma.cinema_manager.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CinemaRepo extends JpaRepository<Cinema,Long> {
}
