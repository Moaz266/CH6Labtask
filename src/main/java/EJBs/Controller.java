package EJBs;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.Past;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Application;
@Stateless
@Path ("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Controller{
//@Inject
//Calculation calculation;
@PersistenceContext(unitName="hello")
private EntityManager entityManager;
@POST
@Path("/calc")
public int calculate(Calculation c)
{
	int result=0;
	result = c.calculate();
	entityManager.persist(c);	return result;
}
@GET
@Path("/calculations")
public List<Calculation> getCalculations() {
    return entityManager.createQuery("SELECT c FROM Calculation c", Calculation.class).getResultList();
}
}
