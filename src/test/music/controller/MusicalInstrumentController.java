package test.music.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import test.music.dao.IMusicalInstrumentDao;
import test.music.dao.ITypeInstrumentsDao;
import test.music.dao.MusicalInstrumentDao;
import test.music.dao.TypeInstrumentsDao;
import test.music.pojo.MusicalInstruments;
import test.music.pojo.TypeInstruments;

public class MusicalInstrumentController implements Controller{
	private IMusicalInstrumentDao intrumentDao = MusicalInstrumentDao.getInstance();
	private ITypeInstrumentsDao typeDao = TypeInstrumentsDao.getInstance();
	private List<MusicalInstruments> listInstruments;
	private List<TypeInstruments> listType;
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("index.jsp");
		listInstruments = intrumentDao.findAllInstruments();
		listType = typeDao.findAllType();
		for (TypeInstruments t : listType) {
			System.out.println(t.getNameType());
		}
		modelAndView.addObject("listinstruments", listInstruments);
		modelAndView.addObject("listtype", listType);
		return modelAndView;
	}
	
	
}
