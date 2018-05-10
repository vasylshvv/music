package test.music.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import test.music.pojo.MusicalInstruments;
import test.music.pojo.TypeInstruments;

public class TypeInstrumentsDao extends HibernateDaoSupport implements ITypeInstrumentsDao{
	private static ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
	private static ITypeInstrumentsDao instance;
	
	public static ITypeInstrumentsDao getInstance() {
		if(instance == null){
			instance = (ITypeInstrumentsDao)context.getBean("type");
		}
		return instance;
	}
	@Override
	public void add(TypeInstruments type) {
		getHibernateTemplate().save(type);
		
	}

	@Override
	public void edit(TypeInstruments type) {
		getHibernateTemplate().update(type);
		
	}

	@Override
	public void delete(Long id) {
		getHibernateTemplate().delete(id);
		
	}

	@Override
	public List<TypeInstruments> findOneType(Long id) {
		try {
		String query = "from TypeInstruments where id="+id;
		return  getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public List<TypeInstruments> findAllType() {
		try {
			
			String query = "from TypeInstruments";
			return getHibernateTemplate().find(query);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
}
