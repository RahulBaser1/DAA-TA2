# DAA-TA2

Aim: Implement KMP string pattern matching algorithm

Application: DNA Sequencing

KMP algorithm is linear sequence matching algorithm and plays an important role in bioinformatics, in DNA sequence matching. It is a forward linear sequence matching algorithm. It scans the strings from left to right.
In case of making comparisons if the current character doesn’t matches with that of the sequence, it doesn’t throw away all the information gained so far. Instead the algorithm calculates the new position from where to begin the search. Therefore KMP is called as an intelligent search algorithm.

Code Explanation:

Let, String "DNASequence" holds the DNA sequence, "DiscaseDNA" holds the diseased DNA sequence, "N" is the index for disease DNA sequence and "M" denotes the starting index of DNA sequence.

Check[] --> holds the longest prefix suffix values for DNASequence

KMPSearch(String DNASequence, String DiscaseDNA) {
    i <-- 0 //index for DNASequence
    j <-- 0 //index for DiscaseDNA

    while ((N - i) >= (M - j)) 
      //if character is same the increment both the index
			if (DNASequence.charAt(j) == DiscaseDNA.charAt(i)) 
				j++;
				i++;
			
      // print the location where the DNA sequence is found
			if (j == M) 
				System.out.println("Found DNASequence at index " + (i - j));
				j = check[j - 1];
			
      //mismatch after j is matches don't match check[0..j-1] characters, they will match anyway
			else if (i < N && DNASequence.charAt(j) != DiscaseDNA.charAt(i)) 
				if (j != 0)
					j = check[j - 1];

				else
					i = i + 1;

}

void computeDiscaseDNA(String DNASequence, int M, int check[]) {
		
    len <-- 0;
		i <-- 1;
		check[0] <-- 0; //check always start with 0

    // the loop calculates check[i] for i <-- 1 to M-1
		while (i < M) 
      // if char[DNASequence(i)] is equal to char[DNASequence(len)] then asignlen to check and increment len and i
			if (DNASequence.charAt(i) == DNASequence.charAt(len)) 
				len++;
				check[i] = len;
				i++;
			
      //if char[DNASequence(i)] is equal to char[DNASequence(len)]
			else 
				if (len != 0) 
					len = check[len - 1];
				// if len <-- 0
				else 
					check[i] = len;
					i++;		
}


