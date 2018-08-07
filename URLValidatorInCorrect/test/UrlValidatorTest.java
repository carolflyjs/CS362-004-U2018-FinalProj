

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
	   // MANUAL TEST 1
	   String test1 = "http://www.google.com";
	   System.out.printf("Testing %s%n", test1);
	   boolean res =  urlVal.isValid(test1);
	   if (res) {
		   System.out.printf("PASS: %b%n", res); 
	   } else {
		   System.out.printf("FAIL: %b%n", res);
	   }
	   assertTrue(res);
	   
	   assertTrue(urlVal.isValid("http://www.google.com/index.html"));
	   //assertTrue(urlVal.isValid("http://www.google.com:80/test/index.html"));
	   //assertTrue(urlVal.isValid("http://google.com///test1"));
   }
   
  
   /*
    *  the first partition: "www" of www.google.com
    * 
    */
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   
	  UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	  assertTrue(urlVal.isValid("http://www.google.com"));
	  assertTrue(urlVal.isValid("http://.google.com"));
	  assertTrue(urlVal.isValid("http://google.com"));
	  assertTrue(urlVal.isValid("http://23r2.google.com"));
   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }

   public static void main(String[] argv) {
		  UrlValidatorTest fct = new UrlValidatorTest("url test");
	      fct.testManualTest();
	      fct.testYourFirstPartition();
	   } 
}
