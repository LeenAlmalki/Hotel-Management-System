import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class Singleroom implements Serializable{

		String name;
	    String contact;
	    String email; 
	    String id;
	    ArrayList<Food> food =new ArrayList<>();

	   
	    Singleroom()
	    {
	        this.name="";
	    }
	    Singleroom(String name,String contact,String email , String id)
	    {
	        this.name=name;
	        this.contact=contact;
	        this.email=email;
	    } 

}
