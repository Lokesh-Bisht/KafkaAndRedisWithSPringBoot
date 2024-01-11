package dev.lokeshbisht.SongService.repository;

import dev.lokeshbisht.SongService.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

    List<Album> findByIdIn(List<Long> albumIdList);
}
