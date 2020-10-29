package com.bridgelabz.workshop.iplproblem;

public class IplAnalyserException extends Exception {
  enum ExceptionType{
	  IPL_FILE_PROBLEM,UNABLE_TO_PARSE;
  }
  ExceptionType type;
  public IplAnalyserException(String message,ExceptionType type) {
	  super(message);
	  this.type=type;
  }
}
