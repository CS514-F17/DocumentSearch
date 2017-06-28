package inforetrieval;

//TODO: Import appropriate packages.

public class DocProcessor {

	//TODO: Declare data members

	/**
	 * Construct a new DocProcessor for documents identified
	 * by file names doc1 and doc2.
	 * @param doc1
	 * @param doc2
	 */
	public DocProcessor(String doc1, String doc2) {
		//TODO: Complete constructor
	}

	/**
	 * Return the cosine similarity of the documents
	 * specified by file names passed as input to the
	 * constructor. 
	 * 
	 * @return
	 */
	public double getCosineSimilarity() {
		//TODO: Replace with your code.
		return 0;
	}
	
	
	/**
	 * Return the number of lines of document 1 --
	 * the document specified by the first parameter
	 * of the constructor.
	 * @return
	 */
	public int getDoc1Lines() {
		//TODO: Replace with your code.
		return 0;
	}
	
	/**
	 * Return the number of lines of document 2 --
	 * the document specified by the second parameter
	 * of the constructor.
	 * @return
	 */
	public int getDoc2Lines() {
		//TODO: Replace with your code.
		return 0;
	}
	
	/**
	 * Return the number of total words in document 1 --
	 * the document specified by the first parameter
	 * of the constructor.
	 * @return
	 */	
	public int getDoc1Words() {
		//TODO: Replace with your code.
		return 0;
	}
	
	/**
	 * Return the number of total words of document 2 --
	 * the document specified by the second parameter
	 * of the constructor.
	 * @return
	 */
	public int getDoc2Words() {
		//TODO: Replace with your code.
		return 0;
	}
	
	/**
	 * Return the TF-IDF score of the given 
	 * word in the given document. If word
	 * does not appear in the corpus (either
	 * of the two documents) then the method returns
	 * 0. If doc does not specify a valid file name
	 * that matches either doc1 or doc2 then return
	 * -1. Otherwise return TF * IDF.
	 * TF = (number of times word appears in doc) / 
	 * 			(total number of words in doc)
	 * IDF = log ((total number of docs)/(number of docs containing word))
	 * log is base 10.
	 * 
	 * @param word
	 * @param doc
	 * @return
	 */
	public double getTFIDF(String word, String doc) {		
		//TODO: Replace with your code.
		return 0;
	}	
}
