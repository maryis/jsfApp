# jsfApp

this app used myface(implementation of apache from jsf) and primefaces and hibernate-jpa

JavaServer Faces (JSF) is the Java standard technology (a specification) for building component-based, 
event-oriented web interfaces. Like JavaServer Pages (JSP), JSF allows access to server-side data and logic. Unlike JSP,
which is essentially an HTML page imbued with server-side capabilities, JSF is an XML document that represents formal components
in a logical tree. JSF components are backed by Java objects, which are independent of the HTML and have the full range of 
Java abilities, including accessing remote APIs and databases.

- two implementations: Oracle Mojarra and Apache MyFaces
- JSF component libraries : A component library is something which adds extra functionality (normally extra UI widgets) 
to the base specification such as primefaces, icefaces, richfaces
--------------defining beans -------------------------
on top of a managedbean class:
@ManagedBean  [(name = "helloWorld", eager = true)]
@RequestScoped ( @ViewScoped   @SessionScoped   @ApplicationScoped)
------------page redirection in jsf --------------------
JSF by default performs a server page forward(dispatch) while navigating to another page and the URL of 
the application does not change.
To enable the page redirection, append faces-redirect=true at the end of the view name.
different ways:
 returning void in action method means remain in the same page
 return "result.jsf?faces-redirect=true";  --> redirect to page
 return "result";  --> dispatch to result.jsf page , it is called Auto Navigation
 seting name of view in action attribute of ...
 ---------------------@ManagedProperty Annotation-----------------------
 JSF is a simple static Dependency Injection (DI) framework. Using @ManagedProperty annotation, 
 a managed bean's property can be injected in another managed bean.
--------------xhtml-------------------------------------
Today's market consists of different browser technologies. Some browsers run on computers, and some browsers run on mobile phones
 or other small devices. Smaller devices often lack the resources or power to interpret "bad" markup.

XML is a markup language where documents must be marked up correctly (be "well-formed"), while html allows bad markup.
XHTML was developed by combining the strengths of HTML and XML(after html4) . XHTML is HTML redesigned as XML which:
- XHTML DOCTYPE is mandatory
- The xmlns attribute in <html> is mandatory
- <html>, <head>, <title>, and <body> are mandatory
- XHTML elements must be properly nested(in order)
- XHTML elements must always be closed
- XHTML elements must be in lowercase
- XHTML documents must have one root element
- Attribute names must be in lower case
- Attribute values must be quoted
- Attribute minimization is forbidden
 
------------------html5------------------
Much of what XHTML was designed to do has been covered with the launch of HTML5, however, making it nearly obsolete.
The most interesting new HTML5 elements are: 
- New semantic elements like <header>, <footer>, <article>, and <section>.
- New attributes of form elements like number, date, time, calendar, and range.
- New graphic elements: <svg> and <canvas>.
- New multimedia elements: <audio> and <video>.
The most interesting new APIs in HTML5 are:
- HTML Geolocation
- HTML Drag and Drop
- HTML Local Storage
- HTML Application Cache
- HTML Web Workers
- HTML SSE
-----------------------semantic web-----------------------------
According to the W3C, a Semantic Web: "Allows data to be shared and reused across applications, enterprises, and communities."
With HTML4, developers used their own id/class names to style elements: header, top, bottom, footer, menu, navigation, main, container, 
content, article, sidebar, topnav, etc.
This made it impossible for search engines to identify the correct web page content.
With the new HTML5 elements (<header> <footer> <nav> <section> <article>), this will become easier.
