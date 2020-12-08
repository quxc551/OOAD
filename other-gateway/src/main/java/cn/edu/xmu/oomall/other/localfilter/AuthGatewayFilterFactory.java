package cn.edu.xmu.oomall.other.localfilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2 * @author: LiangJi3229
 * 3 * @date: 2020/12/5 下午2:11
 * 4
 */
@Component
public class AuthGatewayFilterFactory extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    private  static  final Logger logger = LoggerFactory.getLogger(AuthGatewayFilterFactory.class);

    public AuthGatewayFilterFactory() {
        super(AuthFilter.Config.class);
    }

    @Override
    public GatewayFilter apply(AuthFilter.Config config) {

        return new AuthFilter(config);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return new ArrayList<String>(Collections.singleton("tokenName"));
    }

}
