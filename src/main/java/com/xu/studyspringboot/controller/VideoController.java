package com.xu.studyspringboot.controller;

import com.xu.studyspringboot.pojo.Video;
import com.xu.studyspringboot.service.VideoService;
import com.xu.studyspringboot.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("list")
    public JsonData list() {
        List<Video> list = videoService.listVideo();
        return JsonData.buildSuccess(list, "success");
    }

//    {
//        "id": 1,
//            "title": "23333",
//            "chapterList": [
//        {
//            "title": "11111111"
//        },
//        {
//            "title": "11111111"
//        },
//        {
//            "title": "11111111"
//        },
//        {
//            "title": "11111111"
//        }
//    ]
//    }

    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video) {

        System.out.println("video ==> " + video.toString());

        return JsonData.buildSuccess(video, "success");
    }

}
