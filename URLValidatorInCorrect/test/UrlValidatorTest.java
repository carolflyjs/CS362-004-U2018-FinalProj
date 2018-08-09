

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;
//import 

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   /*public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //The first parameter is the EXPECTED value and we are asserting it against
	   //the returned value from isValid().
	   assertEquals(true, urlVal.isValid("http://www.google.com"));
	   assertEquals(false, urlVal.isValid("http://www.google.com:80/test/index.html"));
	   assertEquals(false, urlVal.isValid("http://google.com///test1"));
	   
   }*/
   
   
   /*public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //The first partition tests the AUTHORITY validation of isValid().
	   assertEquals(true, urlVal.isValid("http://www.google.com"));
	   assertEquals(true, urlVal.isValid("http://.google.com"));
	   assertEquals(true, urlVal.isValid("http://google.com"));
	   assertEquals(false, urlVal.isValid("http://23r2.google.com")); //bug?
	   
   }*/
   
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //The second partition tests the SCHEME validation of isValide().
	   String testString;
	   
	   String[] trueSchemes = {"http://", 
			   					""};
	   
	   String[] falseSchemes = {"3htp://", 
			   					"http//", 
			   					"http:/", 
			   					"http:", 
			   					"://"};
	   
	   String otherParts = "www.google.com";
	   
	   System.out.println("-----Second Partition: Schemes-----");
	   
	   //test isValid() with supposedly valid URL's
	   for (int i = 0; i < trueSchemes.length; i++) {
		   
		   testString = trueSchemes[i] + otherParts;
		   
		   boolean result = urlVal.isValid(testString);
		   
		   System.out.println("\"" + trueSchemes[i]+ "\"" + "--	Expected: true;	Actual Result: " + result);
		   
		   testString = "";
	   }
	   
	   //test isValid() with supposedly invalid URL's
	   for (int j = 0; j < falseSchemes.length; j++) {
		   
		   testString = falseSchemes[j] + otherParts;
		   
		   boolean result = urlVal.isValid(testString);
		   
		   System.out.println("\"" + falseSchemes[j]+ "\"" + "--	Expected: false;	Actual Result: " + result);
		   
		   testString = "";
	   }
	   
   }
   //You need to create more test cases for your Partitions if you need to 
   
   
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
