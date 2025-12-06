package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entities.Contact;

public class ContactJdbcDao {	
	@Autowired
	JdbcTemplate template;
	
	public List<Contact> getAll() {
		 return  template.query("select * from contacts", new RowMapper<Contact>() {
			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact ct = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8));
				return ct;
			}			
		} );
	}	
	
	public boolean save(Contact ct) {
		int n = template.update("insert into contact values(?,?,?)",ct.getCid(),ct.getUid(),ct.getPassword());
		if(n == 1)
			return true;
		else
			return false;
	}
	

}
