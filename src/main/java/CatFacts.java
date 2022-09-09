import com.fasterxml.jackson.annotation.JsonProperty;

public class CatFacts {
    @JsonProperty ("id") private String id;
    @JsonProperty ("text")private String text;
    @JsonProperty ("type")private String type;
    @JsonProperty ("user")private String user;
    @JsonProperty ("upvotes")private int upvotes;

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUser() {
        return user;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }
}
