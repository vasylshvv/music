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

public class TypeController implements Controller{
	
	private ITypeInstrumentsDao typeDao = TypeInstrumentsDao.getInstance();;
	private List<TypeInstruments> listType;
	private TypeInstruments typeInstrument;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/jsp/type.jsp");
		
		String save = request.getParameter("save");
		if(save != null){
			String type = request.getParameter("type");
			typeInstrument = new TypeInstruments();
			typeInstrument.setNameType(type);
			typeDao.add(typeInstrument);
			modelAndView = new ModelAndView("redirect:index.html");
		} else {
			listType = typeDao.findAllType();
			modelAndView.addObject("listtype", listType);
		}
		
		
		return modelAndView;
	}
}
