package rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;

@RestController
public class UserController {
    CassieConnector cc = new CassieConnector();

    @RequestMapping("/getOneRow")
    public User getOneRow() {       
	ResultSet result;
    result = cc.selectCassie("SELECT * FROM users");
	Row row = result.one();
    return new User(row.getString("username"),
                    row.getString("firstname"),
                    row.getString("lastname"),
                    row.getInt("age"));
    }

    @RequestMapping("/getAllRows")
    public UserList getAllRows(){
        UserList userList = new UserList();
	    ResultSet result;
        result = cc.selectCassie("SELECT * FROM users");

	for (Row row : result) {
                User u = new User(row.getString("username"),
                                row.getString("firstname"),
                                row.getString("lastname"),
                                row.getInt("age"));
                userList.getUserList().add(u);
        }
        return userList;
    }

    @RequestMapping(value = "/postOneRow", method = RequestMethod.POST)
    public User postUser(@RequestBody User u){
	cc.insertCassie("users", u.getUsername(), u.getFirstname(), u.getLastname(), u.getAge());
	return u;
	
    }

    @GetMapping("/ui")
    public String uiGet(Model model) {
        ResultSet result;
        result = cc.selectCassie("SELECT * FROM users");
        Row row = result.one();
        model.addAttribute("user", 
            new User(row.getString("username"),
                    row.getString("firstname"),
                    row.getString("lastname"),
                    row.getInt("age")));
        return "user";
    }

    @PostMapping("/ui")
    public String userSubmit(@ModelAttribute User u) {
        cc.insertCassie("users", u.getUsername(), u.getFirstname(), u.getLastname(), u.getAge());
        return "result";
    }
}












