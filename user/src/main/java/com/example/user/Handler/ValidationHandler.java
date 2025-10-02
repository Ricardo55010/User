package com.example.user.Handler;

import com.example.user.Exceptions.NoSuchElementException;
import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ValidationHandler {

    @GraphQlExceptionHandler(NoSuchElementException.class)
    public GraphQLError handleValidationExceptions(NoSuchElementException e) {

        return GraphQLError.newError()
                .errorType(ErrorType.INTERNAL_ERROR)
                .message(e.getMessage())
                .build();
    }
}
