package mapsoft.qa.data;

public enum Title {

    EMPTY(""),//
    ADMIN_LOGIN("Sign In First!"), //
    ADMIN_HOME("Membership Management"), //
    ADMIN_ADD_MEMBER("Membership Management"), //
    ADMIN_EDIT_MEMBER("Membership Management"), //
    ADMIN_VIEW_MEMBER_PAGE("Membership Management"), //
    ;

    private String titleValue;

    private Title(String titleValue) {
        this.titleValue = titleValue;
    }

    public String getTitleValue() {
        return titleValue;
    }

}
