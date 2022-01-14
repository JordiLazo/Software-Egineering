package shared.transferobjects;

import java.io.Serializable;

public class Request implements Serializable {
    private String userRequest;
    private Object objectArgument;

    public Request(String userRequest, Object objectArgument) {
        this.userRequest = userRequest;
        this.objectArgument = objectArgument;
    }

    public String getUserRequest() {
        return userRequest;
    }

    public Object getObjectArgument() {
        return objectArgument;
    }
}
