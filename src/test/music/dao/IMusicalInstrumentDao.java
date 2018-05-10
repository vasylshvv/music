package test.music.dao;

import java.util.List;

import test.music.pojo.MusicalInstruments;



public interface IMusicalInstrumentDao {
	public void add(MusicalInstruments instruments);
	public void edit(MusicalInstruments instruments);
	public void delete(MusicalInstruments instruments);
	public MusicalInstruments getOneInstruments(Long id);
	public List<MusicalInstruments> findAllInstruments();
}
