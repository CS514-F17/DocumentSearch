Project 1 - Document Search Helper
==================================

### Due TBD

*This project description is incomplete and subject to change.*

The goal of this project is to implement two techniques used in data mining: cosine similarity and term frequency-inverse document frequency (TF-IDF). You will use the following programming concepts:

- File Input
- Iteration
- Classes
- Methods
- `ArrayList`

### Cosine Similarity

[Cosine similarity](https://en.wikipedia.org/wiki/Cosine_similarity) measures the cosine of the angle between two vectors. In information retrieval and data mining it is used as a measure of the similarity between two documents. Each document is represented as a multidimensional vector and the similarity is the cosine of the angle between the vectors.

Cosine similarity is calculated as follows:

<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/1e1fccd8f6d7c2acccde3c9426a795c4b9570c27" width="300">

> where Ai and Bi are components of vector A and B respectively.
> 
>  https://en.wikipedia.org/wiki/Cosine_similarity

The cosine similarity of two documents that contain exactly the same (unordered) set of words will be 1. Two documents that contain none of the same words will be 0.

Practically, to compare two documents you will need to implement the following algorithm:

#### Step 1: Create a *score vector* for each document. 

Consider the following two documents:

```
Document 1: The cat and the dog ran.
Document 2: The fuzzy cat and the furry cat played.
```

First, we need a vector of the union of all words that appear in either document:

```
["the", "cat", "and", "dog", "ran", "fuzzy", "furry", "played"]
```

For each document, we need a vector that represents the count of the number of times each word appears in the document. The score vector document 1 would be as follows:

```
[2, 1, 1, 1, 1, 0, 0, 0]
```

This indicates that the word "the" appears twice in document 1. The word "cat" appears once, the word "fuzzy" appears 0 times.

And for document 2:

```
[2, 2, 1, 0, 0, 1, 1, 1]
```

Note the following:

- The word count at position *i* of the document vector corresponds to the word at position *i* of the word vector.
- The score vectors for each document are exactly the same length.
- 0 is a valid value in the score vector and means that the *ith* word of the word vector does not appear in the document.
- The result is case *insensitive* and does not consider punctuation.

#### Step 2: Calculate the Cosine Similarity.

The numerator is the [vector dot product](https://www.mathsisfun.com/algebra/vectors-dot-product.html) of the two score vectors.

The denominator is the product of the square root of the vector dot product of each vector with itself.

In the example above, the numerator is calculated as follows:

```
(2*2) + (1*2) + (1*1) + (1*0) + (1*0) + (0*1) + (0*1) + (0*1) = 7
```

The denominator is calculated as follows:

```
Vector 1: sqrt((2*2) + (1*1) + (1*1) + (1*1) + (1*1) + (0*0) + (0*0) + (0*0)) = 2.83
Vector 2: sqrt((2*2) + (2*2) + (1*1) + (0*0) + (0*0) + (1*1) + (1*1) + (1*1)) = 3.46
Denominator: 2.83 * 3.46 = 9.792
```

Therefore, `Cosine Similarity = 7/(2.83*3.46) = .71`

### TF-IDF

[Term Frequency - Inverse Document Frequency](https://en.wikipedia.org/wiki/Tf%E2%80%93idf)  (TF-IDF) is a measure of how important a word is in a collection of documents (or corpus). 

While cosine similarity returns a single number to compare two documents TF-IDF calculates a score for a single word in a single document, for example we could calculate the score for the word "fuzzy" in Document 2, or the word "cat" in Document 1.

TF-IDF is the product of the term frequency and the inverse document frequency.

Term frequency (TF) is the number of times a word appears in a document divided by the total number of words in that document, for example tf("fuzzy", document2) is `1/8` since the word "fuzzy" appears once and there are eight total words in the document. 

TF gives us a good measure of how important a word is in a document. A word that appears often will have a higher value than a word that appears infrequently.

Some words, for example "the" or "and", appear many times in all documents. Inverse document frequency (IDF) reduces the weight of the term if it appears in many documents.

IDF is calculated as `log( (total number of documents)/(documents containing word))` where log base 10 should be used in your solution.

TF-IDF is then `TF * IDF`.

### Assignment Specification

**API:** You are required to implement the API defined in [`DocProcessor`](https://github.com/CS514-F17/DocumentSearchHelper/blob/master/src/main/java/docsearch/DocProcessor.java). To pass the required test cases you *must* implement every method exactly as specified. Do not modify the signatures of the methods provided or the names of the classes provided.

The API includes methods to calculate Cosine Similarity and TF-IDF, and also methods to retrieve the line count and word count for each of the two documents passed as input to the constructor.

You are expected to create additional classes and methods as appropriate. In my solution I created a separate class that holds some basic statistics about each document and a `Driver` that I used for testing as I developed my solution. I also had several helper methods that performed specific functionality, like calculating just the IDF portion of the TF-IDF score.

:warning: You are expected to implement code that tests your solution as you develop it. It is recommended you create a `Driver` with a `main` method that contains code to test your solution. Do not rely only on the test cases provided!

**Testing:** There are five sets of test cases you must pass for full credit. 

:warning: Do **not** modify the test cases provided. 

The TF-IDF portion of the assignment is designed to be more challenging and is worth only 10% of the final grade. It is expected that you will need to do some additional *independent* research on TF-IDF to complete your solution. You may still earn 90% of the grade if you do pass `DocProcessorSimpleTFIDFTest` and `DocProcessorComplexTFIDFTest`.


### Hints, Notes, and Requirements (read carefully!)

1. Make use of the [Java 8 API](https://docs.oracle.com/javase/8/docs/api/) as you complete your solution. You may need to explore methods available to you in `ArrayList`, `Scanner`,  `String`, and `Math`.
  * To `split` a `String` on one *or more* white spaces you may use a regular expression as follows`str.split("\\s+")`. 
  * To remove all non-alphanumeric characters from a string you may `replaceAll` specifying the regular expression `"\\W"` as the pattern to be replaced.
2. The `input` directory contains the txt files that are used by the test cases. *Do not modify the existing files in this directory*. You may download additional files to use for testing. Some of the test cases use large texts downloaded from [Project Gutenberg](https://www.gutenberg.org/)


### Submission Requirements

1. Use the following link to create your private github repository for this assignment. The repository will be seeded with the skeleton code, test cases, and input files. [Document Search Helper](https://classroom.github.com/assignment-invitations/65d0f58c1b59da38b24354cab60158b1)
2. For full credit, make sure to follow all [Style Guidelines](https://github.com/CS514-F17/notes/blob/master/Admin/style.md). Points will be deducted for each violation.
3. Revisit the notes about setting up your development environment to make sure you are using github correctly: [Setting up your development environment](https://github.com/CS514-F17/notes/blob/master/Admin/devenvironment.md)

### Grading Rubric

| Points | Criterion |
| ------ | -------- |  
| 30 | DocProcessorSimpleTest |
| 30 | DocProcessorComplexTest | 
| 5 | DocProcessorErrorHandlingTest | 
| 5 | DocProcessorSimpleTFIDFTest |
| 5 | DocProcessorComplexTFIDFTest | | 
| 15 | Design |
| 10 | Style |

Partial credit may be awarded for partial functionality and/or partially correct design or style elements.

### Academic Dishonesty

Any work you submit is expected to be your own original work. If you use any web resources in developing your code you are strongly advised to cite those resources. The only exception to this rule is code that is posted on the class website. The URL of the resource you used in a comment in your code is fine. If I google even a single line of uncited code and find it on the internet you may get a 0 on the assignment or an F in the class. You may also get a 0 on the assignment or an F in the class if your solution is at all similar to that of any other student.
