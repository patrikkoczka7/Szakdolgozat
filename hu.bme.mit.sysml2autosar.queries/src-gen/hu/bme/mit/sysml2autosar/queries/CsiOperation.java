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
import org.eclipse.uml2.uml.Operation;
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
 *         pattern csiOperation(umlCsi: UML::Class, umlOperation: UML::Operation){
 *         	find clientServerInterfaceType(umlCsi);
 *         	Class.ownedOperation(umlCsi, umlOperation);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class CsiOperation extends BaseGeneratedEMFQuerySpecification<CsiOperation.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.sysml2autosar.queries.csiOperation pattern,
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
    private org.eclipse.uml2.uml.Class fUmlCsi;

    private Operation fUmlOperation;

    private static List<String> parameterNames = makeImmutableList("umlCsi", "umlOperation");

    private Match(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
      this.fUmlCsi = pUmlCsi;
      this.fUmlOperation = pUmlOperation;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "umlCsi": return this.fUmlCsi;
          case "umlOperation": return this.fUmlOperation;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fUmlCsi;
          case 1: return this.fUmlOperation;
          default: return null;
      }
    }

    public org.eclipse.uml2.uml.Class getUmlCsi() {
      return this.fUmlCsi;
    }

    public Operation getUmlOperation() {
      return this.fUmlOperation;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("umlCsi".equals(parameterName) ) {
          this.fUmlCsi = (org.eclipse.uml2.uml.Class) newValue;
          return true;
      }
      if ("umlOperation".equals(parameterName) ) {
          this.fUmlOperation = (Operation) newValue;
          return true;
      }
      return false;
    }

    public void setUmlCsi(final org.eclipse.uml2.uml.Class pUmlCsi) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlCsi = pUmlCsi;
    }

    public void setUmlOperation(final Operation pUmlOperation) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlOperation = pUmlOperation;
    }

    @Override
    public String patternName() {
      return "hu.bme.mit.sysml2autosar.queries.csiOperation";
    }

    @Override
    public List<String> parameterNames() {
      return CsiOperation.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fUmlCsi, fUmlOperation};
    }

    @Override
    public CsiOperation.Match toImmutable() {
      return isMutable() ? newMatch(fUmlCsi, fUmlOperation) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"umlCsi\"=" + prettyPrintValue(fUmlCsi) + ", ");
      result.append("\"umlOperation\"=" + prettyPrintValue(fUmlOperation));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fUmlCsi, fUmlOperation);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof CsiOperation.Match)) {
          CsiOperation.Match other = (CsiOperation.Match) obj;
          return Objects.equals(fUmlCsi, other.fUmlCsi) && Objects.equals(fUmlOperation, other.fUmlOperation);
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
    public CsiOperation specification() {
      return CsiOperation.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static CsiOperation.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pUmlCsi the fixed value of pattern parameter umlCsi, or null if not bound.
     * @param pUmlOperation the fixed value of pattern parameter umlOperation, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static CsiOperation.Match newMutableMatch(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
      return new Mutable(pUmlCsi, pUmlOperation);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlCsi the fixed value of pattern parameter umlCsi, or null if not bound.
     * @param pUmlOperation the fixed value of pattern parameter umlOperation, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static CsiOperation.Match newMatch(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
      return new Immutable(pUmlCsi, pUmlOperation);
    }

    private static final class Mutable extends CsiOperation.Match {
      Mutable(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
        super(pUmlCsi, pUmlOperation);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends CsiOperation.Match {
      Immutable(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
        super(pUmlCsi, pUmlOperation);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the hu.bme.mit.sysml2autosar.queries.csiOperation pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern csiOperation(umlCsi: UML::Class, umlOperation: UML::Operation){
   * 	find clientServerInterfaceType(umlCsi);
   * 	Class.ownedOperation(umlCsi, umlOperation);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see CsiOperation
   * 
   */
  public static class Matcher extends BaseMatcher<CsiOperation.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static CsiOperation.Matcher on(final ViatraQueryEngine engine) {
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
    public static CsiOperation.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_UMLCSI = 0;

    private static final int POSITION_UMLOPERATION = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(CsiOperation.Matcher.class);

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
     * @param pUmlCsi the fixed value of pattern parameter umlCsi, or null if not bound.
     * @param pUmlOperation the fixed value of pattern parameter umlOperation, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<CsiOperation.Match> getAllMatches(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
      return rawStreamAllMatches(new Object[]{pUmlCsi, pUmlOperation}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pUmlCsi the fixed value of pattern parameter umlCsi, or null if not bound.
     * @param pUmlOperation the fixed value of pattern parameter umlOperation, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<CsiOperation.Match> streamAllMatches(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
      return rawStreamAllMatches(new Object[]{pUmlCsi, pUmlOperation});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlCsi the fixed value of pattern parameter umlCsi, or null if not bound.
     * @param pUmlOperation the fixed value of pattern parameter umlOperation, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<CsiOperation.Match> getOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
      return rawGetOneArbitraryMatch(new Object[]{pUmlCsi, pUmlOperation});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pUmlCsi the fixed value of pattern parameter umlCsi, or null if not bound.
     * @param pUmlOperation the fixed value of pattern parameter umlOperation, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
      return rawHasMatch(new Object[]{pUmlCsi, pUmlOperation});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlCsi the fixed value of pattern parameter umlCsi, or null if not bound.
     * @param pUmlOperation the fixed value of pattern parameter umlOperation, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
      return rawCountMatches(new Object[]{pUmlCsi, pUmlOperation});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlCsi the fixed value of pattern parameter umlCsi, or null if not bound.
     * @param pUmlOperation the fixed value of pattern parameter umlOperation, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation, final Consumer<? super CsiOperation.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pUmlCsi, pUmlOperation}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlCsi the fixed value of pattern parameter umlCsi, or null if not bound.
     * @param pUmlOperation the fixed value of pattern parameter umlOperation, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public CsiOperation.Match newMatch(final org.eclipse.uml2.uml.Class pUmlCsi, final Operation pUmlOperation) {
      return CsiOperation.Match.newMatch(pUmlCsi, pUmlOperation);
    }

    /**
     * Retrieve the set of values that occur in matches for umlCsi.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<org.eclipse.uml2.uml.Class> rawStreamAllValuesOfumlCsi(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLCSI, parameters).map(org.eclipse.uml2.uml.Class.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlCsi.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlCsi() {
      return rawStreamAllValuesOfumlCsi(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlCsi.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<org.eclipse.uml2.uml.Class> streamAllValuesOfumlCsi() {
      return rawStreamAllValuesOfumlCsi(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlCsi.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<org.eclipse.uml2.uml.Class> streamAllValuesOfumlCsi(final CsiOperation.Match partialMatch) {
      return rawStreamAllValuesOfumlCsi(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlCsi.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<org.eclipse.uml2.uml.Class> streamAllValuesOfumlCsi(final Operation pUmlOperation) {
      return rawStreamAllValuesOfumlCsi(new Object[]{null, pUmlOperation});
    }

    /**
     * Retrieve the set of values that occur in matches for umlCsi.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlCsi(final CsiOperation.Match partialMatch) {
      return rawStreamAllValuesOfumlCsi(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlCsi.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<org.eclipse.uml2.uml.Class> getAllValuesOfumlCsi(final Operation pUmlOperation) {
      return rawStreamAllValuesOfumlCsi(new Object[]{null, pUmlOperation}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlOperation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Operation> rawStreamAllValuesOfumlOperation(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLOPERATION, parameters).map(Operation.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlOperation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Operation> getAllValuesOfumlOperation() {
      return rawStreamAllValuesOfumlOperation(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlOperation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Operation> streamAllValuesOfumlOperation() {
      return rawStreamAllValuesOfumlOperation(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlOperation.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Operation> streamAllValuesOfumlOperation(final CsiOperation.Match partialMatch) {
      return rawStreamAllValuesOfumlOperation(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlOperation.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Operation> streamAllValuesOfumlOperation(final org.eclipse.uml2.uml.Class pUmlCsi) {
      return rawStreamAllValuesOfumlOperation(new Object[]{pUmlCsi, null});
    }

    /**
     * Retrieve the set of values that occur in matches for umlOperation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Operation> getAllValuesOfumlOperation(final CsiOperation.Match partialMatch) {
      return rawStreamAllValuesOfumlOperation(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlOperation.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Operation> getAllValuesOfumlOperation(final org.eclipse.uml2.uml.Class pUmlCsi) {
      return rawStreamAllValuesOfumlOperation(new Object[]{pUmlCsi, null}).collect(Collectors.toSet());
    }

    @Override
    protected CsiOperation.Match tupleToMatch(final Tuple t) {
      try {
          return CsiOperation.Match.newMatch((org.eclipse.uml2.uml.Class) t.get(POSITION_UMLCSI), (Operation) t.get(POSITION_UMLOPERATION));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected CsiOperation.Match arrayToMatch(final Object[] match) {
      try {
          return CsiOperation.Match.newMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLCSI], (Operation) match[POSITION_UMLOPERATION]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected CsiOperation.Match arrayToMatchMutable(final Object[] match) {
      try {
          return CsiOperation.Match.newMutableMatch((org.eclipse.uml2.uml.Class) match[POSITION_UMLCSI], (Operation) match[POSITION_UMLOPERATION]);
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
    public static IQuerySpecification<CsiOperation.Matcher> querySpecification() {
      return CsiOperation.instance();
    }
  }

  private CsiOperation() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static CsiOperation instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected CsiOperation.Matcher instantiate(final ViatraQueryEngine engine) {
    return CsiOperation.Matcher.on(engine);
  }

  @Override
  public CsiOperation.Matcher instantiate() {
    return CsiOperation.Matcher.create();
  }

  @Override
  public CsiOperation.Match newEmptyMatch() {
    return CsiOperation.Match.newEmptyMatch();
  }

  @Override
  public CsiOperation.Match newMatch(final Object... parameters) {
    return CsiOperation.Match.newMatch((org.eclipse.uml2.uml.Class) parameters[0], (org.eclipse.uml2.uml.Operation) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link CsiOperation} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link CsiOperation#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final CsiOperation INSTANCE = new CsiOperation();

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
    private static final CsiOperation.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_umlCsi = new PParameter("umlCsi", "org.eclipse.uml2.uml.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Class")), PParameterDirection.INOUT);

    private final PParameter parameter_umlOperation = new PParameter("umlOperation", "org.eclipse.uml2.uml.Operation", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_umlCsi, parameter_umlOperation);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.sysml2autosar.queries.csiOperation";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlCsi","umlOperation");
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
          PVariable var_umlCsi = body.getOrCreateVariableByName("umlCsi");
          PVariable var_umlOperation = body.getOrCreateVariableByName("umlOperation");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlCsi), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlOperation), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_umlCsi, parameter_umlCsi),
             new ExportedParameter(body, var_umlOperation, parameter_umlOperation)
          ));
          // 	find clientServerInterfaceType(umlCsi)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_umlCsi), ClientServerInterfaceType.instance().getInternalQueryRepresentation());
          // 	Class.ownedOperation(umlCsi, umlOperation)
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlCsi), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlCsi, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Class", "ownedOperation")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Operation")));
          new Equality(body, var__virtual_0_, var_umlOperation);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
