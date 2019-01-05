package com.cts.iiht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.iiht.dao.SubjectDao;
import com.cts.iiht.model.Subject;

@Service
public class SubjectService {
	
	@Autowired
	SubjectDao subjectDao;
	
	public void addSubject(Subject subject) {
		subjectDao.addSubject(subject);
	}
	
	public void deleteSubject(long id) {
		subjectDao.deleteSubject(id);
	}

	public Subject searchSubject(long id) {
		return subjectDao.searchSubject(id);
	}

	public void removeBookFomSubjectReferences(long bookId) {
		subjectDao.removeBookFomSubjectReferences(bookId);
	}
}
