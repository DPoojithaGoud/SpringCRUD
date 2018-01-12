package com.nisum;
import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;
@Controller  
public class StudentController {
	@Autowired  
    StuDao dao; 
	
	@RequestMapping("/stuform")  
    public ModelAndView showform(){  
        return new ModelAndView("stuform","command",new Student());  
    }  
	@RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("stu") Student stu){  
        dao.save(stu);  
        return new ModelAndView("registered","msg1","Registered Succesfully");
    }  
	@RequestMapping("/viewstu")  
    public ModelAndView viewstu(){  
        List<Student> list=dao.getStudent();  
        return new ModelAndView("viewstu","list",list);  
    }  
	
	@RequestMapping(value="/editstu/{id}")  
    public ModelAndView edit(@PathVariable int id){  
       Student stu=dao.getStudentById(id);
        return new ModelAndView("stueditform","command",stu);  
    }  
	@RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("Stu") Student stu){  
        dao.update(stu);  
        return new ModelAndView("updated","msg","Updated Succesfully");   
        }  
   
    @RequestMapping(value="/deletestu/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){  
        dao.delete(id);  
        return new ModelAndView("redirect:/viewstu");  
    }  
	
	
	
}
