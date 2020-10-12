package rest.assured.pojos.jira;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemTemplate {
    @SerializedName("fields")
    @Expose
    private Fields fields;

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }
}
