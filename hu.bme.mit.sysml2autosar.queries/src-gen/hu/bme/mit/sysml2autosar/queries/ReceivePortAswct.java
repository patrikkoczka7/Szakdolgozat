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
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
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
 *         pattern receivePortAswct(umlProperty: UML::Property, umlPort: UML::Port){
 *         	find atomicSwComponentTypes(umlProperty);
 *         	Property.ownedElement(umlProperty, umlPort);
 *         	InformationFlow.source(umlFlow, umlPort);
 *         	ItemFlow.base_InformationFlow(_, umlFlow);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ReceivePortAswct extends BaseGeneratedEMFQuerySpecification<ReceivePortAswct.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.sysml2autosar.queries.receivePortAswct pattern,
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
    private Property fUmlProperty;

    private Port fUmlPort;

    private static List<String> parameterNames = makeImmutableList("umlProperty", "umlPort");

    private Match(final Property pUmlProperty, final Port pUmlPort) {
      this.fUmlProperty = pUmlProperty;
      this.fUmlPort = pUmlPort;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "umlProperty": return this.fUmlProperty;
          case "umlPort": return this.fUmlPort;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fUmlProperty;
          case 1: return this.fUmlPort;
          default: return null;
      }
    }

    public Property getUmlProperty() {
      return this.fUmlProperty;
    }

    public Port getUmlPort() {
      return this.fUmlPort;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("umlProperty".equals(parameterName) ) {
          this.fUmlProperty = (Property) newValue;
          return true;
      }
      if ("umlPort".equals(parameterName) ) {
          this.fUmlPort = (Port) newValue;
          return true;
      }
      return false;
    }

    public void setUmlProperty(final Property pUmlProperty) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlProperty = pUmlProperty;
    }

    public void setUmlPort(final Port pUmlPort) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlPort = pUmlPort;
    }

    @Override
    public String patternName() {
      return "hu.bme.mit.sysml2autosar.queries.receivePortAswct";
    }

    @Override
    public List<String> parameterNames() {
      return ReceivePortAswct.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fUmlProperty, fUmlPort};
    }

    @Override
    public ReceivePortAswct.Match toImmutable() {
      return isMutable() ? newMatch(fUmlProperty, fUmlPort) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"umlProperty\"=" + prettyPrintValue(fUmlProperty) + ", ");
      result.append("\"umlPort\"=" + prettyPrintValue(fUmlPort));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fUmlProperty, fUmlPort);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ReceivePortAswct.Match)) {
          ReceivePortAswct.Match other = (ReceivePortAswct.Match) obj;
          return Objects.equals(fUmlProperty, other.fUmlProperty) && Objects.equals(fUmlPort, other.fUmlPort);
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
    public ReceivePortAswct specification() {
      return ReceivePortAswct.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ReceivePortAswct.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlPort the fixed value of pattern parameter umlPort, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ReceivePortAswct.Match newMutableMatch(final Property pUmlProperty, final Port pUmlPort) {
      return new Mutable(pUmlProperty, pUmlPort);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlPort the fixed value of pattern parameter umlPort, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ReceivePortAswct.Match newMatch(final Property pUmlProperty, final Port pUmlPort) {
      return new Immutable(pUmlProperty, pUmlPort);
    }

    private static final class Mutable extends ReceivePortAswct.Match {
      Mutable(final Property pUmlProperty, final Port pUmlPort) {
        super(pUmlProperty, pUmlPort);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends ReceivePortAswct.Match {
      Immutable(final Property pUmlProperty, final Port pUmlPort) {
        super(pUmlProperty, pUmlPort);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the hu.bme.mit.sysml2autosar.queries.receivePortAswct pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern receivePortAswct(umlProperty: UML::Property, umlPort: UML::Port){
   * 	find atomicSwComponentTypes(umlProperty);
   * 	Property.ownedElement(umlProperty, umlPort);
   * 	InformationFlow.source(umlFlow, umlPort);
   * 	ItemFlow.base_InformationFlow(_, umlFlow);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ReceivePortAswct
   * 
   */
  public static class Matcher extends BaseMatcher<ReceivePortAswct.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ReceivePortAswct.Matcher on(final ViatraQueryEngine engine) {
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
    public static ReceivePortAswct.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_UMLPROPERTY = 0;

    private static final int POSITION_UMLPORT = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ReceivePortAswct.Matcher.class);

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
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlPort the fixed value of pattern parameter umlPort, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ReceivePortAswct.Match> getAllMatches(final Property pUmlProperty, final Port pUmlPort) {
      return rawStreamAllMatches(new Object[]{pUmlProperty, pUmlPort}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlPort the fixed value of pattern parameter umlPort, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ReceivePortAswct.Match> streamAllMatches(final Property pUmlProperty, final Port pUmlPort) {
      return rawStreamAllMatches(new Object[]{pUmlProperty, pUmlPort});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlPort the fixed value of pattern parameter umlPort, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ReceivePortAswct.Match> getOneArbitraryMatch(final Property pUmlProperty, final Port pUmlPort) {
      return rawGetOneArbitraryMatch(new Object[]{pUmlProperty, pUmlPort});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlPort the fixed value of pattern parameter umlPort, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Property pUmlProperty, final Port pUmlPort) {
      return rawHasMatch(new Object[]{pUmlProperty, pUmlPort});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlPort the fixed value of pattern parameter umlPort, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Property pUmlProperty, final Port pUmlPort) {
      return rawCountMatches(new Object[]{pUmlProperty, pUmlPort});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlPort the fixed value of pattern parameter umlPort, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Property pUmlProperty, final Port pUmlPort, final Consumer<? super ReceivePortAswct.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pUmlProperty, pUmlPort}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlProperty the fixed value of pattern parameter umlProperty, or null if not bound.
     * @param pUmlPort the fixed value of pattern parameter umlPort, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ReceivePortAswct.Match newMatch(final Property pUmlProperty, final Port pUmlPort) {
      return ReceivePortAswct.Match.newMatch(pUmlProperty, pUmlPort);
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Property> rawStreamAllValuesOfumlProperty(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLPROPERTY, parameters).map(Property.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfumlProperty() {
      return rawStreamAllValuesOfumlProperty(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfumlProperty() {
      return rawStreamAllValuesOfumlProperty(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfumlProperty(final ReceivePortAswct.Match partialMatch) {
      return rawStreamAllValuesOfumlProperty(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfumlProperty(final Port pUmlPort) {
      return rawStreamAllValuesOfumlProperty(new Object[]{null, pUmlPort});
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfumlProperty(final ReceivePortAswct.Match partialMatch) {
      return rawStreamAllValuesOfumlProperty(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlProperty.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfumlProperty(final Port pUmlPort) {
      return rawStreamAllValuesOfumlProperty(new Object[]{null, pUmlPort}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Port> rawStreamAllValuesOfumlPort(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLPORT, parameters).map(Port.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlPort() {
      return rawStreamAllValuesOfumlPort(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlPort() {
      return rawStreamAllValuesOfumlPort(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlPort.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlPort(final ReceivePortAswct.Match partialMatch) {
      return rawStreamAllValuesOfumlPort(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlPort.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlPort(final Property pUmlProperty) {
      return rawStreamAllValuesOfumlPort(new Object[]{pUmlProperty, null});
    }

    /**
     * Retrieve the set of values that occur in matches for umlPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlPort(final ReceivePortAswct.Match partialMatch) {
      return rawStreamAllValuesOfumlPort(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlPort(final Property pUmlProperty) {
      return rawStreamAllValuesOfumlPort(new Object[]{pUmlProperty, null}).collect(Collectors.toSet());
    }

    @Override
    protected ReceivePortAswct.Match tupleToMatch(final Tuple t) {
      try {
          return ReceivePortAswct.Match.newMatch((Property) t.get(POSITION_UMLPROPERTY), (Port) t.get(POSITION_UMLPORT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ReceivePortAswct.Match arrayToMatch(final Object[] match) {
      try {
          return ReceivePortAswct.Match.newMatch((Property) match[POSITION_UMLPROPERTY], (Port) match[POSITION_UMLPORT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected ReceivePortAswct.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ReceivePortAswct.Match.newMutableMatch((Property) match[POSITION_UMLPROPERTY], (Port) match[POSITION_UMLPORT]);
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
    public static IQuerySpecification<ReceivePortAswct.Matcher> querySpecification() {
      return ReceivePortAswct.instance();
    }
  }

  private ReceivePortAswct() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ReceivePortAswct instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected ReceivePortAswct.Matcher instantiate(final ViatraQueryEngine engine) {
    return ReceivePortAswct.Matcher.on(engine);
  }

  @Override
  public ReceivePortAswct.Matcher instantiate() {
    return ReceivePortAswct.Matcher.create();
  }

  @Override
  public ReceivePortAswct.Match newEmptyMatch() {
    return ReceivePortAswct.Match.newEmptyMatch();
  }

  @Override
  public ReceivePortAswct.Match newMatch(final Object... parameters) {
    return ReceivePortAswct.Match.newMatch((org.eclipse.uml2.uml.Property) parameters[0], (org.eclipse.uml2.uml.Port) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link ReceivePortAswct} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ReceivePortAswct#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ReceivePortAswct INSTANCE = new ReceivePortAswct();

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
    private static final ReceivePortAswct.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_umlProperty = new PParameter("umlProperty", "org.eclipse.uml2.uml.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Property")), PParameterDirection.INOUT);

    private final PParameter parameter_umlPort = new PParameter("umlPort", "org.eclipse.uml2.uml.Port", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Port")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_umlProperty, parameter_umlPort);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.sysml2autosar.queries.receivePortAswct";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlProperty","umlPort");
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
          PVariable var_umlProperty = body.getOrCreateVariableByName("umlProperty");
          PVariable var_umlPort = body.getOrCreateVariableByName("umlPort");
          PVariable var_umlFlow = body.getOrCreateVariableByName("umlFlow");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlProperty), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlPort), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Port")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_umlProperty, parameter_umlProperty),
             new ExportedParameter(body, var_umlPort, parameter_umlPort)
          ));
          // 	find atomicSwComponentTypes(umlProperty)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_umlProperty), AtomicSwComponentTypes.instance().getInternalQueryRepresentation());
          // 	Property.ownedElement(umlProperty, umlPort)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlProperty), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlProperty, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
          new Equality(body, var__virtual_0_, var_umlPort);
          // 	InformationFlow.source(umlFlow, umlPort)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlFlow), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InformationFlow")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlFlow, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "DirectedRelationship", "source")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
          new Equality(body, var__virtual_1_, var_umlPort);
          // 	ItemFlow.base_InformationFlow(_, umlFlow)
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/papyrus/sysml/1.6/SysML/PortsAndFlows", "ItemFlow")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/papyrus/sysml/1.6/SysML/PortsAndFlows", "ItemFlow", "base_InformationFlow")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InformationFlow")));
          new Equality(body, var__virtual_2_, var_umlFlow);
          bodies.add(body);
      }
      return bodies;
    }
  }
}