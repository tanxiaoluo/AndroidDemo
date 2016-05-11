package com.tanxiaoluo.androiddemo.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tanluo on 2016/5/11 0011.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Layout {
    int value();


    static class LayoutResolver {
        public static int resolver(Class<?> clazz, Class<?> baseClazz, int defaultValue) {
            if (clazz.equals(baseClazz)) {
                return defaultValue;
            } else {
                Annotation anno = clazz.getAnnotation(Layout.class);
                if ( null != anno) {
                    return  ((Layout)anno).value();
                } else {
                    return resolver(clazz.getSuperclass(),baseClazz,defaultValue);
                }
            }
        }
    }

}
