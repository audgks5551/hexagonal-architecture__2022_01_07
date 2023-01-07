package io.mhan.application.port.output;

import io.mhan.domain.Router;

import java.util.List;

public interface RouterViewOutputPort {

    List<Router> fetchRouters();
}
