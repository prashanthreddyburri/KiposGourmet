package gourmet.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gourmet.qa.base.TestBase;
import gourmet.qa.pages.KiposPOSOpenRegisterPage;
import gourmet.qa.pages.LandingPOSLoginPage;

public class LandingPOSLoginPageTest extends TestBase
{
	LandingPOSLoginPage landingPOSLoginPage;
	KiposPOSOpenRegisterPage kiposPOSOpenRegisterPage;
	
	
	public LandingPOSLoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		landingPOSLoginPage = new LandingPOSLoginPage();	
	}
	
	
	@Test(priority=1,groups = "LandingPOSLoginPage")
	public void loginPageTitleTest(){
		String title = landingPOSLoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Kipos Pos");
	}
	
	@Test(priority=2, groups = "LandingPOSLoginPage")
	public void validateKiposLogoTest(){
		boolean flag = landingPOSLoginPage.validateKiposLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3, groups = "LandingPOSLoginPage")
	public void validateKiposPOSHeadingTest(){
		boolean flagPOS = landingPOSLoginPage.validateKiposPOSHeading();
		Assert.assertTrue(flagPOS);
	}
	
	@Test(priority=4)
	public void validateLoginEmailTxtboxTest(){
		boolean flagUser = landingPOSLoginPage.validateLoginEmailTxtbox();
		Assert.assertTrue(flagUser);
	}
	
	@Test(priority=5)
	public void validateLoginPasswordTxtboxTest(){
		boolean flagPassword = landingPOSLoginPage.validateLoginPasswordTxtbox();
		Assert.assertTrue(flagPassword);
	}
	
	
	@Test(priority=6)
	public void validateLoginBtnTest(){
		boolean flagLoginBtn = landingPOSLoginPage.validateLoginBtn();
		Assert.assertTrue(flagLoginBtn);
	}
	
	
	@Test(priority=7)
	
	public void loginTest(){
		kiposPOSOpenRegisterPage = landingPOSLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	

}
