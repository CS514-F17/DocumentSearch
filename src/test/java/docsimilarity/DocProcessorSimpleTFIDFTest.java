package docsimilarity;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import inforetrieval.DocProcessor;

public class DocProcessorSimpleTFIDFTest {

	private static DocProcessor dp;
	private static String doc1 = "input/simple3.txt";
	private static String doc2 = "input/simple4.txt";
	
	
	@BeforeClass
	public static void setUpBeforeClass() {
		dp = new DocProcessor(doc1, doc2);
	}
	
	@Test
	public void testTFIDFDoc1() {		
		assertEquals("Invalid TF-IDF value for tfidf(\"example\", doc1) ", 0.0, dp.getTFIDF("example", doc1), 0.001);
	}

	@Test
	public void testTFIDFDoc2() {		
		assertEquals("Invalid TF-IDF value for tfidf(\"example\", doc2) ", 0.129, dp.getTFIDF("example", doc2), 0.001);
	}

	@Test
	public void testDoc1Lines() {
		assertEquals("Incorrect line count for " + doc1, 1, dp.getDoc1Lines());
	}

	@Test
	public void testDoc2Lines() {
		assertEquals("Incorrect line count for " + doc2, 1, dp.getDoc2Lines());
	}
	
	@Test
	public void testDoc1Words() {
		assertEquals("Incorrect word count for " + doc1, 5, dp.getDoc1Words());
	}

	@Test
	public void testDoc2Words() {
		assertEquals("Incorrect word count for " + doc2, 7, dp.getDoc2Words());
	}

}
