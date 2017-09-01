package docsimilarity;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class DocProcessorSimpleTest {

	private static DocProcessor dp;
	private static String doc1 = "input/simple1.txt";
	private static String doc2 = "input/simple2.txt";
	
	@BeforeClass
	public static void setUpBeforeClass() {
		dp = new DocProcessor(doc1, doc2);
	}
	
	@Test
	public void testCosineSimilarity() {		
		assertEquals("Invalid Cosine Similarity value for " + doc1 + " " + doc2, 0.7144, dp.getCosineSimilarity(), 0.001);
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
		assertEquals("Incorrect word count for " + doc1, 6, dp.getDoc1Words());
	}

	@Test
	public void testDoc2Words() {
		assertEquals("Incorrect word count for " + doc2, 8, dp.getDoc2Words());
	}

}
