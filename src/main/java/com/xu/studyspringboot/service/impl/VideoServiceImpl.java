package com.xu.studyspringboot.service.impl;

import com.xu.studyspringboot.mapper.VideoMapper;
import com.xu.studyspringboot.pojo.Video;
import com.xu.studyspringboot.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> listVideo() {
        List<Video> videos = videoMapper.listVideo();
        return videos;
    }

}
