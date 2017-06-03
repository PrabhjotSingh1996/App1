package packageMain;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller_Class {
	
	@Autowired
	private Service_Class sc;
	
	@RequestMapping("/account")
	public ArrayList<Account> getAll(){
		return sc.selectAll();
	}
	
	@RequestMapping("/account/{id}")
	public Account get(@PathVariable("id") int id){
		return sc.select(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/account")
	public String post(@RequestBody Account a){
		sc.insert(a);
		return "Account Created";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/account/{id}")
	public String put(@PathVariable("id") int id,@RequestBody Account a){
		sc.update(id, a);
		return "Information updated for account "+id;
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/account/{id}")
	public String delete(@PathVariable("id") int id){
		sc.delete(id);
		return "Account "+id+" deleted";
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/account")
	public String deleteAll(){
		sc.truncate();
		return "All records cleared";
	}
}
