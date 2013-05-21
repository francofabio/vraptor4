package br.com.caelum.vraptor.ioc.fixture;

import java.util.Set;

import br.com.caelum.vraptor.core.RequestInfo;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor4.controller.HttpMethod;
import br.com.caelum.vraptor4.controller.MethodNotAllowedHandler;

@ApplicationScoped
public class CustomMethodNotAllowedHandler implements MethodNotAllowedHandler {

	public void deny(RequestInfo request, Set<HttpMethod> allowedMethods) {
	}

}