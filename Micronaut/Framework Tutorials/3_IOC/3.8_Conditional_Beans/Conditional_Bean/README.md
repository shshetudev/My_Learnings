### Conditional Beans
* At times we may want a bean to load conditionally based on various potential factors including the `classpath`,`configuration`,`presence of other beans` etc.
* The `Requires` annotation provides the ability to define one or many conditions on bean.

### Conditional Bean Demo
* The `JdbcBookService` bean defines two requirements.
* The first indicates that a `DataSource` bean must be present for the bean to load.
* The second requirement ensures that the `datasource.url` property is set before loading the `JdbcBookService` bean.