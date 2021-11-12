package organizations;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

@Listeners(com.crm.vtiger.GenericUtils.ListenerImplementation.class)
public class ListnerPractice extends BaseClass
{
     @Test
     public void ListenerPractice()
     {
    	 System.out.println("testScript Failed");
    	 Assert.fail();
     }
}
