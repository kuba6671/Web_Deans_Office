package office.deans.web.DeansOffice.service;

import lombok.RequiredArgsConstructor;
import office.deans.web.DeansOffice.model.StudentGroup;
import office.deans.web.DeansOffice.model.users.Student;
import office.deans.web.DeansOffice.repository.StudentRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FacebookServiceImpl implements FacebookService {
    private String accessToken;

    @Value("${spring.social.facebook.app-id}")
    private String facebookAppId;
    @Value("${spring.social.facebook.app-secret}")
    private String facebookSecret;
    private final StudentRepository studentRepository;
    private final StudentGroupService studentGroupService;


    private FacebookConnectionFactory createConnection(){
        return new FacebookConnectionFactory(facebookAppId, facebookSecret);
    }

    @Override
    public String generateFacebookAuthorizeUrl() {
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("http://localhost:8080/facebook");
        params.setScope("email");
        return createConnection().getOAuthOperations().buildAuthenticateUrl(params);
    }

    @Override
    public void generateFacebookAccessToken(String code) {
        accessToken = createConnection().getOAuthOperations().exchangeForAccess(code, "http://localhost:8080/facebook",null).getAccessToken();
    }

    @Override
    public String getUserData() {
        Facebook facebook = new FacebookTemplate(accessToken);
        String[] fields = {"id","first_name","last_name","name","email"};
        return facebook.fetchObject("me",String.class, fields);
    }

    @Override
    public void getCode() {
        String facebookAuthorizeUrl = generateFacebookAuthorizeUrl();
        browse(facebookAuthorizeUrl);
    }

    private static void browse(String url){
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean usersExist(String username) {
        Student studentUser = studentRepository.getStudentByMail(username);
        return ObjectUtils.isNotEmpty(studentUser);
    }


    @Override
    public Student getFacebookUser() throws InterruptedException {
        getCode();
        while(accessToken == null) {
               Thread.sleep(1000);
           }
        String facebookUser = getUserData();
        try{
            JSONObject jsonFacebookUser = new JSONObject(facebookUser);
            Student student = getStudentFromJSON(jsonFacebookUser);
            return student;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Student getStudentFromJSON(JSONObject jsonFacebookUser){
        Long id = Long.parseLong(jsonFacebookUser.get("id").toString());
        String firstName =jsonFacebookUser.get("first_name").toString();
        String lastName =jsonFacebookUser.get("last_name").toString();
        String mail = jsonFacebookUser.get("email").toString();
        List<StudentGroup> studentGroups = studentGroupService.getStudentGroups();
        Student student = new Student();
        student.setMail(mail);
        student.setName(firstName);
        student.setSurname(lastName);
        student.setPassword("$2a$12$MgQ1ni3eBTL4lwTBabNYCOacb1QgW5z91QrNNPoIjGPrfNqIvhDfe");
        student.setGroup(studentGroups.get(0));
        student.setIndexNumber(id);
        student.setAge(20);
        return student;
    }

    @Override
    public String facebookUserLogin() throws InterruptedException {
        Student student = getFacebookUser();
        boolean userExist = usersExist(student.getMail());
        if(userExist){
            return "Users exist";
        }else{
            studentRepository.save(student);
            return "User added to database";
        }
    }
}
