import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.goldenbike.model.business.AllTestsBusiness;
import com.goldenbike.model.domain.AllTestsDomain;
import com.goldenbike.model.services.AllTestsServices;

@RunWith(Suite.class)
@SuiteClasses({AllTestsBusiness.class, AllTestsServices.class, AllTestsDomain.class})
public class ApplicationTestSuite {

}
