package rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

@Controller
public class UIController{
	CassieConnector cc = new CassieConnector();
	
	@GetMapping("/ui")
    public String uiGet(Model model) {
        /*ResultSet result;
        result = cc.selectCassie("SELECT * FROM users");
        Row row = result.one();
        model.addAttribute("user", 
            new User(row.getString("username"),
                    row.getString("firstname"),
                    row.getString("lastname"),
                    row.getInt("age")));*/
	model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/ui")
    public String userSubmit(@ModelAttribute User user) {
        //cc.insertCassie("users", u.getUsername(), u.getFirstname(), u.getLastname(), u.getAge());
        return "result";
    }
}
