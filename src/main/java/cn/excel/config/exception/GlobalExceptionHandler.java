package cn.excel.config.exception;

import cn.excel.config.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 全局异常处理
 * </p>
 *
 * @author 作者：张虎
 * @since 2020-11-06
 */
@Slf4j  //日志输出
@RestControllerAdvice  //全局异常捕获标签
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseStatus(HttpStatus.BAD_REQUEST)  //返回给前端的状态码
    @ExceptionHandler(value = MethodArgumentNotValidException.class)  //处理实体校验异常
    public Result handler(MethodArgumentNotValidException e) {
        logger.error(e.getMessage(), e);
        //筛选出重要的错误信息(每次返回最先错的那个)
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        return new Result().failed(objectError.getDefaultMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  //返回给前端的状态码
    @ExceptionHandler(value = IllegalArgumentException.class)  //判断对象为空的异常（Assert.notNull）
    public Result handler(IllegalArgumentException e) {
        logger.error(e.getMessage(), e);
        return new Result().failed(500,e.getMessage(),null);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  //返回给前端的状态码
    @ExceptionHandler(value = RuntimeException.class)  //处理程序运行异常
    public Result handler(RuntimeException e) {
        logger.error(e.getMessage(), e);
        return new Result().failed(500, e.getMessage(), null);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)  //返回给前端的状态码
    @ExceptionHandler(value = Exception.class)  //处理全部异常，Exception为所有异常的父类
    public Result handler(Exception e) {
        logger.error(e.getMessage(), e);
        return new Result().failed(500, e.getMessage(), null);
    }
}

