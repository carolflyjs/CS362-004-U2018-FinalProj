

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }



   public static void testManualTest()
   {
	   UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   System.out.print("Manual Test: \n");
	   String[] myUrlArray = {
			   "www.google.com",
			   "www3.google.com",
			   "http://google.com",
			   "http://www.google.com",
			   //"h3t://google.com",
			   "http://google.com/facebook",
			   "http://google.com//facebook",
			   "google.com/facebook./", 
			   "http:/google.com",
			   "http:google.com"
	   };
	   for (int i = 0; i < myUrlArray.length; i++) {
		   System.out.print(myUrlArray[i] + ": ");
		   System.out.print(urlTest.isValid(myUrlArray[i]) + "\n");

	   }
	   System.out.print("\n\n");
	   
	   
//You can use this function to implement your manual testing
//  Is this test taking several full URLs as input and print True/False as the results without comparing them to expected results?
   }


   public static void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   
	   UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);

	   System.out.print("First Partition Test: \n");

	   String myUrlSecondPartition = "google.com";
	   String[] myUrlFirstPartition = {
			   "www.",
			   "www3.",
			   "http://",
			   "http://www.",
			   //"h3t://google.com",
			   "https://",
			   "h3t://"
	   };
	   
	   boolean[] expected = {
			   true,
			   false,
			   true,
			   true,
			   //false,
			   true,
			   false
	   };
	   
	   for (int i = 0; i < myUrlFirstPartition.length; i++) {
		   System.out.print(myUrlFirstPartition[i] + ": ");
		   if (urlTest.isValid(myUrlFirstPartition[i] + myUrlSecondPartition) == expected[i]) {
			   System.out.print("Pass\n");
		   }
		   else
			   System.out.print("Fail\n");
//		   System.out.print(urlTest.isValid(myUrlFirstPartition[i] + myUrlSecondPartition) + "\n");

	   }
	   System.out.print("\n\n");
   }

   public static void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing
	   UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);

	   System.out.print("Second Partition Test: \n");

	   String myUrlFirstPartition = "www.";
	   String[] myUrlSecondPartition = {
			   "google",
			   "google.com",
			   "google..",
			   "google.com//",
			   "google.com/facebook",
			   "google.com/..facebook"
	   };
	   
	   boolean[] expected = {
			   true,
			   true,
			   false,
			   false,
			   //false,
			   true,
			   false
	   };
	   
	   for (int i = 0; i < myUrlSecondPartition.length; i++) {
		   System.out.print(myUrlSecondPartition[i] + ": ");
		   if (urlTest.isValid(myUrlFirstPartition + myUrlSecondPartition[i]) == expected[i]) {
			   System.out.print("Pass\n");
		   }
		   else
			   System.out.print("Fail\n");
//		   System.out.print(urlTest.isValid(myUrlFirstPartition[i] + myUrlSecondPartition) + "\n");

	   }
	   System.out.print("\n\n");
   }
   //You need to create more test cases for your Partitions if you need to

   public void testIsValid()
   {
	   //You can use this function for programming based testing
//     Are we generating test set (full URLs) from given partitions?
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
