package hello;

import org.springframework.web.bind.annotation.RestController;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class CelleController {

	@RequestMapping("/seleSide")
	@ResponseBody
	public Message chatWebRead() {
		int i = 0;
		Messsages messages = hello.Messsages.initMessages();
		Message m = new Message(0, "");
		while (i < 5 && (m = messages.getMessage2()) == null) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		return m;
	}

	@RequestMapping("/seleComment")
	@ResponseBody
	public void chatWebPut(@RequestBody String m) {
		Messsages messages = hello.Messsages.initMessages();
		System.out.println(m);
		messages.addMessage2(new Message(2, m));
	}

}
