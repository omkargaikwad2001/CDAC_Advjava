package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import entities.Contact;

public class ContactDAO {
	
	@Autowired
	HibernateTemplate template;
	
	//display all
	public List<Contact> getAllContacts(){
		return template.loadAll(Contact.class);
	}
	
	// Display one contact by ID (accepts parameter)
    public Contact getById(int id) {
        return template.get(Contact.class, id);
    }
    
    @Transactional
    public int saveContact(Contact ct) {
    		int i=(int)template.save(ct);
    		return i;
    }
	
    @Transactional
    public void deleteContact(int id) {
        Contact ct = template.get(Contact.class, id);
        template.delete(ct);
    }
    
    @Transactional
    public void updateContact(Contact ct) {
        template.update(ct);
    }


	
	
}
