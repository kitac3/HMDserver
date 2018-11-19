package hello;

import org.springframework.web.bind.annotation.RestController;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@EnableAutoConfiguration
public class WebController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/webSide")
    @ResponseBody
    public Message chatWebRead() {
    int i=0;
    Messsages messages=hello.Messsages.initMessages();
    Message m=new Message(0,"");
    while(i<30 && (m=messages.getMessage1())==null){
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

    @RequestMapping("/getMessage")
    @ResponseBody
    public Message getMessage(@RequestParam("id") int id) {
    int i=0;
    Messsages messages=hello.Messsages.initMessages();
    Message m=new Message(0,"");
 //   System.out.println("id="+id);
    while(i<30 && (m=messages.getMessage(id))==null){
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

    @RequestMapping("/webComment")
    @ResponseBody
    public void chatWebPut(@RequestBody String m) {
        Messsages messages=hello.Messsages.initMessages();
    	System.out.println(m);
    	messages.addMessage1(new Message(1,m));
    }

/*    @RequestMapping("/putMessage")
    @ResponseBody
    public void putMessage(@RequestBody String m) {
        Messsages messages=hello.Messsages.initMessages();
    	System.out.println(m);
//    	messages.addMessage(m);
    }
*/
    
    @RequestMapping("/putMessage")
    @ResponseBody
    public void putMessage(@RequestBody Message m) {
        Messsages messages=hello.Messsages.initMessages();
    	System.out.println(m.getUserId()+":"+m.getBody());
    	messages.addMessage(m);
    }
}
