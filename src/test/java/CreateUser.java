import java.util.HashMap;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Map;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class CreateUser {
    
	@BeforeTest
	public void initialize () {
		
		baseURI = "https://jsonplaceholder.typicode.com/posts";

	}
	@Test()
	public void CreatePost() {
	
		
		Map<String, String> bodydata = new HashMap<String, String>();
		bodydata.put("title", "Test RestAssured api");
		bodydata.put("body", "Mo sayed test");
		bodydata.put("userId", "91");

        given()
                .contentType("application/json")
                .body(bodydata)
                .when().post()
               .then().statusCode(201).and().log().all();
	}
	
	@Test
	public void GetAllPosts() {
		
		expect().body("id.size()",equalTo(100)).when().get().then()
        .statusCode(200).and().log().all();
	}



	    @Test ()
	    public void getPostsOfUser() {
	       
			given()
	                .when().get("/35")
	                .then().body("title",equalTo("id nihil consequatur molestias animi provident"))
	                .statusCode(200).and().log().all();
	    }
	
	
	
	
}
