package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	
	@Test(groups= {"regression","master"})
	void test_account_registration()
	{
		logger.info(" ******* Starting TC_001_AccountRegistrationTest *******");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		
		hp.clickRegister();
		logger.info("clicked on Register");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		
		regpage.setFirstName(randomeString().toUpperCase());
		logger.info("Provided first name");
		
		regpage.setLastName(randomeString().toUpperCase());
		logger.info("Provided last name");
		
		
		regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the email
		logger.info("Provide email");
		
		
		regpage.setTelephone(randomeNumber());
		logger.info("Provided telephone");
		
		
		regpage.setPassword("test@123");
		logger.info("Provided password");
		
		regpage.setConfirmPassword("test@123");
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("Provided telephoneclick on continue");
		
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Registration test failed....");
			Assert.fail();
		}
				
		logger.info(" ******* Finesh TC_001_AccountRegistrationTest ******");
	}
	
}
