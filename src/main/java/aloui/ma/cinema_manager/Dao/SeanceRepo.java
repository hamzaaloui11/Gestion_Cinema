package aloui.ma.cinema_manager.Dao;

import aloui.ma.cinema_manager.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SeanceRepo extends JpaRepository<Seance,Long> {
}
