package docsimilarity;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import inforetrieval.DocProcessor;

public class DocProcessorComplexTest {

	private static DocProcessor dp;
	private static String doc1 = "input/prideandprejudice.txt";
	private static String doc2 = "input/warandpeace.txt";
	
	@BeforeClass
	public static void setUpBeforeClass() {
		dp = new DocProcessor(doc1, doc2);
	}
	
	@Test
	public void testCosineSimilarity() {		
		assertEquals("Invalid Cosine Similarity value for " + doc1 + " " + doc2, 0.9243, dp.getCosineSimilarity(), 0.001);
	}

	@Test
	public void testDoc1Lines() {
		assertEquals("Incorrect line count for " + doc1, 13427, dp.getDoc1Lines());
	}

	@Test
	public void testDoc2Lines() {
		assertEquals("Incorrect line count for " + doc2, 66051, dp.getDoc2Lines());
	}
	
	@Test
	public void testDoc1Words() {
		assertEquals("Incorrect word count for " + doc1, 127032, dp.getDoc1Words());
	}

	@Test
	public void testDoc2Words() {
		assertEquals("Incorrect word count for " + doc2, 580838, dp.getDoc2Words());
	}

}
