package com.example.aoplogback.apspect;

import com.alibaba.fastjson.JSONObject;
import com.example.aoplogback.exception.CustomException;
import com.example.aoplogback.pojo.BaseResponse;
import com.example.aoplogback.pojo.SysLog;
import com.example.aoplogback.utils.IPUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 切面处理类
 */
@Component
@Aspect
public class AppLogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(AppLogAspect.class);

    @Pointcut("@annotation(com.example.aoplogback.apspect.AppLog)")
    public void appLogPointCut() {

    }

    @Before("appLogPointCut()")
    public void appLog(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        // 获取方法上的注解
        AppLog annotation = method.getAnnotation(AppLog.class);
        if (Objects.isNull(annotation)) {
            return;
        }
        // 获取注解的值
        String value = annotation.value();
        SysLog log = new SysLog();
        // 保存操作类型
        log.setOperation(value);

        // 获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取请求方法名
        String methodName = method.getName();
        log.setMethod(className + "." + methodName);
        // 获取请求参数
        Object[] args = joinPoint.getArgs();
        List<Object> arguments = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (!(args[i] instanceof ServletRequest || args[i] instanceof ServletResponse ||
                    args[i] instanceof MultipartFile || args[i] instanceof BindingResult) && args[i] != null) {
                arguments.add(args[i]);
            }
        }

        String paramter = "";
        if (arguments != null) {
            try {
                paramter = JSONObject.toJSONString(arguments.toArray());
            } catch (Exception e) {
                paramter = arguments.toString();
            }
        }
        log.setParams(paramter);
        log.setCreateDate(new Date());
        //获取用户ip地址
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.setIp(IPUtils.getIpAddr(request));
        // 打印日志，此处可以替换为保存到数据库等
        LOG.info(log.toString());
    }


    // 定义参数校验切面的切点
    @Pointcut("execution(* com.example.aoplogback.controller..*.*(..))")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        BindingResult bindingResult = null;
        // 从切点获取bindingResult
        for (Object arg : pjp.getArgs()) {
            if (arg instanceof BindingResult) {
                bindingResult = (BindingResult) arg;
            }
        }
        if (bindingResult != null && bindingResult.hasErrors()) {
            StringBuffer sb = new StringBuffer();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                sb.append(fieldError.getField() + ":" + fieldError.getDefaultMessage() + ";");
            }
            // 参数校验失败打印日志
            LOG.error(sb.toString());
            // 接口返回错误信息 400 bad request, 通过BaseResponse返回或者直接抛自定义异常都可以返回。
//            return new BaseResponse(400,"Parameter error:" + sb.toString(), null);
            throw new CustomException(400, "Parameter error: " + sb.toString());
        }
        //执行目标方法（controller中真正需要执行的业务逻辑）
        return pjp.proceed();
    }

}
