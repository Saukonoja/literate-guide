package rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

@Controller
public class UIController{
	CassieConnector cc = new CassieConnector();

    @RequestMapping(value = "/users", 
            produces = { MediaType.APPLICATION_JSON_VALUE }, 
            method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> getUsers() {

        List<User> users = new ArrayList<>();

        ResultSet result;
        result = cc.selectCassie("SELECT * FROM users");

        for (Row row : result) {
                User u = new User(row.getString("username"),
                                row.getString("firstname"),
                                row.getString("lastname"),
                                row.getInt("age"));
                users.add(u);
        }

        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value="/view", produces = {
            MediaType.TEXT_HTML_VALUE},  
            method = RequestMethod.GET)
    public String viewUsers () {
        return "user-listing";
    }
	
	@GetMapping("/ui")
    public String uiForm(Model model) {
	model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/ui")
    public String userSubmit(@ModelAttribute User user) {
        cc.insertCassie("users", user.getUsername(), user.getFirstname(), user.getLastname(), user.getAge());
        return "result";
    }
}
