package com.example.study.board.exception;

import com.example.study.support.exception.CustomException;
import com.example.study.support.exception.ErrorCode;

public class BoardQueryException extends CustomException {
	public BoardQueryException() {
		super(BoardFailureErrorCode.DEFAULT);
	}
	
	public BoardQueryException(String message) {
		super(message);
	}
	
	public BoardQueryException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BoardQueryException(ErrorCode errorCode) {
		super(errorCode);
	}
	
	public BoardQueryException(ErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}
}
