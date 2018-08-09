import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!

// Partition source: https://en.wikipedia.org/wiki/URL

public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   /*
    * Testing: Manual tests
    * 
    */
   public void testManualTest()
   {
	   System.out.println("-----Manual Tests -----");
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);

	   String manualTrue[] = {"http://www.google.com",
			   				  "http://www.com",
			   				  "http://www.google.com:80/test/index.html/"
	   };
	   String manualFalse[] = {"httwwgoocom",
			   				  "12315",
			   				  "http://google.com///test1",
			   				  "C:/Programs/index.html",
	   };

	   System.out.println("Expected: True");
	   for(int i = 0; i < manualTrue.length; i++) {
		   System.out.printf("\"%s\" -- Result: ", manualTrue[i]);
		   System.out.printf("%b%n", urlVal.isValid(manualTrue[i]));
		   System.out.flush();
	   }
	   System.out.println("Expected: False");
	   for(int j = 0; j < manualFalse.length; j++) {
		   System.out.printf("\"%s\" -- Result: ", manualFalse[j]);
		   System.out.printf("%b%n", urlVal.isValid(manualFalse[j]));
		   System.out.flush();
	   }

   }
   
   /*
    * Testing: AUTHORITY
    * 
    */
   public void testYourFirstPartition()
   {
	   System.out.println("-----First Parition: Authority-----");
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   String authTrue[] = {"www.google.com",
			   				"255.255.255.255",
			   				"400.400.400.400",
			   				"80"
	   };
	   for(int i = 0; i < authTrue.length; i++) {
		   System.out.printf("\"%s\" -- Result: ", authTrue[i]);
		   System.out.printf("%b%n", urlVal.isValid("http://" + authTrue[i]));
		   System.out.flush();
	   }
   }
   
   /*
    * Testing: SCHEME
    * 
    */
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
	   
	   System.out.println();
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

   /*
    * Testing: PATH 
    * 
    */
   public void testYourThirdPartition(){
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //The second partition tests the PATH validation of isValid().
	   String testString;
	   String prefix = "http://www.google.com";
	   
	   String[] truePath = {"", 
			   				"/test1", 
			   				"/test1/", 
			   				"/t123", 
			   				"/123", 
			   				"/$23"};
	   
	   String[] falsePath = {"/..", 
			   					"/../", 
			   					"//.", 
			   					"//.//", 
			   					"/test1//file", 
			   					"//test/file"};
	   
	   
	   System.out.println();
	   System.out.println("-----Third Partition: Path-----");
	   
	   //test isValid() with supposedly valid URL's
	   for (int i = 0; i < truePath.length; i++) {
		   
		   testString = prefix + truePath[i];
		   
		   boolean result = urlVal.isValid(testString);
		   
		   System.out.println("\"" + testString + "\"" + "--	Expected: true;	Actual Result: " + result);
		   
		   testString = "";
	   }
	   
	   //test isValid() with supposedly invalid URL's
	   for (int j = 0; j < falsePath.length; j++) {
		   
		   testString = prefix + falsePath[j];
		   
		   boolean result = urlVal.isValid(testString);
		   
		   System.out.println("\"" + testString + "\"" + "--	Expected: false;	Actual Result: " + result);
		   
		   testString = "";
	   }
	   
 }
   
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}