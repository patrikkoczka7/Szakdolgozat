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
 *         pattern assemblySwConnectors(umlInfFlow: UML::InformationFlow, umlSourcePort: UML::Port, umlTargetPort: UML::Port){
 *         	ItemFlow.base_InformationFlow(_, umlInfFlow);
 *         	Property.ownedElement(_, umlSourcePort);
 *         	Property.ownedElement(_, umlTargetPort);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class AssemblySwConnectors extends BaseGeneratedEMFQuerySpecification<AssemblySwConnectors.Matcher> {
  /**
   * Pattern-specific match representation of the hu.bme.mit.sysml2autosar.queries.assemblySwConnectors pattern,
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

    private Port fUmlSourcePort;

    private Port fUmlTargetPort;

    private static List<String> parameterNames = makeImmutableList("umlInfFlow", "umlSourcePort", "umlTargetPort");

    private Match(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
      this.fUmlInfFlow = pUmlInfFlow;
      this.fUmlSourcePort = pUmlSourcePort;
      this.fUmlTargetPort = pUmlTargetPort;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "umlInfFlow": return this.fUmlInfFlow;
          case "umlSourcePort": return this.fUmlSourcePort;
          case "umlTargetPort": return this.fUmlTargetPort;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fUmlInfFlow;
          case 1: return this.fUmlSourcePort;
          case 2: return this.fUmlTargetPort;
          default: return null;
      }
    }

    public InformationFlow getUmlInfFlow() {
      return this.fUmlInfFlow;
    }

    public Port getUmlSourcePort() {
      return this.fUmlSourcePort;
    }

    public Port getUmlTargetPort() {
      return this.fUmlTargetPort;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("umlInfFlow".equals(parameterName) ) {
          this.fUmlInfFlow = (InformationFlow) newValue;
          return true;
      }
      if ("umlSourcePort".equals(parameterName) ) {
          this.fUmlSourcePort = (Port) newValue;
          return true;
      }
      if ("umlTargetPort".equals(parameterName) ) {
          this.fUmlTargetPort = (Port) newValue;
          return true;
      }
      return false;
    }

    public void setUmlInfFlow(final InformationFlow pUmlInfFlow) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlInfFlow = pUmlInfFlow;
    }

    public void setUmlSourcePort(final Port pUmlSourcePort) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlSourcePort = pUmlSourcePort;
    }

    public void setUmlTargetPort(final Port pUmlTargetPort) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fUmlTargetPort = pUmlTargetPort;
    }

    @Override
    public String patternName() {
      return "hu.bme.mit.sysml2autosar.queries.assemblySwConnectors";
    }

    @Override
    public List<String> parameterNames() {
      return AssemblySwConnectors.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fUmlInfFlow, fUmlSourcePort, fUmlTargetPort};
    }

    @Override
    public AssemblySwConnectors.Match toImmutable() {
      return isMutable() ? newMatch(fUmlInfFlow, fUmlSourcePort, fUmlTargetPort) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"umlInfFlow\"=" + prettyPrintValue(fUmlInfFlow) + ", ");
      result.append("\"umlSourcePort\"=" + prettyPrintValue(fUmlSourcePort) + ", ");
      result.append("\"umlTargetPort\"=" + prettyPrintValue(fUmlTargetPort));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fUmlInfFlow, fUmlSourcePort, fUmlTargetPort);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof AssemblySwConnectors.Match)) {
          AssemblySwConnectors.Match other = (AssemblySwConnectors.Match) obj;
          return Objects.equals(fUmlInfFlow, other.fUmlInfFlow) && Objects.equals(fUmlSourcePort, other.fUmlSourcePort) && Objects.equals(fUmlTargetPort, other.fUmlTargetPort);
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
    public AssemblySwConnectors specification() {
      return AssemblySwConnectors.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AssemblySwConnectors.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlSourcePort the fixed value of pattern parameter umlSourcePort, or null if not bound.
     * @param pUmlTargetPort the fixed value of pattern parameter umlTargetPort, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static AssemblySwConnectors.Match newMutableMatch(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
      return new Mutable(pUmlInfFlow, pUmlSourcePort, pUmlTargetPort);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlSourcePort the fixed value of pattern parameter umlSourcePort, or null if not bound.
     * @param pUmlTargetPort the fixed value of pattern parameter umlTargetPort, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static AssemblySwConnectors.Match newMatch(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
      return new Immutable(pUmlInfFlow, pUmlSourcePort, pUmlTargetPort);
    }

    private static final class Mutable extends AssemblySwConnectors.Match {
      Mutable(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
        super(pUmlInfFlow, pUmlSourcePort, pUmlTargetPort);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends AssemblySwConnectors.Match {
      Immutable(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
        super(pUmlInfFlow, pUmlSourcePort, pUmlTargetPort);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the hu.bme.mit.sysml2autosar.queries.assemblySwConnectors pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern assemblySwConnectors(umlInfFlow: UML::InformationFlow, umlSourcePort: UML::Port, umlTargetPort: UML::Port){
   * 	ItemFlow.base_InformationFlow(_, umlInfFlow);
   * 	Property.ownedElement(_, umlSourcePort);
   * 	Property.ownedElement(_, umlTargetPort);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AssemblySwConnectors
   * 
   */
  public static class Matcher extends BaseMatcher<AssemblySwConnectors.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AssemblySwConnectors.Matcher on(final ViatraQueryEngine engine) {
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
    public static AssemblySwConnectors.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_UMLINFFLOW = 0;

    private static final int POSITION_UMLSOURCEPORT = 1;

    private static final int POSITION_UMLTARGETPORT = 2;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AssemblySwConnectors.Matcher.class);

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
     * @param pUmlSourcePort the fixed value of pattern parameter umlSourcePort, or null if not bound.
     * @param pUmlTargetPort the fixed value of pattern parameter umlTargetPort, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<AssemblySwConnectors.Match> getAllMatches(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
      return rawStreamAllMatches(new Object[]{pUmlInfFlow, pUmlSourcePort, pUmlTargetPort}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlSourcePort the fixed value of pattern parameter umlSourcePort, or null if not bound.
     * @param pUmlTargetPort the fixed value of pattern parameter umlTargetPort, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<AssemblySwConnectors.Match> streamAllMatches(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
      return rawStreamAllMatches(new Object[]{pUmlInfFlow, pUmlSourcePort, pUmlTargetPort});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlSourcePort the fixed value of pattern parameter umlSourcePort, or null if not bound.
     * @param pUmlTargetPort the fixed value of pattern parameter umlTargetPort, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<AssemblySwConnectors.Match> getOneArbitraryMatch(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
      return rawGetOneArbitraryMatch(new Object[]{pUmlInfFlow, pUmlSourcePort, pUmlTargetPort});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlSourcePort the fixed value of pattern parameter umlSourcePort, or null if not bound.
     * @param pUmlTargetPort the fixed value of pattern parameter umlTargetPort, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
      return rawHasMatch(new Object[]{pUmlInfFlow, pUmlSourcePort, pUmlTargetPort});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlSourcePort the fixed value of pattern parameter umlSourcePort, or null if not bound.
     * @param pUmlTargetPort the fixed value of pattern parameter umlTargetPort, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
      return rawCountMatches(new Object[]{pUmlInfFlow, pUmlSourcePort, pUmlTargetPort});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlSourcePort the fixed value of pattern parameter umlSourcePort, or null if not bound.
     * @param pUmlTargetPort the fixed value of pattern parameter umlTargetPort, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort, final Consumer<? super AssemblySwConnectors.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pUmlInfFlow, pUmlSourcePort, pUmlTargetPort}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pUmlInfFlow the fixed value of pattern parameter umlInfFlow, or null if not bound.
     * @param pUmlSourcePort the fixed value of pattern parameter umlSourcePort, or null if not bound.
     * @param pUmlTargetPort the fixed value of pattern parameter umlTargetPort, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public AssemblySwConnectors.Match newMatch(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort, final Port pUmlTargetPort) {
      return AssemblySwConnectors.Match.newMatch(pUmlInfFlow, pUmlSourcePort, pUmlTargetPort);
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
    public Stream<InformationFlow> streamAllValuesOfumlInfFlow(final AssemblySwConnectors.Match partialMatch) {
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
    public Stream<InformationFlow> streamAllValuesOfumlInfFlow(final Port pUmlSourcePort, final Port pUmlTargetPort) {
      return rawStreamAllValuesOfumlInfFlow(new Object[]{null, pUmlSourcePort, pUmlTargetPort});
    }

    /**
     * Retrieve the set of values that occur in matches for umlInfFlow.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<InformationFlow> getAllValuesOfumlInfFlow(final AssemblySwConnectors.Match partialMatch) {
      return rawStreamAllValuesOfumlInfFlow(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlInfFlow.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<InformationFlow> getAllValuesOfumlInfFlow(final Port pUmlSourcePort, final Port pUmlTargetPort) {
      return rawStreamAllValuesOfumlInfFlow(new Object[]{null, pUmlSourcePort, pUmlTargetPort}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlSourcePort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Port> rawStreamAllValuesOfumlSourcePort(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLSOURCEPORT, parameters).map(Port.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlSourcePort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlSourcePort() {
      return rawStreamAllValuesOfumlSourcePort(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlSourcePort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlSourcePort() {
      return rawStreamAllValuesOfumlSourcePort(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlSourcePort.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlSourcePort(final AssemblySwConnectors.Match partialMatch) {
      return rawStreamAllValuesOfumlSourcePort(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlSourcePort.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlSourcePort(final InformationFlow pUmlInfFlow, final Port pUmlTargetPort) {
      return rawStreamAllValuesOfumlSourcePort(new Object[]{pUmlInfFlow, null, pUmlTargetPort});
    }

    /**
     * Retrieve the set of values that occur in matches for umlSourcePort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlSourcePort(final AssemblySwConnectors.Match partialMatch) {
      return rawStreamAllValuesOfumlSourcePort(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlSourcePort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlSourcePort(final InformationFlow pUmlInfFlow, final Port pUmlTargetPort) {
      return rawStreamAllValuesOfumlSourcePort(new Object[]{pUmlInfFlow, null, pUmlTargetPort}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlTargetPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Port> rawStreamAllValuesOfumlTargetPort(final Object[] parameters) {
      return rawStreamAllValues(POSITION_UMLTARGETPORT, parameters).map(Port.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for umlTargetPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlTargetPort() {
      return rawStreamAllValuesOfumlTargetPort(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlTargetPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlTargetPort() {
      return rawStreamAllValuesOfumlTargetPort(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlTargetPort.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlTargetPort(final AssemblySwConnectors.Match partialMatch) {
      return rawStreamAllValuesOfumlTargetPort(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for umlTargetPort.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfumlTargetPort(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort) {
      return rawStreamAllValuesOfumlTargetPort(new Object[]{pUmlInfFlow, pUmlSourcePort, null});
    }

    /**
     * Retrieve the set of values that occur in matches for umlTargetPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlTargetPort(final AssemblySwConnectors.Match partialMatch) {
      return rawStreamAllValuesOfumlTargetPort(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for umlTargetPort.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfumlTargetPort(final InformationFlow pUmlInfFlow, final Port pUmlSourcePort) {
      return rawStreamAllValuesOfumlTargetPort(new Object[]{pUmlInfFlow, pUmlSourcePort, null}).collect(Collectors.toSet());
    }

    @Override
    protected AssemblySwConnectors.Match tupleToMatch(final Tuple t) {
      try {
          return AssemblySwConnectors.Match.newMatch((InformationFlow) t.get(POSITION_UMLINFFLOW), (Port) t.get(POSITION_UMLSOURCEPORT), (Port) t.get(POSITION_UMLTARGETPORT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected AssemblySwConnectors.Match arrayToMatch(final Object[] match) {
      try {
          return AssemblySwConnectors.Match.newMatch((InformationFlow) match[POSITION_UMLINFFLOW], (Port) match[POSITION_UMLSOURCEPORT], (Port) match[POSITION_UMLTARGETPORT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected AssemblySwConnectors.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AssemblySwConnectors.Match.newMutableMatch((InformationFlow) match[POSITION_UMLINFFLOW], (Port) match[POSITION_UMLSOURCEPORT], (Port) match[POSITION_UMLTARGETPORT]);
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
    public static IQuerySpecification<AssemblySwConnectors.Matcher> querySpecification() {
      return AssemblySwConnectors.instance();
    }
  }

  private AssemblySwConnectors() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AssemblySwConnectors instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected AssemblySwConnectors.Matcher instantiate(final ViatraQueryEngine engine) {
    return AssemblySwConnectors.Matcher.on(engine);
  }

  @Override
  public AssemblySwConnectors.Matcher instantiate() {
    return AssemblySwConnectors.Matcher.create();
  }

  @Override
  public AssemblySwConnectors.Match newEmptyMatch() {
    return AssemblySwConnectors.Match.newEmptyMatch();
  }

  @Override
  public AssemblySwConnectors.Match newMatch(final Object... parameters) {
    return AssemblySwConnectors.Match.newMatch((org.eclipse.uml2.uml.InformationFlow) parameters[0], (org.eclipse.uml2.uml.Port) parameters[1], (org.eclipse.uml2.uml.Port) parameters[2]);
  }

  /**
   * Inner class allowing the singleton instance of {@link AssemblySwConnectors} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link AssemblySwConnectors#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final AssemblySwConnectors INSTANCE = new AssemblySwConnectors();

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
    private static final AssemblySwConnectors.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_umlInfFlow = new PParameter("umlInfFlow", "org.eclipse.uml2.uml.InformationFlow", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "InformationFlow")), PParameterDirection.INOUT);

    private final PParameter parameter_umlSourcePort = new PParameter("umlSourcePort", "org.eclipse.uml2.uml.Port", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Port")), PParameterDirection.INOUT);

    private final PParameter parameter_umlTargetPort = new PParameter("umlTargetPort", "org.eclipse.uml2.uml.Port", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.eclipse.org/uml2/5.0.0/UML", "Port")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_umlInfFlow, parameter_umlSourcePort, parameter_umlTargetPort);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "hu.bme.mit.sysml2autosar.queries.assemblySwConnectors";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("umlInfFlow","umlSourcePort","umlTargetPort");
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
          PVariable var_umlSourcePort = body.getOrCreateVariableByName("umlSourcePort");
          PVariable var_umlTargetPort = body.getOrCreateVariableByName("umlTargetPort");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
          PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlInfFlow), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InformationFlow")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlSourcePort), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Port")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_umlTargetPort), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Port")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_umlInfFlow, parameter_umlInfFlow),
             new ExportedParameter(body, var_umlSourcePort, parameter_umlSourcePort),
             new ExportedParameter(body, var_umlTargetPort, parameter_umlTargetPort)
          ));
          // 	ItemFlow.base_InformationFlow(_, umlInfFlow)
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/papyrus/sysml/1.6/SysML/PortsAndFlows", "ItemFlow")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var___0_, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/papyrus/sysml/1.6/SysML/PortsAndFlows", "ItemFlow", "base_InformationFlow")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "InformationFlow")));
          new Equality(body, var__virtual_0_, var_umlInfFlow);
          // 	Property.ownedElement(_, umlSourcePort)
          new TypeConstraint(body, Tuples.flatTupleOf(var___1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var___1_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
          new Equality(body, var__virtual_1_, var_umlSourcePort);
          // 	Property.ownedElement(_, umlTargetPort)
          new TypeConstraint(body, Tuples.flatTupleOf(var___2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Property")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var___2_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element", "ownedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.eclipse.org/uml2/5.0.0/UML", "Element")));
          new Equality(body, var__virtual_2_, var_umlTargetPort);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
