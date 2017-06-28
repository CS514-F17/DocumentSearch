package docsearch;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class DocProcessorComplexTFIDFTest {

	private static DocProcessor dp;
	private static String doc1 = "input/prideandprejudice.txt";
	private static String doc2 = "input/donquijotespan.txt";
	
	
	@BeforeClass
	public static void setUpBeforeClass() {
		dp = new DocProcessor(doc1, doc2);
	}
	
	@Test
	public void testTFIDFDoc1() {		
		assertEquals("Invalid TF-IDF value for tfidf(\"example\", doc1) ", 0.0, dp.getTFIDF("el", doc1), 0.001);
	}

	@Test
	public void testTFIDFDoc2() {		
		assertEquals("Invalid TF-IDF value for tfidf(\"example\", doc2) ", 0.006315, dp.getTFIDF("el", doc2), 0.001);
	}

	@Test
	public void testDoc1Lines() {
		assertEquals("Incorrect line count for " + doc1, 13427, dp.getDoc1Lines());
	}

	@Test
	public void testDoc2Lines() {
		assertEquals("Incorrect line count for " + doc2, 37861, dp.getDoc2Lines());
	}
	
	@Test
	public void testDoc1Words() {
		assertEquals("Incorrect word count for " + doc1, 127032, dp.getDoc1Words());
	}

	@Test
	public void testDoc2Words() {
		assertEquals("Incorrect word count for " + doc2, 391352, dp.getDoc2Words());
	}

}
