package qeema.net.exceptions;


import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Aspect
@Component
public class ExceptionHandlerAspect {
    private static final Logger logger = LogManager.getLogger(ExceptionHandlerAspect.class);

    @AfterThrowing(pointcut = "execution(* qeema.net.service.*.*(..))", throwing = "ex")
    public ResponseEntity<Object> handleTeacherNotFoundException(TeacherNotFoundException ex) {
        logger.error("TeacherNotFound Exception: ", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @AfterThrowing(pointcut = "execution(* qeema.net.service.*.*(..))", throwing = "ex")
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        logger.error("Exception is : ", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
