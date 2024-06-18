package vn.codegym.bt1.model;

public class Email {
    private String languages;
    private int pageSize;
    private String spamsFilter;
    private String signature;

    public Email() {
    }

    public Email(String languages, int pageSize, String spamsFilter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(String spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "Email{" +
                "languages='" + languages + '\'' +
                ", pageSize=" + pageSize +
                ", spamsFilter=" + spamsFilter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
