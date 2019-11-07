package bean;

import entity.Person;
import exception.DBException;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import service.PersonService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@RequestScoped
public class IndexBean {

    private Person person=new Person();
    private String msg;
    private Person selectedPerson;
    private List<Person> personList;


    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    /////////////////////////////////

    //@PostConstruct is the contract that guarantees that this method will be invoked only once in the bean lifecycle
    //    Such a method take no arguments, return void
    //the dif with constructor: it is called after all initializations and setters
    @PostConstruct
    public void init() {
        try {
            personList = PersonService.getInstance().findAll();
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            PersonService.getInstance().save(person);
        } catch (DBException e) {
            e.printStackTrace();
        }
        msg="added successfully";
        init();
    }

    public void update(Person person) {
        try {
            PersonService.getInstance().update(person);
        } catch (DBException e) {
            e.printStackTrace();
        }
        msg="updated successfully";
        init();
    }

    public void delete(Person person) {  //returning void in action method means remain in the same page
        try {
            PersonService.getInstance().delete(person);
        } catch (DBException e) {
            e.printStackTrace();
        }
        msg="deleted successfully";
        init();
    }
    public String searchDisatch() {  //dispatch

        init();
        msg="dispatched";
        return "result";
    }
    public String searchRedirect() {  //redirect

       // init();
        msg="redirected";
        return "result.jsf?faces-redirect=true";
    }

    /////prime faces event
//    public void onRowSelect(SelectEvent event) {
//        FacesMessage msg = new FacesMessage("Person Selected", ((Person) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
//
//    public void onRowUnselect(UnselectEvent event) {
//        FacesMessage msg = new FacesMessage("Person Unselected", ((Person) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
}
