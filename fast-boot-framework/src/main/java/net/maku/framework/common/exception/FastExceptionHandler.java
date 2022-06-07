package net.maku.framework.common.exception;

import lombok.extern.slf4j.Slf4j;
import net.maku.framework.common.utils.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 异常处理器   自定义异常
 * RestControllerAdvice都是对Controller进行增强的，可以全局捕获spring mvc抛的异常。
 * @author 阿沐 babamu@126.com
 */
@Slf4j  //我们只需要在类前面添加注解@Slf4j，即可使用log日志的功能了
@RestControllerAdvice
public class FastExceptionHandler {
	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(FastException.class)
	public Result<String> handleRenException(FastException ex){

		return Result.error(ex.getCode(), ex.getMsg());
	}

	/**
	 * SpringMVC参数绑定，Validator校验不正确
	 */
	@ExceptionHandler(BindException.class)
	public Result<String> bindException(BindException ex) {
		FieldError fieldError = ex.getFieldError();
		assert fieldError != null;
		return Result.error(fieldError.getDefaultMessage());
	}

	@ExceptionHandler(AccessDeniedException.class)
	public Result<String> handleAccessDeniedException(Exception ex){

		return Result.error(ErrorCode.FORBIDDEN);
	}

	@ExceptionHandler(Exception.class)
	public Result<String> handleException(Exception ex){
		log.error(ex.getMessage(), ex);
		return Result.error(ErrorCode.INTERNAL_SERVER_ERROR);
	}

}