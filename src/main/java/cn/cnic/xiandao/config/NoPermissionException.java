package cn.cnic.xiandao.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
@Slf4j
public class NoPermissionException {

    @ExceptionHandler(UnauthorizedException.class)
    public String handleShiroException(Exception ex) {
        log.info("无权限");
        return "/unauthc";
    }

    @ExceptionHandler(AuthorizationException.class)
    public String AuthorizationException(Exception ex) {
        log.info("权限认证失败");
        return "/login1";
    }


}
