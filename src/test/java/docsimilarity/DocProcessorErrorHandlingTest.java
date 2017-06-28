package docsimilarity;

import static org.junit.Assert.*;

import org.junit.Test;

public class DocProcessorErrorHandlingTest {

	@Test
	public void testInvalidFileName() {
		DocProcessor dp = new DocProcessor("BADNAME1", "BADNAME2");
		try {
			assertEquals("Incorrect cosine similarity for DocProcessor created with invalid file name", 0, dp.getCosineSimilarity(), 0.001);
		} catch(Exception e) {
			fail("getCosineSimilarity throws exception when called on DocProcessor created with invalid file name.");
		}
	}
	
}
