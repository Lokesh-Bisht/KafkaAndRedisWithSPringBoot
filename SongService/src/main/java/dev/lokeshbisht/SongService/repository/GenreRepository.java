package dev.lokeshbisht.SongService.repository;

import dev.lokeshbisht.SongService.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
