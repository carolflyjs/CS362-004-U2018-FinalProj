

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //The first parameter is the EXPECTED value and we are asserting it against
	   //the returned value from isValid().
	   assertEquals(true, urlVal.isValid("http://www.google.com"));
	   assertEquals(false, urlVal.isValid("http://www.google.com:80/test/index.html"));
	   assertEquals(false, urlVal.isValid("http://google.com///test1"));
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //The first partition tests the AUTHORITY validation of isValid().
	   assertEquals(true, urlVal.isValid("http://www.google.com"));
	   assertEquals(true, urlVal.isValid("http://.google.com"));
	   assertEquals(true, urlVal.isValid("http://google.com"));
	   //assertEquals(false, urlVal.isValid("http://23r2.google.com")); //bug?
	   
   }
   
   public void testYourSecondPartition()
   {
	   //The second partition tests the SCHEME validation.
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   assertEquals(true, urlVal.isValid("http://www.google.com"));
	   //assertEquals(true, urlVal.isValid("h3t://www.google.com")); //bug?
	   //assertEquals(true, urlVal.isValid("www.google.com")); //bug?
	   
	   assertEquals(false, urlVal.isValid("3htp://www.google.com"));
	   assertEquals(false, urlVal.isValid("http//www.google.com"));
	   //assertEquals(false, urlVal.isValid("http:/www.google.com")); //bug?
	   assertEquals(false, urlVal.isValid("http:www.google.com"));
	   assertEquals(false, urlVal.isValid("://www.google.com"));
   }
   
   /*public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //The second partition tests the SCHEME validation of isValide().
	   String testString;
	   String prefix = "";
	   String[] trueSchemes = {"http://",
			   					"h3t://", 
			   					""};
	   
	   String[] falseSchemes = {"3htp://", 
			   					"http//", 
			   					"http:/", 
			   					"http:", 
			   					"://"};
	   
	   String otherParts = "www.google.com";
	   
	   
	   //test isValid() with supposedly valid URL's
	   for (int i = 0; i < trueSchemes.length; i++) {
		   
		   testString = trueSchemes[i] + otherParts;
		   
		   boolean result = urlVal.isValid(testString);
		   assertEquals(true, result);
		   
		   testString = "";
	   }
	   
	   //test isValid() with supposedly invalid URL's
	   for (int i = 0; i < falseSchemes.length; i++) {
		   
		   testString = prefix + falseSchemes[i] + otherParts;
		   
		   assertEquals(false, urlVal.isValid(testString));
		   
		   testString = "";
	   }
	   
   }*/
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
