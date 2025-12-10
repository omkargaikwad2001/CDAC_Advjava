package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Contact;
import com.example.demo.services.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService cservice;

	@GetMapping("/all")
	public List<Contact> getAllContacts() {
		return cservice.getAllContacts();
	}

	// http://localhost:8080/byid?cid=1 this is request param
	@GetMapping("/byid")
	public Contact getContactById(@RequestParam("cid") int id) {
		return cservice.getContactById(id);
	}

	// http://localhost:8080/byid2/1 this is pathVariable
	// we can pass multiple variables also
	@GetMapping("/byid2/{cid}")
	public Contact getContact(@PathVariable("cid") int id) {
		return cservice.getContactById(id);
	}

	@PostMapping("/save")
	public String saveContact(@RequestBody Contact ct) {
		String saveContact = cservice.saveContact(ct);
		return saveContact;
	}

	@DeleteMapping("/delete/{cid}")
	public String deleteContactById(@PathVariable("cid") int id) {
		return cservice.deleteContact(id);
	}

	@PutMapping("/update/{id}")
	public Contact updateContactByid(@RequestBody Contact ct, @PathVariable int id) {

		Contact updateContact = cservice.updateContact(ct, id);
		return updateContact;

	}

	@PatchMapping("/update2/{id}")
	public Contact updateContactByid2(@RequestBody Contact ct, @PathVariable int id) {

		Contact updateContact = cservice.updateContactPartial(ct, id);
		return updateContact;

	}

	// *****************************************************

	// http://localhost:8080/getcontacts?id=10
	@GetMapping("/getcontacts")
	public List<Contact> getContacts(@RequestParam int id) {
		return cservice.getContacts(id);
	}

	// http://localhost:8080/updateemail?cid=10&email=admin@gmail
	@PutMapping("/updateemail")
	public int updateEmail(@RequestParam int cid, @RequestParam String email) {
		System.out.println(cid + " : " + email);
		return cservice.updateEmail(cid, email);
	}

	// http://localhost:8080/getinfo
	@GetMapping("/getinfo")
	public List<Object[]> getData() {
		return cservice.getInfo();
	}

	// http://localhost:8080/getname/1
	@GetMapping("/getname/{cid}")
	public String getName(@PathVariable int cid) {
		return cservice.getName(cid);
	}

	// http://localhost:8080/findbyname?fname=priya
	@GetMapping("/findbyname")
	public List<Contact> findbyname(@RequestParam String fname) {
		return cservice.findbyfname(fname);
	}

}
