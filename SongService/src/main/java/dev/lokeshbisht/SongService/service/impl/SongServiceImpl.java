package dev.lokeshbisht.service.impl;

import dev.lokeshbisht.dto.song.response.SongDto;
import dev.lokeshbisht.dto.song.request.SongRequestDto;
import dev.lokeshbisht.entity.Song;
import dev.lokeshbisht.mapper.SongMapper;
import dev.lokeshbisht.repository.SongRepository;
import dev.lokeshbisht.service.SongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        song.setCreatedAt(System.currentTimeMillis());
        return songMapper.toSongDto(songRepository.save(song));
    }
}
