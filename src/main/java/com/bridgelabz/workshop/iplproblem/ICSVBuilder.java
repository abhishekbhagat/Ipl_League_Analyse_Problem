package com.bridgelabz.workshop.iplproblem;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder<E> {
	public Iterator<E> getCsvFileIterator(Reader reader, Class csvClass) throws IplAnalyserException;
	public List<E> getCSVFileList(Reader reader, Class csvClass) throws IplAnalyserException;
}
