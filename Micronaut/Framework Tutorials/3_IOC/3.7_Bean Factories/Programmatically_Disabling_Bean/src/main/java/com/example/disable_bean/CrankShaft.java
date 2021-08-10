package com.example.disable_bean;

import javax.inject.Singleton;

//------------------------------------------
// About Bean Scopes:
// @Singleton -> Only one instance of a bean will exist in the entire application.
// @Prototype -> New instance of a bean is created each time it is injected.
// @RequestScope -> New instance of a bean is created and associated with each HTTP request.
// @Refreshable -> A custom scope that allows a bean's state to be refreshed via the `/refresh` endpoint.
// @Context -> The bean will create at the same time as ApplicationContext(eager initialization).
// @Infrastructure -> A bean can not be overridden or replaced using @Replaces.
// @ThreadLocal -> A bean is associated per thread via ThreadLocal.
//-------------------------------------------
@Singleton
public class CrankShaft {
}
