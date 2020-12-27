package com.xu.studyspringboot.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.studyspringboot.pojo.User;
import com.xu.studyspringboot.service.impl.UserServiceImpl;
import com.xu.studyspringboot.utils.JsonData;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * login 过滤器
 */
@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 容器加载时使用
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init LoginFilter <<========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // System.out.println("doFilter LoginFilter <<========");

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String token = req.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = req.getParameter("token");
        }

        if (!StringUtils.isEmpty(token)) {
            //判断是否合法
            User user = UserServiceImpl.sessionMap.get(token);
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                JsonData jsonData = JsonData.buildError("token无效", -2);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(res, jsonStr);
            }
        } else {
            JsonData jsonData = JsonData.buildError("未登录", -3);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(res, jsonStr);
        }

    }

    private void renderJson(HttpServletResponse response, String json) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 容器销毁时使用
     */
    @Override
    public void destroy() {
        System.out.println("destroy LoginFilter <<========");
    }
}
