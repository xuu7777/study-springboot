package com.xu.studyspringboot.mapper;

import com.xu.studyspringboot.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VideoMapper {

    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1, new Video(1, "数学"));
        videoMap.put(2, new Video(2, "语文"));
        videoMap.put(3, new Video(3, "英语"));
        videoMap.put(4, new Video(4, "政治"));
        videoMap.put(5, new Video(5, "历史"));
    }

    public List<Video> listVideo() {
        List<Video> list = new ArrayList<>();
        list.addAll(videoMap.values());
        return list;
    }

}
