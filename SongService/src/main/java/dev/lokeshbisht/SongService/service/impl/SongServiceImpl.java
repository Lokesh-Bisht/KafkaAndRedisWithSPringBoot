package dev.lokeshbisht.SongService.service.impl;

import dev.lokeshbisht.SongService.dto.song.request.SongRequestDto;
import dev.lokeshbisht.SongService.dto.song.response.SongDto;
import dev.lokeshbisht.SongService.entity.Song;
import dev.lokeshbisht.SongService.mapper.SongMapper;
import dev.lokeshbisht.SongService.repository.SongRepository;
import dev.lokeshbisht.SongService.service.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Autowired
    private SongMapper songMapper;

    private final static Logger logger = LoggerFactory.getLogger(SongServiceImpl.class);

    @Override
    public SongDto addSong(SongRequestDto songRequestDto, Long genreId) {
        logger.info("Add a new song: {} in {} genre", songRequestDto, genreId);
        Song song = songMapper.toSong(songRequestDto);
        song.setGenreId(genreId);
        song.setCreatedAt(new Date());
        return songMapper.toSongDto(songRepository.save(song));
    }
}
