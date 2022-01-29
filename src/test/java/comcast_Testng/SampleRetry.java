package comcast_Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;

public class SampleRetry extends BaseClass{
	@Test(retryAnalyzer= com.crm.GenericLibrary.RetryImpClass.class)
	public void retryTest() {
		Assert.assertEquals("A", "B");
	}

}
