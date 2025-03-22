package hookes;

import java.io.IOException;

import com.sai.cucumber.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHookes extends BaseClass {

    public MyHookes() {

	super.driver = this.driver;
    }

    @Before(order = 1)
    public void setUp() throws IOException {
	System.out.println("Before hook1");
    }

    @Before(order = 2)
    public void setUp1() throws IOException {
	System.out.println("Before hook2");
    }

    @After(order = 1)
    public void tearDown() throws IOException {
	System.out.println("After hook1");
    }

    @After(order = 2)
    public void tearDown1() throws IOException {
	System.out.println("After hook2");
    }
}
