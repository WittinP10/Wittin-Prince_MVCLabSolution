package com.collegefest.services;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collegefest.Model.Student;


@Repository
public class StudentServiceImpl implements StudentService {

	
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory=sessionFactory;
		
		try {
		this.session=sessionFactory.getCurrentSession();
		}catch(HibernateException e){
			session=sessionFactory.openSession();
		}
	}
	
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		
		List<Student> students=session.createQuery("from Student").list();
		return students;
	}

	@Transactional
	public Student findById(int theId) {
		// TODO Auto-generated method stub
		
		Student stu=new Student();
		
		 Transaction tx=session.beginTransaction();
		
		stu=session.get(Student.class,theId);
		
		tx.commit();
		return stu;
	}

	@Override
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(theStudent);
		tx.commit();
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
		Transaction tx = session.beginTransaction();

		// get transaction
		Student student = session.get(Student.class,theId);

		// delete record
		session.delete(student);

		tx.commit();
		
	}
	
	

}
