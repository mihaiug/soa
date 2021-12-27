package ro.ucv.inf.soa.ws.phonebook.rest;

import java.util.List;

import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import ro.ucv.inf.soa.ws.phonebook.exception.RecordNotFoundException;
import ro.ucv.inf.soa.ws.phonebook.model.Contact;
import ro.ucv.inf.soa.ws.phonebook.repository.ContactRepository;
import ro.ucv.inf.soa.ws.phonebook.repository.ContactRepositoryMemImpl;


@Path("contacts")
@Singleton // Needed to create only one instance. By default a new resource class instance is created for each request to that resource. 
public class ContactResource {

  private ContactRepository contactRepository;

  public ContactResource() {
    contactRepository = new ContactRepositoryMemImpl();
    System.out.println("Create instance of ContactResource");
  }

  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Contact> getAllContacts() {
    return contactRepository.findAll();
  }

  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Path("/{id}")
  public Contact getContactById(@PathParam("id") Long id) throws RecordNotFoundException {
    Contact contact = contactRepository.findOne(id);
    if (contact == null) {
      throw new RecordNotFoundException("Not found contact with id: " + id);      
    }
   return contact;
  }

  @POST
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Response addContact(@Valid Contact contact, @Context UriInfo uriInfo) {
    System.out.println("Add contact " + contact);
    contact.setId(null);
    contactRepository.save(contact);
    return Response.status(Response.Status.CREATED.getStatusCode())
        .header("Location", String.format("%s/%s",uriInfo.getAbsolutePath().toString(), contact.getId()))
        .build();
  }

  @PUT
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  @Path("/{id}")
  public void updateContact(@PathParam("id") Long id, @Valid Contact contact) throws RecordNotFoundException {
    contact.setId(id);
    contactRepository.save(contact);
  }

  @DELETE
  @Path("/{id}")
  public void deleteContact(@PathParam("id") Long id) throws RecordNotFoundException {
    contactRepository.delete(id);
  }

}
