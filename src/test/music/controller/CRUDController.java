package test.music.controller;



import java.util.Enumeration;
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

public class CRUDController implements Controller{
	private IMusicalInstrumentDao intrumentDao = MusicalInstrumentDao.getInstance();
	private ITypeInstrumentsDao typeDao = TypeInstrumentsDao.getInstance();
	private List<MusicalInstruments> listInstruments;
	private List<TypeInstruments> listType;
	private TypeInstruments typeInstrument;
	private MusicalInstruments instruments;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		
		Enumeration<String> param = request.getParameterNames();
		while (param.hasMoreElements()) {
			String string = (String) param.nextElement();
			System.out.println("param: "+string);
		}
		
	
		
		
		
		String save = request.getParameter("save");
		System.out.println("save = "+save);
		
		String delete = request.getParameter("delete");
		System.out.println("delete = "+delete);
		
		String update = request.getParameter("update");
		System.out.println("update = "+update);
		
		if(save!=null){
			String newtype = request.getParameter("newtype");
			String newname = request.getParameter("newname");
			String newprice = request.getParameter("newprice");
			String newYear = request.getParameter("newyear");
			listType = typeDao.findOneType(Long.parseLong(newtype));
			for (TypeInstruments t : listType) {
				typeInstrument = new TypeInstruments(t.getId(), t.getNameType());
			}
			instruments = new MusicalInstruments();
			instruments.setNameInstruments(newname);	
			instruments.setPrice(Integer.parseInt(newprice));
			instruments.setReleaseYear(newYear);
			instruments.setTypeInstr(typeInstrument);
			intrumentDao.add(instruments);
			
			
		} else if(delete!=null){
			instruments = new MusicalInstruments(Long.parseLong(delete));
			intrumentDao.delete(instruments);
		} else if(update!=null){
			
			String edittype = request.getParameter("edittype");
			System.out.println("edittype = "+edittype);
			String editname = request.getParameter("editnameInstruments");
			String editprice = request.getParameter("editprice");
			String editYear = request.getParameter("editreleaseYear");
			
			listType = typeDao.findOneType(Long.parseLong(edittype));
			for (TypeInstruments t : listType) {
				typeInstrument = new TypeInstruments(t.getId(), t.getNameType());
			}
			instruments = new MusicalInstruments(Long.parseLong(update), editname, Integer.parseInt(editprice), editYear, typeInstrument);
			intrumentDao.edit(instruments);
		}
		
		return new ModelAndView("redirect:index.html");
	}
}
