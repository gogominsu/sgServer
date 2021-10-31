package dmh.sgserver.domain;

public class Member {
    private Long user_number;
    private String user_name;
    private String user_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Long getUser_number() {
        return user_number;
    }

    public void setUser_number(Long user_number) {
        this.user_number = user_number;
    }
}
