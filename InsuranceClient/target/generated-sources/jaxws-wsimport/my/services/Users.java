
package my.services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Users", targetNamespace = "http://services.my/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Users {


    /**
     * 
     * @param password
     * @param userName
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "authenticate", targetNamespace = "http://services.my/", className = "my.services.Authenticate")
    @ResponseWrapper(localName = "authenticateResponse", targetNamespace = "http://services.my/", className = "my.services.AuthenticateResponse")
    @Action(input = "http://services.my/Users/authenticateRequest", output = "http://services.my/Users/authenticateResponse")
    public String authenticate(
        @WebParam(name = "UserName", targetNamespace = "")
        String userName,
        @WebParam(name = "Password", targetNamespace = "")
        String password);

    /**
     * 
     * @param users
     * @return
     *     returns java.util.List<my.services.User>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getUsers", targetNamespace = "http://services.my/", className = "my.services.GetUsers")
    @ResponseWrapper(localName = "getUsersResponse", targetNamespace = "http://services.my/", className = "my.services.GetUsersResponse")
    @Action(input = "http://services.my/Users/getUsersRequest", output = "http://services.my/Users/getUsersResponse")
    public List<User> getUsers(
        @WebParam(name = "Users", targetNamespace = "")
        String users);

    /**
     * 
     * @param password
     * @param phoneNumber
     * @param userName
     * @param user
     * @param email
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "register", targetNamespace = "http://services.my/", className = "my.services.Register")
    @ResponseWrapper(localName = "registerResponse", targetNamespace = "http://services.my/", className = "my.services.RegisterResponse")
    @Action(input = "http://services.my/Users/registerRequest", output = "http://services.my/Users/registerResponse")
    public String register(
        @WebParam(name = "UserName", targetNamespace = "")
        String userName,
        @WebParam(name = "Password", targetNamespace = "")
        String password,
        @WebParam(name = "PhoneNumber", targetNamespace = "")
        String phoneNumber,
        @WebParam(name = "Email", targetNamespace = "")
        String email,
        @WebParam(name = "User", targetNamespace = "")
        String user);

}