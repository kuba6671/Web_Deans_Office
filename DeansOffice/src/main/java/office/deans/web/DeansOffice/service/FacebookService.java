package office.deans.web.DeansOffice.service;

import office.deans.web.DeansOffice.model.users.Student;

public interface FacebookService {

    String generateFacebookAuthorizeUrl();

    void generateFacebookAccessToken(String code);

    String getUserData();

    void getCode();

    Student getFacebookUser() throws InterruptedException;

    boolean usersExist(String username);

    String facebookUserLogin() throws InterruptedException;
}
