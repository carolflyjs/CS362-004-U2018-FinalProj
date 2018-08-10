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
   
   /*
    *  Bug scenarios 
    *  	-> h3t / https (regex error)
    *   -> http:/ (passing but should fail)
    *   -> /test1/ (failing but should be true)
    *   -> www.google (true but should be false)
    *   -> www.google.com//  (passing, but should fail)
    */     

   public void testManualTest()
   {
	   System.out.println("-----Manual Tests -----");
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);

	   String manualTest[] = {"http://www.google.com",
			   				  "http://www.com",
			   				  "http://www.google.com:80/test/index.html/",
			   				  "http:/google.com",
			   				  "httwwgoocom",
			   				  "12315",
			   				  "http://google.com///test1",
			   				  "C:/Programs/index.html",
			   				  "www3.google.com"

	   };

	   System.out.println("Expected: True");
	   for(int i = 0; i < manualTest.length; i++) {
		   System.out.printf("\"%s\" -- Result: ", manualTest[i]);
		   System.out.printf("%b%n", urlVal.isValid(manualTest[i]));
		   System.out.flush();
	   }
   }
   
   /*
    * 
    */
   public void testYourFirstPartition()
   {
	   System.out.println("-----First Parition: Authority-----");
	   UrlValidator urlVal = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   String auth[] = {"255.255.255.255",
			   			"400.400.400.400",
			   			"80",
			   			"google",
			   			"google.com",
			   			"google..",
			   			"google.com//",
			   			"google.com/facebook",
			   			"google.com/..facebook"
	   };
	   for(int i = 0; i < auth.length; i++) {
		   System.out.printf("\"%s\" -- Result: ", auth[i]);
		   System.out.printf("%b%n", urlVal.isValid("http://" + auth[i]));
		   System.out.flush();
	   }
   }
   
   /*
    * 
    */
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //The second partition tests the SCHEME validation of isValide().
	   String testString;
	   
	   String[] Schemes = {"http://", 
			   				"",
			   				"www.",
			   				"www3.",
			   				"https://",
			   				"3htp://", 
			   				"http//", 
			   				"http:/", 
			   				"http:", 
			   				"://"
			   				};
	   
	   String otherParts = "www.google.com";
	   
	   System.out.println();
	   System.out.println("-----Second Partition: Schemes-----");
	   
	   //test isValid() with supposedly valid URL's
	   for (int i = 0; i < Schemes.length; i++) {
		   
		   testString = Schemes[i] + otherParts;
		   
		   boolean result = urlVal.isValid(testString);
		   
		   System.out.println("\"" + Schemes[i]+ "\"" + "--	Result: " + result);
		   
		   testString = "";
	   }
   }

   /*
    * 
    */
   public void testYourThirdPartition(){
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   //The second partition tests the PATH validation of isValid().
	   String testString;
	   String prefix = "http://www.google.com";
	   
	   String[] Path = {"", 
			   				"/test1", 
			   				"/test1/", 
			   				"/t123", 
			   				"/123", 
			   				"/$23",
			   				"/..", 
			   				"/../", 
			   				"//.", 
			   				"//.//", 
			   				"/test1//file", 
			   				"//test/file"};
	   
	   
	   System.out.println();
	   System.out.println("-----Third Partition: Path-----");
	   
	   //test isValid() with supposedly valid URL's
	   for (int i = 0; i < Path.length; i++) {
		   
		   testString = prefix + Path[i];
		   
		   boolean result = urlVal.isValid(testString);
		   
		   System.out.println("\"" + testString + "\"" + "-- Result: " + result);
		   
		   testString = "";
	   }
 }
   
   
   public void testIsValid()
   {
	   //     first partition: www, ht3
	   //     second partition: google.com 123..com
	   //     test set:
	   //       www.google.com
	   //       www.123..com
	   //       ht3.google.com
	   //       ht3.123..com
	   System.out.print("Overall Test: \n");
	   UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);

	   String[] myUrlFirstPartition = {
			   "www.",
			   "www3.",
			   "http://",
			   "http://www.",
			   //"h3t://google.com",
			   "https://",
			   "h3t://"
	   };
	   
	   boolean[] expected1 = {
			   true,
			   false,
			   true,
			   true,
			   //false,
			   true,
			   false
	   };
	   
	   String[] myUrlSecondPartition = {
			   "google",
			   "google.com",
			   "google..",
			   "google.com//",
			   "google.com/facebook",
			   "google.com/..facebook"
	   };
	   
	   boolean[] expected2 = {
			   true,
			   true,
			   false,
			   false,
			   //false,
			   true,
			   false
	   };
	   
	   for (int i = 0; i < myUrlFirstPartition.length; i++) {
		   for (int j = 0; j < myUrlSecondPartition.length; j++) {
			   String testSubject = myUrlFirstPartition[i] + myUrlSecondPartition[j];
			   System.out.print(testSubject + ": ");
			   if (urlTest.isValid(testSubject) == (expected1[i] && expected2[j])) {
				   System.out.print("Pass\n");
			   }
			   else
				   System.out.print("Fail\n");
		   }
	   }

	   System.out.print("\n\n");
   }
}
   