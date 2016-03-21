package org.popkit.appkit.common.adapter;

import org.popkit.appkit.demo.entity.ArgReq;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Aborn Jiang
 * Mail aborn.jiang@gmail.com
 * 2016-03-21:21:58
 */
public class ArgumentsHandler implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 这里决定了是否要执行resolveArgument操作
        return true;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer
            mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Class clazz = parameter.getParameterType();
        if (ArgReq.class.isAssignableFrom(clazz)) {
            int id = 0;
            try {
                 id = Integer.parseInt(webRequest.getParameter("id"));
            } catch (Exception e) {
                // TODO: 3/21/16
            }
            String name = webRequest.getParameter("name");

            return new ArgReq(id, name);
        }

        return null;
    }
}
