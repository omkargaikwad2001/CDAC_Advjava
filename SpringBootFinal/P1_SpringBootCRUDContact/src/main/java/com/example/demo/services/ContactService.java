package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Contact;
import com.example.demo.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository crepo;

	public List<Contact> getAllContacts() {
		return crepo.findAll();
	}

	public Contact getContactById(int id) {

		Contact ct = null;
		Optional<Contact> oc = crepo.findById(id);
		;

		try {
			ct = oc.get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ct;
	}

	public String saveContact(Contact ct) {
		Contact save = crepo.save(ct);
		if (save != null) {
			return "data saved";
		}
		return "data not saved";
	}

	public String deleteContact(int id) {

		Contact ct = null;
		Optional<Contact> byId = crepo.findById(id);

		ct = byId.get();

		if (ct != null) {
			crepo.deleteById(id);
			return "data deleted with id " + id;
		} else {
			return "wrong id";
		}
	}

	public Contact updateContact(Contact nct, int id) {

		Optional<Contact> byId = crepo.findById(id);

		if (byId.isPresent()) {
			Contact oct = byId.get();

			oct.setUid(nct.getUid());
			oct.setPassword(nct.getPassword());
			oct.setFname(nct.getFname());
			oct.setLname(nct.getLname());
			oct.setEmail(nct.getEmail());
			oct.setContactno(nct.getContactno());
			oct.setBdate(nct.getBdate());

			return crepo.save(oct);
		}

		return null;
	}

	public Contact updateContactPartial(Contact nct, int id) {

		Optional<Contact> byId = crepo.findById(id);

		if (byId.isPresent()) {
			Contact oct = byId.get();

			if (nct.getUid() != null)
				oct.setUid(nct.getUid());
			if (nct.getPassword() != null)
				oct.setPassword(nct.getPassword());
			if (nct.getFname() != null)
				oct.setFname(nct.getFname());
			if (nct.getLname() != null)
				oct.setLname(nct.getLname());
			if (nct.getEmail() != null)
				oct.setEmail(nct.getEmail());
			if (nct.getContactno() != null)
				oct.setContactno(nct.getContactno());
			if (nct.getBdate() != null)
				oct.setBdate(nct.getBdate());

			return crepo.save(oct);
		}

		return null;
	}

//	**************************************************************

	public List<Contact> getContacts(int id) {
		return crepo.getContacts(id);
	}

	public int updateEmail(int cid, String email) {
		System.out.println(cid + " : " + email);
		return crepo.updateEmail(cid, email);
	}

	public List<Object[]> getInfo() {
		return crepo.getData();
	}

	public String getName(int cid) {
		return crepo.getName(cid);
	}

	public List<Contact> findbyfname(String fname) {
		return crepo.findByFname(fname);
	}

}
