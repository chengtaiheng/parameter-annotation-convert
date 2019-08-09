package com.chth.parameter.annotation.convert.controller;

import com.chth.parameter.annotation.convert.annotation.MagicStringConvertToEnumSet;
import com.chth.parameter.annotation.convert.enumdomain.PayOffType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author: 程泰恒
 * @date: 2019/8/9 16:50
 */

@Slf4j
@RestController
@RequestMapping("/parameter-convert")
public class TestController {

    @PostMapping("/test")
    public Map<String, Object> parameterConvert(@RequestParam(value = "payOffType", required = false, defaultValue = "全部")
                                                @MagicStringConvertToEnumSet Set<PayOffType> typeSet) {
        for (PayOffType payOffType : typeSet) {
            System.out.println(payOffType.toString());
        }

        return new HashMap<String, Object>();
    }
}

