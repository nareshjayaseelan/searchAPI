package REST.REST_Automation;

import org.testng.annotations.DataProvider;


public class DataProviderSource {

    @DataProvider(name="TD_Search")
    public static Object[][] getClientSData() {

        return new Object[][] { 
        	 								{ "term=jack", "Jack Reacher" },
        	 								{ "term=jack+Reacher", "Jack Reacher" },
        	 								{ "term=jack.*", "Jack Reacher" },
        	 								{ "term=jack_", "Jack Reacher" },
        	 								{ "term=jack.", "Jack Reacher" },
        	 								{ "term=jack&Country=US", "Jack Reacher" },
        	 								{ "term=jack&Country=IN&media=movie", "Jack Reacher" },
        	 								{ "term=jack&Country=US&media=all", "Jack Reacher" },
        	 								{ "term=jack&Country=US&media=all&limit=1", "Jack Reacher" },
        	 								{ "term=jack&Country=US&media=all&limit=50", "Jack Reacher" },
        	 								{ "term=jack&Country=US&media=all&limit=200", "Jack Reacher" },
        	 								{ "term=12", "12 Years a Slave" },
        	 								{ "term=", "" },
        	 								{ "term=#$*().*", "Jack Reacher" },
        	 								{ "term=_", "Artifacture: IX. Mancando Nobilmente" },
        	 								{ "term=.", "." },
        	 								{ "term=jack&Country=OO", "Jack Reacher" },
        	 								{ "term=jack&Country=12&media=movie", "Jack Reacher" },
        	 								
        	 								{ "term=jack&Country=US&media=all&limit=0.1", "Jack Reacher" },
        	 								{ "term=jack&Country=US&media=all&limit=201", "Jack Reacher" },
        	 								};    

    }
    @DataProvider(name="TD_Search1")
    public static Object[][] getClientSData1() {

        return new Object[][] { 			{ "term=jack&Country=US&media=ALL", "400" },
				{ "term=jack&Country=US&media=internet&limit=1", "400" },};    

    }
}
