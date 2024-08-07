//package qeema.net.exceptions;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//public class TeacherRestExceptionHandler {
//
//    @ExceptionHandler
//    public ResponseEntity<TeacherErrorResponse> handleException(TeacherNotFoundException exc) {
//
//        TeacherErrorResponse error = new TeacherErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler
//    public ResponseEntity<TeacherErrorResponse> handleException(Exception exc) {
//
//        TeacherErrorResponse error = new TeacherErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exc.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//    }
//}