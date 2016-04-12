package com.controller;

import com.object.Person;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangqi on 16/4/10.
 */
public class PersonFormController extends SimpleFormController {

    private String[] languages = new String[]{"Java", "Ruby", "Python"};

    public PersonFormController() {
        setCommandName("person");
        setCommandClass(Person.class);
        setFormView("newPerson");
        setSuccessView("redirect:/PersonSuccess");
    }

    @Override
    protected Map referenceData(HttpServletRequest req) throws Exception {
        Map data = new HashMap();
        data.put("languages", languages);
        return data;
    }

    @Override
    protected void initBinder(HttpServletRequest request,
                              ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        Person person = (Person) command;
        //personDao.persist(person);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("suggestedBook",
                suggestBook(person.getFavoriteProgrammingLanguage()));
       // model.put(getCommandName(), person);
        System.out.println(person.getName());
        model.put("personName", person.getName().getFirstName()+","+person.getName().getLastName());
        model.put("personFavoriteProgrammingLanguage",
                person.getFavoriteProgrammingLanguage());
        return new ModelAndView(getSuccessView(), model);
    }
    private String suggestBook(String favoriteProgrammingLanguage) {
      //  Language language = Language.create(favoriteProgrammingLanguage);
        return "c语言从入门到放弃";
    }
}
