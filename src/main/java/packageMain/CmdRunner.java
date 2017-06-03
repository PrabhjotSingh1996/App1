package packageMain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CmdRunner implements CommandLineRunner{

	@Autowired
	private DataBaseInterface dataBaseInterface;
	
	@Override
	public void run(String... arg0) throws Exception {
		dataBaseInterface.save(new Account(1,"A",650000.0));
		dataBaseInterface.save(new Account(2,"B",750000.0));
		dataBaseInterface.save(new Account(3,"C",850000.0));
		dataBaseInterface.save(new Account(4,"D",950000.0));
		dataBaseInterface.save(new Account(5,"E",1050000.0));
		dataBaseInterface.findAll().forEach(account->System.out.println(account.getAccountNumber()+"  "+account.getName()+"  "+account.getAccountBalance()));
	}
}
