package hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WellCome {
	
	@GetMapping("/go")
	public String hello(){
		System.out.println("Check go\n");
		return "index";
	}
    @RequestMapping("/go2")
    public String index() {
        return "WellCome";
    }
    
}
