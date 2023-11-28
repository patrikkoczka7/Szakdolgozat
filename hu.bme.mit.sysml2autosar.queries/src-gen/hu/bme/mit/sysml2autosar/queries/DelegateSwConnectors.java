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
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.Port;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
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
 *         pattern delegateSwConnectors(umlInfFlow: UML::InformationFlow, umlOuterPort: UML::Port) {
 *         	find rDelegateSwConnectors(umlInfFlow, _, umlOuterPort, _, _);
 *         } or  {
 *         	find pDelegateSwConnectors(umlInfFlow, _, _, _, umlOuterPort);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class DelegateSwConnectors extends BaseGeneratedEMFQuerySpecification<DelegateSwConnectors.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.sysml2autosar.queries.delegateSwConnectors pattern,
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
    private InformationFlow fUmlInfFlow;

    private Port fUmlOuterPort;

    private static List<String> parameterNames = makeImmutableList("umlInfFlow", "umlOuterPort");

    private Match(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
      this.fUmlInfFlow = pUmlInfFlow;
      this.fUmlOuterPort = pUmlOuterPort;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "umlInfFlow": return this.fUmlInfFlow;
          case "umlOuterPort": return this.fUmlOuterPort;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fUmlInfFlow;
          case 1: return this.fUmlOuterPort;
          default: return null;
      }
    }

    public InformationFlow getUmlInfFlow() {
      return this.fUmlInfFlow;
    }

    public Port getUmlOuterPort() {
      return this.fUmlOuterPort;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("umlInfFlow".equals(parameterName) ) {
          this.fUmlInfFlow = (InformationFlow) newValue;
          return true;
      }
      if ("umlOuterPort".equals(parameterName) ) {
          this.fUmlOuterPort = (Port) newValue;
          return true;
      }
      return false;
    }

    public void setUmlInfFlow(final InformationFlow pUmlInfFlow) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlInfFlow = pUmlInfFlow;
    }

    public void setUmlOuterPort(final Port pUmlOuterPort) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlOuterPort = pUmlOuterPort;
    }

    @Override
    public String patternName() {
      return "hu.bme.mit.sysml2autosar.queries.delegateSwConnectors";
    }

    @Override
    public List<String> parameterNames() {
      return DelegateSwConnectors.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fUmlInfFlow, fUmlOuterPort};
    }

    @Override
    public DelegateSwConnectors.Match toImmutable() {
      return isMutable() ? newMatch(fUmlInfFlow, fUmlOuterPort) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"umlInfFlow\"=" + prettyPrintValue(fUmlInfFlow) + ", ");
      result.append("\"umlOuterPort\"=" + prettyPrintValue(fUmlOuterPort));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fUmlInfFlow, fUmlOuterPort);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof DelegateSwConnectors.Match)) {
          DelegateSwConnectors.Match other = (DelegateSwConnectors.Match) obj;
          return Objects.equals(fUmlInfFlow, other.fUmlInfFlow) && Objects.equals(fUmlOuterPort, other.fUmlOuterPort);
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
    public DelegateSwConnectors specification() {
      return DelegateSwConnectors.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static DelegateSwConnectors.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlOuterPort the fixed value of pattern parameter umlOuterPort, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static DelegateSwConnectors.Match newMutableMatch(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
      return new Mutable(pUmlInfFlow, pUmlOuterPort);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlOuterPort the fixed value of pattern parameter umlOuterPort, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static DelegateSwConnectors.Match newMatch(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
      return new Immutable(pUmlInfFlow, pUmlOuterPort);
    }

    private static final class Mutable extends DelegateSwConnectors.Match {
      Mutable(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
        super(pUmlInfFlow, pUmlOuterPort);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends DelegateSwConnectors.Match {
      Immutable(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
        super(pUmlInfFlow, pUmlOuterPort);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the hu.bme.mit.sysml2autosar.queries.delegateSwConnectors pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern delegateSwConnectors(umlInfFlow: UML::InformationFlow, umlOuterPort: UML::Port) {
   * 	find rDelegateSwConnectors(umlInfFlow, _, umlOuterPort, _, _);
   * } or  {
   * 	find pDelegateSwConnectors(umlInfFlow, _, _, _, umlOuterPort);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see DelegateSwConnectors
   * 
   */
  public static class Matcher extends BaseMatcher<DelegateSwConnectors.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static DelegateSwConnectors.Matcher on(final ViatraQueryEngine engine) {
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
    public static DelegateSwConnectors.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_UMLINFFLOW = 0;

    private static final int POSITION_UMLOUTERPORT = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(DelegateSwConnectors.Matcher.class);

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
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlOuterPort the fixed value of pattern parameter umlOuterPort, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<DelegateSwConnectors.Match> getAllMatches(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
      return rawStreamAllMatches(new Object[]{pUmlInfFlow, pUmlOuterPort}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlOuterPort the fixed value of pattern parameter umlOuterPort, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<DelegateSwConnectors.Match> streamAllMatches(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
      return rawStreamAllMatches(new Object[]{pUmlInfFlow, pUmlOuterPort});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlOuterPort the fixed value of pattern parameter umlOuterPort, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<DelegateSwConnectors.Match> getOneArbitraryMatch(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
      return rawGetOneArbitraryMatch(new Object[]{pUmlInfFlow, pUmlOuterPort});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlOuterPort the fixed value of pattern parameter umlOuterPort, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
      return rawHasMatch(new Object[]{pUmlInfFlow, pUmlOuterPort});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlOuterPort the fixed value of pattern parameter umlOuterPort, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
      return rawCountMatches(new Object[]{pUmlInfFlow, pUmlOuterPort});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlOuterPort the fixed value of pattern parameter umlOuterPort, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort, final Consumer<? super DelegateSwConnectors.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pUmlInfFlow, pUmlOuterPort}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlOuterPort the fixed value of pattern parameter umlOuterPort, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public DelegateSwConnectors.Match newMatch(final InformationFlow pUmlInfFlow, final Port pUmlOuterPort) {
      return DelegateSwConnectors.Match.newMatch(pUmlInfFlow, pUmlOuterPort);
    }

    /**
     * Retrieve the set of values that occur in matches for umlInfFlow.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<InformationFlow> rawStreamAllValuesOfumlInfFlow(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLINFFLOW, parameters).map(InformationFlow.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlInfFlow.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<InformationFlow> getAllValuesOfumlInfFlow() {
      return rawStreamAllValuesOfumlInfFlow(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlInfFlow.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<InformationFlow> streamAllValuesOfumlInfFlow() {
      return rawStreamAllValuesOfumlInfFlow(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlInfFlow.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<InformationFlow> streamAllValuesOfumlInfFlow(final DelegateSwConnectors.Match partialMatch) {
      return rawStreamAllValuesOfumlInfFlow(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlInfFlow.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<InformationFlow> streamAllValuesOfumlInfFlow(final Port pUmlOuterPort) {
      return rawStreamAllValuesOfumlInfFlow(new Object[]{null, pUmlOuterPort});
    }

    /**
     * Retrieve the set of values that occur in matches for umlInfFlow.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<InformationFlow> getAllValuesOfumlInfFlow(final DelegateSwConnectors.Match partialMatch) {
      return rawStreamAllValuesOfumlInfFlow(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlInfFlow.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<InformationFlow> getAllValuesOfumlInfFlow(final Port pUmlOuterPort) {
      return rawStreamAllValuesOfumlInfFlow(new Object[]{null, pUmlOuterPort}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlOuterPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Port> rawStreamAllValuesOfumlOuterPort(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLOUTERPORT, parameters).map(Port.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlOuterPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlOuterPort() {
      return rawStreamAllValuesOfumlOuterPort(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlOuterPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlOuterPort() {
      return rawStreamAllValuesOfumlOuterPort(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlOuterPort.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlOuterPort(final DelegateSwConnectors.Match partialMatch) {
      return rawStreamAllValuesOfumlOuterPort(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlOuterPort.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlOuterPort(final InformationFlow pUmlInfFlow) {
      return rawStreamAllValuesOfumlOuterPort(new Object[]{pUmlInfFlow, null});
    }

    /**
     * Retrieve the set of values that occur in matches for umlOuterPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlOuterPort(final DelegateSwConnectors.Match partialMatch) {
      return rawStreamAllValuesOfumlOuterPort(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlOuterPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlOuterPort(final InformationFlow pUmlInfFlow) {
      return rawStreamAllValuesOfumlOuterPort(new Object[]{pUmlInfFlow, null}).collect(Collectors.toSet());
    }

    @Override
    protected DelegateSwConnectors.Match tupleToMatch(final Tuple t) {
      try {
          return DelegateSwConnectors.Match.newMatch((InformationFlow) t.get(POSITION_UMLINFFLOW), (Port) t.get(POSITION_UMLOUTERPORT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected DelegateSwConnectors.Match arrayToMatch(final Object[] match) {
      try {
          return DelegateSwConnectors.Match.newMatch((InformationFlow) match[POSITION_UMLINFFLOW], (Port) match[POSITION_UMLOUTERPORT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected DelegateSwConnectors.Match arrayToMatchMutable(final Object[] match) {
      try {
          return DelegateSwConnectors.Match.newMutableMatch((InformationFlow) match[POSITION_UMLINFFLOW], (Port) match[POSITION_UMLOUTERPORT]);
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
    public static IQuerySpecification<DelegateSwConnectors.Matcher> querySpecification() {
      return DelegateSwConnectors.instance();
    }
  }

  private DelegateSwConnectors() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static DelegateSwConnectors instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected DelegateSwConnectors.Matcher instantiate(final ViatraQueryEngine engine) {
    return DelegateSwConnectors.Matcher.on(engine);
  }

  @Override
  public DelegateSwConnectors.Matcher instantiate() {
    return DelegateSwConnectors.Matcher.create();
  }

  @Override
  public DelegateSwConnectors.Match newEmptyMatch() {
    return DelegateSwConnectors.Match.newEmptyMatch();
  }

  @Override
  public DelegateSwConnectors.Match newMatch(final Object... parameters) {
    return DelegateSwConnectors.Match.newMatch((org.eclipse.uml2.uml.InformationFlow) parameters[0], (org.eclipse.uml2.uml.Port) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link DelegateSwConnectors} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link DelegateSwConnectors#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final DelegateSwConnectors INSTANCE = new DelegateSwConnectors();

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
    private static final DelegateSwConnectors.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_umlInfFlow = new PParameter("umlInfFlow", "org.eclipse.uml2.uml.InformationFlow", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "InformationFlow")), PParameterDirection.INOUT);

    private final PParameter parameter_umlOuterPort = new PParameter("umlOuterPort", "org.eclipse.uml2.uml.Port", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Port")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_umlInfFlow, parameter_umlOuterPort);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.sysml2autosar.queries.delegateSwConnectors";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlInfFlow","umlOuterPort");
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
          PVariable var_umlInfFlow = body.getOrCreateVariableByName("umlInfFlow");
          PVariable var_umlOuterPort = body.getOrCreateVariableByName("umlOuterPort");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlInfFlow), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InformationFlow")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlOuterPort), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Port")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_umlInfFlow, parameter_umlInfFlow),
             new ExportedParameter(body, var_umlOuterPort, parameter_umlOuterPort)
          ));
          // 	find rDelegateSwConnectors(umlInfFlow, _, umlOuterPort, _, _)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_umlInfFlow, var___0_, var_umlOuterPort, var___1_, var___2_), RDelegateSwConnectors.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_umlInfFlow = body.getOrCreateVariableByName("umlInfFlow");
          PVariable var_umlOuterPort = body.getOrCreateVariableByName("umlOuterPort");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlInfFlow), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InformationFlow")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlOuterPort), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Port")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_umlInfFlow, parameter_umlInfFlow),
             new ExportedParameter(body, var_umlOuterPort, parameter_umlOuterPort)
          ));
          // 	find pDelegateSwConnectors(umlInfFlow, _, _, _, umlOuterPort)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_umlInfFlow, var___0_, var___1_, var___2_, var_umlOuterPort), PDelegateSwConnectors.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
