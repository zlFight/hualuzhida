package zhida.business.config.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import zhida.business.domain.util.DESUtils;
import zhida.business.domain.util.UserInfoUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        if(authToken(request)){
            return true;
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }

    private Boolean authToken(HttpServletRequest request) {
        Cookie[] cookieArr = request.getCookies();
        String token = "";
        if(cookieArr != null && cookieArr.length>0 ) {
            for(Cookie cookie : cookieArr) {
                if("token".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
            if(!"".equals(token) &&
                    UserInfoUtils.authTokens.containsKey(DESUtils.decrypt(token,UserInfoUtils.SECRET_KEY))){
                return true;
            }
        }
        return false;
    }
}
