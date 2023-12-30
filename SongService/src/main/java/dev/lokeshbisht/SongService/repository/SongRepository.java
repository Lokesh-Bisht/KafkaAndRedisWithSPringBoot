package dev.lokeshbisht.SongService.repository;

import dev.lokeshbisht.SongService.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
