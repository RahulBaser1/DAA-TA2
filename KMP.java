class KMP {
	void KMPSearch(String DNASequence, String DiscaseDNA) {
		int M = DNASequence.length();
		int N = DiscaseDNA.length();

		int check[] = new int[M];
		int j = 0;

		computeDiscaseDNA(DNASequence, M, check);

		int i = 0;
		while ((N - i) >= (M - j)) {
			if (DNASequence.charAt(j) == DiscaseDNA.charAt(i)) {
				j++;
				i++;
			}

			if (j == M) {
				System.out.println("DNA Sequence found at index " + (i - j));
				j = check[j - 1];
			}

			else if (i < N && DNASequence.charAt(j) != DiscaseDNA.charAt(i)) {
				if (j != 0)
					j = check[j - 1];
				else
					i = i + 1;
			}
		}
	}

	void computeDiscaseDNA(String DNASequence, int M, int check[])
	{
		int len = 0;
		int i = 1;
		check[0] = 0;

		
		while (i < M) {
			if (DNASequence.charAt(i) == DNASequence.charAt(len)) {
				len++;
				check[i] = len;
				i++;
			}
			else 
			{
				if (len != 0) {
					len = check[len - 1];
				}
				else {
					check[i] = len;
					i++;
				}
			}
		}
	}

	public static void main(String args[])
	{
		String DiscaseDNA = "AGC AGCTAG AGCGAGCTAGT";
		String DNASequence = "AGCTAGT";
		KMP DNA_SEQ = new KMP();
        DNA_SEQ.KMPSearch(DNASequence, DiscaseDNA);
	}
}
