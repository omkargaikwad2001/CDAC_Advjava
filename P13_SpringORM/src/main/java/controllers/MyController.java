package controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ContactDAO;
import entities.Contact;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class MyController {

	@Autowired
	ContactDAO dao;

	@RequestMapping("/all")
	public ModelAndView getAll() {
		List<Contact> clist = dao.getAllContacts();
		return new ModelAndView("allcontacts", "contactlist", clist);
	}

	@RequestMapping("/getbyid/{id}")
	public ModelAndView getById(@PathVariable("id") int id) {
		Contact contact = dao.getById(id);
		// Wrap single contact in list for same JSP
		List<Contact> contactList = Arrays.asList(contact);
		return new ModelAndView("allcontacts", "contactlist", contactList);
	}

	@RequestMapping("/save")
	public ModelAndView saveContact() {
		return new ModelAndView("contactform", "ct", new Contact());
	}

	@RequestMapping("/insert")
	public ModelAndView insertRecord(@ModelAttribute("ct") Contact ct) {
		int id = dao.saveContact(ct);
		return new ModelAndView("msg", "id", id);
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView editContact(@PathVariable("id") int id) {
	    Contact ct = dao.getById(id);
	    return new ModelAndView("contactform", "ct", ct);
	}

	@RequestMapping("/update")
	public String updateContact(@ModelAttribute("ct") Contact ct) {
	    dao.updateContact(ct);
	    return "redirect:/all";
	}


	@RequestMapping("/delete/{id}")
	public String deleteContact(@PathVariable("id") int id) {
	    dao.deleteContact(id);
	    return "redirect:/all";
	}

	
	
	
	
	
	
	
	
	
	
	
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

}
