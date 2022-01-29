package comcast_Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sample2_dataProvTest {
	 @Test(dataProvider= "bookTicketDataProvider")
	   public void bookTicketTest(String src,String dest) {
		   System.out.println("execute sourc==>"+src+",Destination==>"+dest);
		
	   }
	   @DataProvider
	   public Object[][] bookTicketDataProvider(){
		   Object[][] objArr=new Object[3][2];  
		   objArr[0][0]="Bangalore";
		   objArr[0][1]="Tumakuru";
		   
		   objArr[1][0]="Bangalore";
		   objArr[1][1]="Bijapur";
		  
		   objArr[2][0]="Bangalore";
		   objArr[2][1]="Chikmagaluru";
		  
		   return objArr;
	   }

}
