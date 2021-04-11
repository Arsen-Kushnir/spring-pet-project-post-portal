package com.arsenkushnir.postportal.exception.handle;

import com.arsenkushnir.postportal.exception.ServiceException;
import com.arsenkushnir.postportal.exception.UserPasswordsException;
import lombok.extern.slf4j.Slf4j;
import com.arsenkushnir.postportal.exception.UserDuplicationException;
import com.arsenkushnir.postportal.util.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
@Slf4j
public class ExceptionInterceptor {

    @ExceptionHandler({Exception.class})
    public String unhandledException(Exception e, HttpServletRequest request) {

        log.error("Unexpected exception was thrown, httpServletRequest: {}", request, e);

        return getRedirectUrl(request);
    }

    @ExceptionHandler({ServiceException.class})
    public String serviceAdminException(ServiceException e, HttpServletRequest request) {

        log.error("ServiceException was thrown, httpServletRequest: {}", request, e);

        return getRedirectUrl(request);
    }

    @ExceptionHandler({UserPasswordsException.class})
    public String handleUserDuplicationException(UserPasswordsException e,
                                                 RedirectAttributes redirectAttributes, HttpServletRequest request){

        log.error("UserDuplicationException was thrown, httpServletRequest: {}", request, e);

        redirectAttributes.addFlashAttribute("passwordsException", e.getMessage());

        return getRedirectUrl(request);
    }

    @ExceptionHandler({UserDuplicationException.class})
    public String handleUserDuplicationException(UserDuplicationException e,
                                                 RedirectAttributes redirectAttributes, HttpServletRequest request){

        log.error("UserDuplicationException was thrown, httpServletRequest: {}", request, e);

        redirectAttributes.addFlashAttribute("duplicationException", e.getMessage());

        return getRedirectUrl(request);
    }

    @ExceptionHandler({BindException.class})
    public String handleValidationExceptions(BindException e,
                                             RedirectAttributes redirectAttributes, HttpServletRequest request) {

        log.error("BindException was thrown, httpServletRequest: {}", request, e);

        e.getBindingResult().getAllErrors()
                .forEach(error -> {
                    String fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    redirectAttributes.addFlashAttribute(fieldName + "Error", errorMessage);
                });

        return getRedirectUrl(request);
    }

    private String getRedirectUrl(HttpServletRequest request) {

        if (StringUtils.equals(request.getMethod(), "POST")) {
            return "redirect:" + HttpUtils.getPreviousPageUrl(request);
        }

        return "redirect:/";

    }
}
