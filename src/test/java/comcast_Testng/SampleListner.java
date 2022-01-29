package comcast_Testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;

@Listeners(com.crm.GenericLibrary.ListnerImpClass.class)
public class SampleListner extends BaseClass{
	@Test
	public void sample( ) throws Throwable{
		System.out.println("*******Test Start*******");
		Assert.assertEquals(false,true);
		System.out.println("*******Test End*******");
	}

}
