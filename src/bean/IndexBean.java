package bean;

import entity.Person;
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
    private List<Person> personList;

    @PostConstruct
    public void init() {
        personList = PersonService.getInstance().findAll();
    }

    public void save() {
        PersonService.getInstance().save(person);
        msg="added successfully";
        init();
    }

    public void update(Person person) {
        PersonService.getInstance().update(person);
        msg="updated successfully";
        init();
    }

    public void delete(Person person) {
        PersonService.getInstance().delete(person);
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
        return "result.jsp?faces-redirect=true";
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
