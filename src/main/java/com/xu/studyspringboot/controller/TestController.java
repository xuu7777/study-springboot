package com.xu.studyspringboot.controller;

import com.xu.studyspringboot.utils.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    /**
     * 测试异常
     *
     * @return
     */
    @GetMapping("list")
    public JsonData testExe() {
        int i = 1 / 0;
        return JsonData.buildSuccess("", "success");
    }

}
