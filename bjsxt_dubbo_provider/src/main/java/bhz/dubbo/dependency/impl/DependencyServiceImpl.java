package bhz.dubbo.dependency.impl;

import bhz.dubbo.dependency.DependencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bhz.dubbo.sample.SampleService;

@Service("dependencyServiceImpl")
public class DependencyServiceImpl implements DependencyService {

    @Autowired
    private SampleService sampleService;

    @Override
    public String dependency() throws Exception {
        System.out.println(sampleService.sayHello("DependencyConsumer"));
        return "dependency exec";
    }

}
