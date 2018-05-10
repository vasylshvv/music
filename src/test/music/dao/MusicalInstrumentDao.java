package test.music.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import test.music.pojo.MusicalInstruments;

public class MusicalInstrumentDao extends HibernateDaoSupport implements IMusicalInstrumentDao{
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static IMusicalInstrumentDao instance;
	
	public static IMusicalInstrumentDao getInstance() {
		if(instance == null){
			instance = (IMusicalInstrumentDao)context.getBean("instrument");
		}
		return instance;
	}

	public void add(MusicalInstruments instruments) {
		getHibernateTemplate().save(instruments);
		
	}

	public void edit(MusicalInstruments instruments) {
		getHibernateTemplate().update(instruments);
		
	}

	public void delete(MusicalInstruments instruments) {
		getHibernateTemplate().delete(instruments);
		
	}

	public MusicalInstruments getOneInstruments(Long id) {
		String query = "from MusicalInstruments where id="+id;
		return (MusicalInstruments) getHibernateTemplate().find(query);
	}

	public List<MusicalInstruments> findAllInstruments() {
		try {
			
			String query = "from MusicalInstruments";
			return (List<MusicalInstruments>) getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
}
