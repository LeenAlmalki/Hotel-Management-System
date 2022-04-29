import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
class Doubleroom extends Singleroom implements Serializable
{ 
    String name2;
    String contact2;
    String email2;
    String id2;
    
    Doubleroom()
    {
        this.name="";
        this.name2="";
    }
    Doubleroom(String name,String contact,String email , String id,String name2,String contact2,String email2 , String id2)
    {
    		this.name=name;
	        this.contact=contact;
	        this.email=email;
	        this.id = id ;
	        this.name2=name2;
	        this.contact2=contact2;
	        this.email2=email2;
	        this.id2 = id2 ;
    }
}