/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.boot;

import java.util.function.Supplier;

import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.EntityNameResolver;
import org.hibernate.Interceptor;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.annotations.CacheLayout;
import org.hibernate.boot.TempTableDdlTransactionHandling;
import org.hibernate.boot.spi.SessionFactoryBuilderImplementor;
import org.hibernate.cache.spi.TimestampsCacheFactory;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.loader.BatchFetchStyle;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.impl.OgmSessionFactoryOptions;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.hibernate.query.NullPrecedence;
import org.hibernate.query.sqm.function.SqmFunctionDescriptor;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.hibernate.type.format.FormatMapper;

/**
 * A {@link SessionFactoryBuilderImplementor} which creates {@link OgmSessionFactory} instances.
 *
 * @author Gunnar Morling
 */
public interface OgmSessionFactoryBuilderImplementor extends SessionFactoryBuilderImplementor, OgmSessionFactoryBuilder {

	@Override
	OgmSessionFactoryBuilderImplementor applyValidatorFactory(Object validatorFactory);

	@Override
	OgmSessionFactoryBuilderImplementor applyBeanManager(Object beanManager);

	@Override
	OgmSessionFactoryBuilderImplementor applyName(String sessionFactoryName);

	@Override
	OgmSessionFactoryBuilderImplementor applyNameAsJndiName(boolean isJndiName);

	@Override
	OgmSessionFactoryBuilderImplementor applyAutoClosing(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyAutoFlushing(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyStatisticsSupport(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyInterceptor(Interceptor interceptor);

	@Override
	OgmSessionFactoryBuilderImplementor applyStatelessInterceptor(Class<? extends Interceptor> statelessInterceptorClass);

	@Override
	OgmSessionFactoryBuilderImplementor applyStatelessInterceptor(Supplier<? extends Interceptor> statelessInterceptorSupplier);

	@Override
	OgmSessionFactoryBuilderImplementor applyStatementInspector(StatementInspector statementInspector);

	@Override
	OgmSessionFactoryBuilderImplementor addSessionFactoryObservers(SessionFactoryObserver... observers);

	@Override
	OgmSessionFactoryBuilderImplementor applyCustomEntityDirtinessStrategy(CustomEntityDirtinessStrategy strategy);

	@Override
	OgmSessionFactoryBuilderImplementor addEntityNameResolver(EntityNameResolver... entityNameResolvers);

	@Override
	OgmSessionFactoryBuilderImplementor applyEntityNotFoundDelegate(EntityNotFoundDelegate entityNotFoundDelegate);

	@Override
	OgmSessionFactoryBuilderImplementor applyIdentifierRollbackSupport(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyNullabilityChecking(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyLazyInitializationOutsideTransaction(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyTempTableDdlTransactionHandling(TempTableDdlTransactionHandling handling);

	@Override
	OgmSessionFactoryBuilderImplementor applyBatchFetchStyle(BatchFetchStyle style);

	@Override
	OgmSessionFactoryBuilderImplementor applyDelayedEntityLoaderCreations(boolean delay);

	@Override
	OgmSessionFactoryBuilderImplementor applyDefaultBatchFetchSize(int size);

	@Override
	OgmSessionFactoryBuilderImplementor applyMaximumFetchDepth(int depth);

	@Override
	OgmSessionFactoryBuilderImplementor applySubselectFetchEnabled(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyDefaultNullPrecedence(NullPrecedence nullPrecedence);

	@Override
	OgmSessionFactoryOptions buildSessionFactoryOptions();

	@Override
	OgmSessionFactoryBuilderImplementor applyOrderingOfInserts(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyOrderingOfUpdates(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyMultiTenancy(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyCurrentTenantIdentifierResolver(CurrentTenantIdentifierResolver<?> resolver);

	@Override
	OgmSessionFactoryBuilderImplementor applyJtaTrackingByThread(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyPreferUserTransactions(boolean preferUserTransactions);

	@Override
	OgmSessionFactoryBuilderImplementor applyNamedQueryCheckingOnStartup(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applySecondLevelCacheSupport(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyQueryCacheSupport(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyQueryCacheLayout(CacheLayout cacheLayout);

	@Override
	OgmSessionFactoryBuilderImplementor applyTimestampsCacheFactory(TimestampsCacheFactory factory);

	@Override
	OgmSessionFactoryBuilderImplementor applyCacheRegionPrefix(String prefix);

	@Override
	OgmSessionFactoryBuilderImplementor applyMinimalPutsForCaching(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyStructuredCacheEntries(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyDirectReferenceCaching(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyAutomaticEvictionOfCollectionCaches(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyJdbcBatchSize(int size);

	@Override
	OgmSessionFactoryBuilderImplementor applyJdbcBatchingForVersionedEntities(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyScrollableResultsSupport(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyGetGeneratedKeysSupport(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyJdbcFetchSize(int size);

	@Override
	OgmSessionFactoryBuilderImplementor applyConnectionHandlingMode(PhysicalConnectionHandlingMode connectionHandlingMode);

	@Override
	OgmSessionFactoryBuilderImplementor applyConnectionProviderDisablesAutoCommit(boolean providerDisablesAutoCommit);

	@Override
	OgmSessionFactoryBuilderImplementor applySqlComments(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applySqlFunction(String registrationName, SqmFunctionDescriptor functionDescriptor);

	@Override
	OgmSessionFactoryBuilderImplementor applyCollectionsInDefaultFetchGroup(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor allowOutOfTransactionUpdateOperations(boolean allow);

	@Override
	OgmSessionFactoryBuilderImplementor enableReleaseResourcesOnCloseEnabled(boolean enable);

	@Override
	OgmSessionFactoryBuilderImplementor enableJpaQueryCompliance(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor enableJpaOrderByMappingCompliance(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor enableJpaTransactionCompliance(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor enableJpaListCompliance(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor enableJpaClosedCompliance(boolean enabled);

	@Override
	OgmSessionFactoryBuilderImplementor applyJsonFormatMapper(FormatMapper jsonFormatMapper);

	@Override
	OgmSessionFactoryBuilderImplementor applyXmlFormatMapper(FormatMapper xmlFormatMapper);

	@Override
	OgmSessionFactory build();

}
