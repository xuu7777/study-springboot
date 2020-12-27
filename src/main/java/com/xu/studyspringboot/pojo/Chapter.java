package com.xu.studyspringboot.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Chapter implements Serializable {

    private Integer id;

    private Integer videoId;

    private String title;

}
