// @author  Samuel Lim

package ADT;

public class ADTStorage {

	private String[] ignoredWords;
	private String[] titles;

	public ADTStorage() {
	}

	public String[] getTitles() {

		return titles;
	}

	public String[] getIgnoredWords() {

		return ignoredWords;
	}

	public String[] insertTitles(String[] titles) {

		this.titles = titles;
		return this.titles;
	}

	public String[] insertIgnoredWords(String[] ignoredWords) {

		this.ignoredWords = ignoredWords;
		return this.ignoredWords;
	}
}
