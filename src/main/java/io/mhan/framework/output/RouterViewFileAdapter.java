package io.mhan.framework.output;

import io.mhan.application.port.output.RouterViewOutputPort;
import io.mhan.domain.Router;
import io.mhan.domain.RouterId;
import io.mhan.domain.RouterType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RouterViewFileAdapter implements RouterViewOutputPort {
    private static RouterViewFileAdapter instance;

    private RouterViewFileAdapter() {}

    public static RouterViewFileAdapter getInstance() {
        if (instance == null) {
            instance = new RouterViewFileAdapter();
        }

        return instance;
    }

    @Override
    public List<Router> fetchRouters() {
        return readFileAsString();
    }

    private List<Router> readFileAsString() {
        List<Router> routers = new ArrayList<>();
        try (Stream<String> stream = new BufferedReader(
                new InputStreamReader(RouterViewFileAdapter.class.getClassLoader()
                        .getResourceAsStream("routers.txt"))).lines()) {
            stream.forEach(line -> {
                String[] routerEntry = line.split(";");
                var id = routerEntry[0];
                var type = routerEntry[1];
                Router router = new Router(RouterType.valueOf(type), RouterId.of(id));
                routers.add(router);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return routers;
    }
}
