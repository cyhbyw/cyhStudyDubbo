package bhz.dubbo.direct.impl;

import bhz.dubbo.direct.DirectService;

public class DirectServiceImpl implements DirectService {

    @Override
    public String direct() throws Exception {
        return "Direct Service";
    }

}
