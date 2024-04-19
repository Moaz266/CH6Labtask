package EJBs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
@Entity
public class Calculation
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column( name = "ID")
private int ID;
//@Column(name = "number1")
private int number1;
//@Column(name = "number2")
private int number2;
//@Column(name = "operation")
private String operation;




public Calculation()
{
	
}

public Calculation(int number1, int number2, String operation)
{
	this.number1=number1;
	this.number2=number2;
	this.operation=operation;
}

public void setID(int ID)
{
	this.ID=ID;
}

public void setnumber1(int number1)
{
	this.number1=number1;
}

public void setnumber2(int number2)
{
	this.number2=number2;
}

public void setOperation(String operation)
{
	this.operation=operation;
}



public int getID()
{
	return this.ID;
}
public String getOperation()
{
	return this.operation;
}

public int getnumber1()
{
	return this.number1;
}

public int getnumber2()
{
	return this.number2;
}



public int calculate()
{
	int result = 0;
	if(operation.equals("+")) 
	{
		result = number1 + number2;
	}
	else if(operation.equals("-"))
	{
		result = number1 - number2;
	}
	else if(operation.equals("*"))
	{
		result = number1 * number2;
	}
	else if(operation.equals("/"))
	{
		result = number1 / number2;
	}
	return result;
}

void saveOperations()
{
   EntityManagerFactory EMF = Persistence.createEntityManagerFactory("persistence");
   EntityManager EM = EMF.createEntityManager();
   
   try
   {
	   EM.getTransaction().begin();
	   EM.persist(this);
	   EM.getTransaction().commit();
   }
   catch(Exception x)
   {
	   EM.getTransaction().rollback();
   }
   EM.close();
}



}