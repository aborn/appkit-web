package org.popkit.appkit.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation use authority policy
 * Author: aborn.jiang
 * Email : aborn.jiang AT foxmail.com
 * Date  : 4/12/15
 * Time  : 11:04 AM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorityPolicy {

    public String scene();
}
