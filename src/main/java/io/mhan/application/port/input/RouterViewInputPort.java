package io.mhan.application.port.input;

import io.mhan.application.port.output.RouterViewOutputPort;
import io.mhan.application.usecase.RouterViewUseCase;
import io.mhan.domain.Router;

import java.util.List;
import java.util.function.Predicate;

public class RouterViewInputPort implements RouterViewUseCase {
    private RouterViewOutputPort routerViewOutputPort;

    public RouterViewInputPort(RouterViewOutputPort routerViewOutputPort) {
        this.routerViewOutputPort = routerViewOutputPort;
    }

    @Override
    public List<Router> getRouters(Predicate<Router> filter) {
        var routers = routerViewOutputPort.fetchRouters(); // 액션
        return Router.retrieveRouter(routers, filter); // 계산
    }
}
