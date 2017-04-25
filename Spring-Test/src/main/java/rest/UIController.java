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
    public String uiForm(Model model) {
	model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/ui")
    public String userSubmit(@ModelAttribute User user) {
        cc.insertCassie("users", u.getUsername(), u.getFirstname(), u.getLastname(), u.getAge());
        return "result";
    }
}
