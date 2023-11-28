/**
 * Generated from platform:/resource/hu.bme.mit.sysml2autosar.queries/src/hu/bme/mit/sysml2autosar/queries/patterns.vql
 */
package hu.bme.mit.sysml2autosar.queries;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         pattern applicationDataType(umlDataType: UML::DataType){
 *         	Model.packagedElement(_, umlDataType);
 *         	ValueType.base_DataType(_, umlDataType);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ApplicationDataType extends BaseGeneratedEMFQuerySpecification<ApplicationDataType.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.sysml2autosar.queries.applicationDataType pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private DataType fUmlDataType;

    private static List<String> parameterNames = makeImmutableList("umlDataType");

    private Match(final DataType pUmlDataType) {
      this.fUmlDataType = pUmlDataType;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "umlDataType": return this.fUmlDataType;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fUmlDataType;
          default: return null;
      }
    }

    public DataType getUmlDataType() {
      return this.fUmlDataType;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("umlDataType".equals(parameterName) ) {
          this.fUmlDataType = (DataType) newValue;
          return true;
      }
      return false;
    }

    public void setUmlDataType(final DataType pUmlDataType) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlDataType = pUmlDataType;
    }

    @Override
    public String patternName() {
      return "hu.bme.mit.sysml2autosar.queries.applicationDataType";
    }

    @Override
    public List<String> parameterNames() {
      return ApplicationDataType.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fUmlDataType};
    }

    @Override
    public ApplicationDataType.Match toImmutable() {
      return isMutable() ? newMatch(fUmlDataType) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"umlDataType\"=" + prettyPrintValue(fUmlDataType));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fUmlDataType);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ApplicationDataType.Match)) {
          ApplicationDataType.Match other = (ApplicationDataType.Match) obj;
          return Objects.equals(fUmlDataType, other.fUmlDataType);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }

    @Override
    public ApplicationDataType specification() {
      return ApplicationDataType.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ApplicationDataType.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pUmlDataType the fixed value of pattern parameter umlDataType, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ApplicationDataType.Match newMutableMatch(final DataType pUmlDataType) {
      return new Mutable(pUmlDataType);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlDataType the fixed value of pattern parameter umlDataType, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ApplicationDataType.Match newMatch(final DataType pUmlDataType) {
      return new Immutable(pUmlDataType);
    }

    private static final class Mutable extends ApplicationDataType.Match {
      Mutable(final DataType pUmlDataType) {
        super(pUmlDataType);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends ApplicationDataType.Match {
      Immutable(final DataType pUmlDataType) {
        super(pUmlDataType);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the hu.bme.mit.sysml2autosar.queries.applicationDataType pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern applicationDataType(umlDataType: UML::DataType){
   * 	Model.packagedElement(_, umlDataType);
   * 	ValueType.base_DataType(_, umlDataType);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ApplicationDataType
   * 
   */
  public static class Matcher extends BaseMatcher<ApplicationDataType.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ApplicationDataType.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }

    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static ApplicationDataType.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_UMLDATATYPE = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ApplicationDataType.Matcher.class);

    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }

    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlDataType the fixed value of pattern parameter umlDataType, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ApplicationDataType.Match> getAllMatches(final DataType pUmlDataType) {
      return rawStreamAllMatches(new Object[]{pUmlDataType}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pUmlDataType the fixed value of pattern parameter umlDataType, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ApplicationDataType.Match> streamAllMatches(final DataType pUmlDataType) {
      return rawStreamAllMatches(new Object[]{pUmlDataType});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlDataType the fixed value of pattern parameter umlDataType, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ApplicationDataType.Match> getOneArbitraryMatch(final DataType pUmlDataType) {
      return rawGetOneArbitraryMatch(new Object[]{pUmlDataType});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pUmlDataType the fixed value of pattern parameter umlDataType, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final DataType pUmlDataType) {
      return rawHasMatch(new Object[]{pUmlDataType});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlDataType the fixed value of pattern parameter umlDataType, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final DataType pUmlDataType) {
      return rawCountMatches(new Object[]{pUmlDataType});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlDataType the fixed value of pattern parameter umlDataType, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final DataType pUmlDataType, final Consumer<? super ApplicationDataType.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pUmlDataType}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlDataType the fixed value of pattern parameter umlDataType, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ApplicationDataType.Match newMatch(final DataType pUmlDataType) {
      return ApplicationDataType.Match.newMatch(pUmlDataType);
    }

    /**
     * Retrieve the set of values that occur in matches for umlDataType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<DataType> rawStreamAllValuesOfumlDataType(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLDATATYPE, parameters).map(DataType.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlDataType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<DataType> getAllValuesOfumlDataType() {
      return rawStreamAllValuesOfumlDataType(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlDataType.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<DataType> streamAllValuesOfumlDataType() {
      return rawStreamAllValuesOfumlDataType(emptyArray());
    }

    @Override
    protected ApplicationDataType.Match tupleToMatch(final Tuple t) {
      try {
          return ApplicationDataType.Match.newMatch((DataType) t.get(POSITION_UMLDATATYPE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ApplicationDataType.Match arrayToMatch(final Object[] match) {
      try {
          return ApplicationDataType.Match.newMatch((DataType) match[POSITION_UMLDATATYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ApplicationDataType.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ApplicationDataType.Match.newMutableMatch((DataType) match[POSITION_UMLDATATYPE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<ApplicationDataType.Matcher> querySpecification() {
      return ApplicationDataType.instance();
    }
  }

  private ApplicationDataType() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ApplicationDataType instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected ApplicationDataType.Matcher instantiate(final ViatraQueryEngine engine) {
    return ApplicationDataType.Matcher.on(engine);
  }

  @Override
  public ApplicationDataType.Matcher instantiate() {
    return ApplicationDataType.Matcher.create();
  }

  @Override
  public ApplicationDataType.Match newEmptyMatch() {
    return ApplicationDataType.Match.newEmptyMatch();
  }

  @Override
  public ApplicationDataType.Match newMatch(final Object... parameters) {
    return ApplicationDataType.Match.newMatch((org.eclipse.uml2.uml.DataType) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link ApplicationDataType} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ApplicationDataType#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ApplicationDataType INSTANCE = new ApplicationDataType();

    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();

    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }

  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final ApplicationDataType.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_umlDataType = new PParameter("umlDataType", "org.eclipse.uml2.uml.DataType", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "DataType")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_umlDataType);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.sysml2autosar.queries.applicationDataType";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlDataType");
    }

    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }

    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_umlDataType = body.getOrCreateVariableByName("umlDataType");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlDataType), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "DataType")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_umlDataType, parameter_umlDataType)
          ));
          // 	Model.packagedElement(_, umlDataType)
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Model")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Package", "packagedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "PackageableElement")));
          new Equality(body, var__virtual_0_, var_umlDataType);
          // 	ValueType.base_DataType(_, umlDataType)
          new TypeConstraint(body, Tuples.flatTupleOf(var___1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/papyrus/sysml/1.6/SysML/Blocks", "ValueType")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var___1_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/papyrus/sysml/1.6/SysML/Blocks", "ValueType", "base_DataType")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "DataType")));
          new Equality(body, var__virtual_1_, var_umlDataType);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
