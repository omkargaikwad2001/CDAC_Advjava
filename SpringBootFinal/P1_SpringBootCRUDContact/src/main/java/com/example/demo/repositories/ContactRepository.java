package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Contact;

import jakarta.transaction.Transactional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
	
	//all basic crud operation methods automatically
		@Query("select c from Contact c where c.cid > ?1")
		public List<Contact> getContacts(int id);
		
		@Modifying
		@Transactional
		@Query("update Contact c set c.email = :emailid where c.cid = :id")
		public int updateEmail(int id, String emailid);
		
		@Query(value = "select fname, lname from contacts", nativeQuery = true)
		public List<Object[]> getData();
		
		@Procedure(name = "getname")
		public String getName(int cid) ;
		
		//no @Query annotation
		public List<Contact> findByFname(String fname);
	
}
