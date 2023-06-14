import codecrusaders.Main;
import codecrusaders.business.ISearchManager;
import codecrusaders.business.ITestStepManager;
import codecrusaders.business.impl.SearchManager;
import codecrusaders.business.impl.TestStepManager;
import codecrusaders.domain.SearchResult;
import codecrusaders.domain.TestStep;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

public class ServiceRunner {
    public static void main(String[] args){
        try{
            ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
            ISearchManager manager = context.getBean(SearchManager.class);
            ITestStepManager testStepManager = context.getBean(TestStepManager.class);
            TestStep t = testStepManager.getTestStepById(1L).get();
            List<SearchResult> resultList = manager.getByErrorIdFromPublic(1L, 2, 2);
//            System.out.println(t);
            System.out.println(resultList);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
