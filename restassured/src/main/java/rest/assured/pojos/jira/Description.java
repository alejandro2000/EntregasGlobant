package rest.assured.pojos.jira;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Description {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("version")
    @Expose
    private Integer version;
    @SerializedName("content")
    @Expose
    private List<Content> content = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }
}
