package it.remind.rest;

import com.google.common.collect.ImmutableSet;
import restx.factory.*;
import it.remind.rest.SearchBookmarkRouter;

@Machine
public class SearchBookmarkRouterFactoryMachine extends SingleNameFactoryMachine<SearchBookmarkRouter> {
    public static final Name<SearchBookmarkRouter> NAME = Name.of(SearchBookmarkRouter.class, "SearchBookmarkRouter");

    public SearchBookmarkRouterFactoryMachine() {
        super(0, new StdMachineEngine<SearchBookmarkRouter>(NAME, BoundlessComponentBox.FACTORY) {
private final Factory.Query<it.remind.rest.SearchBookmark> resource = Factory.Query.byClass(it.remind.rest.SearchBookmark.class).mandatory();
private final Factory.Query<restx.entity.EntityRequestBodyReaderRegistry> readerRegistry = Factory.Query.byClass(restx.entity.EntityRequestBodyReaderRegistry.class).mandatory();
private final Factory.Query<restx.entity.EntityResponseWriterRegistry> writerRegistry = Factory.Query.byClass(restx.entity.EntityResponseWriterRegistry.class).mandatory();
private final Factory.Query<restx.converters.MainStringConverter> converter = Factory.Query.byClass(restx.converters.MainStringConverter.class).mandatory();
private final Factory.Query<javax.validation.Validator> validator = Factory.Query.byClass(javax.validation.Validator.class).mandatory();
private final Factory.Query<restx.security.RestxSecurityManager> securityManager = Factory.Query.byClass(restx.security.RestxSecurityManager.class).mandatory();

            @Override
            public BillOfMaterials getBillOfMaterial() {
                return new BillOfMaterials(ImmutableSet.<Factory.Query<?>>of(
resource,
readerRegistry,
writerRegistry,
converter,
validator,
securityManager
                ));
            }

            @Override
            protected SearchBookmarkRouter doNewComponent(SatisfiedBOM satisfiedBOM) {
                return new SearchBookmarkRouter(
satisfiedBOM.getOne(resource).get().getComponent(),
satisfiedBOM.getOne(readerRegistry).get().getComponent(),
satisfiedBOM.getOne(writerRegistry).get().getComponent(),
satisfiedBOM.getOne(converter).get().getComponent(),
satisfiedBOM.getOne(validator).get().getComponent(),
satisfiedBOM.getOne(securityManager).get().getComponent()
                );
            }
        });
    }

}
