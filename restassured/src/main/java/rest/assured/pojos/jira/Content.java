package rest.assured.pojos.jira;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Content {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("content")
    @Expose
    private List<Content_> content = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Content_> getContent() {
        return content;
    }

    public void setContent(List<Content_> content) {
        this.content = content;
    }
}
