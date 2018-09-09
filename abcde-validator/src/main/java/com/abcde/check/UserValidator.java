package com.abcde.check;

public class UserValidator extends Validator<User> {

    private User user;

    public UserValidator(User data) {
        super(data);
        this.user = data;
    }

    @Override
    protected boolean doCheck() {
        if (null == user.getName() || "".equals(user.getName().trim()) ) {
            getErrMsgs().add("姓名不能为空！");
            return false;
        }
        if (null == user.getAge()) {
            getErrMsgs().add("年龄不能为空！");
        }
        int nameLen = user.getName().length();
        if (nameLen > 30) {
            getErrMsgs().add("姓名长度必须小于30！");
        }
        return true;
    }
}
