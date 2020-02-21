package com.qskx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: CarClient
 * @Author: cg
 * @CreateDate: 2020-01-18 14:50
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
@FeignClient("car")
@RequestMapping("/car")
public interface CarClient {
    @GetMapping("/getCarNo")
    String getCarNo();


    @GetMapping("/getCarNoQuery")
    String getCarNoQuery(@RequestParam("carNo") String carNo);
}
