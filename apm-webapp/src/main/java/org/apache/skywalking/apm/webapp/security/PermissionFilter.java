package org.apache.skywalking.apm.webapp.security;


import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.skywalking.apm.webapp.entity.UserInfo;
import org.apache.skywalking.apm.webapp.logic.UserInfoLogic;
import org.jasig.cas.client.util.AssertionHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by moruwen on 2018/11/7.
 */
public class PermissionFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(PermissionFilter.class);

    private Set<String> excludesPathSet = new HashSet<>();

    private UserInfoLogic userInfoLogic;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String ssoUserName = AssertionHolder.getAssertion().getPrincipal().getName();
        String path = request.getServletPath();
        logger.info("用户[{}]请求访问[{}]", ssoUserName, path);

        if (StringUtils.isEmpty(ssoUserName)) {
            logger.warn("用户未登录，无权访问[{}]", path);
            buildResponse(response, "用户未登录，无权访问" + path);
            return;
        }
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        UserInfoLogic userInfoLogic = context.getBean(UserInfoLogic.class);
        UserInfo userInfo = userInfoLogic.selectByUserName(ssoUserName);
        if (userInfo == null) {
            logger.warn("您没有访问此链接权限{}", path);
            buildResponse(response, "您没有访问此链接权限:" + path);
            return;
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        excludesPathSet.add("/index.htm");
    }

    private void buildResponse(HttpServletResponse response, String message) throws IOException {
        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("message", message);
        response.setContentType("text/html;charset=utf-8的");
        response.setCharacterEncoding("UTF-8");
        String html="<div id=\"hidebg\"></div>\n" +
                "    <div id=\"hidebox\" onClick=\"hidebox();\">\n" +
                "        <div  style=\"text-align:center;\">\n" +
                "            <p class=\"box-head\">温馨提示</p>\n" +
                "            <div class=\"hidebox-hr\"><hr/></div>\n" +
                "            <p class=\"box-textarea\">您暂时没有查看权限，请联系技术人员获取权限～<p>\n" +
                "        </div>\n" +
                "    </div><br><div><a href=\"javascript:void(0);\"  onclick=\"showbox();\"></div>";
        response.getWriter().print(html);
        response.getWriter().close();
    }

}
