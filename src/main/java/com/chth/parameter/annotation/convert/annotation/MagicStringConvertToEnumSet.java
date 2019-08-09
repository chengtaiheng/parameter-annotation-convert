package com.chth.parameter.annotation.convert.annotation;

import com.chth.parameter.annotation.convert.enumdomain.PayOffType;
import com.google.common.collect.Sets;
import lombok.var;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.lang.annotation.*;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author: 程泰恒
 * @date: 2019/8/9 15:37
 */

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface MagicStringConvertToEnumSet {


    /**
     * 将字符串转换为枚举集合，如果是全部则转换成包含所有PayOffType类型的集合，如果不是则转换成包含有相对应PayOffType类型的集合
     */
    public static class FormmaterFactory implements AnnotationFormatterFactory<MagicStringConvertToEnumSet> {

        @Override
        public Set<Class<?>> getFieldTypes() {
            return Sets.newHashSet(Set.class);
        }

        @Override
        public Printer<?> getPrinter(MagicStringConvertToEnumSet magicStringConvertToEnumSet, Class<?> aClass) {
            return (Printer<Object>) (o, locale) -> o.toString();
        }

        @Override
        public Parser<?> getParser(MagicStringConvertToEnumSet magicStringConvertToEnumSet, Class<?> aClass) {
            return (Parser<Object>) (o, Locale) -> {
                var result = o.toString();

                if (Objects.deepEquals("全部", result)) {
                    return EnumSet.allOf(PayOffType.class);
                }

                HashSet<PayOffType> payOffSet = Sets.newHashSet();
                return PayOffType.valueOf(result);

            };
        }
    }

}
