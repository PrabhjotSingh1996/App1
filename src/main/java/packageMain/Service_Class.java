package packageMain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_Class {

	@Autowired
	DataBaseInterface di;
	
	public Account select(int id){
		Account acc=di.findOne(id);
		return acc;
	}
	
	public ArrayList<Account> selectAll(){
		ArrayList<Account> list = new ArrayList<>();
		di.findAll().forEach(account->list.add(account));
		return list;
	}
	
	public void insert(Account a){
		di.save(a);
		return;
	}
	
	public void update(int id,Account a){
		di.delete(id);
		di.save(a);
		return;
	}
	
	public void delete(int id){
		di.delete(id);
		return;
	}
	
	public void truncate(){
		di.deleteAll();
		return;
	}
	
}
