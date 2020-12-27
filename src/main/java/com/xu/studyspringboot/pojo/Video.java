package com.xu.studyspringboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Video implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String summary;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("cover_img")
    private String coverImg;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("create_time")
    private Date createTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("chapter_list")
    private List<Chapter> chapterList;

    public Video() {

    }

    public Video(Integer id, String title) {
        this.id = id;
        this.title = title;
        this.createTime = new Date();
    }

}
