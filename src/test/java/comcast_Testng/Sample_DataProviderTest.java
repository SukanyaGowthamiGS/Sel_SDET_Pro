package comcast_Testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sample_DataProviderTest {
	
   @Test(dataProvider= "bookTicketDataProvider")
   public void bookTicketTest(String src,String dest,int ticket) {
	   System.out.println("execute sourc==>"+src+",Destination==>"+dest);
	
   }
   @DataProvider
   public Object[][] bookTicketDataProvider(){
	   Object[][] objArr=new Object[5][3];  
	   objArr[0][0]="Bangalore";
	   objArr[0][1]="Tumakuru";
	   objArr[0][2]=4;
	   
	   objArr[1][0]="Bangalore";
	   objArr[1][1]="Bijapur";
	   objArr[1][2]=3;
	   
	   objArr[2][0]="Bangalore";
	   objArr[2][1]="Chikmagaluru";
	   objArr[2][2]=2;
	   
	   objArr[3][0]="Bangalore";
	   objArr[3][1]="kerala";
	   objArr[3][2]=2;
	   
	   objArr[4][0]="Bangalore";
	   objArr[4][1]="Mysuru";
	   objArr[4][2]=1;
	   
	   return objArr;
	   
   }
}
