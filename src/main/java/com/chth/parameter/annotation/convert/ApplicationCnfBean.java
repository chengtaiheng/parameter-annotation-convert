package com.chth.parameter.annotation.convert;

import com.chth.parameter.annotation.convert.annotation.MagicStringConvertToEnumSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;

/**
 * @author: 程泰恒
 * @date: 2019/8/9 15:32
 */

@Component
public class ApplicationCnfBean {

    @Autowired
    public void configFormatterRegistry(FormatterRegistry formatterRegistry) {
        formatterRegistry.addFormatterForFieldAnnotation(new MagicStringConvertToEnumSet.FormmaterFactory());
    }
}
