package com.youquiz.youquiz.Service.IMPL;

import com.youquiz.youquiz.DTO.MediaDTO;
import com.youquiz.youquiz.Entity.Media;
import com.youquiz.youquiz.Repository.MediaRepository;
import com.youquiz.youquiz.Service.IMediaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaService implements IMediaService {
    @Autowired
    private MediaRepository mediaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MediaDTO create(MediaDTO mediaDTO) {
        Media media = modelMapper.map(mediaDTO, Media.class);
        return modelMapper.map(mediaRepository.save(media), MediaDTO.class);
    }
}
