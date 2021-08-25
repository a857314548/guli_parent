package com.zhangzhen.servicebase.config.hanled;



import com.zhangzhen.commontils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobaeExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R globaeEceptionHandler(Exception e) {
        e.printStackTrace();
        return R.error().message("进行了全局异常处理......");
    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R globaeArithmeticExceptionHandler(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("进行了算法异常处理......");
    }

    @ExceptionHandler(customException.class)
    @ResponseBody
    public R globaeCustomExceptionHandler(customException e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return R.error().code(e.getCustomCode()).message(e.getMsg());
    }
}
