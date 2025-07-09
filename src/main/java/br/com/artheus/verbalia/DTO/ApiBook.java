package br.com.artheus.verbalia.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiBook {
    private String title;

    private List<String> languages;

    @JsonProperty("download_count")
    private int downloadCount;

    @JsonProperty("authors")
    private List<ApiAuthor> authors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<ApiAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<ApiAuthor> authors) {
        this.authors = authors;
    }

    public String getAuthorName() {
        return (authors != null && !authors.isEmpty()) ? authors.get(0).getName() : "Unknown";
    }

    public Integer getAuthorBirthYear() {
        return (authors != null && !authors.isEmpty()) ? authors.get(0).getBirthYear() : null;
    }

    public Integer getAuthorDeathYear() {
        return (authors != null && !authors.isEmpty()) ? authors.get(0).getDeathYear() : null;
    }

    public String getLanguage() {
        return (languages != null && !languages.isEmpty()) ? languages.get(0) : null;
    }
}
