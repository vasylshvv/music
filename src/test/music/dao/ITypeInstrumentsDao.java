package test.music.dao;

import java.util.List;


import test.music.pojo.TypeInstruments;

public interface ITypeInstrumentsDao {
	public void add(TypeInstruments type);
	public void edit(TypeInstruments type);
	public void delete(Long id);
	public List<TypeInstruments> findOneType(Long id);
	public List<TypeInstruments> findAllType();
}
