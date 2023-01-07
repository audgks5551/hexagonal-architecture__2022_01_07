package io.mhan.framework.input;

import io.mhan.application.port.input.RouterViewInputPort;
import io.mhan.application.usecase.RouterViewUseCase;
import io.mhan.domain.Router;
import io.mhan.domain.RouterType;
import io.mhan.framework.output.RouterViewFileAdapter;

import java.util.List;

public class RouterViewCLIAdapter {
    RouterViewUseCase routerViewUseCase;

    public RouterViewCLIAdapter() {
        this.routerViewUseCase = new RouterViewInputPort(RouterViewFileAdapter.getInstance());
    }

    public List<Router> obtainRelatedRouters(String type) {
        return routerViewUseCase.getRouters(
                Router.filterRouterByType(RouterType.valueOf(type)));
    }
}
