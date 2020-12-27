package com.xu.studyspringboot.controller;

import com.xu.studyspringboot.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试过滤器
 */
@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {

    @RequestMapping("save")
    public JsonData saveOrder() {
        return JsonData.buildSuccess("", "success");
    }

}
