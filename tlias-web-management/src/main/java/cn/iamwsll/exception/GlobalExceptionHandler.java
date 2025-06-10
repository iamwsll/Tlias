package cn.iamwsll.exception;

import cn.iamwsll.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.Message;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("系统异常: {}", e.getMessage(), e);
        return Result.error("系统异常，请稍后再试或联系管理员");
    }

    @ExceptionHandler
    public Result DuplicateKeyException(DuplicateKeyException e) {
        log.error("数据重复异常: {}", e.getMessage(), e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        if (i != -1) {
            String duplicateData = message.substring(i + "Duplicate entry".length()).split(" ")[0];
            return Result.error("数据重复" + duplicateData + " 已经存在");
        }
        return Result.error("数据重复，请检查输入");
    }
}
